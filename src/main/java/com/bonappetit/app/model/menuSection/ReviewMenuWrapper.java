package com.bonappetit.app.model.menuSection;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class ReviewMenuWrapper {

    private String date;
    private String dayName;
    private HashMap<MenuType,Integer> menuTypeAndNumbersOfOrders;

    public ReviewMenuWrapper(String date, HashMap<MenuType, Integer> menuTypeAndNumbersOfOrders){
        this.date = date;
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek dow = localDate.getDayOfWeek();
        this.dayName = String.valueOf(dow);
        this.menuTypeAndNumbersOfOrders = menuTypeAndNumbersOfOrders;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
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
}
