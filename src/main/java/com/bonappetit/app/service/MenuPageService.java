package com.bonappetit.app.service;

import com.bonappetit.app.model.menuSection.DailyMenu;

import java.util.List;

public interface MenuPageService {
    List<DailyMenu> getListOfMenu();
}
