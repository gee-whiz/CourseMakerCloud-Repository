/*
 * To change this template, choose Tools | Templates
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
    private Integer inventoryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "conditionFlag")
    private Integer conditionFlag;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Size(max = 100)
    @Column(name = "model")
    private String model;
    @Column(name = "yearPurchased")
    private Integer yearPurchased;
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

    public Inventory(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Inventory(Integer inventoryID, String serialNumber) {
        this.inventoryID = inventoryID;
        this.serialNumber = serialNumber;
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

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
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

    public Integer getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(Integer conditionFlag) {
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

    public Integer getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(Integer yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

   

    public List<TraineeEquipment> getTraineeEquipmentList() {
        return traineeEquipmentList;
    }

    public void setTraineeEquipmentList(List<TraineeEquipment> traineeEquipmentList) {
        this.traineeEquipmentList = traineeEquipmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryID != null ? inventoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryID == null && other.inventoryID != null) || (this.inventoryID != null && !this.inventoryID.equals(other.inventoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Inventory[ inventoryID=" + inventoryID + " ]";
    }
    
}
