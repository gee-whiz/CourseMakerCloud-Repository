/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.GcmDevice;

/**
 *
 * @author aubreyM
 */
public class GcmDeviceDTO {

    private int gcmDeviceID;
    private String registrationID;
    private String manufacturer;
    private String model;
    private String product;
    private int messageCount;
    private long dateRegistered;
    private String serialNumber;
    private int reportUserID;
    private int traineeID;
    private int instructorID;
    private int authorID;
    private int administratorID;
    
    public GcmDeviceDTO(GcmDevice a) {
        gcmDeviceID = a.getGcmDeviceID();
        registrationID = a.getRegistrationID();
        manufacturer = a.getManufacturer();
        model = a.getModel();
        product = a.getProduct();
        messageCount = a.getMessageCount();
        dateRegistered =  a.getDateRegistered().getTime();
        serialNumber = a.getSerialNumber();
        if (a.getReportUser() != null) {
            reportUserID = a.getReportUser().getReportUserID();
        }
        if (a.getAdministrator() != null) {
            administratorID = a.getAdministrator().getAdministratorID();
        }
        if (a.getAuthor() != null) {
            authorID = a.getAuthor().getAuthorID();
        }
        if (a.getInstructor() != null) {
            instructorID = a.getInstructor().getInstructorID();
        }
        if (a.getTrainee() != null) {
            traineeID = a.getTrainee().getTraineeID();
        }
    }

    public int getGcmDeviceID() {
        return gcmDeviceID;
    }

    public void setGcmDeviceID(int gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getReportUserID() {
        return reportUserID;
    }

    public void setReportUserID(int reportUserID) {
        this.reportUserID = reportUserID;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(int administratorID) {
        this.administratorID = administratorID;
    }
}
