package com.bonappetit.app.model.menuSection;

import com.bonappetit.app.utils.DailyMenuFoodConstraint;

public class Food {

    @DailyMenuFoodConstraint
    private String soupName;
    @DailyMenuFoodConstraint
    private String mainName;
    @DailyMenuFoodConstraint
    private String dessertName;

    public String getSoupName() {
        return soupName;
    }

    public void setSoupName(String soupName) {
        this.soupName = soupName;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }
}
