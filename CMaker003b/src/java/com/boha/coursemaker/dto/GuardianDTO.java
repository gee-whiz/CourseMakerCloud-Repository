/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.data.Guardian;
import com.boha.coursemaker.data.GuardianTrainee;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.util.EMUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author aubreyM
 */
public class GuardianDTO {

    private Integer guardianID;
    private String name;
    private String lastName;
    private String email;
    private String cellphone;
    private long dateRegistered;
    private List<TraineeDTO> traineeList;
    
    public GuardianDTO(Guardian a) {
        guardianID = a.getGuardianID();
        name = a.getName();
        lastName = a.getLastName();
        email = a.getEmail();
        cellphone = a.getCellphone();
        dateRegistered = a.getDateRegistered().getTime();
        EntityManager em = EMUtil.getEntityManager();
        traineeList  = new ArrayList<>(); 
        
    }
    

    public Integer getGuardianID() {
        return guardianID;
    }

    public void setGuardianID(Integer guardianID) {
        this.guardianID = guardianID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
