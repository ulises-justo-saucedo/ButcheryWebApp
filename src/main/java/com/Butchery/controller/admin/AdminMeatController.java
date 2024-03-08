package com.Butchery.controller.admin;

import com.Butchery.service.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Butchery/adm/meat")
public class AdminMeatController {
    @Autowired
    private MeatService meatService;
    @GetMapping("/list")
    public ModelAndView meatList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("meats", meatService.selectAll());
        mav.setViewName("admin/meats/meatsList");
        return mav;
    }
}
