package com.bonappetit.app.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomePageController {

    @GetMapping(value = {"/home", "/", "/index"})
    public String loadIndexPage(Model model){
        model.addAttribute("todayMenu",null);
        return "index";
    }

    @ModelAttribute("date")
    public String getCurrentDate() throws ParseException {
        return new SimpleDateFormat("dd-MMM-YYYY").format(new Date());
    }
}
