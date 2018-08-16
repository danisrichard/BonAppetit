package com.bonappetit.app.model.menuSection;

import com.bonappetit.app.utils.DateFutureOrPresentConstraint;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Document
public class DailyMenu {

    @Id
    private String id;
    @DateFutureOrPresentConstraint
    private String date;
    @Valid
    @DBRef
    private ArrayList<Menu> menuList = new ArrayList<>();

    public DailyMenu() {
        menuList.add(new Menu(MenuType.A));
        menuList.add(new Menu(MenuType.B));
    }

    public String getId() {
        return id;
    }

    public HashMap<MenuType,Integer> getOrderNumberGroupByMenuType(){
        return menuList.stream()
                .filter(menu -> menu.sumAllOrderToInteger() != 0)
                .collect(Collectors.toMap(Menu::getMenuType, Menu::sumAllOrderToInteger, (a, b) -> b, HashMap::new));
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(Menu menu){
        this.menuList.add(menu);
    }
}
