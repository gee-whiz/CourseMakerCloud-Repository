/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.data;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "lessonResource")
@NamedQueries({
    @NamedQuery(name = "LessonResource.findByCategoryID", query = "select a from LessonResource a "
                + "where a.lesson.course.category.categoryID = :id"),
    @NamedQuery(name = "LessonResource.findByAuthorID", 
        query = "select a from LessonResource a, CourseAuthor b "
                + " where a.lesson.course.courseID = b.course.courseID and b.author.authorID = :authorID "
                + " order by a.lesson.lessonID"),
@NamedQuery(name = "LessonResource.findByLessonID", 
        query = "select a from LessonResource a where a.lesson.lessonID = :id"),
@NamedQuery(name = "LessonResource.findByCompany", 
        query = "select a from LessonResource a "
                + " where a.lesson.course.company.companyID = :id "
                + " order by a.lesson.lessonID"),
@NamedQuery(name = "LessonResource.findByCourse", 
        query = "select a from LessonResource a "
                + "where a.lesson.course.courseID = :id ")})
public class LessonResource implements Serializable {
    @Column(name = "localID")
    private BigInteger localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lessonResourceID")
    private Integer lessonResourceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Size(max = 255)
    @Column(name = "resourceName")
    private String resourceName;
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne
    private Instructor instructor;
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    @ManyToOne
    private Author author;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne
    private Trainee trainee;
    @JoinColumn(name = "lessonID", referencedColumnName = "lessonID")
    @ManyToOne(optional = false)
    private Lesson lesson;

    public LessonResource() {
    }

    public LessonResource(Integer lessonResourceID) {
        this.lessonResourceID = lessonResourceID;
    }

    public LessonResource(Integer lessonResourceID, String url, Date dateUpdated) {
        this.lessonResourceID = lessonResourceID;
        this.url = url;
        this.dateUpdated = dateUpdated;
    }

    public Integer getLessonResourceID() {
        return lessonResourceID;
    }

    public void setLessonResourceID(Integer lessonResourceID) {
        this.lessonResourceID = lessonResourceID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
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
        hash += (lessonResourceID != null ? lessonResourceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LessonResource)) {
            return false;
        }
        LessonResource other = (LessonResource) object;
        if ((this.lessonResourceID == null && other.lessonResourceID != null) || (this.lessonResourceID != null && !this.lessonResourceID.equals(other.lessonResourceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.LessonResource[ lessonResourceID=" + lessonResourceID + " ]";
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
    
}
