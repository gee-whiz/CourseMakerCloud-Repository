/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TrainingClassCourse;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class TrainingClassCourseDTO {

    private int trainingClassCourseID;
    private long dateUpdated;
    private int trainingClassID, priorityFlag;
    private int courseID, numberOfActivities;
    private String courseName, description;
    private List<ActivityDTO> activityList;
    private List<TrainingClassEventDTO> trainingClassEventList;
    private List<CourseTraineeActivityDTO> courseTraineeActivityList;

    public TrainingClassCourseDTO(TrainingClassCourse a) {
        trainingClassCourseID = a.getTrainingClassCourseID();
        dateUpdated = a.getDateUpdated().getTime();
        priorityFlag = a.getPriorityFlag();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        courseID = a.getCourse().getCourseID();
        courseName = a.getCourse().getCourseName();
        description = a.getCourse().getDescription();
        numberOfActivities = a.getCourse().getActivityList().size();

    }

    public List<CourseTraineeActivityDTO> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivityDTO> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

    public List<TrainingClassEventDTO> getTrainingClassEventList() {
        return trainingClassEventList;
    }

    public void setTrainingClassEventList(List<TrainingClassEventDTO> trainingClassEventList) {
        this.trainingClassEventList = trainingClassEventList;
    }

    public int getTrainingClassCourseID() {
        return trainingClassCourseID;
    }

    public void setTrainingClassCourseID(int trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public int getNumberOfActivities() {
        return numberOfActivities;
    }

    public void setNumberOfActivities(int numberOfActivities) {
        this.numberOfActivities = numberOfActivities;
    }

    public List<ActivityDTO> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityDTO> activityList) {
        this.activityList = activityList;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public int getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(int priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public int getNumberOfLessons() {
        return numberOfActivities;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfActivities = numberOfLessons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
