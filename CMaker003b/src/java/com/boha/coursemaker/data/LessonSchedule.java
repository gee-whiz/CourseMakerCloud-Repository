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
    private Integer lessonScheduleID;
    @Column(name = "scheduleDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "lessonID", referencedColumnName = "lessonID")
    @ManyToOne
    private Lesson lesson;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne
    private TrainingClass trainingClass;

    public LessonSchedule() {
    }

    public LessonSchedule(Integer lessonScheduleID) {
        this.lessonScheduleID = lessonScheduleID;
    }

    public Integer getLessonScheduleID() {
        return lessonScheduleID;
    }

    public void setLessonScheduleID(Integer lessonScheduleID) {
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonScheduleID != null ? lessonScheduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LessonSchedule)) {
            return false;
        }
        LessonSchedule other = (LessonSchedule) object;
        if ((this.lessonScheduleID == null && other.lessonScheduleID != null) || (this.lessonScheduleID != null && !this.lessonScheduleID.equals(other.lessonScheduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.LessonSchedule[ lessonScheduleID=" + lessonScheduleID + " ]";
    }
    
}
