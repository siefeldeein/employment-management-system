package com.example.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    
    @Column(name = "description")
    @NotNull
    private String description;

    @OneToMany(mappedBy = "department",
        cascade = {CascadeType.MERGE,CascadeType.PERSIST}
    )
    private List<Employee> employeeList = new ArrayList<>();



}
