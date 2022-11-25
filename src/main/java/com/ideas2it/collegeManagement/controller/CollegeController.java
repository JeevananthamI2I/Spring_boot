package com.ideas2it.collegeManagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.service.CollegeService;
import com.ideas2it.collegeManagement.util.DateUtil;
import com.ideas2it.collegeManagement.util.exception.CollegeManagementException;

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

//	@GetMapping("/rangeBetweenTwoDate/{inauguration_date}")
//	public ResponseEntity<List<College>> rangeBetweenTwoDate(@Param("startDate")Date startDate,@Param("endDate")Date endDate) {
//		return new ResponseEntity<List<College>> (collegeService.rangeBetweenTwoDate(startDate, endDate), HttpStatus.OK);
//	}

//	@GetMapping("/getCollegesByMultipleId/{Ids}")
//	public ResponseEntity<List<College>> getCollegesByMultipleId(@PathVariable List<Long> Ids) {
//		return new ResponseEntity<List<College>> (collegeService.getCollegesByMultipleId(Ids), HttpStatus.OK);
//
//	} 
	
	@GetMapping("/getDate/{startDate}/{endDate}")
    public ResponseEntity<List<College>> findCollegeBetweenDate(@PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate) {
        try {
			return new ResponseEntity<List<College>> (collegeService.findCollegeByDate(DateUtil.parseDate(startDate), DateUtil.parseDate(endDate)), HttpStatus.OK);
		} catch (CollegeManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    @GetMapping("/getCollegeByIds/{ids}")
    public ResponseEntity<List<College>> getCollege(@PathVariable("ids") String id) {
        List<Integer> ids = new ArrayList<>();
        for (String a: Arrays.asList(id.split(","))) {
            ids.add(Integer.parseInt(a));
        }
        return new ResponseEntity<List<College>> (collegeService.getCollegesByMultipleId(ids), HttpStatus.OK);
    }

}
