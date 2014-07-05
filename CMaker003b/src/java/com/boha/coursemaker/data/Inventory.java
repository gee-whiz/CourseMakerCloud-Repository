/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "inventory")
@NamedQueries({
    @NamedQuery(name = "Inventory.findByCompany", query = "select a from Inventory a"
                    + " where a.equipment.company.companyID = :id"
                    + " order by a.dateUpdated"),
    @NamedQuery(name = "Inventory.findByEquipment", 
        query = "select a from Inventory a "
                    + "where a.equipment.equipmentID = :id "
                    + "order by a.dateRegistered desc")
    })
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventoryID")
    private int inventoryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "conditionFlag")
    private int conditionFlag;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Size(max = 100)
    @Column(name = "model")
    private String model;
    @Column(name = "yearPurchased")
    private int yearPurchased;
    @JoinColumn(name = "administratorID", referencedColumnName = "administratorID")
    @ManyToOne
    private Administrator administrator;
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmentID")
    @ManyToOne(optional = false)
    private Equipment equipment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<TraineeEquipment> traineeEquipmentList;

    public Inventory() {
    }

    public Inventory(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Inventory(int inventoryID, String serialNumber) {
        this.inventoryID = inventoryID;
        this.serialNumber = serialNumber;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public int getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(int conditionFlag) {
        this.conditionFlag = conditionFlag;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(int yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public List<TraineeEquipment> getTraineeEquipmentList() {
        return traineeEquipmentList;
    }

    public void setTraineeEquipmentList(List<TraineeEquipment> traineeEquipmentList) {
        this.traineeEquipmentList = traineeEquipmentList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Inventory[ inventoryID=" + inventoryID + " ]";
    }
    
}
