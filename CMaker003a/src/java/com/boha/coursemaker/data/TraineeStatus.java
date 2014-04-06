/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "traineeStatus")
@NamedQueries({
    @NamedQuery(name = "TraineeStatus.findAll", query = "SELECT t FROM TraineeStatus t"),
    @NamedQuery(name = "TraineeStatus.findByTraineeStatusID", query = "SELECT t FROM TraineeStatus t WHERE t.traineeStatusID = :traineeStatusID"),
    @NamedQuery(name = "TraineeStatus.findByDateUpdated", query = "SELECT t FROM TraineeStatus t WHERE t.dateUpdated = :dateUpdated")})
public class TraineeStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeStatusID")
    private Integer traineeStatusID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "traineeStatusTypeID", referencedColumnName = "traineeStatusTypeID")
    @ManyToOne(optional = false)
    private TraineeStatusType traineeStatusType;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;

    public TraineeStatus() {
    }

    public TraineeStatus(Integer traineeStatusID) {
        this.traineeStatusID = traineeStatusID;
    }

    public TraineeStatus(Integer traineeStatusID, Date dateUpdated) {
        this.traineeStatusID = traineeStatusID;
        this.dateUpdated = dateUpdated;
    }

    public Integer getTraineeStatusID() {
        return traineeStatusID;
    }

    public void setTraineeStatusID(Integer traineeStatusID) {
        this.traineeStatusID = traineeStatusID;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public TraineeStatusType getTraineeStatusType() {
        return traineeStatusType;
    }

    public void setTraineeStatusType(TraineeStatusType traineeStatusType) {
        this.traineeStatusType = traineeStatusType;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traineeStatusID != null ? traineeStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraineeStatus)) {
            return false;
        }
        TraineeStatus other = (TraineeStatus) object;
        if ((this.traineeStatusID == null && other.traineeStatusID != null) || (this.traineeStatusID != null && !this.traineeStatusID.equals(other.traineeStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeStatus[ traineeStatusID=" + traineeStatusID + " ]";
    }
    
}
