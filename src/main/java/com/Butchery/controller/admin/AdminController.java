package com.Butchery.controller.admin;

import com.Butchery.dto.ClientDTO;
import com.Butchery.entity.ClientEntity;
import com.Butchery.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Butchery/adm")
public class AdminController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/panel")
    public String adminpanel(){
        return "admin/adminpanel";
    }
    @GetMapping("/users")
    public ModelAndView users(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("users",clientService.selectAll());
        mav.setViewName("admin/usersList");
        return mav;
    }
    @GetMapping("/users/update")
    public ModelAndView showUpdatePage(@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user",clientService.selectById(id));
        mav.setViewName("admin/updateUser");
        return mav;
    }
    @PostMapping("/users/update/sent")
    public String updateUser(@ModelAttribute ClientDTO clientDTO, @RequestParam("id") long id){
        ClientEntity clientEntity = clientDTO.toClientEntity(id);
        clientService.saveOrUpdate(clientEntity);
        return "redirect:/Butchery/adm/users";
    }
}
