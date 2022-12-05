package com.ideas2it.collegeManagement.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ideas2it.collegeManagement.model.College;

public interface CollegeDao extends JpaRepository<College, Integer> {
		
	@Query(value = "select count(id) from college" , nativeQuery = true)
    Long getCollegesCount();
	
	@Query("select c from College c where c.name like %:keyword% or c.name like %:keyword% or c.university like %:keyword%")
    List<College> searchProduct(@Param("keyword") String value);

    List<College> findByInaugurationDateBetween(Date startDate, Date endDate);

    List<College> findByIdIn(List<Integer> ids);

}
