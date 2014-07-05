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

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "traineeEquipment")
@NamedQueries({
    @NamedQuery(name = "TraineeEquipment.findByTrainingClassID", query = "select a from TraineeEquipment a "
                    + " where a.trainee.trainingClass.trainingClassID = :id"
                    + " order by a.trainee.lastName, a.trainee.firstName "),
    @NamedQuery(name = "TraineeEquipment.findByInventoryID", 
        query = "select a from TraineeEquipment a "
                    + " where a.inventory.inventoryID = :id"
                    + " order by a.trainee.lastName, a.trainee.firstName "),
    @NamedQuery(name = "TraineeEquipment.findByEquipmentID", 
        query = "select a from TraineeEquipment a "
                    + " where a.inventory.equipment.equipmentID = :id "
                    + " and a.dateReturned is null "
                    + " order by a.dateRegistered desc "),
    @NamedQuery(name = "TraineeEquipment.findByDateReturned", query = "SELECT t FROM TraineeEquipment t WHERE t.dateReturned = :dateReturned"),
    @NamedQuery(name = "TraineeEquipment.findByConditionFlag", query = "SELECT t FROM TraineeEquipment t WHERE t.conditionFlag = :conditionFlag")})
public class TraineeEquipment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeEquipmentID")
    private int traineeEquipmentID;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "dateReturned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReturned;
    @Column(name = "conditionFlag")
    private int conditionFlag;
    @JoinColumn(name = "administratorID", referencedColumnName = "administratorID")
    @ManyToOne
    private Administrator administrator;
    @JoinColumn(name = "inventoryID", referencedColumnName = "inventoryID")
    @ManyToOne(optional = false)
    private Inventory inventory;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;

    public TraineeEquipment() {
    }

    public TraineeEquipment(int traineeEquipmentID) {
        this.traineeEquipmentID = traineeEquipmentID;
    }

    public int getTraineeEquipmentID() {
        return traineeEquipmentID;
    }

    public void setTraineeEquipmentID(int traineeEquipmentID) {
        this.traineeEquipmentID = traineeEquipmentID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public int getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(int conditionFlag) {
        this.conditionFlag = conditionFlag;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeEquipment[ traineeEquipmentID=" + traineeEquipmentID + " ]";
    }
    
}
