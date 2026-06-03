package com.example.ems.attendance;

import com.example.ems.employee.Employee;
import com.example.ems.attendance.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in")
    private LocalTime checkIn;

    @Column(name = "check_out")
    private LocalTime checkOut;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING) // ← This maps PRESENT → 'PRESENT' in DB
    @Column(name = "status", nullable = false)
    private AttendanceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "employee_id",
        nullable = false
    )
    private Employee employee;




}
