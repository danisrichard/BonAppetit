package com.bonappetit.app.model.menuSection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Document
public class Menu {

    @Id
    private String id;
    @NotNull
    private MenuType menuType;
    private String date;
    @Valid
    private Food food;
    private List<String> listOfOrderNames;

    public Menu(@NotNull @NotEmpty MenuType menuType) {
        this.id = String.valueOf(new ObjectId());
        this.menuType = menuType;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDate.now().format(formatter);
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getListOfOrderNames() {
        return listOfOrderNames;
    }

    public void setListOfOrderNames(List<String> listOfOrderNames) {
        this.listOfOrderNames = listOfOrderNames;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(@Valid Food food) {
        this.food = food;
    }
}
