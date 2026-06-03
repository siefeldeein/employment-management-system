package com.example.ems.mapper;

import com.example.ems.dto.request.DepartmentCreateReq;
import com.example.ems.dto.request.DepartmentUpdateReq;
import com.example.ems.dto.response.DepartmentResponse;
import com.example.ems.dto.response.DepartmentDetailsResponse;
import com.example.ems.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface DepartmentMapper {

//    @Mapping(target = "employeeList", ignore = true)
    Department toEntity(DepartmentCreateReq req);

//    @Mapping(target = "employeeList", ignore = true)
    void updateDepartment(DepartmentUpdateReq updateReq, @MappingTarget Department department);

    DepartmentResponse toDtoResponse(Department department);

    DepartmentDetailsResponse toDtoResponseDetails(Department department);



}
