/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.InstructorRating;

/**
 *
 * @author aubreyM
 */
public class InstructorRatingDTO {
   private int instructorRatingID;
    private long dateUpdated;
    
    private String comment, activityName;
    private int completedFlag;
   
    private RatingDTO rating;
    
    private int courseTraineeActivityID;
    
    private int instructorID; 
    
    public InstructorRatingDTO(InstructorRating a) {
        instructorRatingID = a.getInstructorRatingID();
        dateUpdated = a.getDateUpdated().getTime();
        comment = a.getComment();
        activityName = a.getCourseTraineeActivity().getActivity().getActivityName();
        completedFlag = a.getCompletedFlag();
        if (a.getRating() != null) {
            rating = new RatingDTO(a.getRating());
        }
        courseTraineeActivityID = a.getCourseTraineeActivity().getCourseTraineeActivityID();
        instructorID = a.getInstructor().getInstructorID();
    }

    public int getInstructorRatingID() {
        return instructorRatingID;
    }

    public void setInstructorRatingID(int instructorRatingID) {
        this.instructorRatingID = instructorRatingID;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getCompletedFlag() {
        return completedFlag;
    }

    public void setCompletedFlag(int completedFlag) {
        this.completedFlag = completedFlag;
    }

    public RatingDTO getRating() {
        return rating;
    }

    public void setRating(RatingDTO rating) {
        this.rating = rating;
    }

    public int getCourseTraineeActivityID() {
        return courseTraineeActivityID;
    }

    public void setCourseTraineeActivityID(int courseTraineeActivityID) {
        this.courseTraineeActivityID = courseTraineeActivityID;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }
    
}
