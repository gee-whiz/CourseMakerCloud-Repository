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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "lesson")
@NamedQueries({
    @NamedQuery(name = "Lesson.findByCourse", query = "select a from Lesson a "
                + "where a.course.courseID = :id order by a.priorityFlag"),
    @NamedQuery(name = "Lesson.findByCategory", 
        query = "select a from Lesson a "
                + "where a.course.category.categoryID = :id"),
    @NamedQuery(name = "Lesson.findByAuthor", 
        query = "select a from Lesson a, CourseAuthor b "
                + " where a.course.courseID = b.course.courseID and b.author.authorID = :authorID "
                + " order by a.course.courseID, a.priorityFlag"),
     @NamedQuery(name = "Lesson.findByInstructor", 
        query = "select distinct a from Lesson a, TrainingClassCourse b, InstructorClass c "
                + " where a.course = b.course "
                + " and b.trainingClass = c.trainingClass "
                + " and c.instructor.instructorID = :id "
                + " order by a.course.courseID"),
     
     @NamedQuery(name = "Lesson.findByClass", 
        query = "select a from Lesson a, TrainingClassCourse b "
                + "where a.course = b.course "
                + "and b.trainingClass.trainingClassID = :id"),
     
     
    @NamedQuery(name = "Lesson.findByCompany", 
        query = "select a from Lesson a "
                + " where a.course.company.companyID = :id "
                + "  order by a.course.courseID, a.priorityFlag")})
public class Lesson implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "durationInDays")
    private Double durationInDays;

    @Column(name = "localID")
    private BigInteger localID;
    @Column(name = "syncDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lessonID")
    private Integer lessonID;
    @Size(max = 255)
    @Column(name = "lessonName")
    private String lessonName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "priorityFlag")
    private Integer priorityFlag;
   
    @OneToMany(mappedBy = "lesson")
    private List<LessonSchedule> lessonScheduleList;
    //
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lesson")
    @OrderBy("priorityFlag")
    private List<Activity> activityList;
    //
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne
    private Course course;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lesson")
    private List<LessonResource> lessonResourceList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lesson")
    private List<CourseTraineeActivity> courseTraineeActivityList;

    public Lesson() {
    }

    public Lesson(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivityList() {
        return courseTraineeActivityList;
    }

    public void setCourseTraineeActivityList(List<CourseTraineeActivity> courseTraineeActivityList) {
        this.courseTraineeActivityList = courseTraineeActivityList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriorityFlag() {
        return priorityFlag;
    }

  

    public void setPriorityFlag(Integer priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public List<LessonSchedule> getLessonScheduleList() {
        return lessonScheduleList;
    }

    public void setLessonScheduleList(List<LessonSchedule> lessonScheduleList) {
        this.lessonScheduleList = lessonScheduleList;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<LessonResource> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResource> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonID != null ? lessonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.lessonID == null && other.lessonID != null) || (this.lessonID != null && !this.lessonID.equals(other.lessonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Lesson[ lessonID=" + lessonID + " ]";
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

    public Double getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Double durationInDays) {
        this.durationInDays = durationInDays;
    }
}
