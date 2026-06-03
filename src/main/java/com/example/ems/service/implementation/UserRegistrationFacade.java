package com.example.ems.service.implementation;

import com.example.ems.dto.request.RegisterRequest;
import com.example.ems.dto.response.AuthResponse;
import com.example.ems.entity.Employee;
import com.example.ems.entity.Role;
import com.example.ems.entity.User;
import com.example.ems.exception.DuplicateResourceException;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.RoleRepository;
import com.example.ems.repository.UserRepository;
import com.example.ems.security.CustomUserDetailsService;
import com.example.ems.security.JwtService;
import com.example.ems.service.AuthService;
import com.example.ems.service.EmployeeService;
import com.example.ems.service.RoleService;
import com.example.ems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationFacade {

    private final UserService userService;
    private final RoleService roleService;
    private final EmployeeService employeeService;
    private final AuthService authService;

    public AuthResponse register(RegisterRequest request) {

        // 1- Check if user already exists
        if (userService.existsByUsername(request.getUsername())){
           throw new DuplicateResourceException("This username already exists");
        }

        // 2- load Employee
        Employee employee =
        employeeService.getEmployeeByEmail(request.getEmail());

        // 3- load Role
        Role role = roleService.getEmployeeRole();

        // 4- create user
        User user = userService.createUser(
        request.getUsername(),
        request.getPassword(),
        role,
        employee
        );

        return new AuthResponse(
        authService.generateToken(user)
        );
    }
}
