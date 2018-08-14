package com.bonappetit.app.controller;

import com.bonappetit.app.model.userSection.Roles;
import com.bonappetit.app.model.userSection.Users;
import com.bonappetit.app.repository.RoleRepository;
import com.bonappetit.app.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AuthenticationController implements WebMvcConfigurer {

    @Autowired
    private UserRegistrationService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new Users());
        return "/authentication-section/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid Users user, BindingResult bindingResult, Model model) throws RoleNotFoundException {
        if (bindingResult.hasErrors()) {
            return "/authentication-section/registration";
        }
        //model.addAttribute("successMessage", true);
        userService.saveUser(user);
        return "/authentication-section/login";
    }

    @GetMapping(value = "/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect: /";
        }
        return "authentication-section/login";
    }
}
