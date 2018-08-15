package com.bonappetit.app.controller;

import com.bonappetit.app.service.ReviewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders/view")
public class ReviewOrderPageController {

    @Autowired
    private ReviewOrderService reviewOrderService;

    @GetMapping
    public String getViewFromDailyOrder(Model model){
        model.addAttribute("reviewMenu",reviewOrderService.getOrder());
        return "order-review-section/order-review-page-section";
    }
}
