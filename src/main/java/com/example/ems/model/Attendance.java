package com.example.ems.model;

import com.example.ems.model.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @Column(name = "check_out")
    private LocalDateTime checkout;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING) // ← This maps PRESENT → 'PRESENT' in DB
    @Column(name = "status")
    private AttendanceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "employee_id",
        nullable = false
    )
    private Employee employee;




}
