/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "trainingClass")
@NamedQueries({
    @NamedQuery(name = "TrainingClass.findByCompanyID", query = "select a from TrainingClass a "
                + " where a.company.companyID = :id "
                + " and (a.isOpen is null or a.isOpen = 1)"
                + " order by a.startDate desc"),
    @NamedQuery(name = "TrainingClass.findByInstructor", 
        query = "select a from TrainingClass a, InstructorClass b where (a.isOpen = 1 or a.isOpen is null) "
                    + " and a.trainingClassID = b.trainingClass.trainingClassID "
                    + " and b.instructor.instructorID = :id")
    
    })
public class TrainingClass implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass", fetch = FetchType.EAGER)
    private List<Team> teamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass", fetch = FetchType.EAGER)
    private List<DemoAnnouncement> demoAnnouncementList;
    @Column(name = "calendarID")
    private Integer calendarID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass", fetch = FetchType.EAGER)
    private List<TrainingClassEvent> trainingClassEventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass")
    private List<HelpRequest> helpRequestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass")
    private List<InstructorClass> instructorClassList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass")
    private List<Attendance> attendanceList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trainingClassID")
    private Integer trainingClassID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "trainingClassName")
    private String trainingClassName;
    @Column(name = "isOpen")
    private Integer isOpen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingClass")
    private List<TrainingClassCourse> trainingClassCourseList;
    @OneToMany(mappedBy = "trainingClass")
    @OrderBy("lastName, firstName")
    private List<Trainee> traineeList;
    @OneToMany(mappedBy = "trainingClass")
    private List<LessonSchedule> lessonScheduleList;
    @JoinColumn(name = "administratorID", referencedColumnName = "administratorID")
    @ManyToOne(optional = false)
    private Administrator administrator;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;

    public TrainingClass() {
    }

    public TrainingClass(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public TrainingClass(Integer trainingClassID, String trainingClassName, Date startDate, Date endDate) {
        this.trainingClassID = trainingClassID;
        this.trainingClassName = trainingClassName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public List<TrainingClassCourse> getTrainingClassCourseList() {
        return trainingClassCourseList;
    }

    public void setTrainingClassCourseList(List<TrainingClassCourse> trainingClassCourseList) {
        this.trainingClassCourseList = trainingClassCourseList;
    }

    public List<Trainee> getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List<Trainee> traineeList) {
        this.traineeList = traineeList;
    }

    public List<LessonSchedule> getLessonScheduleList() {
        return lessonScheduleList;
    }

    public void setLessonScheduleList(List<LessonSchedule> lessonScheduleList) {
        this.lessonScheduleList = lessonScheduleList;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingClassID != null ? trainingClassID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingClass)) {
            return false;
        }
        TrainingClass other = (TrainingClass) object;
        if ((this.trainingClassID == null && other.trainingClassID != null) || (this.trainingClassID != null && !this.trainingClassID.equals(other.trainingClassID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TrainingClass[ trainingClassID=" + trainingClassID + " ]";
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<InstructorClass> getInstructorClassList() {
        return instructorClassList;
    }

    public void setInstructorClassList(List<InstructorClass> instructorClassList) {
        this.instructorClassList = instructorClassList;
    }

    public List<HelpRequest> getHelpRequestList() {
        return helpRequestList;
    }

    public void setHelpRequestList(List<HelpRequest> helpRequestList) {
        this.helpRequestList = helpRequestList;
    }


    public List<TrainingClassEvent> getTrainingClassEventList() {
        return trainingClassEventList;
    }

    public void setTrainingClassEventList(List<TrainingClassEvent> trainingClassEventList) {
        this.trainingClassEventList = trainingClassEventList;
    }

    public Integer getCalendarID() {
        return calendarID;
    }

    public void setCalendarID(Integer calendarID) {
        this.calendarID = calendarID;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<DemoAnnouncement> getDemoAnnouncementList() {
        return demoAnnouncementList;
    }

    public void setDemoAnnouncementList(List<DemoAnnouncement> demoAnnouncementList) {
        this.demoAnnouncementList = demoAnnouncementList;
    }
    
}
