package com.bonappetit.app.service;

import com.bonappetit.app.model.menuSection.DailyMenu;

public interface MenuPublisherService {
    DailyMenu saveDailyMenu(DailyMenu dailyMenu);
}
