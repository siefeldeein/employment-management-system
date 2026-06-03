package com.example.ems.service;

import com.example.ems.dto.request.EmployeeCreateRequest;
import com.example.ems.dto.request.EmployeeUpdateRequest;
import com.example.ems.dto.response.EmployeeResponse;
import com.example.ems.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    // Create
    EmployeeResponse createEmployee(EmployeeCreateRequest request);

    // Read
    EmployeeResponse getEmployeeById(Long id);
    Employee getEmployeeByEmail(String email);
    List<EmployeeResponse> getAllEmployees();
    List<EmployeeResponse> getEmployeesByFullNameContaining(String name);

    // Update
    EmployeeResponse updateEmployee(Long id, EmployeeUpdateRequest request);

    // Delete
    void deleteEmployee(Long id);

    Page<EmployeeResponse> getAllEmployees(Pageable pageable);
}
