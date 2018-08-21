package com.bonappetit.app.service.Impl;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.repository.DailyMenuRepository;
import com.bonappetit.app.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexPageServiceImpl implements IndexPageService {

    @Autowired
    private DailyMenuRepository dailyMenuRepository;

    @Override
    public List<DailyMenu> getListOfMenu() {
        return dailyMenuRepository.getDailyMenuList();
    }

}
