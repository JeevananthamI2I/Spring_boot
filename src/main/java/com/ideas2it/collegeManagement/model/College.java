package com.ideas2it.collegeManagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.ideas2it.collegeManagement.util.enumeration.Type;

@SQLDelete(sql = "UPDATE College SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Entity
public class College extends BaseModel {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "university", nullable = false)
	private String university;

	@Column(name = "grade", nullable = false)
	private String rank;

	@Column(name = "place", nullable = false)
	private String place;

	@Column(name = "inauguration_date", nullable = false)
	private Date inaugurationDate;

	@Column(name = "type", nullable = false)
	private Type type;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	// @ManyToMany(mappedBy = "colleges", fetch = FetchType.LAZY)

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "colleges_departments", joinColumns = {
//			@JoinColumn(name = "college_id", nullable = false, updatable = false) }, inverseJoinColumns = {
//					@JoinColumn(name = "department_id", nullable = false, updatable = false) })
//	private List<Department> departments;

	public College() {
	}

	public College(String name, String university, String rank, String place, Date inaugurationDate, Type type,
			String code, List<Department> departments) {
		this.name = name;
		this.university = university;
		this.rank = rank;
		this.place = place;
		this.inaugurationDate = inaugurationDate;
		this.type = type;
		this.code = code;
		//this.departments = departments;
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
