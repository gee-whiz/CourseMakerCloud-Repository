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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "trainingClassEvent")
@NamedQueries({
    @NamedQuery(name = "TrainingClassEvent.findByClass", 
        query = "select a from TrainingClassEvent a "
                    + "where a.trainingClass.trainingClassID = :id "
                    + "order by a.startDate desc")})

public class TrainingClassEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trainingClassEventID")
    private int trainingClassEventID;
    @Lob
    @Size(max = 65535)
    @Column(name = "eventName")
    private String eventName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Lob
    @Size(max = 65535)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false)
    private TrainingClass trainingClass;
    @JoinColumn(name = "trainingClassCourseID", referencedColumnName = "trainingClassCourseID")
    @ManyToOne(optional = false)
    private TrainingClassCourse trainingClassCourse;

    public TrainingClassEvent() {
    }

    public TrainingClassEvent(int trainingClassEventID) {
        this.trainingClassEventID = trainingClassEventID;
    }

    public TrainingClassEvent(int trainingClassEventID, Date dateRegistered, Date startDate, Date endDate) {
        this.trainingClassEventID = trainingClassEventID;
        this.dateRegistered = dateRegistered;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTrainingClassEventID() {
        return trainingClassEventID;
    }

    public void setTrainingClassEventID(int trainingClassEventID) {
        this.trainingClassEventID = trainingClassEventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }

    public TrainingClassCourse getTrainingClassCourse() {
        return trainingClassCourse;
    }

    public void setTrainingClassCourse(TrainingClassCourse trainingClassCourse) {
        this.trainingClassCourse = trainingClassCourse;
    }

  

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TrainingClassEvent[ trainingClassEventID=" + trainingClassEventID + " ]";
    }
    
}
