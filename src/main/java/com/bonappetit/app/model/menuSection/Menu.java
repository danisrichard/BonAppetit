package com.bonappetit.app.model.menuSection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Document
public class Menu {

    @Id
    private String id;
    @NotNull
    private MenuType menuType;
    private String date;
    @Valid
    private Food food;
    @DBRef
    private List<OrderUser> listOfOrderUser;

    public Menu(@NotNull @NotEmpty MenuType menuType) {
        this.listOfOrderUser = new ArrayList<>();
        this.id = String.valueOf(new ObjectId());
        this.menuType = menuType;
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

    public List<OrderUser> getListOfOrderUser() {
        return listOfOrderUser;
    }

    public void addNewNameToList(OrderUser name) {
        this.listOfOrderUser.add(name);
    }

    public int sumAllOrderToInteger() {
        return (int) IntStream.range(0, listOfOrderUser.size()).count();
    }

    public void setListOfOrderUser(List<OrderUser> listOfOrderUser) {
        this.listOfOrderUser = listOfOrderUser;
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
