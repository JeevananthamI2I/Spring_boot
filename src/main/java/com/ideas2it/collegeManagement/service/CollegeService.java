package com.ideas2it.collegeManagement.service;

import java.util.List;

import com.ideas2it.collegeManagement.model.College;

public interface CollegeService {

	public College saveCollege(College college);
	
	public String Code();

	public List<College> getColleges();
	
	public College getCollege(int id);
	
	public String deleteCollege(int id);

	public College updateCollege(College college, int id);

}
