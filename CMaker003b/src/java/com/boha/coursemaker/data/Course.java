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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findByNameInCategory",
            query = "select a from Course a where a.courseName = :courseName "
            + "and a.category.categoryID = :id"),
    @NamedQuery(name = "Course.findByCategoryID",
            query = "select a from Course a "
            + "where a.category.categoryID = :id"
            + " order by a.priorityFlag"),
    @NamedQuery(name = "Course.findByAuthorID",
            query = "select a from Course a, CourseAuthor b "
            + " where a.courseID = b.course.courseID and b.author.authorID = :authorID "
            + " order by a.category.categoryID, a.courseName"),
    @NamedQuery(name = "Course.findByCompanyID",
            query = "select a from Course a"
            + " where a.company.companyID = :id "
            + " order by a.category.categoryID, a.priorityFlag")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseID")
    private int courseID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "activeFlag")
    private int activeFlag;
    @Size(max = 255)
    @Column(name = "courseName")
    private String courseName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "shareFlag")
    private int shareFlag;
    @Column(name = "priorityFlag")
    private int priorityFlag;
    @Column(name = "localID")
    private long localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<CourseAuthor> courseAuthorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<TrainingClassCourse> trainingClassCourseList;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    @ManyToOne
    private Category category;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Activity> activityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Objective> objectiveList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<LessonResource> lessonResourceList;

    public Course() {
    }

    public Course(int courseID) {
        this.courseID = courseID;
    }

    public Course(int courseID, Date dateUpdated) {
        this.courseID = courseID;
        this.dateUpdated = dateUpdated;
    }

    public List<LessonResource> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResource> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(int priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShareFlag() {
        return shareFlag;
    }

    public void setShareFlag(int shareFlag) {
        this.shareFlag = shareFlag;
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

    public List<CourseAuthor> getCourseAuthorList() {
        return courseAuthorList;
    }

    public void setCourseAuthorList(List<CourseAuthor> courseAuthorList) {
        this.courseAuthorList = courseAuthorList;
    }

    public List<TrainingClassCourse> getTrainingClassCourseList() {
        return trainingClassCourseList;
    }

    public void setTrainingClassCourseList(List<TrainingClassCourse> trainingClassCourseList) {
        this.trainingClassCourseList = trainingClassCourseList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public List<Objective> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(List<Objective> objectiveList) {
        this.objectiveList = objectiveList;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Course[ courseID=" + courseID + " ]";
    }

}
