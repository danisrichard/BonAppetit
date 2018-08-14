package com.bonappetit.app.service.Impl;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.repository.DailyMenuRepository;
import com.bonappetit.app.service.MenuPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class MenuPageServiceImpl implements MenuPageService {

    @Autowired
    private DailyMenuRepository dailyMenuRepository;

    @Override
    public DailyMenu getCurrentDayMenu() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dailyMenuRepository.getDailyMenu(LocalDate.now().format(formatter));
    }
}
