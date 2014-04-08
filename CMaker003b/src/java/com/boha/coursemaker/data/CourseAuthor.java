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
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "courseAuthor")
@NamedQueries({
    @NamedQuery(name = "CourseAuthor.findByCompany", 
        query = "select b from Course a, CourseAuthor b "
                + "where a.courseID = b.course.courseID "
                + "and b.author.company.companyID = :id ")})
public class CourseAuthor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseAuthorID")
    private Integer courseAuthorID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    @ManyToOne(optional = false)
    private Author author;

    public CourseAuthor() {
    }

    public CourseAuthor(Integer courseAuthorID) {
        this.courseAuthorID = courseAuthorID;
    }

    public CourseAuthor(Integer courseAuthorID, Date dateUpdated) {
        this.courseAuthorID = courseAuthorID;
        this.dateUpdated = dateUpdated;
    }

    public Integer getCourseAuthorID() {
        return courseAuthorID;
    }

    public void setCourseAuthorID(Integer courseAuthorID) {
        this.courseAuthorID = courseAuthorID;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseAuthorID != null ? courseAuthorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseAuthor)) {
            return false;
        }
        CourseAuthor other = (CourseAuthor) object;
        if ((this.courseAuthorID == null && other.courseAuthorID != null) || (this.courseAuthorID != null && !this.courseAuthorID.equals(other.courseAuthorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.CourseAuthor[ courseAuthorID=" + courseAuthorID + " ]";
    }
    
}
