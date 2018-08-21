package com.bonappetit.app.repository.customQueries;

import com.bonappetit.app.model.menuSection.Menu;
import com.bonappetit.app.model.menuSection.OrderUser;
import com.bonappetit.app.repository.CustomMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomMenuRepositoryImpl  implements CustomMenuRepository {

    @Autowired
    private MongoTemplate mongoOperation;

    @Override
    public Menu saveOrderUserToMenu(Menu menu,OrderUser orderUser) {
        menu.addNewNameToList(orderUser);
        mongoOperation.save(menu);
        mongoOperation.save(orderUser);
        return menu;
    }

    @Override
    public Menu updateOrderUserInMenu(Menu menu, OrderUser orderUser) {
        return null;
    }
}
