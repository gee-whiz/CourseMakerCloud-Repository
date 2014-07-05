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
            + "where a.course.category.categoryID = :id"),
    
    @NamedQuery(name = "LessonResource.findByAuthorID",
            query = "select a from LessonResource a, CourseAuthor b "
            + " where a.course.courseID = b.course.courseID and b.author.authorID = :authorID "
            + " order by a.course.courseID"),
    
    @NamedQuery(name = "LessonResource.findByCompany",
            query = "select a from LessonResource a "
            + " where a.course.company.companyID = :id "
            + " order by a.course.courseID"),
   
    @NamedQuery(name = "LessonResource.findByCourse",
            query = "select a from LessonResource a "
            + "where a.course.courseID = :id ")})
public class LessonResource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lessonResourceID")
    private int lessonResourceID;
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
    @Column(name = "localID")
    private long localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne
    private Instructor instructor;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne
    private Trainee trainee;
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    @ManyToOne
    private Author author;

    public LessonResource() {
    }

    public LessonResource(int lessonResourceID) {
        this.lessonResourceID = lessonResourceID;
    }

    public LessonResource(int lessonResourceID, String url, Date dateUpdated) {
        this.lessonResourceID = lessonResourceID;
        this.url = url;
        this.dateUpdated = dateUpdated;
    }

    public int getLessonResourceID() {
        return lessonResourceID;
    }

    public void setLessonResourceID(int lessonResourceID) {
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

    public long getLocalID() {
        return localID;
    }

    public void setLocalID(long localID) {
        this.localID = localID;
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.LessonResource[ lessonResourceID=" + lessonResourceID + " ]";
    }

}
