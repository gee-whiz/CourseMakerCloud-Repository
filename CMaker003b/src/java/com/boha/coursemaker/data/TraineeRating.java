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
@Table(name = "traineeRating")
@NamedQueries({
    @NamedQuery(name = "TraineeRating.findByActivity", 
        query = "select a from TraineeRating a "
                    + " where a.courseTraineeActivity.courseTraineeActivityID = :id "
                    + " order by a.dateUpdated desc"),
    @NamedQuery(name = "TraineeRating.findByTrainee", 
        query = "select a from TraineeRating a "
                    + " where a.trainee.traineeID = :id "
                    + " order by a.dateUpdated desc "),
    @NamedQuery(name = "TraineeRating.findByClass", 
        query = "select distinct a from TraineeRating a "
        + "where a.trainee.trainingClass.trainingClassID = :id "
                + " order by a.dateUpdated desc")})
public class TraineeRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeRatingID")
    private Integer traineeRatingID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;
    @JoinColumn(name = "ratingID", referencedColumnName = "ratingID")
    @ManyToOne(optional = false)
    private Rating rating;
    @JoinColumn(name = "courseTraineeActivityID", referencedColumnName = "courseTraineeActivityID")
    @ManyToOne(optional = false)
    private CourseTraineeActivity courseTraineeActivity;

    public TraineeRating() {
    }

    public TraineeRating(Integer traineeRatingID) {
        this.traineeRatingID = traineeRatingID;
    }

    public TraineeRating(Integer traineeRatingID, Date dateUpdated) {
        this.traineeRatingID = traineeRatingID;
        this.dateUpdated = dateUpdated;
    }

    public Integer getTraineeRatingID() {
        return traineeRatingID;
    }

    public void setTraineeRatingID(Integer traineeRatingID) {
        this.traineeRatingID = traineeRatingID;
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

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
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

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traineeRatingID != null ? traineeRatingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraineeRating)) {
            return false;
        }
        TraineeRating other = (TraineeRating) object;
        if ((this.traineeRatingID == null && other.traineeRatingID != null) || (this.traineeRatingID != null && !this.traineeRatingID.equals(other.traineeRatingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TraineeRating[ traineeRatingID=" + traineeRatingID + " ]";
    }
    
}
