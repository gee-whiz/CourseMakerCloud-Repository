/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

/**
 *
 * @author Aubrey Malabie
 */
public class DataException extends Exception {
    int errorType;
    String description = "GENERIC DATABASE ERROR";
    public DataException() {}
    public DataException(String message) {
        description = message;
    }
    public DataException(int errorType) {
        this.errorType = errorType;
        switch(errorType) {
            case GENERIC_ERROR:
                description = "GENERIC ERROR";
                break;
            case ADMIN_ERROR:
                description = "ADMINISTRATOR ERROR";
                break;
            case INSTRUCTOR_ERROR:
                description = "INSTRUCTOR ERROR";
                break;
            case TRAINEE_ERROR:
                description = "TRAINEE ERROR";
                break;
            case AUTHOR_ERROR:
                description = "GENERIC ERROR";
                break;
        }
    }

    public String getDescription() {
        return description;
    }
    
    public static final int GENERIC_ERROR = 1, ADMIN_ERROR = 2, INSTRUCTOR_ERROR = 3,
            TRAINEE_ERROR = 4, AUTHOR_ERROR = 5;
}
