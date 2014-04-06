/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.data;

import java.io.Serializable;
import java.math.BigInteger;
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
    @NamedQuery(name = "Activity.findByLesson", query = "select a from Activity a "
                + "where a.lesson.lessonID = :id order by a.priorityFlag"),
    @NamedQuery(name = "Activity.findByCourseID", 
        query = "select a from Activity a where "
                + "a.lesson.course.courseID = :id"
                + " order by a.priorityFlag"),
    @NamedQuery(name = "Activity.findByCategory", 
        query = "select a from Activity a "
                + "where a.lesson.course.category.categoryID = :id"),
    @NamedQuery(name = "Activity.findByAuthor", 
        query = "select a from Activity a, CourseAuthor b "
                + " where a.lesson.course.courseID = b.course.courseID and b.author.authorID = :authorID "
                + " order by a.lesson.lessonID, a.priorityFlag"),
@NamedQuery(name = "Activity.findByCompany", 
        query = "select a from Activity a "
                + " where a.lesson.course.company.companyID = :id "
                + " order by a.lesson.lessonID, a.priorityFlag")})
public class Activity implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "durationInDays")
    private Double durationInDays;
    @Column(name = "localID")
    private BigInteger localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activityID")
    private Integer activityID;
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
    private Integer priorityFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity")
    private List<CourseTraineeActivity> courseTraineeActivityList;
    @JoinColumn(name = "lessonID", referencedColumnName = "lessonID")
    @ManyToOne(optional = false)
    private Lesson lesson;

    public Activity() {
    }

    public Activity(Integer activityID) {
        this.activityID = activityID;
    }

    public Activity(Integer activityID, String activityName) {
        this.activityID = activityID;
        this.activityName = activityName;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
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

    public Integer getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(Integer priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivity> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityID != null ? activityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityID == null && other.activityID != null) || (this.activityID != null && !this.activityID.equals(other.activityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Activity[ activityID=" + activityID + " ]";
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public BigInteger getLocalID() {
        return localID;
    }

    public void setLocalID(BigInteger localID) {
        this.localID = localID;
    }

    public Double getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Double durationInDays) {
        this.durationInDays = durationInDays;
    }
    
}
