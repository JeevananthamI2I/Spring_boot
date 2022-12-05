package com.ideas2it.collegeManagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.collegeManagement.dto.CollegeDto;
import com.ideas2it.collegeManagement.model.College;

@Component
public class CollegeConverter {

	public CollegeDto entityToDto(College college) {
		ModelMapper mapper = new ModelMapper();
		CollegeDto collegeDto = mapper.map(college, CollegeDto.class);

		return collegeDto;
	}

	public List<CollegeDto> entityToDto(List<College> colleges) {
		List<CollegeDto> collegeDtos = new ArrayList<CollegeDto>();
		for (College college : colleges) {
			collegeDtos.add(entityToDto(college));
		}
		return collegeDtos;
	}

	public College dtoToEntity(CollegeDto collegeDto) {
		ModelMapper mapper = new ModelMapper();
		College college = mapper.map(collegeDto, College.class);
		return college;
	}
}
