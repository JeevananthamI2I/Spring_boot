package com.ideas2it.collegeManagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;
	
	@PostMapping("/addCollege")
	public College addCollege(@RequestBody College college) {
		return collegeService.saveCollege(college);
	}
	
	@GetMapping("/viewColleges")
	public List<College> viewCollege() {
		return collegeService.getColleges();
	}
	
	@GetMapping("/viewCollege/{id}")
	public College viewCollege(@PathVariable("id") int id) {
		return collegeService.getCollege(id);
	}
	
	@DeleteMapping("/deleteCollege/{id}")
	public String deleteCollege(@PathVariable int id) {
		return collegeService.deleteCollege(id);
	}
	
	@PutMapping("/updateCollege/{id}")
	public College updateCollege(@RequestBody College college, @PathVariable("id") int id) {
		return collegeService.updateCollege(college, id);
	}
	
	@PutMapping("/updateDepartment/{id}")
	public List<College> rangeBetweenTwoDate(@Param("from") Date from, @Param("to") Date to) {
		return collegeService.rangeBetweenTwoDate(from, to);
	}

}
