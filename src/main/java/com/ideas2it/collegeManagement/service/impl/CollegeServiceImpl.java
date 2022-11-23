package com.ideas2it.collegeManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.collegeManagement.dao.CollegeDao;
import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeDao collegeRepository;

	public College saveCollege(College college) {
		college.setCode(Code());
		return collegeRepository.save(college);
	}

	public String Code() {
		long value = collegeRepository.count();
		return "COLL" + (++value);
	}

	public List<College> getColleges() {
		return collegeRepository.findAll();
	}

	public College getCollege(int id) {
		return collegeRepository.findById(id).get();

	}

	public String deleteCollege(int id) {
		collegeRepository.deleteById(id);
		return "remove" + id;
	}

	public College updateCollege(College college, int id) {
		if(null != collegeRepository.findById(id)) {
		    collegeRepository.save(college);
		    return college;
		}
		return null;
	}

}
