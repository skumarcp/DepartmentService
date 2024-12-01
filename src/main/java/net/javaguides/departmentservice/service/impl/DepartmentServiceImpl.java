package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.MapstructMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//        Department department =new Department(departmentDto.getId(),
//                departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode());

        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment= departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
//        return new DepartmentDto(department.getId(),
//                department.getDepartmentName(),department.getDepartmentDescription(),
//                department.getDepartmentCode());
        return MapstructMapper.MAPPER.toDepartmentDto(department);
    }


}
