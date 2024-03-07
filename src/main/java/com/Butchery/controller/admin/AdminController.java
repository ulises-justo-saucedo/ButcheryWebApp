package com.Butchery.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Butchery/adm")
public class AdminController {
    @GetMapping("/panel")
    public String adminpanel(){
        return "admin/adminpanel";
    }
}
