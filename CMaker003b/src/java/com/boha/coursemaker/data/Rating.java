/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "rating")
@NamedQueries({
    @NamedQuery(name = "Rating.findByCompany", 
        query = "select a from Rating a where a.company.companyID = :id "
                    + " order by a.ratingNumber desc"),
    })
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ratingID")
    private int ratingID;
    @Size(max = 50)
    @Column(name = "ratingName")
    private String ratingName;
    @Column(name = "ratingNumber")
    private int ratingNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
    private List<TraineeRating> traineeRatingList;
    @OneToMany(mappedBy = "rating")
    private List<CourseTraineeActivity> courseTraineeActivityList;
    @OneToMany(mappedBy = "rating")
    private List<CourseTrainee> courseTraineeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
    private List<InstructorRating> instructorRatingList;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;

    public Rating() {
    }

    public Rating(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public String getRatingName() {
        return ratingName;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public List<TraineeRating> getTraineeRatingList() {
        return traineeRatingList;
    }

    public void setTraineeRatingList(List<TraineeRating> traineeRatingList) {
        this.traineeRatingList = traineeRatingList;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivity> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

    public List<CourseTrainee> getCourseTraineeList() {
        return courseTraineeList;
    }

    public void setCourseTraineeList(List<CourseTrainee> courseTraineeList) {
        this.courseTraineeList = courseTraineeList;
    }

    public List<InstructorRating> getInstructorRatingList() {
        return instructorRatingList;
    }

    public void setInstructorRatingList(List<InstructorRating> instructorRatingList) {
        this.instructorRatingList = instructorRatingList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Rating[ ratingID=" + ratingID + " ]";
    }
    
}
