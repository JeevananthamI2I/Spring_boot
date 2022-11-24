package com.ideas2it.collegeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.model.Student;
import com.ideas2it.collegeManagement.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student Student) {
		return studentService.saveStudent(Student);
	}

	@GetMapping("/viewStudents")
	public List<Student> viewStudent() {
		return studentService.getStudents();
	}

	@GetMapping("/viewStudent/{id}")
	public Student viewStudent(@PathVariable("id") int id) {
		return studentService.getStudent(id);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student Student, @PathVariable("id") int id) {
		return studentService.updateStudent(Student, id);
	}
}
