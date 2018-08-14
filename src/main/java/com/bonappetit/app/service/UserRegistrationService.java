package com.bonappetit.app.service;

import com.bonappetit.app.model.userSection.Users;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

public interface UserRegistrationService {
    Users saveUser(@Valid Users users) throws RoleNotFoundException, UsernameNotFoundException;
}
