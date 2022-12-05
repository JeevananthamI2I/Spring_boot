package com.ideas2it.collegeManagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.collegeManagement.dto.DepartmentDto;
import com.ideas2it.collegeManagement.model.Department;

@Component
public class DepartmentConverter {

		public DepartmentDto entityToDto(Department department) {
			ModelMapper mapper = new ModelMapper();
			DepartmentDto departmentDto = mapper.map(department, DepartmentDto.class);

			return departmentDto;
		}

		public List<DepartmentDto> entityToDto(List<Department> Departments) {
			List<DepartmentDto> departmentDtos = new ArrayList<DepartmentDto>();
			for (Department department : Departments) {
				departmentDtos.add(entityToDto(department));
			}
			return departmentDtos;
		}

		public Department dtoToEntity(DepartmentDto departmentDto) {
			ModelMapper mapper = new ModelMapper();
			Department department = mapper.map(departmentDto, Department.class);
			return department;
		}
		
	}