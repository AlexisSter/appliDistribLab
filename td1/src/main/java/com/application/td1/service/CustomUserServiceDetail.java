package com.application.td1.service;

import com.application.td1.model.*;

import com.application.td1.repository.EmployeeRepository;
import com.application.td1.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service


public class CustomUserServiceDetail implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeesEntity> usersOptional = employeeRepository.findByEmail(username);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        System.out.println(usersOptional.get().getEmployeeId());
        System.out.println(usersOptional.get().getPassword());
        System.out.println(usersOptional.get().getJobId().getJobId());
        CustomUserDetail user =usersOptional
                .map(CustomUserDetail::new)
                .get();



        return new CustomUserDetail(user);
    }

    public void create(EmployeesEntity user,String roleName) throws UsernameNotFoundException{
        int count =0;

        List<EmployeesEntity> t = employeeRepository.findAll();
        for(int i =0 ; i<t.size();i++){
            if(count<=t.get(i).getEmployeeId()){
                count = t.get(i).getEmployeeId();
            }
        }
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEmployeeId(count+1);
        user.setHireDate(new Date(System.currentTimeMillis()));
        JobsEntity a = jobRepository.findByJobId(roleName);
        user.setJobId(a);

        employeeRepository.save(user);


    }


}
