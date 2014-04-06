/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Activity;
import java.math.BigInteger;

/**
 *
 * @author aubreyM
 */
public class ActivityDTO {

    private Integer activityID;
    private Double durationInDays;
    private String activityName;
    private String description;
    private Integer priorityFlag;
    private BigInteger localID;
    private long syncDate;
    private Integer lessonID;

    public ActivityDTO(Activity a) {
        activityID = a.getActivityID();
        activityName = a.getActivityName();
        description = a.getDescription();
        priorityFlag = a.getPriorityFlag();
        lessonID = a.getLesson().getLessonID();
        durationInDays = a.getDurationInDays();
        if (a.getLocalID() != null) {
            localID = a.getLocalID();
        }
        if (a.getSyncDate() != null) {
            syncDate = a.getSyncDate().getTime();
        }

    }

    public Integer getActivityID() {
        return activityID;
    }

    public BigInteger getLocalID() {
        return localID;
    }

    public void setLocalID(BigInteger localID) {
        this.localID = localID;
    }

    public Double getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Double durationInDays) {
        this.durationInDays = durationInDays;
    }

    

    public long getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(long syncDate) {
        this.syncDate = syncDate;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(Integer priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }
}
