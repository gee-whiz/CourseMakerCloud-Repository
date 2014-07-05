/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@Table(name = "activity")
@NamedQueries({
   
    @NamedQuery(name = "Activity.findByCourseID",
            query = "select a from Activity a where a.course.courseID = :id"
            + " order by a.priorityFlag"),
    @NamedQuery(name = "Activity.findByCategory",
            query = "select a from Activity a "
            + "where a.course.category.categoryID = :id"),
    @NamedQuery(name = "Activity.findByAuthor",
            query = "select a from Activity a, CourseAuthor b "
            + " where a.course.courseID = b.course.courseID and b.author.authorID = :authorID "
            + " order by a.course.courseID, a.priorityFlag"),
    @NamedQuery(name = "Activity.findByCompany",
            query = "select a from Activity a "
            + " where a.course.company.companyID = :id "
            + " order by a.course.courseID, a.priorityFlag")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activityID")
    private int activityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "activityName")
    private String activityName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "priorityFlag")
    private int priorityFlag;
    @Column(name = "localID")
    private long localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "durationInDays")
    private double durationInDays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity")
    private List<CourseTraineeActivity> courseTraineeActivityList;
    @OneToMany(mappedBy = "activity")
    private List<LessonSchedule> lessonScheduleList;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course course;
    

    public Activity() {
    }

    public Activity(int activityID) {
        this.activityID = activityID;
    }

    public Activity(int activityID, String activityName) {
        this.activityID = activityID;
        this.activityName = activityName;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(int priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public long getLocalID() {
        return localID;
    }

    public void setLocalID(long localID) {
        this.localID = localID;
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public double getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(double durationInDays) {
        this.durationInDays = durationInDays;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivity> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

    public List<LessonSchedule> getLessonScheduleList() {
        return lessonScheduleList;
    }

    public void setLessonScheduleList(List<LessonSchedule> lessonScheduleList) {
        this.lessonScheduleList = lessonScheduleList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Activity[ activityID=" + activityID + " ]";
    }

}
