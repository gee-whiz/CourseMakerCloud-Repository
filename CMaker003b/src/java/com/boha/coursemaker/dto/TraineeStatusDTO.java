/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TraineeStatus;

/**
 *
 * @author aubreyM
 */
public class TraineeStatusDTO {
   private int traineeStatusID;
    
    private long dateUpdated;
    
    private String remarks;
    
    private TraineeStatusTypeDTO traineeStatusType;
    
    private int traineeID;
    
    public TraineeStatusDTO(TraineeStatus a) {
        traineeID = a.getTrainee().getTraineeID();
        dateUpdated = a.getDateUpdated().getTime();
        remarks = a.getRemarks();
        traineeStatusType = new TraineeStatusTypeDTO(a.getTraineeStatusType());
        traineeStatusID = a.getTraineeStatusID();
    }

    public int getTraineeStatusID() {
        return traineeStatusID;
    }

    public void setTraineeStatusID(int traineeStatusID) {
        this.traineeStatusID = traineeStatusID;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public TraineeStatusTypeDTO getTraineeStatusType() {
        return traineeStatusType;
    }

    public void setTraineeStatusType(TraineeStatusTypeDTO traineeStatusType) {
        this.traineeStatusType = traineeStatusType;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }
 
}
