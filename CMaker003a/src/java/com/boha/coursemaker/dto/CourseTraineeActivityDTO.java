/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.Trainee;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class CourseTraineeActivityDTO {

    private Integer courseTraineeActivityID, courseID, trainingClassID, companyID;
    private Integer completedFlag, lessonID, cityID, traineeID;
    private Integer refreshRequested;
    private String comment;
    private long dateUpdated;
    private long completionDate;
    private RatingDTO rating;
    private Integer courseTraineeID;
    private String lessonName, courseName, traineeName,
            trainingClassName, companyName;
    private ActivityDTO activity;
    private List<InstructorRatingDTO> instructorRatingList;
    private List<TraineeRatingDTO> traineeRatingList;

    public CourseTraineeActivityDTO() {}
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
         
        lessonID = a.getLesson().getLessonID();
        
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
        if (a.getCourseTrainee().
                getTrainingClassCourse().
                getCourse() != null) {
            Course c = a.getCourseTrainee()
                    .getTrainingClassCourse().getCourse();
            courseName = c.getCourseName();
            courseID = c.getCourseID();

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

    public Integer getCourseTraineeActivityID() {
        return courseTraineeActivityID;
    }

    public void setCourseTraineeActivityID(Integer courseTraineeActivityID) {
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

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
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

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCompletedFlag() {
        return completedFlag;
    }

    public void setCompletedFlag(Integer completedFlag) {
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

    public Integer getRefreshRequested() {
        return refreshRequested;
    }

    public void setRefreshRequested(Integer refreshRequested) {
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

    public Integer getCourseTraineeID() {
        return courseTraineeID;
    }

    public void setCourseTraineeID(Integer courseTraineeID) {
        this.courseTraineeID = courseTraineeID;
    }

    public ActivityDTO getActivity() {
        return activity;
    }

    public void setActivity(ActivityDTO activity) {
        this.activity = activity;
    }
}
