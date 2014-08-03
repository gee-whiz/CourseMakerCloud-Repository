/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "traineeSkill")
@NamedQueries({
    @NamedQuery(name = "TraineeSkill.findByTrainee", 
            query = "SELECT t FROM TraineeSkill t where t.trainee.traineeID = :id order by t.dateAssessed desc"),
    @NamedQuery(name = "TraineeSkill.findByTrainingClass", 
            query = "SELECT t FROM TraineeSkill t "
                    + "WHERE t.trainee.trainingClass.trainingClassID = :id "
                    + "order by t.trainee.traineeID, t.dateAssessed desc"),
    @NamedQuery(name = "TraineeSkill.findByDateAssessed", 
            query = "SELECT t FROM TraineeSkill t WHERE t.dateAssessed = :dateAssessed order by t.dateAssessed desc")})
public class TraineeSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeSkillID")
    private int traineeSkillID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateAssessed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAssessed;
    @JoinColumn(name = "skillID", referencedColumnName = "skillID")
    @ManyToOne(optional = false)
    private Skill skill;
    @JoinColumn(name = "skillLevelID", referencedColumnName = "skillLevelID")
    @ManyToOne(optional = false)
    private SkillLevel skillLevel;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne(optional = false)
    private Instructor instructor;

    public TraineeSkill() {
    }

    public TraineeSkill(int traineeSkillID) {
        this.traineeSkillID = traineeSkillID;
    }

    public TraineeSkill(int traineeSkillID, Date dateAssessed) {
        this.traineeSkillID = traineeSkillID;
        this.dateAssessed = dateAssessed;
    }

    public int getTraineeSkillID() {
        return traineeSkillID;
    }

    public void setTraineeSkillID(int traineeSkillID) {
        this.traineeSkillID = traineeSkillID;
    }

    public Date getDateAssessed() {
        return dateAssessed;
    }

    public void setDateAssessed(Date dateAssessed) {
        this.dateAssessed = dateAssessed;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

   

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeSkill[ traineeSkillID=" + traineeSkillID + " ]";
    }
    
}
