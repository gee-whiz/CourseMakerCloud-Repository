/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TeamMember;

/**
 *
 * @author aubreyM
 */
public class TeamMemberDTO {

    private Integer teamMemberID, companyID;
    private long dateRegistered;
    private Integer activeFlag;
    private Integer traineeID;
    private Integer teamID;
    private String firstName, lastName, email, cellphone;
    
    public TeamMemberDTO(TeamMember a) {
        teamMemberID = a.getTeamMemberID();
        dateRegistered = a.getDateRegistered().getTime();
        activeFlag = a.getActiveFlag();
        traineeID = a.getTrainee().getTraineeID();
        firstName = a.getTrainee().getFirstName();
        lastName = a.getTrainee().getLastName();
        email = a.getTrainee().getEmail();
        cellphone = a.getTrainee().getCellphone();
        teamID = a.getTeam().getTeamID();
        companyID = a.getTrainee().getCompany().getCompanyID();
        
    }

    public Integer getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(Integer teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
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

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }
}
