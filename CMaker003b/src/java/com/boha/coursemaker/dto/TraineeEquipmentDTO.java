/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.TraineeEquipment;

/**
 *
 * @author aubreyM
 */
public class TraineeEquipmentDTO {
    private int traineeEquipmentID;
    
    private long dateRegistered;
    
    private long dateReturned;
    
    private int conditionFlag;
        
    private InventoryDTO inventory;
    
    private TraineeDTO trainee;
    
    public TraineeEquipmentDTO(TraineeEquipment a) {
        traineeEquipmentID = a.getTraineeEquipmentID();
        trainee = new TraineeDTO(a.getTrainee());
        dateRegistered = a.getDateRegistered().getTime();
        if (a.getDateReturned() != null) {
            dateReturned = a.getDateReturned().getTime();
        }
        conditionFlag = a.getConditionFlag();
        inventory = new InventoryDTO(a.getInventory());
        
    }

    public int getTraineeEquipmentID() {
        return traineeEquipmentID;
    }

    public void setTraineeEquipmentID(int traineeEquipmentID) {
        this.traineeEquipmentID = traineeEquipmentID;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public long getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(long dateReturned) {
        this.dateReturned = dateReturned;
    }

    public int getConditionFlag() {
        return conditionFlag;
    }

    public InventoryDTO getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDTO inventory) {
        this.inventory = inventory;
    }

    public void setConditionFlag(int conditionFlag) {
        this.conditionFlag = conditionFlag;
    }

    public TraineeDTO getTrainee() {
        return trainee;
    }

    public void setTrainee(TraineeDTO trainee) {
        this.trainee = trainee;
    }


}
