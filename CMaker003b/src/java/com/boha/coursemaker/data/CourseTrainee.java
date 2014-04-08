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
@Table(name = "courseTrainee")
@NamedQueries({
    @NamedQuery(name = "CourseTrainee.checkIfEnrolled", 
        query = "select a from CourseTrainee a "
                + "where a.trainee = :t and a.trainingClassCourse = :tcc "),
    
    @NamedQuery(name = "CourseTrainee.findByClassCourse", 
        query = "select a from CourseTrainee a "
                + "where a.trainingClassCourse.trainingClassCourseID = :id"),
    
    @NamedQuery(name = "CourseTrainee.findByTrainee", 
        query = "select a from CourseTrainee a "
                + "where a.trainee = :tc"),
    
    
    @NamedQuery(name = "CourseTrainee.findByClass", 
        query = "select a from CourseTrainee a "
                + "where a.trainee.trainingClass.trainingClassID = :id "
                + "order by a.trainee.traineeID")})
public class CourseTrainee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseTraineeID")
    private Integer courseTraineeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateEnrolled")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnrolled;
    @Column(name = "ratingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratingDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseTrainee")
    private List<CourseTraineeActivity> courseTraineeActivityList;
    @JoinColumn(name = "ratingID", referencedColumnName = "ratingID")
    @ManyToOne
    private Rating rating;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;
    @JoinColumn(name = "trainingClassCourseID", referencedColumnName = "trainingClassCourseID")
    @ManyToOne(optional = false)
    private TrainingClassCourse trainingClassCourse;

    public CourseTrainee() {
    }

    public CourseTrainee(Integer courseTraineeID) {
        this.courseTraineeID = courseTraineeID;
    }

    public CourseTrainee(Integer courseTraineeID, Date dateEnrolled) {
        this.courseTraineeID = courseTraineeID;
        this.dateEnrolled = dateEnrolled;
    }

    public Integer getCourseTraineeID() {
        return courseTraineeID;
    }

    public void setCourseTraineeID(Integer courseTraineeID) {
        this.courseTraineeID = courseTraineeID;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivity> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public TrainingClassCourse getTrainingClassCourse() {
        return trainingClassCourse;
    }

    public void setTrainingClassCourse(TrainingClassCourse trainingClassCourse) {
        this.trainingClassCourse = trainingClassCourse;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseTraineeID != null ? courseTraineeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseTrainee)) {
            return false;
        }
        CourseTrainee other = (CourseTrainee) object;
        if ((this.courseTraineeID == null && other.courseTraineeID != null) || (this.courseTraineeID != null && !this.courseTraineeID.equals(other.courseTraineeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.CourseTrainee[ courseTraineeID=" + courseTraineeID + " ]";
    }
    
}
