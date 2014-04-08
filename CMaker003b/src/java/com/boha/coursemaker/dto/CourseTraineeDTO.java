/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.CourseTrainee;

/**
 *
 * @author aubreyM
 */
public class CourseTraineeDTO {
    private Integer courseTraineeID;
    private long dateEnrolled;
    private long ratingDate;
    private String comment, courseName, traineeName;
    private RatingDTO rating;
    private Integer traineeID;
    
    private Integer courseID;
    
    public CourseTraineeDTO(CourseTrainee a) {
        courseTraineeID = a.getCourseTraineeID();
        traineeID = a.getTrainee().getTraineeID();
        traineeName = a.getTrainee().getFirstName() +  
                " " + a.getTrainee().getLastName();
        courseID = a.getTrainingClassCourse().getCourse().getCourseID();
        dateEnrolled = a.getDateEnrolled().getTime();
        if (a.getRatingDate() != null) {
            ratingDate = a.getRatingDate().getTime();
        }
        comment = a.getComment();
        courseName = a.getTrainingClassCourse().getCourse().getCourseName();
        if (a.getRating() != null) {
            rating = new RatingDTO(a.getRating());
        }
    }

    public Integer getCourseTraineeID() {
        return courseTraineeID;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public void setCourseTraineeID(Integer courseTraineeID) {
        this.courseTraineeID = courseTraineeID;
    }

    public long getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(long dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public long getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(long ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public RatingDTO getRating() {
        return rating;
    }

    public void setRating(RatingDTO rating) {
        this.rating = rating;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public Integer getTrainingCompanyCourseID() {
        return courseID;
    }

    public void setTrainingCompanyCourseID(Integer trainingCompanyCourseID) {
        this.courseID = trainingCompanyCourseID;
    }
}
