/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TraineeShout;

/**
 *
 * @author aubreyM
 */
public class TraineeShoutDTO {
     private Integer traineeShoutID;    
    private long dateRegistered;    
    private String remarks;    
    private Integer traineeID;  
    private Integer helpTypeID;
    
    public TraineeShoutDTO(TraineeShout a) {
        traineeShoutID = a.getTraineeShoutID();
        dateRegistered = a.getDateRegistered().getTime();
        remarks = a.getRemarks();
        traineeID = a.getTrainee().getTraineeID();
        helpTypeID = a.getHelpType().getHelpTypeID();
    }

    public Integer getTraineeShoutID() {
        return traineeShoutID;
    }

    public void setTraineeShoutID(Integer traineeShoutID) {
        this.traineeShoutID = traineeShoutID;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public Integer getHelpTypeID() {
        return helpTypeID;
    }

    public void setHelpTypeID(Integer helpTypeID) {
        this.helpTypeID = helpTypeID;
    }
}
