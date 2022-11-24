package com.ideas2it.collegeManagement.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * <p>
 * The College class have attributes.
 * This class contain getter and setter method for student attributes
 * </p>
 *
 * @author jeevanantham
 * @version 1.0  10 AUG 2022
 */
@SQLDelete(sql = "UPDATE students SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Entity
@Table(name = "students")
public class Student extends BaseModel {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "mobile_number", nullable = false)
    private long mobileNumber;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "place", nullable = false)
    private String place;
    @Column(name = "code", unique = true, nullable = false)
    private String code;
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Student () {}
    public Student (
        String firstName,
        String lastName,
        long mobileNumber,
        String place,
        Date dateOfBirth,
        String code) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.place = place;
        this.dateOfBirth = dateOfBirth;
        this.code = code;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getLastName() {
        return lastName;
    }
   
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPlace(String place) {
        this.place = place;
    }
 
    public String getPlace() {
        return place;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() { 
        return department;
    }
}