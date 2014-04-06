/*
 * To change this template, choose Tools | Templates
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
    @NamedQuery(name = "GuardianTrainee.findAll", query = "SELECT g FROM GuardianTrainee g")})
public class GuardianTrainee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "guardianTraineeID")
    private Integer guardianTraineeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeFlag")
    private int activeFlag;
    @JoinColumn(name = "guardianID", referencedColumnName = "guardianID")
    @ManyToOne(optional = false)
    private Guardian guardian;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;

    public GuardianTrainee() {
    }

    public GuardianTrainee(Integer guardianTraineeID) {
        this.guardianTraineeID = guardianTraineeID;
    }

    public GuardianTrainee(Integer guardianTraineeID, int activeFlag) {
        this.guardianTraineeID = guardianTraineeID;
        this.activeFlag = activeFlag;
    }

    public Integer getGuardianTraineeID() {
        return guardianTraineeID;
    }

    public void setGuardianTraineeID(Integer guardianTraineeID) {
        this.guardianTraineeID = guardianTraineeID;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guardianTraineeID != null ? guardianTraineeID.hashCode() : 0);
        return hash;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuardianTrainee)) {
            return false;
        }
        GuardianTrainee other = (GuardianTrainee) object;
        if ((this.guardianTraineeID == null && other.guardianTraineeID != null) || (this.guardianTraineeID != null && !this.guardianTraineeID.equals(other.guardianTraineeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.GuardianTrainee[ guardianTraineeID=" + guardianTraineeID + " ]";
    }
    
}
