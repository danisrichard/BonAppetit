package com.bonappetit.app.model.menuSection;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

public abstract class Menu {

    @Id
    private String id;
    private String menuType;
    @NotNull
    @NotEmpty
    private String soupName;
    @NotNull
    @NotEmpty
    private String mainCourse;
    @NotNull
    @NotEmpty
    private String dessertName;
    @FutureOrPresent
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoupName() {
        return soupName;
    }

    public void setSoupName(String soupName) {
        this.soupName = soupName;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "soupName='" + soupName + '\'' +
                ", mainCourse='" + mainCourse + '\'' +
                ", dessertName='" + dessertName + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(soupName, menu.soupName) &&
                Objects.equals(mainCourse, menu.mainCourse) &&
                Objects.equals(dessertName, menu.dessertName) &&
                Objects.equals(date, menu.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soupName, mainCourse, dessertName, date);
    }
}
