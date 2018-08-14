package com.bonappetit.app.service.Impl;

import com.bonappetit.app.model.userSection.Roles;
import com.bonappetit.app.model.userSection.Users;
import com.bonappetit.app.model.userSection.rolesType.RolesType;
import com.bonappetit.app.repository.RoleRepository;
import com.bonappetit.app.repository.UsersRepository;
import com.bonappetit.app.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService, UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users saveUser(@Valid Users users) throws RoleNotFoundException, UsernameNotFoundException {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Roles userRoles = roleRepository.findByRole(String.valueOf(RolesType.CAFETERIA_MANAGER)).orElseThrow(() -> new RoleNotFoundException("Role not found in registration."));
        users.setRoles(new HashSet<>(Collections.singletonList(userRoles)));
        return usersRepository.save(users);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return new User(user.getUserName(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Roles> userRoles) {
        return userRoles.stream().map(roles -> new SimpleGrantedAuthority(roles.getRole())).distinct().collect(Collectors.toList());
    }
}
