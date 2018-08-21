package com.bonappetit.app.controller;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.model.menuSection.Menu;
import com.bonappetit.app.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MenuPageController {

    @Autowired
    private IndexPageService menuPageService;

    @GetMapping(value = {"/home", "/", "/index"})
    public String loadIndexPage(Model model) {
        model.addAttribute("todayMenu", menuPageService.getListOfMenu());
        return "home-page-section/index";
    }

    @ModelAttribute("date")
    public String getCurrentDate() throws ParseException {
        return new SimpleDateFormat("dd-MMM-YYYY").format(new Date());
    }

    @GetMapping("/dsa")
    public @ResponseBody
    List<DailyMenu> get() {
        return menuPageService.getListOfMenu();
    }
}


