package com.ideas2it.collegeManagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.converter.CollegeConverter;
import com.ideas2it.collegeManagement.dto.CollegeDto;
import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.service.CollegeService;
import com.ideas2it.collegeManagement.util.DateUtil;
import com.ideas2it.collegeManagement.util.exception.CollegeManagementException;

@RestController
public class CollegeController {

	@Autowired
	CollegeService collegeService;
	@Autowired
	CollegeConverter collegeConverter;

	@PostMapping("/addCollege")
	public CollegeDto addCollege(@RequestBody College college){
		return collegeConverter.entityToDto(collegeService.saveCollege(college));
	}

	@GetMapping("/viewColleges")
	public List<CollegeDto> viewCollege() throws CollegeManagementException {
		return collegeConverter.entityToDto(collegeService.getColleges());
	}

	@GetMapping("/viewCollege/{id}")
	public CollegeDto viewCollege(@PathVariable("id") int id) throws CollegeManagementException {
		return collegeConverter.entityToDto(collegeService.getCollege(id));
	}

	@DeleteMapping("/deleteCollege/{id}")
	public String deleteCollege(@PathVariable int id) {
		return collegeService.deleteCollege(id);
	}

	@PutMapping("/updateCollege/{id}")
	public CollegeDto updateCollege(@RequestBody College college, @PathVariable("id") int id) {
		CollegeDto collegeDto = collegeConverter.entityToDto(college);
		return collegeService.updateCollege(collegeDto, id);
	}

	@GetMapping("/getDate/{startDate}/{endDate}")
	public ResponseEntity<List<College>> findCollegeBetweenDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		try {
			return new ResponseEntity<List<College>>(
					collegeService.findCollegeByDate(DateUtil.parseDate(startDate), DateUtil.parseDate(endDate)),
					HttpStatus.OK);
		} catch (CollegeManagementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getCollegeByIds/{ids}")
	public ResponseEntity<List<College>> getCollege(@PathVariable("ids") String id) {
		List<Integer> ids = new ArrayList<>();
		for (String a : Arrays.asList(id.split(","))) {
			ids.add(Integer.parseInt(a));
		}
		return new ResponseEntity<List<College>>(collegeService.getCollegesByMultipleId(ids), HttpStatus.OK);
	}

}
