package com.example.ems.repository;

import com.example.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameIgnoreCase(String fname);

    boolean existsByFirstNameIgnoreCase(String fname);

    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    @Query("SELECT DISTINCT e FROM Employee e " +
            "LEFT JOIN FETCH e.department d " +
            "WHERE e.firstName = :fname")
    List<Employee> findByFirstNameWithDepartment(@Param("fname") String fname);

    Optional<Employee> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);

    @Query("SELECT DISTINCT e FROM Employee e " +
            "LEFT JOIN FETCH e.department d " +
            "WHERE LOWER(e.fullName) LIKE LOWER(%:fullName%)")
    List<Employee> findByFullNameContainingWithDepartment(@Param("fullName") String fullName);


    @Query("SELECT DISTINCT e FROM Employee e " +
            "LEFT JOIN FETCH e.department d " +
            "WHERE LOWER(e.fullName) = LOWER(:fullName)")
    Optional<Employee> findByFullNameWithDepartment(@Param("fullName") String fullName);

}