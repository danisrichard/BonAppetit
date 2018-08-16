package com.bonappetit.app.service.Impl;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.repository.DailyMenuRepository;
import com.bonappetit.app.service.MenuPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MenuPageServiceImpl implements MenuPageService {

    @Autowired
    private DailyMenuRepository dailyMenuRepository;

    @Override
    public List<DailyMenu> getListOfMenu() {
        return dailyMenuRepository.getDailyMenu();
    }

}
