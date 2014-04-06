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
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "traineeShout")
@NamedQueries({
    @NamedQuery(name = "TraineeShout.findAll", query = "SELECT t FROM TraineeShout t")})
public class TraineeShout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeShoutID")
    private Integer traineeShoutID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Trainee trainee;
    @JoinColumn(name = "helpTypeID", referencedColumnName = "helpTypeID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private HelpType helpType;

    public TraineeShout() {
    }

    public TraineeShout(Integer traineeShoutID) {
        this.traineeShoutID = traineeShoutID;
    }

    public TraineeShout(Integer traineeShoutID, Date dateRegistered, String remarks) {
        this.traineeShoutID = traineeShoutID;
        this.dateRegistered = dateRegistered;
        this.remarks = remarks;
    }

    public Integer getTraineeShoutID() {
        return traineeShoutID;
    }

    public void setTraineeShoutID(Integer traineeShoutID) {
        this.traineeShoutID = traineeShoutID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public HelpType getHelpType() {
        return helpType;
    }

    public void setHelpType(HelpType helpType) {
        this.helpType = helpType;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traineeShoutID != null ? traineeShoutID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraineeShout)) {
            return false;
        }
        TraineeShout other = (TraineeShout) object;
        if ((this.traineeShoutID == null && other.traineeShoutID != null) || (this.traineeShoutID != null && !this.traineeShoutID.equals(other.traineeShoutID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeShout[ traineeShoutID=" + traineeShoutID + " ]";
    }
    
}
