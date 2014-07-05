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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "courseTraineeActivity")
@NamedQueries({
    @NamedQuery(name = "CourseTraineeActivity.findByClassCourse",
            query = "select a from CourseTraineeActivity a "
            + " where a.courseTrainee.trainingClassCourse.trainingClassCourseID = :id"
            + " order by a.dateUpdated desc "),
    @NamedQuery(name = "CourseTraineeActivity.checkIfExists",
            query = "select a from CourseTraineeActivity a "
            + " where a.courseTrainee = :ct and a.activity = :ac "),
    @NamedQuery(name = "CourseTraineeActivity.findByClass",
            query = "select a from CourseTraineeActivity a "
            + " where a.courseTrainee.trainingClassCourse.trainingClass.trainingClassID "
            + "= :id order by a.courseTrainee.trainee.lastName,"
            + " a.courseTrainee.trainee.firstName "),
    @NamedQuery(name = "CourseTraineeActivity.isEnrolled",
            query = "select a from CourseTraineeActivity a "
            + " where a.activity = :act and a.courseTrainee = :ct"),
    @NamedQuery(name = "CourseTraineeActivity.findByCourseTrainee",
            query = "select a from CourseTraineeActivity a "
            + "where a.courseTrainee = :tc"),
    @NamedQuery(name = "CourseTraineeActivity.findByTrainee",
            query = "select a from CourseTraineeActivity a "
            + " where a.courseTrainee.trainee.traineeID = :id "
            + "  ")
})
public class CourseTraineeActivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseTraineeActivityID")
    private int courseTraineeActivityID;
    @Column(name = "completedFlag")
    private int completedFlag;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "completionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completionDate;
    @Column(name = "refreshRequested")
    private int refreshRequested;
    @Column(name = "completionPercentage")
    private int completionPercentage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseTraineeActivity")
    private List<TraineeRating> traineeRatingList;
    @JoinColumn(name = "ratingID", referencedColumnName = "ratingID")
    @ManyToOne
    private Rating rating;
    @JoinColumn(name = "activityID", referencedColumnName = "activityID")
    @ManyToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "courseTraineeID", referencedColumnName = "courseTraineeID")
    @ManyToOne(optional = false)
    private CourseTrainee courseTrainee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseTraineeActivity")
    private List<InstructorRating> instructorRatingList;
    @OneToMany(mappedBy = "courseTraineeActivity")
    private List<HelpRequest> helpRequestList;

    public CourseTraineeActivity() {
    }

    public CourseTraineeActivity(int courseTraineeActivityID) {
        this.courseTraineeActivityID = courseTraineeActivityID;
    }

    public int getCourseTraineeActivityID() {
        return courseTraineeActivityID;
    }

    public void setCourseTraineeActivityID(int courseTraineeActivityID) {
        this.courseTraineeActivityID = courseTraineeActivityID;
    }

    public int getCompletedFlag() {
        return completedFlag;
    }

    public void setCompletedFlag(int completedFlag) {
        this.completedFlag = completedFlag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getRefreshRequested() {
        return refreshRequested;
    }

    public void setRefreshRequested(int refreshRequested) {
        this.refreshRequested = refreshRequested;
    }

    public int getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(int completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public List<TraineeRating> getTraineeRatingList() {
        return traineeRatingList;
    }

    public void setTraineeRatingList(List<TraineeRating> traineeRatingList) {
        this.traineeRatingList = traineeRatingList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public CourseTrainee getCourseTrainee() {
        return courseTrainee;
    }

    public void setCourseTrainee(CourseTrainee courseTrainee) {
        this.courseTrainee = courseTrainee;
    }

    public List<InstructorRating> getInstructorRatingList() {
        return instructorRatingList;
    }

    public void setInstructorRatingList(List<InstructorRating> instructorRatingList) {
        this.instructorRatingList = instructorRatingList;
    }

    public List<HelpRequest> getHelpRequestList() {
        return helpRequestList;
    }

    public void setHelpRequestList(List<HelpRequest> helpRequestList) {
        this.helpRequestList = helpRequestList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.CourseTraineeActivity[ courseTraineeActivityID=" + courseTraineeActivityID + " ]";
    }
    
}
