package com.ideas2it.collegeManagement.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * <p>
 * The College class have attributes.
 * This class contain getter and setter method for department attributes
 * </p>
 *
 * @author jeevanantham
 * @version 1.0  22 SEP 2022
 */

@SQLDelete(sql = "UPDATE departments SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Entity
@Table(name = "departments")
public class Department extends BaseModel {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", unique = true, nullable = false)
    private String code;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "colleges_departments",
//    joinColumns = {@JoinColumn(name = "department_id" ,nullable = false, updatable = false)},
//    inverseJoinColumns = {@JoinColumn(name = "college_id",nullable = false, updatable = false)})
   
    @ManyToMany(mappedBy = "departments", fetch = FetchType.LAZY)
    private List<College> colleges;
    
    @OneToMany(mappedBy = "department",cascade = {CascadeType.ALL})
    private List<Student> students;

    public Department(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public  Department() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }

//    public void setColleges(List<College> colleges) {
//        this.colleges = colleges;
//    }
//
//    public List<College> getColleges() {
//        return colleges;
//    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    } 
}