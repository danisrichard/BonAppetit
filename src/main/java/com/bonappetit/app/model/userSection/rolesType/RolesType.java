package com.bonappetit.app.model.userSection.rolesType;

import org.springframework.security.core.GrantedAuthority;

public enum RolesType implements GrantedAuthority {
    CAFETERIA_MANAGER;

    RolesType() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}