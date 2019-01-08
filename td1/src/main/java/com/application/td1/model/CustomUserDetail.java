package com.application.td1.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetail extends EmployeesEntity implements UserDetails {

    public CustomUserDetail(final EmployeesEntity users) {

        super(users);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ super.getJobId().getJobId()));
        System.out.println(authorities);
        return authorities;


    }

    @Override
    public String getPassword() {
        System.out.println("pass : "+super.getPassword());
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("lastname : "+super.getLastName());
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
