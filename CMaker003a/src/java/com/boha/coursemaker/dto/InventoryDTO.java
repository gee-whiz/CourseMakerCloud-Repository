/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Inventory;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class InventoryDTO {

    private Integer inventoryID;
    private String serialNumber;
    private long dateRegistered;
    private Integer conditionFlag;
    private long dateUpdated;
    private String model;
    private Integer yearPurchased;
    private EquipmentDTO equipment;
    private List<TraineeDTO> traineeList;

    public InventoryDTO(Inventory a) {
        inventoryID = a.getInventoryID();
        serialNumber = a.getSerialNumber();
        model = a.getModel();
        dateRegistered = a.getDateRegistered().getTime();
        conditionFlag = a.getConditionFlag();
        if (a.getDateUpdated() != null) {
            dateUpdated = a.getDateUpdated().getTime();
        }
        yearPurchased = a.getYearPurchased();
        if (a.getEquipment() != null) {
            equipment = new EquipmentDTO(a.getEquipment());
        }
        
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public List<TraineeDTO> getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List<TraineeDTO> traineeList) {
        this.traineeList = traineeList;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(Integer conditionFlag) {
        this.conditionFlag = conditionFlag;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
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

    public EquipmentDTO getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentDTO equipment) {
        this.equipment = equipment;
    }
}
