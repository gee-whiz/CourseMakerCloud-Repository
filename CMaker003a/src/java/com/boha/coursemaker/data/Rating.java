/*
 * To change this template, choose Tools | Templates
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
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ratingID")
    private Integer ratingID;
    @Size(max = 50)
    @Column(name = "ratingName")
    private String ratingName;
    @Column(name = "ratingNumber")
    private Integer ratingNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
    private List<TraineeRating> traineeRatingList;
    @OneToMany(mappedBy = "rating")
    private List<CourseTraineeActivity> courseTraineeActivityList;
    @OneToMany(mappedBy = "rating")
    private List<CourseTrainee> courseTraineeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
    private List<InstructorRating> instructorRatingList;

    public Rating() {
    }

    public Rating(Integer ratingID) {
        this.ratingID = ratingID;
    }

    public Integer getRatingID() {
        return ratingID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setRatingID(Integer ratingID) {
        this.ratingID = ratingID;
    }

    public String getRatingName() {
        return ratingName;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public Integer getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(Integer ratingNumber) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingID != null ? ratingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingID == null && other.ratingID != null) || (this.ratingID != null && !this.ratingID.equals(other.ratingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Rating[ ratingID=" + ratingID + " ]";
    }
    
}
