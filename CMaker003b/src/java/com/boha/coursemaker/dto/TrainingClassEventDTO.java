/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TrainingClassEvent;

/**
 *
 * @author aubreyM
 */
public class TrainingClassEventDTO {

    private int trainingClassEventID;

    private String eventName;
    private String description;
    private long dateRegistered;
    private String location;
    private long startDate;
    private long endDate;
    private int trainingClassID, trainingClassCourseID;

    public TrainingClassEventDTO(TrainingClassEvent a) {
        trainingClassEventID = a.getTrainingClassEventID();
        eventName = a.getEventName();
        description = a.getDescription();
        dateRegistered = a.getDateRegistered().getTime();
        location = a.getLocation();
        startDate = a.getStartDate().getTime();
        endDate = a.getEndDate().getTime();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        if (a.getTrainingClassCourse() != null) {
            trainingClassCourseID = a.getTrainingClassCourse().getTrainingClassCourseID();
        }
    }

    public int getTrainingClassEventID() {
        return trainingClassEventID;
    }

    public void setTrainingClassEventID(int trainingClassEventID) {
        this.trainingClassEventID = trainingClassEventID;
    }

    public int getTrainingClassCourseID() {
        return trainingClassCourseID;
    }

    public void setTrainingClassCourseID(int trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }
}
