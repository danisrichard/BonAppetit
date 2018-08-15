package com.bonappetit.app.model.menuSection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Document
public class DailyMenu {

    @Id
    private String id;
    private String date;
    @Valid
    @DBRef
    private ArrayList<Menu> menuList = new ArrayList<>();

    public DailyMenu() {
        menuList.add(new Menu(MenuType.A));
        menuList.add(new Menu(MenuType.B));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDate.now().format(formatter);
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

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(Menu menu){
        this.menuList.add(menu);
    }
}
