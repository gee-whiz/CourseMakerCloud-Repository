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
    private Integer traineeEquipmentID;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "dateReturned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReturned;
    
    @Column(name = "conditionFlag")
    private Integer conditionFlag;
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

    public TraineeEquipment(Integer traineeEquipmentID) {
        this.traineeEquipmentID = traineeEquipmentID;
    }

    public Integer getTraineeEquipmentID() {
        return traineeEquipmentID;
    }

    public void setTraineeEquipmentID(Integer traineeEquipmentID) {
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

    public Integer getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(Integer conditionFlag) {
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
    public int hashCode() {
        int hash = 0;
        hash += (traineeEquipmentID != null ? traineeEquipmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraineeEquipment)) {
            return false;
        }
        TraineeEquipment other = (TraineeEquipment) object;
        if ((this.traineeEquipmentID == null && other.traineeEquipmentID != null) || (this.traineeEquipmentID != null && !this.traineeEquipmentID.equals(other.traineeEquipmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeEquipment[ traineeEquipmentID=" + traineeEquipmentID + " ]";
    }

  
    
}
