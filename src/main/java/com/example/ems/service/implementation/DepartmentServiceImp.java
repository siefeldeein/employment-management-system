package com.example.ems.service.implementation;

import com.example.ems.dto.request.DepartmentCreateReq;
import com.example.ems.dto.request.DepartmentUpdateReq;
import com.example.ems.dto.response.DepartmentResponse;
import com.example.ems.mapper.DepartmentMapper;
import com.example.ems.model.Department;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImp implements DepartmentService {

    final private DepartmentMapper departmentMapper;
    final private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreateReq createReq) {

        if (departmentRepository.existsByNameIgnoreCase(createReq.getName())) {
            throw new DataIntegrityViolationException("Department name '" + createReq.getName() + "' already exists");
        }

        Department department = departmentMapper.toEntity(createReq);

        Department savedDepartment = departmentRepository.save(department);

        return departmentMapper.toDtoResponse(savedDepartment);
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department returnedDepartment = departmentRepository.findById(id).orElseThrow();

        return departmentMapper.toDtoResponse(returnedDepartment);
    }

    @Override
    public DepartmentResponse getDepartmentByName(String name) {
        Department returnedDepartment = departmentRepository.findByNameIgnoreCase(name).orElseThrow();

        return departmentMapper.toDtoResponse(returnedDepartment);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream()
            .map(departmentMapper::toDtoResponse)
            .collect(Collectors.toList());


    }

    @Override
    public Page<DepartmentResponse> getAllDepartments(Pageable pageable) {
        Page<Department> departments = departmentRepository.findAll(pageable);

        return departments.map(departmentMapper::toDtoResponse);

    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentUpdateReq updateReq) {
       Department department = departmentRepository.findById(id).orElseThrow();

       if (updateReq.getName() != null &&
            departmentRepository.existsByNameIgnoreCase(updateReq.getName()))
       {
         throw new DataIntegrityViolationException("Name already exists");
       }
       departmentMapper.updateDepartment(updateReq, department);

       Department updatedDepartment = departmentRepository.save(department);

       return departmentMapper.toDtoResponse(updatedDepartment);
    }


}
