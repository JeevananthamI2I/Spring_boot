package com.ideas2it.collegeManagement.dto;

import java.util.Date;
import java.util.List;

import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.util.enumeration.Type;

public class CollegeDto {

	private int id;
	private String name;	
	private String university;
	private String rank;
	private String place;
	private Date inaugurationDate;
	private Type type;
	private String code;
	private List<Department> departments;

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getInaugurationDate() {
		return inaugurationDate;
	}

	public void setInaugurationDate(Date inaugurationDate) {
		this.inaugurationDate = inaugurationDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
//	public List<Department> getDepartments() {
//		return departments;
//	}
//
//	public void setDepartments(List<Department> departments) {
//		this.departments = departments;
//	}

}
