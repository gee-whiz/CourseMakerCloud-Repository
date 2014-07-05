/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.LessonResource;

/**
 *
 * @author aubreyM
 */
public class LessonResourceDTO {

    private int lessonResourceID;
    private String url, resourceName;
    private long syncDate;
    private long dateUpdated;
    private int courseID, instructorID, traineeID, authorID;

    public LessonResourceDTO(LessonResource a) {
        lessonResourceID = a.getLessonResourceID();
        courseID = a.getCourse().getCourseID();
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
       
        if (a.getSyncDate() != null) {
            syncDate = a.getSyncDate().getTime();
        }
        resourceName = a.getResourceName();
    }

    public int getLessonResourceID() {
        return lessonResourceID;
    }

    public String getResourceName() {
        return resourceName;
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

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setLessonResourceID(int lessonResourceID) {
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

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

   

}
