/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Company;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class CompanyDTO {
    private Integer companyID;
    
    private String companyName;
    
    private String email;
    
    private long dateRegistered;
    
    private CityDTO city;
    private List<CourseDTO> courseList;
    private List<HelpTypeDTO> helpTypeList;
    private List<SkillDTO> skillList;
    private List<SkillLevelDTO> skillLevelList;
    public CompanyDTO() {}
    public CompanyDTO(Company a) {
        companyID = a.getCompanyID();
        companyName = a.getCompanyName();
        email = a.getEmail();
        dateRegistered = a.getDateRegistered().getTime();
        if (a.getCity() != null) {
            city = new CityDTO(a.getCity());
        }
       
    }

    public List<SkillDTO> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<SkillDTO> skillList) {
        this.skillList = skillList;
    }

    public List<SkillLevelDTO> getSkillLevelList() {
        return skillLevelList;
    }

    public void setSkillLevelList(List<SkillLevelDTO> skillLevelList) {
        this.skillLevelList = skillLevelList;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public List<HelpTypeDTO> getHelpTypeList() {
        return helpTypeList;
    }

    public void setHelpTypeList(List<HelpTypeDTO> helpTypeList) {
        this.helpTypeList = helpTypeList;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public List<CourseDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDTO> courseList) {
        this.courseList = courseList;
    }

    

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
