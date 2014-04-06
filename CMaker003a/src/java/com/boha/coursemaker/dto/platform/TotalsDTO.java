/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto.platform;

/**
 *
 * @author aubreyM
 */
public class TotalsDTO {

    private Integer traineeID, courseID,
            trainingClassCourseID,
            courseTraineeID, trainingClassID;
    private String courseName, trainingClassName;
    private double percComplete, averageRating;
    private int totalTasks, totalComplete, totalRatings, totalRated;

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public int getTotalComplete() {
        return totalComplete;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public void setTotalComplete(int totalComplete) {
        this.totalComplete = totalComplete;
    }

    public double getPercComplete() {
        return percComplete;
    }

    public int getTotalRated() {
        return totalRated;
    }

    public void setTotalRated(int totalRated) {
        this.totalRated = totalRated;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setPercComplete(double percComplete) {
        this.percComplete = percComplete;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public Integer getTrainingClassCourseID() {
        return trainingClassCourseID;
    }

    public void setTrainingClassCourseID(Integer trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public Integer getCourseTraineeID() {
        return courseTraineeID;
    }

    public void setCourseTraineeID(Integer courseTraineeID) {
        this.courseTraineeID = courseTraineeID;
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
