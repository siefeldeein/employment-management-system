package com.example.ems.service;

import com.example.ems.entity.Role;

public interface RoleService {

    Role getEmployeeRole();

    Role getRoleByName(String name);
}
