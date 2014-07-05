/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "attendance")
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findByAttendanceID", query = "SELECT a FROM Attendance a WHERE a.attendanceID = :attendanceID"),
    @NamedQuery(name = "Attendance.findByCheckInDate", query = "SELECT a FROM Attendance a WHERE a.checkInDate = :checkInDate"),
    @NamedQuery(name = "Attendance.findByCheckOutDate", query = "SELECT a FROM Attendance a WHERE a.checkOutDate = :checkOutDate"),
    @NamedQuery(name = "Attendance.findByCheckInLatitude", query = "SELECT a FROM Attendance a WHERE a.checkInLatitude = :checkInLatitude"),
    @NamedQuery(name = "Attendance.findByCheckInLongitude", query = "SELECT a FROM Attendance a WHERE a.checkInLongitude = :checkInLongitude"),
    @NamedQuery(name = "Attendance.findByCheckOutLatitude", query = "SELECT a FROM Attendance a WHERE a.checkOutLatitude = :checkOutLatitude"),
    @NamedQuery(name = "Attendance.findByCheckOutLongitude", query = "SELECT a FROM Attendance a WHERE a.checkOutLongitude = :checkOutLongitude")})
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attendanceID")
    private int attendanceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "checkInLatitude")
    private double checkInLatitude;
    @Column(name = "checkInLongitude")
    private double checkInLongitude;
    @Column(name = "checkOutLatitude")
    private double checkOutLatitude;
    @Column(name = "checkOutLongitude")
    private double checkOutLongitude;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false)
    private TrainingClass trainingClass;

    public Attendance() {
    }

    public Attendance(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Attendance(int attendanceID, Date checkInDate, Date checkOutDate) {
        this.attendanceID = attendanceID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
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

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }



    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Attendance[ attendanceID=" + attendanceID + " ]";
    }
    
}
