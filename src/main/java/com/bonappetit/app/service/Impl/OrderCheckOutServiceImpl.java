package com.bonappetit.app.service.Impl;

import com.bonappetit.app.errors.DailyMenuNotFoundException;
import com.bonappetit.app.errors.OrderUserNotFoundException;
import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.model.menuSection.OrderCheckOutWrapper;
import com.bonappetit.app.model.menuSection.OrderUser;
import com.bonappetit.app.repository.DailyMenuRepository;
import com.bonappetit.app.repository.OrderUserRepository;
import com.bonappetit.app.service.OrderCheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCheckOutServiceImpl implements OrderCheckOutService {

    @Autowired
    private DailyMenuRepository dailyMenuRepository;

    @Autowired
    private OrderUserRepository orderUserRepository;

    @Override
    public OrderCheckOutWrapper getMenuOrder() throws DailyMenuNotFoundException {
        DailyMenu dailyMenu = dailyMenuRepository.getOrdersToDailyMenu();

        if (dailyMenu == null) {
            throw new DailyMenuNotFoundException("null");
        }

        return new OrderCheckOutWrapper.Builder().orderUserMap(dailyMenu.getMenuList()).build();
    }

    @Override
    @Transactional
    public OrderUser changeOrderStatus(String userId) throws OrderUserNotFoundException {
        OrderUser orderUser = orderUserRepository.findById(userId).orElseThrow(() -> new OrderUserNotFoundException("dsa"));
        orderUser.setOrdered(true);
        return orderUserRepository.save(orderUser);
    }
}
