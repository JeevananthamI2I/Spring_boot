package com.ideas2it.collegeManagement.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ideas2it.collegeManagement.converter.CollegeConverter;
import com.ideas2it.collegeManagement.dao.CollegeDao;
import com.ideas2it.collegeManagement.dto.CollegeDto;
import com.ideas2it.collegeManagement.dto.DepartmentDto;
import com.ideas2it.collegeManagement.model.College;
import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.service.CollegeService;
import com.ideas2it.collegeManagement.service.DepartmentService;
import com.ideas2it.collegeManagement.util.DateUtil;
import com.ideas2it.collegeManagement.util.constant.CollegeConstant;
import com.ideas2it.collegeManagement.util.enumeration.Type;
import com.ideas2it.collegeManagement.util.exception.CollegeManagementException;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeDao collegeRepository;
	private DepartmentService departmentService;
	private CollegeConverter collegeConverter;
	
	public College saveCollege(College college)  {
		college.setCode(generateCode());
		
		return college;
	}

	public String generateCode() {
		long value = collegeRepository.getCollegesCount();
		return "COLL" + (++value);
	}

	public List<College> getColleges() throws CollegeManagementException {
		List<College> colleges = collegeRepository.findAll();
		if(null == colleges) {
			throw new CollegeManagementException("no details found");
		}
		return colleges;
	}

	public College getCollege(int id) throws CollegeManagementException {
	   return collegeRepository.findById(id).orElseThrow();			

	}

	public String deleteCollege(int id) {
		collegeRepository.deleteById(id);
		return "Successful Delete your id " + id;
	}

	public CollegeDto updateCollege(CollegeDto collegeDto, int id) throws CollegeManagementException {
		CollegeDto existingCollege = null;
		
		if (collegeRepository.existsById(id)) {
			 existingCollege = collegeConverter.entityToDto(getCollege(id));
			if (null != existingCollege) {
				existingCollege.setName(collegeDto.getName());
				existingCollege.setPlace(collegeDto.getPlace());		
				existingCollege.setInaugurationDate(collegeDto.getInaugurationDate());
				existingCollege.setRank(collegeDto.getRank());
				existingCollege.setType(collegeDto.getType());
				existingCollege.setUniversity(collegeDto.getUniversity());
				if (null != collegeDto.getDepartments()) {
					List<Department> input = existingCollege.getDepartments();
					input.addAll(collegeDto.getDepartments());
					existingCollege.setDepartments(input);
				}
			}
		}
		return existingCollege;
	
	}

	public List<College> findCollegeByDate(Date startdate, Date endDate) {
		return collegeRepository.findByInaugurationDateBetween(startdate, endDate);
			 
	}

	
	public List<College> getCollegesByMultipleId(List<Integer> ids) {
		
		return collegeRepository.findByIdIn(ids);
	}

			
}
