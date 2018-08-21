package com.bonappetit.app.service;

import com.bonappetit.app.errors.DailyMenuNotFoundException;
import com.bonappetit.app.errors.OrderUserNotFoundException;
import com.bonappetit.app.model.menuSection.OrderCheckOutWrapper;
import com.bonappetit.app.model.menuSection.OrderUser;

public interface OrderCheckOutService {
    OrderCheckOutWrapper getMenuOrder() throws DailyMenuNotFoundException;
    OrderUser changeOrderStatus(String userId) throws OrderUserNotFoundException;
}
