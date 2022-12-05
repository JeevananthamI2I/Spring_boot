package com.ideas2it.collegeManagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.collegeManagement.dto.StudentDto;
import com.ideas2it.collegeManagement.model.Student;

@Component
public class StudentConverter {

	public StudentDto entityToDto(Student student) {
		ModelMapper mapper = new ModelMapper();
		StudentDto studentDto = mapper.map(student, StudentDto.class);

		return studentDto;
	}

	public List<StudentDto> entityToDto(List<Student> students) {
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		for (Student student : students) {
			studentDtos.add(entityToDto(student));
		}
		return studentDtos;
	}

	public Student dtoToEntity(StudentDto studentDto) {
		ModelMapper mapper = new ModelMapper();
		Student student = mapper.map(studentDto, Student.class);
		return student;
	}
	
}