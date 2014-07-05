/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Team;
import com.boha.coursemaker.data.TeamMember;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class TeamDTO {

    private int teamID;
    private String teamName, trainingClassName;
    private long dateRegistered;
    private int trainingClassID;
    private List<TeamMemberDTO> teamMemberList;
    
    public TeamDTO(Team a) {
        teamID = a.getTeamID();
        teamName = a.getTeamName();
        dateRegistered = a.getDateRegistered().getTime();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        trainingClassName = a.getTrainingClass().getTrainingClassName();
        teamMemberList = new ArrayList<>();
        if (a.getTeamMemberList() != null) {          
            for (TeamMember tm : a.getTeamMemberList()) {
                teamMemberList.add(new TeamMemberDTO(tm));
            }
        }
    }

    public int getTeamID() {
        return teamID;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public List<TeamMemberDTO> getTeamMemberList() {
        return teamMemberList;
    }

    public void setTeamMemberList(List<TeamMemberDTO> teamMemberList) {
        this.teamMemberList = teamMemberList;
    }
}
