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

    private Integer trainingClassCourseID;
    private long dateUpdated;
    private Integer trainingClassID, priorityFlag;
    private Integer courseID, numberOfLessons;
    private String courseName, description;
    private List<LessonDTO> lessonList;
    private List<TrainingClassEventDTO> trainingClassEventList;

    public TrainingClassCourseDTO(TrainingClassCourse a) {
        trainingClassCourseID = a.getTrainingClassCourseID();
        dateUpdated = a.getDateUpdated().getTime();
        priorityFlag = a.getPriorityFlag();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        courseID = a.getCourse().getCourseID();
        courseName = a.getCourse().getCourseName();
        description = a.getCourse().getDescription();
        numberOfLessons = a.getCourse().getLessonList().size();

    }

    public List<TrainingClassEventDTO> getTrainingClassEventList() {
        return trainingClassEventList;
    }

    public void setTrainingClassEventList(List<TrainingClassEventDTO> trainingClassEventList) {
        this.trainingClassEventList = trainingClassEventList;
    }

    public Integer getTrainingClassCourseID() {
        return trainingClassCourseID;
    }

    public void setTrainingClassCourseID(Integer trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public List<LessonDTO> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<LessonDTO> lessonList) {
        this.lessonList = lessonList;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public Integer getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(Integer priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public Integer getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(Integer numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
