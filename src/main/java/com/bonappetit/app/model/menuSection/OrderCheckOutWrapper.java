package com.bonappetit.app.model.menuSection;

import java.util.*;
import java.util.stream.Collectors;

public class OrderCheckOutWrapper {
    private HashMap<MenuType, List<OrderUser>> orderUserMap;

    private OrderCheckOutWrapper(Builder builder) {
        orderUserMap = builder.orderUserMap;
    }

    public HashMap<MenuType, List<OrderUser>> getOrderUserMap() {
        return orderUserMap;
    }

    public static final class Builder {

        private HashMap<MenuType, List<OrderUser>> orderUserMap;

        public Builder() {
        }

        public Builder orderUserMap(List<Menu> menuList) {
            HashMap<MenuType, List<OrderUser>> unsortedMap = menuList.stream()
                    .collect(Collectors.toMap(Menu::getMenuType, aMenuList -> aMenuList.getListOfOrderUser()
                            .stream()
                            .filter(e -> !e.isOrdered())
                            .collect(Collectors.toList()), (a, b) -> b, HashMap::new));

            HashMap<MenuType, List<OrderUser>> sortedMap = new HashMap<>();
            unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            sortedMap.values().removeIf(e -> e.size() == 0);

            this.orderUserMap = sortedMap;
            return this;
        }

        public OrderCheckOutWrapper build() {
            return new OrderCheckOutWrapper(this);
        }
    }
}
