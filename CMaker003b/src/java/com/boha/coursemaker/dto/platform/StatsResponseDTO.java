/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto.platform;

import com.boha.coursemaker.dto.ErrorStoreAndroidDTO;
import com.boha.coursemaker.dto.ErrorStoreDTO;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class StatsResponseDTO {

    private int statusCode;
    private String message, logString, sessionID;
    private List<CompanyStatsDTO> statsList;
    private List<ErrorStoreDTO> errorStoreList;
    private List<ErrorStoreAndroidDTO> errorStoreAndroidList;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    
    public int getStatusCode() {
        return statusCode;
    }

    public List<ErrorStoreAndroidDTO> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroidDTO> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getLogString() {
        return logString;
    }

    public void setLogString(String logString) {
        this.logString = logString;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CompanyStatsDTO> getStatsList() {
        return statsList;
    }

    public void setStatsList(List<CompanyStatsDTO> statsList) {
        this.statsList = statsList;
    }

    public List<ErrorStoreDTO> getErrorStoreList() {
        return errorStoreList;
    }

    public void setErrorStoreList(List<ErrorStoreDTO> errorStoreList) {
        this.errorStoreList = errorStoreList;
    }
    public static final int ERROR_UNKNOWN_REQUEST = 105;
    public static final int ERROR_INVALID_REQUEST = 100;
    public static final int ERROR_DATABASE = 120;
    public static final int ERROR_USER_LOGIN = 130;
    public static final int ERROR_DUPLICATE = 140;
    public static final int ERROR_SERVER = 150;
    public static final int ERROR_CALENDAR_NOT_FOUND = 160;
    public static final int ERROR_DATA_NOT_FOUND = 170;
    public static final int ERROR_FILE_DOWNLOAD = 180;
}
