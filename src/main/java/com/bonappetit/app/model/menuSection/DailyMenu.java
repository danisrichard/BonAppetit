package com.bonappetit.app.model.menuSection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.FutureOrPresent;
import java.sql.Date;

@Document
public class DailyMenu {

    @Id
    private String id;
    @FutureOrPresent
    private Date date;
    private Menu menuA;
    private Menu menuB;

    public DailyMenu() {
        this.menuA = new Menu(MenuType.A);
        this.menuB = new Menu(MenuType.B);
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Menu getMenuA() {
        return menuA;
    }

    public void setMenuA(Menu menuA) {
        this.menuA = menuA;
    }

    public Menu getMenuB() {
        return menuB;
    }

    public void setMenuB(Menu menuB) {
        this.menuB = menuB;
    }
}
