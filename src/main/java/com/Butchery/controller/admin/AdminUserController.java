package com.Butchery.controller.admin;
import com.Butchery.dto.ClientDTO;
import com.Butchery.entity.ClientEntity;
import com.Butchery.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Butchery/adm/user")
public class AdminUserController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/list")
    public ModelAndView userList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("users",clientService.selectAll());
        mav.setViewName("admin/users/usersList");
        return mav;
    }
    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user",clientService.selectById(id));
        mav.setViewName("admin/users/updateUser");
        return mav;
    }
    @PostMapping("/update/sent")
    public String updateUser(@Valid ClientDTO clientDTO, BindingResult bindingResult, @RequestParam("id") long id, @RequestParam("button") String button){
        if(!bindingResult.hasErrors() && button.equals("confirm")){
            ClientEntity clientEntity = clientDTO.toClientEntity(id);
            clientService.saveOrUpdate(clientEntity);
        }
        return "redirect:/Butchery/adm/user/list";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user",clientService.selectById(id));
        mav.setViewName("admin/users/deleteUser");
        return mav;
    }
    @PostMapping("/delete/sent")
    public String deleteUser(@RequestParam("id") long id, @RequestParam("button") String button){
        if(button.equals("delete")){
            clientService.deleteById(id);
        }
        return "redirect:/Butchery/adm/user/list";
    }
    @GetMapping("/create")
    public String showCreateUserPage(){
        return "admin/users/createUser";
    }
    @PostMapping("/create/sent")
    public String createUser(@Valid ClientDTO clientDTO, BindingResult bindingResult, @RequestParam("button") String button){
        if(button.equals("confirm") && !bindingResult.hasErrors()){
            ClientEntity clientEntity = clientDTO.toClientEntity();
            clientService.saveOrUpdate(clientEntity);
        }
        return "redirect:/Butchery/adm/user/list";
    }
}
