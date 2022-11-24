package com.ideas2it.collegeManagement.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.collegeManagement.dao.CollegeDao;
import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.service.CollegeService;
import com.ideas2it.collegeManagement.util.DateUtil;
import com.ideas2it.collegeManagement.util.enumeration.Type;
import com.ideas2it.collegeManagement.util.exception.CollegeManagementException;

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
		return "Successful Delete your id " + id;
	}

	public College updateCollege(College college, int id) {
		College existingCollege = collegeRepository.findById(id).orElse(null);
		if(null != existingCollege) {
		existingCollege.setName(college.getName());
		existingCollege.setPlace(college.getPlace());		
		existingCollege.setInaugurationDate(college.getInaugurationDate());
		existingCollege.setRank(college.getRank());
		existingCollege.setType(college.getType());
		existingCollege.setUniversity(college.getUniversity());
		}
		collegeRepository.save(existingCollege);
		return existingCollege;
		
	}

	@Override
	public List<College> rangeBetweenTwoDate(Date from, Date to) {
		
		return null;
	}

}
