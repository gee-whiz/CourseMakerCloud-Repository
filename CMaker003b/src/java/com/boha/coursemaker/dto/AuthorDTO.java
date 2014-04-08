/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Author;
import com.boha.coursemaker.data.CourseAuthor;
import com.boha.coursemaker.data.GcmDevice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class AuthorDTO {

    private Integer authorID;

    private String firstName;

    private String lastName;

    private String email;

    private String cellphone;

    private String password;

    private long dateRegistered;

    private Integer companyID, activeFlag;
    private List<CourseDTO> courseList;
    private List<GcmDeviceDTO> gcmDeviceList;

    public AuthorDTO() {
    }

    public AuthorDTO(Author a) {
        authorID = a.getAuthorID();
        firstName = a.getFirstName();
        lastName = a.getLastName();
        email = a.getEmail();
        cellphone = a.getCellphone();
        password = a.getPassword();
        activeFlag = a.getActiveFlag();
        if (a.getDateRegistered() != null) {
            dateRegistered = a.getDateRegistered().getTime();
        }
        companyID = a.getCompany().getCompanyID();
        
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public List<GcmDeviceDTO> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }


    public List<CourseDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDTO> courseList) {
        this.courseList = courseList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

 
}
