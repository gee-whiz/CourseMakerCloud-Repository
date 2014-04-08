/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.ErrorStore;

/**
 *
 * @author aubreyM
 */
public class ErrorStoreDTO {

    private Integer errorStoreID;
    private int statusCode;
    private String message, origin;
    private long dateOccured;

    public ErrorStoreDTO(ErrorStore a) {
        errorStoreID = a.getErrorStoreID();
        statusCode = a.getStatusCode();
        message = a.getMessage();
        origin = a.getOrigin();
        dateOccured = a.getDateOccured().getTime();
    }

    public Integer getErrorStoreID() {
        return errorStoreID;
    }

    public void setErrorStoreID(Integer errorStoreID) {
        this.errorStoreID = errorStoreID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDateOccured() {
        return dateOccured;
    }

    public void setDateOccured(long dateOccured) {
        this.dateOccured = dateOccured;
    }
}
