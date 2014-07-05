/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Activity;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class ActivityDTO {

    private int activityID;
    private Double durationInDays;
    private String activityName;
    private String description, courseName;
    private int priorityFlag;
    private long localID;
    private long syncDate;
    private int courseID;
    

    public ActivityDTO(Activity a) {
        activityID = a.getActivityID();
        activityName = a.getActivityName();
        description = a.getDescription();
        priorityFlag = a.getPriorityFlag();
        courseID = a.getCourse().getCourseID();
        courseName = a.getCourse().getCourseName();
        durationInDays = a.getDurationInDays();
        localID = a.getLocalID();

        if (a.getSyncDate() != null) {
            syncDate = a.getSyncDate().getTime();
        }

    }

    public int getCourseID() {
        return courseID;
    }

  
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getActivityID() {
        return activityID;
    }

    public long getLocalID() {
        return localID;
    }

    public void setLocalID(long localID) {
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

    public void setActivityID(int activityID) {
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

    public int getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(int priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public int getLessonID() {
        return courseID;
    }

    public void setLessonID(int lessonID) {
        this.courseID = lessonID;
    }
}
