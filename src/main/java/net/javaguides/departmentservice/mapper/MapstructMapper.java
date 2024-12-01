package net.javaguides.departmentservice.mapper;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MapstructMapper {

    MapstructMapper MAPPER= Mappers.getMapper(MapstructMapper.class);
    DepartmentDto toDepartmentDto(Department department);

    Department toDepartment(DepartmentDto departmentDto);
}
