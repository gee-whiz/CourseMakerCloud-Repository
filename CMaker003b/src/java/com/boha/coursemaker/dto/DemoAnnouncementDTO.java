/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.DemoAnnouncement;

/**
 *
 * @author aubreyM
 */
public class DemoAnnouncementDTO {

    private int demoAnnouncementID;
    private long demoDate;
    private int teamID;
    private long dateRequested, cancellationDate;
    private String description;
    private int traineeID;
    private int trainingClassID;
    
    public DemoAnnouncementDTO(DemoAnnouncement a) {
        demoAnnouncementID = a.getDemoAnnouncementID();
        demoDate = a.getDemoDate().getTime();
        description = a.getDescription();
        dateRequested = a.getDateRequested().getTime();
        if (a.getCancellationDate() != null) {
            cancellationDate = a.getCancellationDate().getTime();
        }
        
        if (a.getTeam() != null) {
            teamID = a.getTeam().getTeamID();
        }
        if (a.getTrainee() != null) {
            traineeID = a.getTrainee().getTraineeID();
        }
        if (a.getTrainingClass() != null) {
            trainingClassID = a.getTrainingClass().getTrainingClassID();
        }
    }

    public int getDemoAnnouncementID() {
        return demoAnnouncementID;
    }

    public long getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(long cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public void setDemoAnnouncementID(int demoAnnouncementID) {
        this.demoAnnouncementID = demoAnnouncementID;
    }

    public long getDemoDate() {
        return demoDate;
    }

    public void setDemoDate(long demoDate) {
        this.demoDate = demoDate;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public long getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(long dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }
}
