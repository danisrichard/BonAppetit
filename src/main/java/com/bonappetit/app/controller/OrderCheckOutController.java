package com.bonappetit.app.controller;

import com.bonappetit.app.errors.DailyMenuNotFoundException;
import com.bonappetit.app.errors.OrderUserNotFoundException;
import com.bonappetit.app.model.menuSection.OrderCheckOutWrapper;
import com.bonappetit.app.service.OrderCheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/orders")
public class OrderCheckOutController {

    @Autowired
    private OrderCheckOutService orderCheckOutService;

    @GetMapping("/check-out")
    public String loadCheckOutPage(Model model) throws DailyMenuNotFoundException {
        model.addAttribute("orderCheckout",orderCheckOutService.getMenuOrder());
        return "check-out-section/check-out-index";
    }

    @GetMapping("/check-out/response")
    public @ResponseBody
    OrderCheckOutWrapper loadCheckOutPage() throws DailyMenuNotFoundException {
       return orderCheckOutService.getMenuOrder();
    }

    @GetMapping("/check-out/user/{id}")
    public String setOrderToOrderUser(@PathVariable("id") String userId) throws OrderUserNotFoundException {
        orderCheckOutService.changeOrderStatus(userId);
        return "redirect:/orders/check-out";
    }
}
