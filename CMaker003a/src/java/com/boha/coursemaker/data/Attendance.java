/*
 * To change this template, choose Tools | Templates
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
    private Integer attendanceID;
    @Column(name = "checkInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Column(name = "checkOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "checkInLatitude")
    private Double checkInLatitude;
    @Column(name = "checkInLongitude")
    private Double checkInLongitude;
    @Column(name = "checkOutLatitude")
    private Double checkOutLatitude;
    @Column(name = "checkOutLongitude")
    private Double checkOutLongitude;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false)
    private TrainingClass trainingClass;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;

    public Attendance() {
    }

    public Attendance(Integer attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Integer getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(Integer attendanceID) {
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

    public Double getCheckInLatitude() {
        return checkInLatitude;
    }

    public void setCheckInLatitude(Double checkInLatitude) {
        this.checkInLatitude = checkInLatitude;
    }

    public Double getCheckInLongitude() {
        return checkInLongitude;
    }

    public void setCheckInLongitude(Double checkInLongitude) {
        this.checkInLongitude = checkInLongitude;
    }

    public Double getCheckOutLatitude() {
        return checkOutLatitude;
    }

    public void setCheckOutLatitude(Double checkOutLatitude) {
        this.checkOutLatitude = checkOutLatitude;
    }

    public Double getCheckOutLongitude() {
        return checkOutLongitude;
    }

    public void setCheckOutLongitude(Double checkOutLongitude) {
        this.checkOutLongitude = checkOutLongitude;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendanceID != null ? attendanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendanceID == null && other.attendanceID != null) || (this.attendanceID != null && !this.attendanceID.equals(other.attendanceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Attendance[ attendanceID=" + attendanceID + " ]";
    }
    
}
