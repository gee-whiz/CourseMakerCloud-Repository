/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
    @NamedQuery(name = "Course.findByCategoryID", 
        query = "select a from Course a "
                    + "where a.category.categoryID = :id"
                    + " order by a.courseName"),
    @NamedQuery(name = "Course.findByAuthorID", 
        query = "select a from Course a, CourseAuthor b "
                + " where a.courseID = b.course.courseID and b.author.authorID = :authorID "
                + " order by a.category.categoryID, a.courseName"),
@NamedQuery(name = "Course.findByCompanyID", 
        query = "select a from Course a"
                    + " where a.company.companyID = :id "
                    + " order by a.dateUpdated desc")})
public class Course implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.LAZY)
    private List<Objective> objectiveList;
    @Column(name = "localID")
    private BigInteger localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseID")
    private Integer courseID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "activeFlag")
    private Integer activeFlag;
    @Size(max = 255)
    @Column(name = "courseName")
    private String courseName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "shareFlag")
    private Integer shareFlag;
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
    
    @OneToMany(mappedBy = "course")
    @OrderBy("priorityFlag")    
    private List<Lesson> lessonList;

    public Course() {
    }

    public Course(Integer courseID) {
        this.courseID = courseID;
    }

    public Course(Integer courseID, Date dateUpdated) {
        this.courseID = courseID;
        this.dateUpdated = dateUpdated;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
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

    public Integer getShareFlag() {
        return shareFlag;
    }

    public void setShareFlag(Integer shareFlag) {
        this.shareFlag = shareFlag;
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

    

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Course[ courseID=" + courseID + " ]";
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

    public List<Objective> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(List<Objective> objectiveList) {
        this.objectiveList = objectiveList;
    }
    
}
