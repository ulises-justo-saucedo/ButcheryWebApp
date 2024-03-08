package com.Butchery.controller.admin;

import com.Butchery.dto.MeatDTO;
import com.Butchery.entity.MeatEntity;
import com.Butchery.service.MeatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("meat",meatService.selectById(id));
        mav.setViewName("admin/meats/updateMeat");
        return mav;
    }
    @PostMapping("/update/sent")
    public String updateMeat(@Valid MeatDTO meatDTO, BindingResult bindingResult, @RequestParam("id") long id, @RequestParam("button") String button){
        if(button.equals("confirm") && !bindingResult.hasErrors()){
            MeatEntity meatEntity = meatDTO.toMeatEntity(id);
            meatService.saveOrUpdate(meatEntity);
        }
        return "redirect:/Butchery/adm/meat/list";
    }
}
