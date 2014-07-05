/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "guardianTrainee")
@NamedQueries({
    @NamedQuery(name = "GuardianTrainee.findAll", query = "SELECT g FROM GuardianTrainee g"),
    @NamedQuery(name = "GuardianTrainee.findByGuardianTraineeID", query = "SELECT g FROM GuardianTrainee g WHERE g.guardianTraineeID = :guardianTraineeID"),
    @NamedQuery(name = "GuardianTrainee.findByActiveFlag", query = "SELECT g FROM GuardianTrainee g WHERE g.activeFlag = :activeFlag")})
public class GuardianTrainee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "guardianTraineeID")
    private int guardianTraineeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeFlag")
    private int activeFlag;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;
    @JoinColumn(name = "guardianID", referencedColumnName = "guardianID")
    @ManyToOne(optional = false)
    private Guardian guardian;

    public GuardianTrainee() {
    }

    public GuardianTrainee(int guardianTraineeID) {
        this.guardianTraineeID = guardianTraineeID;
    }

    public GuardianTrainee(int guardianTraineeID, int activeFlag) {
        this.guardianTraineeID = guardianTraineeID;
        this.activeFlag = activeFlag;
    }

    public int getGuardianTraineeID() {
        return guardianTraineeID;
    }

    public void setGuardianTraineeID(int guardianTraineeID) {
        this.guardianTraineeID = guardianTraineeID;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.GuardianTrainee[ guardianTraineeID=" + guardianTraineeID + " ]";
    }
    
}
