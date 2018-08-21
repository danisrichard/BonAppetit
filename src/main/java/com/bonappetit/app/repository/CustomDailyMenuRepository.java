package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.DailyMenu;

import javax.validation.Valid;
import java.util.List;

public interface CustomDailyMenuRepository {

    DailyMenu saveOrUpdateDailyMenu(@Valid DailyMenu dailyMenu);

    List<DailyMenu> getDailyMenuList();

    DailyMenu getOrdersToDailyMenu();
}
