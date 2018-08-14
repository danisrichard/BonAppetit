package com.bonappetit.app.controller;

import com.bonappetit.app.service.MenuPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MenuPageController {

    @Autowired
    private MenuPageService menuPageService;

    @GetMapping(value = {"/home", "/", "/index"})
    public String loadIndexPage(Model model){
        model.addAttribute("todayMenu",menuPageService.getCurrentDayMenu());
        return "home-page-section/index";
    }

    @ModelAttribute("date")
    public String getCurrentDate() throws ParseException {
        return new SimpleDateFormat("dd-MMM-YYYY").format(new Date());
    }
}
