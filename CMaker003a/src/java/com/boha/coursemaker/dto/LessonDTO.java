/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Lesson;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class LessonDTO {

    private Integer lessonID;
    private Double durationInDays;
    private String lessonName;
    private String description;
    private Integer priorityFlag;
    private Integer courseID;
    private BigInteger localID;
    private long syncDate;
    private List<ActivityDTO> activityList;
    private List<LessonResourceDTO> lessonResourceList;
    private List<CourseTraineeActivityDTO> courseTraineeActivityList;

    public LessonDTO() {
    }

    public LessonDTO(Lesson a) {
        lessonID = a.getLessonID();
        lessonName = a.getLessonName();
        description = a.getDescription();
        priorityFlag = a.getPriorityFlag();
        durationInDays = a.getDurationInDays();
        if (a.getCourse() != null) {
            courseID = a.getCourse().getCourseID();
        }

        

    }

    public List<CourseTraineeActivityDTO> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivityDTO> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

  

    public BigInteger getLocalID() {
        return localID;
    }

    public Double getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Double durationInDays) {
        this.durationInDays = durationInDays;
    }

    public void setLocalID(BigInteger localID) {
        this.localID = localID;
    }

    public long getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(long syncDate) {
        this.syncDate = syncDate;
    }

    public List<LessonResourceDTO> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResourceDTO> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }

  
    public List<ActivityDTO> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityDTO> activityList) {
        this.activityList = activityList;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
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

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }
}
