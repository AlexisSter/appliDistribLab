package com.application.td1.service;

import com.application.td1.model.CustomUserDetail;
import com.application.td1.model.Role;
import com.application.td1.model.Users;

import com.application.td1.repository.RoleRepository;
import com.application.td1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service


public class CustomUserServiceDetail implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <Users> usersOptional = userRepository.findByLastName(username);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        CustomUserDetail user =usersOptional
                .map(CustomUserDetail::new)
                .get();

        return new CustomUserDetail(user);
    }

    public void create(Users user,String roleName) {
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole(roleName);
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }


}
