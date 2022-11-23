package com.ideas2it.collegeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;
	
	@PostMapping("/addCollege")
	public College addCollege(@RequestBody College college) {
		return collegeService.saveCollege(college);
	}
	
	@PostMapping("/viewColleges")
	public List<College> viewCollege() {
		return collegeService.getColleges();
	}
	
	@PostMapping("/viewCollege/{id}")
	public College viewCollege(@PathVariable("id") int id) {
		return collegeService.getCollege(id);
	}
	
	@PostMapping("/deleteCollege/{id}")
	public String deleteCollege(@PathVariable int id) {
		return collegeService.deleteCollege(id);
	}
	
	@PostMapping("/updateCollege/{id}")
	public College updateCollege(@RequestBody College college, @PathVariable int id) {
		return collegeService.updateCollege(college, id);
	}
	

}
