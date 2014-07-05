/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.*;
import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class InstructorClassDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int instructorClassID;
    private long dateRegistered, startDate, endDate;
    private String trainingClassName;
    //private long calendarID;
    private int instructorID;
    private int trainingClassID;

    public InstructorClassDTO(InstructorClass a) {
        instructorClassID = a.getInstructorClassID();
        dateRegistered = a.getDateRegistered().getTime();
        instructorID = a.getInstructor().getInstructorID();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        trainingClassName = a.getTrainingClass().getTrainingClassName();
        if (a.getTrainingClass().getStartDate() != null) {
            startDate = a.getTrainingClass().getStartDate().getTime();
        }
        if (a.getTrainingClass().getEndDate() != null) {
            endDate = a.getTrainingClass().getEndDate().getTime();
        }
    }

    public int getInstructorClassID() {
        return instructorClassID;
    }

    public void setInstructorClassID(int instructorClassID) {
        this.instructorClassID = instructorClassID;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

   

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    
}
