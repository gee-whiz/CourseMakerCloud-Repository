/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Administrator;
import com.boha.coursemaker.data.GcmDevice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class AdministratorDTO {

    private Integer administratorID;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone, password;
    private long dateRegistered;
    private Integer activeFlag;
    private Integer companyID;
    private Integer superUserFlag;
    private List<GcmDeviceDTO> gcmDeviceList;

    public AdministratorDTO(Administrator a) {
        
        administratorID = a.getAdministratorID();
        password = a.getPassword();
        activeFlag = a.getActiveFlag();
        companyID = a.getCompany().getCompanyID();
        firstName = a.getFirstName();
        lastName = a.getLastName();
        superUserFlag = a.getSuperUserFlag();
        email = a.getEmail();
        cellphone = a.getCellphone();
        dateRegistered = a.getDateRegistered().getTime();
        if (a.getGcmDeviceList() != null) {
            gcmDeviceList = new ArrayList<GcmDeviceDTO>();
            for (GcmDevice g : a.getGcmDeviceList()) {
                gcmDeviceList.add(new GcmDeviceDTO(g));
            }
        }

    }

    public AdministratorDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GcmDeviceDTO> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public Integer getSuperUserFlag() {
        return superUserFlag;
    }

    public void setSuperUserFlag(Integer superUserFlag) {
        this.superUserFlag = superUserFlag;
    }

    public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

  

    public Integer getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Integer administratorID) {
        this.administratorID = administratorID;
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

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

   
}
