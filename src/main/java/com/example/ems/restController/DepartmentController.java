package com.example.ems.restController;

import com.example.ems.dto.request.DepartmentCreateReq;
import com.example.ems.dto.request.DepartmentUpdateReq;
import com.example.ems.dto.response.DepartmentDetailsResponse;
import com.example.ems.dto.response.DepartmentResponse;
import com.example.ems.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/departments")
// Security model:
// - READ (GET): Public or authenticated users
// - WRITE (POST/PUT/DELETE): ADMIN only
public class DepartmentController {

    // 1️⃣ DEPENDENCIES (top of class)
    private final DepartmentService departmentService;

    // 2️⃣ CREATE METHOD
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(@Valid @RequestBody DepartmentCreateReq createReq){
        DepartmentResponse departmentResponse = departmentService.createDepartment(createReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponse);

    }

    // 3️⃣ READ METHODS GROUP
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(){
        List<DepartmentResponse> departmentResponses = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentResponses);
    }
    @GetMapping("/paginated")
    public ResponseEntity<Page<DepartmentResponse>> getAllDepartments(Pageable pageable){
        Page<DepartmentResponse> departmentResponse = departmentService.getAllDepartments(pageable);
        return ResponseEntity.ok(departmentResponse);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long id){
        DepartmentResponse departmentResponse = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentResponse);
    }
    @GetMapping("/{id}/employees")
    public ResponseEntity<DepartmentDetailsResponse> getDepartmentByIdWithEmployees(@PathVariable Long id){
        DepartmentDetailsResponse departmentDetailsResponse = departmentService.getDepartmentByIdWithEmployees(id);
        return ResponseEntity.ok(departmentDetailsResponse);
    }

    // 4️⃣ UPDATE METHOD
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentUpdateReq updateReq){
       DepartmentResponse departmentResponse = departmentService.updateDepartment(id, updateReq);
       return ResponseEntity.ok(departmentResponse);
    }

    // 5️⃣ DELETE METHOD
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

}
