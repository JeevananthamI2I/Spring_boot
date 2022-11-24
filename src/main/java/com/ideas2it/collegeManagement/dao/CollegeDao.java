package com.ideas2it.collegeManagement.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.collegeManagement.model.College;

public interface CollegeDao extends JpaRepository<College, Integer> {
	
	List<College> findByStartDateBetweenEndDate(Date StartDate,Date EndDate);


}
