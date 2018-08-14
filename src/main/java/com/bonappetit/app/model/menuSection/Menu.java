package com.bonappetit.app.model.menuSection;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Menu {

    @NotNull
    private MenuType menuType;
    @Valid
    private Food food;

    public Menu(@NotNull @NotEmpty MenuType menuType) {
        this.menuType = menuType;
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
