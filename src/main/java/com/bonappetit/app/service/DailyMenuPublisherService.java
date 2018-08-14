package com.bonappetit.app.service;

import com.bonappetit.app.model.menuSection.DailyMenu;

public interface DailyMenuPublisherService {
    DailyMenu saveDailyMenu(DailyMenu dailyMenu);
}
