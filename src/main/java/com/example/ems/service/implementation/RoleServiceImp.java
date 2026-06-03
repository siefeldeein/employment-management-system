package com.example.ems.service.implementation;

import com.example.ems.entity.Role;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.RoleRepository;
import com.example.ems.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getEmployeeRole() {
        return roleRepository.findByName("ROLE_EMPLOYEE")
        .orElseThrow(() ->
        new ResourceNotFoundException("ROLE_EMPLOYEE not found"));
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name)
        .orElseThrow(() ->
        new ResourceNotFoundException("Role not found: " + name));
    }
}