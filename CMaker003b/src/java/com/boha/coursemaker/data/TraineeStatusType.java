/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "traineeStatusType")
@NamedQueries({
    @NamedQuery(name = "TraineeStatusType.findAll", query = "SELECT t FROM TraineeStatusType t"),
    @NamedQuery(name = "TraineeStatusType.findByTraineeStatusTypeID", query = "SELECT t FROM TraineeStatusType t WHERE t.traineeStatusTypeID = :traineeStatusTypeID"),
    @NamedQuery(name = "TraineeStatusType.findByTraineeStatusTypeName", query = "SELECT t FROM TraineeStatusType t WHERE t.traineeStatusTypeName = :traineeStatusTypeName")})
public class TraineeStatusType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeStatusTypeID")
    private int traineeStatusTypeID;
    @Size(max = 45)
    @Column(name = "traineeStatusTypeName")
    private String traineeStatusTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traineeStatusType")
    private List<TraineeStatus> traineeStatusList;

    public TraineeStatusType() {
    }

    public TraineeStatusType(int traineeStatusTypeID) {
        this.traineeStatusTypeID = traineeStatusTypeID;
    }

    public int getTraineeStatusTypeID() {
        return traineeStatusTypeID;
    }

    public void setTraineeStatusTypeID(int traineeStatusTypeID) {
        this.traineeStatusTypeID = traineeStatusTypeID;
    }

    public String getTraineeStatusTypeName() {
        return traineeStatusTypeName;
    }

    public void setTraineeStatusTypeName(String traineeStatusTypeName) {
        this.traineeStatusTypeName = traineeStatusTypeName;
    }

    public List<TraineeStatus> getTraineeStatusList() {
        return traineeStatusList;
    }

    public void setTraineeStatusList(List<TraineeStatus> traineeStatusList) {
        this.traineeStatusList = traineeStatusList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeStatusType[ traineeStatusTypeID=" + traineeStatusTypeID + " ]";
    }
    
}
