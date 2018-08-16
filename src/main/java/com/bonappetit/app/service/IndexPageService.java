package com.bonappetit.app.service;

import com.bonappetit.app.model.menuSection.DailyMenu;

import java.util.List;

public interface IndexPageService {
    List<DailyMenu> getListOfMenu();
}
