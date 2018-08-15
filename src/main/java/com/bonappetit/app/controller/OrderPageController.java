package com.bonappetit.app.controller;

import com.bonappetit.app.errors.MenuNotFoundException;
import com.bonappetit.app.service.OrderPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class OrderPageController implements WebMvcConfigurer {

    @Autowired
    private OrderPageService orderPageService;

    @PostMapping("/order")
    public String getOrder(@RequestParam("id") String id, Model model) throws MenuNotFoundException {
        model.addAttribute("concreteMenu", orderPageService.getMenuById(id));
        return "order-page-section/order-page-main";
    }

    @PostMapping("/order/confirm")
    public String confirmOrder(@RequestParam("name") String name, @RequestParam("id") String id) throws MenuNotFoundException {
        if (name == null || name.equals("")) {
            return "redirect:/order";
        }
        orderPageService.updateOrders(id,name);
        return "order-page-section/order-page-confirm";
    }

}
