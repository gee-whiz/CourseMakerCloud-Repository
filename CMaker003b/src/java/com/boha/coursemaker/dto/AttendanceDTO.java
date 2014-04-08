/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Attendance;

/**
 *
 * @author aubreyM
 */
public class AttendanceDTO {

    private Integer attendanceID;
    private long checkInDate, checkOutDate;
    private double checkInLatitude;
    private double checkInLongitude;
    private double checkOutLatitude;
    private double checkOutLongitude;
    private Integer trainingClassID;
    private Integer traineeID;

    public AttendanceDTO(Attendance a) {
        attendanceID = a.getAttendanceID();
        traineeID = a.getTrainee().getTraineeID();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        if (a.getCheckInDate() != null) {
            checkInDate = a.getCheckInDate().getTime();
        }
        if (a.getCheckOutDate() != null) {
            checkOutDate = a.getCheckOutDate().getTime();
        }
        checkInLatitude = a.getCheckInLatitude();
        checkInLongitude = a.getCheckInLongitude();
        
        checkOutLatitude = a.getCheckOutLatitude();
        checkOutLongitude = a.getCheckOutLongitude();
        
        
    }

    public Integer getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(Integer attendanceID) {
        this.attendanceID = attendanceID;
    }

    public long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getCheckInLatitude() {
        return checkInLatitude;
    }

    public void setCheckInLatitude(double checkInLatitude) {
        this.checkInLatitude = checkInLatitude;
    }

    public double getCheckInLongitude() {
        return checkInLongitude;
    }

    public void setCheckInLongitude(double checkInLongitude) {
        this.checkInLongitude = checkInLongitude;
    }

    public double getCheckOutLatitude() {
        return checkOutLatitude;
    }

    public void setCheckOutLatitude(double checkOutLatitude) {
        this.checkOutLatitude = checkOutLatitude;
    }

    public double getCheckOutLongitude() {
        return checkOutLongitude;
    }

    public void setCheckOutLongitude(double checkOutLongitude) {
        this.checkOutLongitude = checkOutLongitude;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }
}
