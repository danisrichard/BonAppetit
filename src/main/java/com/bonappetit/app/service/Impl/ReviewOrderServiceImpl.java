package com.bonappetit.app.service.Impl;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.model.menuSection.ReviewMenuWrapper;
import com.bonappetit.app.repository.DailyMenuRepository;
import com.bonappetit.app.service.ReviewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class ReviewOrderServiceImpl implements ReviewOrderService {

    @Autowired
    private DailyMenuRepository dailyMenuRepository;

    @Override
    public List<ReviewMenuWrapper> getOrder() {
        List<DailyMenu> dailyMenuList = dailyMenuRepository.findAll();
        return dailyMenuList.stream()
                .map(aDailyMenuList -> new ReviewMenuWrapper(aDailyMenuList.getDate(), aDailyMenuList.getOrderNumberGroupByMenuType()))
                .collect(collectingAndThen(toList(),
                        Collections::unmodifiableList));
    }
}
