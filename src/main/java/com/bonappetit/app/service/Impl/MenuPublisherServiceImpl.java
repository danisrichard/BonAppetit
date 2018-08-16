package com.bonappetit.app.service.Impl;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.repository.DailyMenuRepository;
import com.bonappetit.app.service.MenuPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class MenuPublisherServiceImpl implements MenuPublisherService {

    @Autowired
    private DailyMenuRepository menuRepository;

    @Override
    @Transactional
    public DailyMenu saveDailyMenu(@Valid DailyMenu dailyMenu) {
        return menuRepository.saveOrUpdateDailyMenu(dailyMenu);
    }

}
