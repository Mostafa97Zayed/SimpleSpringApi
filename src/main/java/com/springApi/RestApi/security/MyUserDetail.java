package com.springApi.RestApi.security;

import com.springApi.RestApi.Model.Doctor;
import com.springApi.RestApi.dao.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.springApi.RestApi.security.Roles.ADMIN;

@Service
public class MyUserDetail implements UserDetailsService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private MyUserDetail myUserDetail;


    @Override
    public UserDetails loadUserByUsername(String name) {
        final Doctor customer = doctorRepo.findByName(name);
        if (customer == null) {
            throw new UsernameNotFoundException(name);
        }
        UserDetails user = User.withUsername(customer.getName()).password(customer.getPassword())
                .roles(customer.getRole()).build();

        return user;
    }
}

