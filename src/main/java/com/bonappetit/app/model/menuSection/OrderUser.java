package com.bonappetit.app.model.menuSection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document
public class OrderUser {

    @Id
    private String id;
    private String name;
    private boolean isOrdered;

    public OrderUser(@NotNull @NotEmpty String name) {
        this.name = name;
        this.isOrdered = false;
        this.id = String.valueOf(new ObjectId());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }
}
