package com.bonappetit.app.controller;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.service.DailyMenuPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/menu")
public class DaliyMenuPublisherController implements WebMvcConfigurer {

    @Autowired
    private DailyMenuPublisherService menuPublisherService;

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String loadPublishSite(Model model) {
        model.addAttribute("dailyMenu", new DailyMenu());
        return "publisher-section/menu-publisher-main";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String validateMenuRequest(@Valid DailyMenu dailyMenu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "publisher-section/menu-publisher-main";
        }
        menuPublisherService.saveDailyMenu(dailyMenu);
        return "redirect:/menu/publish/confirm";
    }

    @ModelAttribute("date")
    public String getCurrentDate() throws ParseException {
        return new SimpleDateFormat("dd-MMM-YYYY").format(new Date());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/menu/publish/confirm").setViewName("/publisher-section/menu-publisher-confirm");
    }
}
