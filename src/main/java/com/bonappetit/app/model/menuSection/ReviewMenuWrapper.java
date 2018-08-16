package com.bonappetit.app.model.menuSection;

import java.util.HashMap;

import static com.bonappetit.app.utils.LocalDateConverter.stringToLocalDateTime;

public class ReviewMenuWrapper {

    private String dayName;
    private String date;
    private HashMap<MenuType,Integer> menuTypeAndNumbersOfOrders;

    public ReviewMenuWrapper(String date, HashMap<MenuType, Integer> menuTypeAndNumbersOfOrders){
        this.date = date;
        this.menuTypeAndNumbersOfOrders = menuTypeAndNumbersOfOrders;
        this.dayName = stringToLocalDateTime(date).getDayOfWeek().toString();
    }

    public void setMenuTypeAndNumbersOfOrders(HashMap<MenuType, Integer> menuTypeAndNumbersOfOrders) {
        this.menuTypeAndNumbersOfOrders = menuTypeAndNumbersOfOrders;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<MenuType, Integer> getMenuTypeAndNumbersOfOrders() {
        return menuTypeAndNumbersOfOrders;
    }

    public String getDate() {
        return date;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
