/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.LessonResource;
import java.math.BigInteger;

/**
 *
 * @author aubreyM
 */
public class LessonResourceDTO {

    private Integer lessonResourceID;
    private String url, resourceName;
    private BigInteger localID;
    private long syncDate;
    private long dateUpdated;
    private Integer lessonID, instructorID, traineeID, authorID;

    public LessonResourceDTO(LessonResource a) {
        lessonResourceID = a.getLessonResourceID();
        lessonID = a.getLesson().getLessonID();
        if (a.getInstructor() != null) {
            instructorID = a.getInstructor().getInstructorID();
        }
        if (a.getAuthor() != null) {
            authorID = a.getAuthor().getAuthorID();
        }
        if (a.getTrainee() != null) {
            traineeID = a.getTrainee().getTraineeID();
        }
        url = a.getUrl();
        dateUpdated = a.getDateUpdated().getTime();
        if (a.getLocalID() != null) {
            localID = a.getLocalID();
        }
        if (a.getSyncDate() != null) {
            syncDate = a.getSyncDate().getTime();
        }
        resourceName = a.getResourceName();
    }

    public Integer getLessonResourceID() {
        return lessonResourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public BigInteger getLocalID() {
        return localID;
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

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public void setLessonResourceID(Integer lessonResourceID) {
        this.lessonResourceID = lessonResourceID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }
}
