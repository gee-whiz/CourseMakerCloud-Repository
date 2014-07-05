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

    private int inventoryID;
    private String serialNumber;
    private long dateRegistered;
    private int conditionFlag;
    private long dateUpdated;
    private String model;
    private int yearPurchased;
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

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
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

    public int getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(int conditionFlag) {
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

    public int getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(int yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    public EquipmentDTO getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentDTO equipment) {
        this.equipment = equipment;
    }
}
