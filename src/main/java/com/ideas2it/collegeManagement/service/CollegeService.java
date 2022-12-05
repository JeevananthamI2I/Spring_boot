package com.ideas2it.collegeManagement.service;

import java.util.Date;
import java.util.List;

import com.ideas2it.collegeManagement.dto.CollegeDto;
import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.util.exception.CollegeManagementException;

public interface CollegeService {

	public College saveCollege(College college);
	
	public String generateCode();

	public List<College> getColleges() throws CollegeManagementException;
	
	public College getCollege(int id) throws CollegeManagementException;
	
	public String deleteCollege(int id);

	public CollegeDto updateCollege(CollegeDto collegeDto, int id) throws CollegeManagementException;

	public List<College> findCollegeByDate(Date startDate, Date endDate);

	public List<College> getCollegesByMultipleId(List<Integer> ids);

}
