package com.bonappetit.app.service;

import com.bonappetit.app.errors.MenuNotFoundException;
import com.bonappetit.app.model.menuSection.Menu;

public interface OrderPageService {
    Menu getMenuById(String id) throws MenuNotFoundException;
}
