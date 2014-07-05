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

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "lessonSchedule")
@NamedQueries({
    @NamedQuery(name = "LessonSchedule.findAll", query = "SELECT l FROM LessonSchedule l"),
    @NamedQuery(name = "LessonSchedule.findByLessonScheduleID", query = "SELECT l FROM LessonSchedule l WHERE l.lessonScheduleID = :lessonScheduleID"),
    @NamedQuery(name = "LessonSchedule.findByScheduleDate", query = "SELECT l FROM LessonSchedule l WHERE l.scheduleDate = :scheduleDate"),
    @NamedQuery(name = "LessonSchedule.findByEndDate", query = "SELECT l FROM LessonSchedule l WHERE l.endDate = :endDate")})
public class LessonSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lessonScheduleID")
    private int lessonScheduleID;
    @Column(name = "scheduleDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "activityID", referencedColumnName = "activityID")
    @ManyToOne
    private Activity activity;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne
    private TrainingClass trainingClass;

    public LessonSchedule() {
    }

    public LessonSchedule(int lessonScheduleID) {
        this.lessonScheduleID = lessonScheduleID;
    }

    public int getLessonScheduleID() {
        return lessonScheduleID;
    }

    public void setLessonScheduleID(int lessonScheduleID) {
        this.lessonScheduleID = lessonScheduleID;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.LessonSchedule[ lessonScheduleID=" + lessonScheduleID + " ]";
    }
    
}
