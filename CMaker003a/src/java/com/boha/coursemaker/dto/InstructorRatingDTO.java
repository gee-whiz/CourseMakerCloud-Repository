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
   private Integer instructorRatingID;
    private long dateUpdated;
    
    private String comment, activityName;
    private Integer completedFlag;
   
    private RatingDTO rating;
    
    private Integer courseTraineeActivityID;
    
    private Integer instructorID; 
    
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

    public Integer getInstructorRatingID() {
        return instructorRatingID;
    }

    public void setInstructorRatingID(Integer instructorRatingID) {
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

    public Integer getCompletedFlag() {
        return completedFlag;
    }

    public void setCompletedFlag(Integer completedFlag) {
        this.completedFlag = completedFlag;
    }

    public RatingDTO getRating() {
        return rating;
    }

    public void setRating(RatingDTO rating) {
        this.rating = rating;
    }

    public Integer getCourseTraineeActivityID() {
        return courseTraineeActivityID;
    }

    public void setCourseTraineeActivityID(Integer courseTraineeActivityID) {
        this.courseTraineeActivityID = courseTraineeActivityID;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
    }
    
}
