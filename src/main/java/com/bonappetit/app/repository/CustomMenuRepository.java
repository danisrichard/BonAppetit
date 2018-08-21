package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.Menu;
import com.bonappetit.app.model.menuSection.OrderUser;

public interface CustomMenuRepository {

    Menu saveOrderUserToMenu(Menu menu, OrderUser orderUser);

    Menu updateOrderUserInMenu(Menu menu, OrderUser orderUser);
}
