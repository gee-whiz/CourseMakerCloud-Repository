/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TraineeRating;

/**
 *
 * @author aubreyM
 */
public class TraineeRatingDTO {
    private int traineeRatingID;
    
    private long dateUpdated;
    
    private String comment, activityName;
    
    private int traineeID;
   
    private RatingDTO rating;
    
    private int courseTraineeActivityID;
    
    public TraineeRatingDTO(TraineeRating a) {
        traineeRatingID = a.getTraineeRatingID();
        dateUpdated = a.getDateUpdated().getTime();
        comment = a.getComment();
        if (a.getRating() != null) {
            rating = new RatingDTO(a.getRating());
        }
        courseTraineeActivityID = a.getCourseTraineeActivity().getCourseTraineeActivityID();
        activityName = a.getCourseTraineeActivity().getActivity().getActivityName();
        traineeID = a.getTrainee().getTraineeID();
    }

    public int getTraineeRatingID() {
        return traineeRatingID;
    }

    public void setTraineeRatingID(int traineeRatingID) {
        this.traineeRatingID = traineeRatingID;
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

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
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
}
