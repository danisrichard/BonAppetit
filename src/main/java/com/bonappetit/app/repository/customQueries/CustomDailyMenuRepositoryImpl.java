package com.bonappetit.app.repository.customQueries;

import com.bonappetit.app.model.menuSection.DailyMenu;
import com.bonappetit.app.model.menuSection.Menu;
import com.bonappetit.app.repository.CustomDailyMenuRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomDailyMenuRepositoryImpl implements CustomDailyMenuRepository {

    private static final Logger logger = LogManager.getLogger(CustomDailyMenuRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoOperation;

    @Override
    public DailyMenu saveOrUpdateDailyMenu(@Valid DailyMenu dailyMenu) {
        mongoOperation.remove(new Query(Criteria.where("date").is(dailyMenu.getDate())), DailyMenu.class);
        ArrayList<Menu> menuList = dailyMenu.getMenuList();
        menuList.forEach(aMenuList -> {
            aMenuList.setDate(dailyMenu.getDate());
            mongoOperation.save(aMenuList);
        });
        mongoOperation.save(dailyMenu);
        return dailyMenu;
    }

    @Override
    public List<DailyMenu> getDailyMenuList() {
        return mongoOperation.find(
                new Query(Criteria.where("date")
                        .gt(currentDateMinusOneInString()))
                        .with(sortByDateAsc())
                        .limit(30), DailyMenu.class
        );
    }

    @Override
    public DailyMenu getOrdersToDailyMenu() {
        return mongoOperation.findOne(
                new Query(Criteria.where("date")
                        .is(currentDateInString()))
                , DailyMenu.class
        );
    }

    private String currentDateInString(){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }

    private String currentDateMinusOneInString() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().minusDays(1L).format(formatter);
    }

    private Sort sortByDateAsc() {
        return new Sort(Sort.Direction.ASC, "date");
    }
}
