/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Instructor;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class InstructorDTO {
    private int instructorID;
    private String firstName;    
    private String lastName;
    private String email;
    private String cellphone, password;
    private long dateRegistered;
    private int activeFlag;
    private String cityName, companyName;
    private int cityID, companyID;
    private List<GcmDeviceDTO> gcmDeviceList;
    private List<InstructorClassDTO> instructorClassList;
    private List<HelpResponseDTO> helpResponseList;
    
    public InstructorDTO(Instructor a) {
        instructorID = a.getInstructorID();
        companyID = a.getCompany().getCompanyID();
        companyName = a.getCompany().getCompanyName();
        firstName = a.getFirstName();
        lastName = a.getLastName();
        password = a.getPassword();
        email = a.getEmail();
        cellphone = a.getCellphone();
        dateRegistered = a.getDateRegistered().getTime();
        activeFlag = a.getActiveFlag();
        if (a.getCity() != null) {
            cityID = a.getCity().getCityID();
            cityName = a.getCity().getCityName();
        }
        
    }

    public int getInstructorID() {
        return instructorID;
    }

    public String getPassword() {
        return password;
    }

    public List<GcmDeviceDTO> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public int getActiveFlag() {
        return activeFlag;
    }


    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    public List<InstructorClassDTO> getInstructorClassList() {
        return instructorClassList;
    }

    public void setInstructorClassList(List<InstructorClassDTO> instructorClassList) {
        this.instructorClassList = instructorClassList;
    }

    public List<HelpResponseDTO> getHelpResponseList() {
        return helpResponseList;
    }

    public void setHelpResponseList(List<HelpResponseDTO> helpResponseList) {
        this.helpResponseList = helpResponseList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
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

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }
    
}
