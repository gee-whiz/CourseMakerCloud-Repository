/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TrainingClass;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class TrainingClassDTO {

    private Integer trainingClassID, isOpen;
    private String trainingClassName;
    private AdministratorDTO administrator;
    private long startDate;
    private long endDate;
    private List<TrainingClassCourseDTO> trainingClassCourseList;
    private List<TraineeDTO> traineeList;
    private List<TrainingClassEventDTO> trainingClassEventList;
    private Integer companyID;

    public TrainingClassDTO(TrainingClass a) {
        trainingClassID = a.getTrainingClassID();
        trainingClassName = a.getTrainingClassName();
        isOpen = a.getIsOpen();
        if (a.getAdministrator() != null) {
            administrator = new AdministratorDTO(a.getAdministrator());
        }
        if (a.getStartDate() != null) {
            startDate = a.getStartDate().getTime();
        }
        if (a.getEndDate() != null) {
            endDate = a.getEndDate().getTime();
        }
   
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public List<TrainingClassEventDTO> getTrainingClassEventList() {
        return trainingClassEventList;
    }

    public void setTrainingClassEventList(List<TrainingClassEventDTO> trainingClassEventList) {
        this.trainingClassEventList = trainingClassEventList;
    }

    

    public List<TraineeDTO> getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List<TraineeDTO> traineeList) {
        this.traineeList = traineeList;
    }

   

    public AdministratorDTO getAdministrator() {
        return administrator;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public void setAdministrator(AdministratorDTO administrator) {
        this.administrator = administrator;
    }

    public List<TrainingClassCourseDTO> getTrainingClassCourseList() {
        return trainingClassCourseList;
    }

    public void setTrainingClassCourseList(List<TrainingClassCourseDTO> trainingClassCourseList) {
        this.trainingClassCourseList = trainingClassCourseList;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
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

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }
}
