package com.ideas2it.collegeManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.collegeManagement.dao.StudentDao;
import com.ideas2it.collegeManagement.model.Student;
import com.ideas2it.collegeManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentRepository;

	public Student saveStudent(Student student) {
		student.setCode(Code());
		return studentRepository.save(student);
	}

	public String Code() {
		long value = studentRepository.getStudentCount();
		return "STU" + (++value);
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(int id) {
		return studentRepository.findById(id).get();
	}

	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Delete Succcessful Your Id " + id;
	}

	public Student updateStudent(Student student, int id) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if (null != existingStudent) {
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setPlace(student.getPlace());
			existingStudent.setDateOfBirth(student.getDateOfBirth());
			existingStudent.setMobileNumber(student.getMobileNumber());
		}
		studentRepository.save(existingStudent);
		return existingStudent;

	}

}
