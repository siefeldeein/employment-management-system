package com.example.ems.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDetailsResponse {

    private Long id;
    private String name;
    private String description;
    private List<EmployeeResponse> employeeList;
}
