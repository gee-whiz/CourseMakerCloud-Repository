/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.Trainee;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class CourseTraineeActivityDTO {

    private int courseTraineeActivityID, courseID, trainingClassID, companyID;
    private int completedFlag, cityID, traineeID;
    private int refreshRequested;
    private String comment;
    private long dateUpdated;
    private long completionDate;
    private RatingDTO rating;
    private int courseTraineeID;
    private String courseName, traineeName,
            trainingClassName, companyName;
    private List<InstructorRatingDTO> instructorRatingList;
    private List<TraineeRatingDTO> traineeRatingList;
    private ActivityDTO activity;

    public CourseTraineeActivityDTO() {
    }

    /**
     * Constructor to create Data Transfer Object
     *
     * @param a
     */
    public CourseTraineeActivityDTO(CourseTraineeActivity a) {
        courseTraineeActivityID = a.getCourseTraineeActivityID();
        courseTraineeID = a.getCourseTrainee().getCourseTraineeID();
        completedFlag = a.getCompletedFlag();
        comment = a.getComment();
        refreshRequested = a.getRefreshRequested();
        dateUpdated = a.getDateUpdated().getTime();
        comment = a.getComment();

        courseID = a.getActivity().getCourse().getCourseID();
        courseName = a.getActivity().getCourse().getCourseName();

        if (a.getCourseTrainee().getTrainee() != null) {
            Trainee tr = a.getCourseTrainee().getTrainee();
            traineeName = tr.getFirstName()
                    + " " + tr.getLastName();
            traineeID = tr.getTraineeID();
            cityID = tr.getCity().getCityID();
            companyID = tr.getCompany().getCompanyID();
            //companyName = tr.getCompany().getCompanyName();
            trainingClassID = tr.getTrainingClass().getTrainingClassID();
            //trainingClassName = tr.getTrainingClass().getTrainingClassName();
        }

        if (a.getCompletionDate() != null) {
            completionDate = a.getCompletionDate().getTime();
        }
        if (a.getRating() != null) {
            rating = new RatingDTO(a.getRating());
        }
        if (a.getActivity() != null) {
            activity = new ActivityDTO(a.getActivity());
        }

    }

    public ActivityDTO getActivity() {
        return activity;
    }

    public void setActivity(ActivityDTO activity) {
        this.activity = activity;
    }

    public int getCourseTraineeActivityID() {
        return courseTraineeActivityID;
    }

    public void setCourseTraineeActivityID(int courseTraineeActivityID) {
        this.courseTraineeActivityID = courseTraineeActivityID;
    }

    public List<InstructorRatingDTO> getInstructorRatingList() {
        return instructorRatingList;
    }

    public void setInstructorRatingList(List<InstructorRatingDTO> instructorRatingList) {
        this.instructorRatingList = instructorRatingList;
    }

    public List<TraineeRatingDTO> getTraineeRatingList() {
        return traineeRatingList;
    }

    public void setTraineeRatingList(List<TraineeRatingDTO> traineeRatingList) {
        this.traineeRatingList = traineeRatingList;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCompletedFlag() {
        return completedFlag;
    }

    public void setCompletedFlag(int completedFlag) {
        this.completedFlag = completedFlag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public int getRefreshRequested() {
        return refreshRequested;
    }

    public void setRefreshRequested(int refreshRequested) {
        this.refreshRequested = refreshRequested;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public long getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(long completionDate) {
        this.completionDate = completionDate;
    }

    public RatingDTO getRating() {
        return rating;
    }

    public void setRating(RatingDTO rating) {
        this.rating = rating;
    }

    public int getCourseTraineeID() {
        return courseTraineeID;
    }

    public void setCourseTraineeID(int courseTraineeID) {
        this.courseTraineeID = courseTraineeID;
    }

}
