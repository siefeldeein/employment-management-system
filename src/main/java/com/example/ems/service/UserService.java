package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.entity.Role;
import com.example.ems.entity.User;

public interface UserService {

    User createUser(String username, String rawPassword, Role role, Employee employee);

    boolean existsByUsername(String username);

    User getByUsername(String username);

    void linkEmployee(User user, Employee employee);
}