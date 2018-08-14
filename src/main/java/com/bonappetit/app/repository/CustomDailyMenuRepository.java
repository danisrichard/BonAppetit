package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.DailyMenu;

import javax.validation.Valid;

public interface CustomDailyMenuRepository {

    DailyMenu saveOrUpdateDailyMenu(@Valid DailyMenu dailyMenu);

    DailyMenu getDailyMenu(String date);
}
