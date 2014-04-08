/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "trainingClassCourse")
@NamedQueries({
    @NamedQuery(name = "TrainingClassCourse.findByCompanyID", query = "select distinct a from TrainingClassCourse a "
                + "where a.trainingClass.company.companyID = :id "
                + "order by a.course.courseID"),
    @NamedQuery(name = "TrainingClassCourse.findByTrainingClassID", 
        query = "select a from TrainingClassCourse a "
                    + " where a.trainingClass.trainingClassID = :id"
                    + " order by a.priorityFlag "),
    @NamedQuery(name = "TrainingClassCourse.findByInstructor", 
        query = "select distinct a from TrainingClassCourse a, InstructorClass b "
                + " where a.trainingClass = b.trainingClass "
                + " and b.instructor.instructorID = :id "
                + " order by a.trainingClass.trainingClassID"),
    
    @NamedQuery(name = "TrainingClassCourse.countByInstructor", 
        query = "select count(distinct a) from TrainingClassCourse a, InstructorClass b "
                + " where a.trainingClass.trainingClassID = b.trainingClass.trainingClassID "
                + " and b.instructor.instructorID = :instructorID"),
    @NamedQuery(name = "TrainingClassCourse.checkIfExists", 
        query = "select a from TrainingClassCourse a "
                + "where a.trainingClass.trainingClassID = :tcID "
                + "and a.course.courseID = :cID")
    })
public class TrainingClassCourse implements Serializable {
    @OneToMany(mappedBy = "trainingClassCourse", fetch = FetchType.EAGER)
    private List<TrainingClassEvent> trainingClassEventList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trainingClassCourseID")
    private Integer trainingClassCourseID;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "priorityFlag")
    private Integer priorityFlag;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false)
    private TrainingClass trainingClass;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course course;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClassCourse")
    private List<CourseTrainee> courseTraineeList;

    public TrainingClassCourse() {
    }

    public TrainingClassCourse(Integer trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public Integer getTrainingClassCourseID() {
        return trainingClassCourseID;
    }

    public void setTrainingClassCourseID(Integer trainingClassCourseID) {
        this.trainingClassCourseID = trainingClassCourseID;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(Integer priorityFlag) {
        this.priorityFlag = priorityFlag;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

  

    public List<CourseTrainee> getCourseTraineeList() {
        return courseTraineeList;
    }

    public void setCourseTraineeList(List<CourseTrainee> courseTraineeList) {
        this.courseTraineeList = courseTraineeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingClassCourseID != null ? trainingClassCourseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingClassCourse)) {
            return false;
        }
        TrainingClassCourse other = (TrainingClassCourse) object;
        if ((this.trainingClassCourseID == null && other.trainingClassCourseID != null) || (this.trainingClassCourseID != null && !this.trainingClassCourseID.equals(other.trainingClassCourseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TrainingClassCourse[ trainingClassCourseID=" + trainingClassCourseID + " ]";
    }

    public List<TrainingClassEvent> getTrainingClassEventList() {
        return trainingClassEventList;
    }

    public void setTrainingClassEventList(List<TrainingClassEvent> trainingClassEventList) {
        this.trainingClassEventList = trainingClassEventList;
    }
    
}
