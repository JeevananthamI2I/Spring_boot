package com.ideas2it.collegeManagement.dto;

import java.util.List;

import com.ideas2it.collegeManagement.model.College;

public class DepartmentDto {
	private int id;
	private String name;
	private String code;
	private List<College> colleges;

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
