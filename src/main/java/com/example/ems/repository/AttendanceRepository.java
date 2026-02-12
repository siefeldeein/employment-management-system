package com.example.ems.repository;

import com.example.ems.model.Attendance;
import com.example.ems.model.enums.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {


    Optional<Attendance> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

    // check attendance of specific date or todays
    List<Attendance> findByDate(LocalDate date);

    List<Attendance> findByEmployeeId(Long employeeId);

    List<Attendance> findByStatus(AttendanceStatus status);

    @Query("SELECT DISTINCT a FROM Attendance a " +
            "LEFT JOIN FETCH a.employee e " +
            "WHERE a.status = :status ")
    List<Attendance> findByStatusWithEmployees(@Param("status") AttendanceStatus status);

    List<Attendance> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Attendance> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);

    boolean existsByEmployeeIdAndDate(Long employeeId, LocalDate date);

    @Query("SELECT DISTINCT a FROM Attendance a " +
            "LEFT JOIN FETCH a.employee e " +
            "WHERE a.id = :id ")
    Optional<Attendance> findByIdWithEmployee(@Param("id") Long id);



}