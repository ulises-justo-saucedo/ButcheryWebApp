package com.Butchery.controller.admin;

import com.Butchery.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
