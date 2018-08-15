package com.bonappetit.app.repository.customQueries;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.repository.CustomDailyMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.validation.Valid;

public class CustomDailyMenuRepositoryImpl implements CustomDailyMenuRepository {

    @Autowired
    private MongoTemplate mongoOperation;

    @Override
    public DailyMenu saveOrUpdateDailyMenu(@Valid DailyMenu dailyMenu) {
        mongoOperation.remove(new Query(Criteria.where("date").is(dailyMenu.getDate())), DailyMenu.class);
        dailyMenu.getMenuList().forEach(e -> mongoOperation.save(e));
        mongoOperation.save(dailyMenu);
        return dailyMenu;
    }

    @Override
    public DailyMenu getDailyMenu(String date) {
        return mongoOperation.findOne(new Query(Criteria.where("date").is(date)),DailyMenu.class);
    }
}
