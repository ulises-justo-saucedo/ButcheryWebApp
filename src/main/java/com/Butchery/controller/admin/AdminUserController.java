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
        mav.setViewName("admin/usersList");
        return mav;
    }
    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user",clientService.selectById(id));
        mav.setViewName("admin/updateUser");
        return mav;
    }
    @PostMapping("/update/sent")
    public String updateUser(@Valid ClientDTO clientDTO, BindingResult bindingResult, @RequestParam("id") long id){
        if(!bindingResult.hasErrors()){
            ClientEntity clientEntity = clientDTO.toClientEntity(id);
            clientService.saveOrUpdate(clientEntity);
            System.out.println("Successfully saved entity. Entity has no errors.");
        }else{
            System.out.println("Couldn't save entity. Entity has errors.");
        }
        return "redirect:/Butchery/adm/user/list";
    }
}
