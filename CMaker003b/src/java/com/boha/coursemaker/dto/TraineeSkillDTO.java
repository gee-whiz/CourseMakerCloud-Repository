/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TraineeSkill;

/**
 *
 * @author aubreyM
 */
public class TraineeSkillDTO {
    private int traineeSkillID, traineeID, instructorID, skillID, skillLevelID, level;
    private long dateAssessed;
    private String skillName, skillLevelName;
    public TraineeSkillDTO(TraineeSkill a) {
        traineeSkillID = a.getTraineeSkillID();
        traineeID = a.getTrainee().getTraineeID();
        instructorID = a.getInstructor().getInstructorID();
        skillID = a.getSkill().getSkillID();
        skillName = a.getSkill().getSkillName();
        skillLevelID = a.getSkillLevel().getSkillLevelID();
        skillLevelName = a.getSkillLevel().getSkillLevelName();
        level = a.getSkillLevel().getLevel();
        dateAssessed = a.getDateAssessed().getTime();
    }

    public int getTraineeSkillID() {
        return traineeSkillID;
    }

    public void setTraineeSkillID(int traineeSkillID) {
        this.traineeSkillID = traineeSkillID;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public int getSkillLevelID() {
        return skillLevelID;
    }

    public void setSkillLevelID(int skillLevelID) {
        this.skillLevelID = skillLevelID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getDateAssessed() {
        return dateAssessed;
    }

    public void setDateAssessed(long dateAssessed) {
        this.dateAssessed = dateAssessed;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillLevelName() {
        return skillLevelName;
    }

    public void setSkillLevelName(String skillLevelName) {
        this.skillLevelName = skillLevelName;
    }
    
}
