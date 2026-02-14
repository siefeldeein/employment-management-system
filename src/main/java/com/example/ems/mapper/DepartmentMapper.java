package com.example.ems.mapper;

import com.example.ems.dto.request.DepartmentCreateReq;
import com.example.ems.dto.request.DepartmentUpdateReq;
import com.example.ems.dto.response.DepartmentResponse;
import com.example.ems.dto.response.DepartmentDetailsResponse;
import com.example.ems.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface DepartmentMapper {

    public Department toEntity(DepartmentCreateReq req);

    public DepartmentResponse toDtoResponse(Department department);

    public DepartmentDetailsResponse toDtoResponseDetails(Department department);

    void updateDepartment(DepartmentUpdateReq updateReq, @MappingTarget Department department);

}
