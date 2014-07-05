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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "traineeShout")
@NamedQueries({
    @NamedQuery(name = "TraineeShout.findAll", query = "SELECT t FROM TraineeShout t"),
    @NamedQuery(name = "TraineeShout.findByTraineeShoutID", query = "SELECT t FROM TraineeShout t WHERE t.traineeShoutID = :traineeShoutID"),
    @NamedQuery(name = "TraineeShout.findByDateRegistered", query = "SELECT t FROM TraineeShout t WHERE t.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "TraineeShout.findByRemarks", query = "SELECT t FROM TraineeShout t WHERE t.remarks = :remarks")})
public class TraineeShout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeShoutID")
    private int traineeShoutID;
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
    @ManyToOne(optional = false)
    private Trainee trainee;
    @JoinColumn(name = "helpTypeID", referencedColumnName = "helpTypeID")
    @ManyToOne(optional = false)
    private HelpType helpType;

    public TraineeShout() {
    }

    public TraineeShout(int traineeShoutID) {
        this.traineeShoutID = traineeShoutID;
    }

    public TraineeShout(int traineeShoutID, Date dateRegistered, String remarks) {
        this.traineeShoutID = traineeShoutID;
        this.dateRegistered = dateRegistered;
        this.remarks = remarks;
    }

    public int getTraineeShoutID() {
        return traineeShoutID;
    }

    public void setTraineeShoutID(int traineeShoutID) {
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
    public String toString() {
        return "com.boha.coursemaker.data.TraineeShout[ traineeShoutID=" + traineeShoutID + " ]";
    }
    
}
