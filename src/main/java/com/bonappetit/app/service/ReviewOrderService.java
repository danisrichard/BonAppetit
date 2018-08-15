package com.bonappetit.app.service;

import com.bonappetit.app.model.menuSection.ReviewMenuWrapper;

import java.util.List;

public interface ReviewOrderService {
    List<ReviewMenuWrapper> getOrder();
}
