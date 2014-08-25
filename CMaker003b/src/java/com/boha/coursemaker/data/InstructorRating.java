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
@Table(name = "instructorRating")
@NamedQueries({
    @NamedQuery(name = "InstructorRating.findByTrainee", 
        query = "select a from InstructorRating a "
                + "where a.courseTraineeActivity.courseTrainee.trainee.traineeID"
                + " = :id order by a.dateUpdated desc"),
    @NamedQuery(name = "InstructorRating.findByClass", 
        query = "select distinct a from InstructorRating a, CourseTraineeActivity b "
                + " where a.courseTraineeActivity.courseTraineeActivityID = b.courseTraineeActivityID "
                + " and b.courseTrainee.trainee.trainingClass.trainingClassID = :id "
        + "order by a.dateUpdated desc"),
    @NamedQuery(name = "InstructorRating.findByInstructor", 
        query = "select a from InstructorRating a where "
                + " a.courseTraineeActivity.courseTraineeActivityID = :id "
                + " order by a.dateUpdated desc")
    })
public class InstructorRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instructorRatingID")
    private int instructorRatingID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Column(name = "completedFlag")
    private int completedFlag;
    @JoinColumn(name = "ratingID", referencedColumnName = "ratingID")
    @ManyToOne(optional = false)
    private Rating rating;
    @JoinColumn(name = "courseTraineeActivityID", referencedColumnName = "courseTraineeActivityID")
    @ManyToOne(optional = false)
    private CourseTraineeActivity courseTraineeActivity;
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne(optional = false)
    private Instructor instructor;

    public InstructorRating() {
    }

    public InstructorRating(int instructorRatingID) {
        this.instructorRatingID = instructorRatingID;
    }

    public InstructorRating(int instructorRatingID, Date dateUpdated) {
        this.instructorRatingID = instructorRatingID;
        this.dateUpdated = dateUpdated;
    }

    public int getInstructorRatingID() {
        return instructorRatingID;
    }

    public void setInstructorRatingID(int instructorRatingID) {
        this.instructorRatingID = instructorRatingID;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCompletedFlag() {
        return completedFlag;
    }

    public void setCompletedFlag(int completedFlag) {
        this.completedFlag = completedFlag;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public CourseTraineeActivity getCourseTraineeActivity() {
        return courseTraineeActivity;
    }

    public void setCourseTraineeActivity(CourseTraineeActivity courseTraineeActivity) {
        this.courseTraineeActivity = courseTraineeActivity;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.InstructorRating[ instructorRatingID=" + instructorRatingID + " ]";
    }
    
}
