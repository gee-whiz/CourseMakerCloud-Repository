/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Objective;

/**
 *
 * @author aubreyM
 */
public class ObjectiveDTO {

    private Integer objectiveID;
    private String objectiveName, description;    
    private Integer courseID;

    public ObjectiveDTO(Objective a) {
        objectiveID = a.getObjectiveID();
        objectiveName = a.getObjectiveName();
        courseID = a.getCourse().getCourseID();
        description = a.getDescription();
        
    }

    public Integer getObjectiveID() {
        return objectiveID;
    }

    public void setObjectiveID(Integer objectiveID) {
        this.objectiveID = objectiveID;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
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

   
}
