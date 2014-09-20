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
@Table(name = "trainee")
@NamedQueries({
    @NamedQuery(name = "Trainee.CountByClass", query = "select count(a) from Trainee a "
            + "where a.trainingClass.trainingClassID = :id "
            + " and (a.activeFlag is null or a.activeFlag = 0)"),
     @NamedQuery(name = "Trainee.findByClass", query = "select a from Trainee a "
            + "where a.trainingClass.trainingClassID = :id "
            + " and (a.activeFlag is null or a.activeFlag = 0)"),
    @NamedQuery(name = "Trainee.findByCompany", query = "select a from Trainee a where a.company.companyID = :id "
            + " and (a.activeFlag is null or a.activeFlag = 0)"),
    @NamedQuery(name = "Trainee.findByInstructor",
            query = "select a from Trainee a, InstructorClass b "
            + " where a.trainingClass = b.trainingClass "
            + " and b.instructor.instructorID = :id "
            + " order by a.lastName, a.firstName"),
    @NamedQuery(name = "Trainee.login",
            query = "select a from Trainee a "
            + "where a.email = :email and a.password = :pswd")})
public class Trainee implements Serializable {
    @Column(name = "gender")
    private int gender;
    @Column(name = "activeFlag")
    private int activeFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TraineeSkill> traineeSkillList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TraineeSkillHistory> traineeSkillHistoryList;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traineeID")
    private int traineeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "middleName")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "cellphone")
    private String cellphone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Size(max = 45)
    @Column(name = "IDNumber")
    private String iDNumber;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Lob
    @Size(max = 65535)
    @Column(name = "GCMRegistrationID")
    private String gCMRegistrationID;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TraineeShout> traineeShoutList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TraineeRating> traineeRatingList;
    @OneToMany(mappedBy = "trainee")
    private List<DemoAnnouncement> demoAnnouncementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TraineeStatus> traineeStatusList;
    @JoinColumn(name = "administratorID", referencedColumnName = "administratorID")
    @ManyToOne
    private Administrator administrator;
    
    
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne
    private TrainingClass trainingClass;
    
    
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = true)
    private City city;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne
    private Company company;
    @JoinColumn(name = "institutionID", referencedColumnName = "institutionID")
    @ManyToOne
    private Institution institution;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<GuardianTrainee> guardianTraineeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<CourseTrainee> courseTraineeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<Attendance> attendanceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TeamMember> teamMemberList;
    @OneToMany(mappedBy = "trainee")
    private List<LessonResource> lessonResourceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
    private List<TraineeEquipment> traineeEquipmentList;
    @OneToMany(mappedBy = "trainee")
    private List<GcmDevice> gcmDeviceList;

    public Trainee() {
    }

    public Trainee(int traineeID) {
        this.traineeID = traineeID;
    }

    public Trainee(int traineeID, String firstName, String lastName, String email, String cellphone, Date dateRegistered) {
        this.traineeID = traineeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.dateRegistered = dateRegistered;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public List<TraineeSkillHistory> getTraineeSkillHistoryList() {
        return traineeSkillHistoryList;
    }

    public void setTraineeSkillHistoryList(List<TraineeSkillHistory> traineeSkillHistoryList) {
        this.traineeSkillHistoryList = traineeSkillHistoryList;
    }

    public String getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getgCMRegistrationID() {
        return gCMRegistrationID;
    }

    public void setgCMRegistrationID(String gCMRegistrationID) {
        this.gCMRegistrationID = gCMRegistrationID;
    }
    

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }


    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getGCMRegistrationID() {
        return gCMRegistrationID;
    }

    public void setGCMRegistrationID(String gCMRegistrationID) {
        this.gCMRegistrationID = gCMRegistrationID;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<TraineeShout> getTraineeShoutList() {
        return traineeShoutList;
    }

    public void setTraineeShoutList(List<TraineeShout> traineeShoutList) {
        this.traineeShoutList = traineeShoutList;
    }

    public List<TraineeRating> getTraineeRatingList() {
        return traineeRatingList;
    }

    public void setTraineeRatingList(List<TraineeRating> traineeRatingList) {
        this.traineeRatingList = traineeRatingList;
    }

    public List<DemoAnnouncement> getDemoAnnouncementList() {
        return demoAnnouncementList;
    }

    public void setDemoAnnouncementList(List<DemoAnnouncement> demoAnnouncementList) {
        this.demoAnnouncementList = demoAnnouncementList;
    }

    public List<TraineeStatus> getTraineeStatusList() {
        return traineeStatusList;
    }

    public void setTraineeStatusList(List<TraineeStatus> traineeStatusList) {
        this.traineeStatusList = traineeStatusList;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<GuardianTrainee> getGuardianTraineeList() {
        return guardianTraineeList;
    }

    public void setGuardianTraineeList(List<GuardianTrainee> guardianTraineeList) {
        this.guardianTraineeList = guardianTraineeList;
    }

    public List<CourseTrainee> getCourseTraineeList() {
        return courseTraineeList;
    }

    public void setCourseTraineeList(List<CourseTrainee> courseTraineeList) {
        this.courseTraineeList = courseTraineeList;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<TeamMember> getTeamMemberList() {
        return teamMemberList;
    }

    public void setTeamMemberList(List<TeamMember> teamMemberList) {
        this.teamMemberList = teamMemberList;
    }

    public List<LessonResource> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResource> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }

    public List<TraineeEquipment> getTraineeEquipmentList() {
        return traineeEquipmentList;
    }

    public void setTraineeEquipmentList(List<TraineeEquipment> traineeEquipmentList) {
        this.traineeEquipmentList = traineeEquipmentList;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Trainee[ traineeID=" + traineeID + " ]";
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<TraineeSkill> getTraineeSkillList() {
        return traineeSkillList;
    }

    public void setTraineeSkillList(List<TraineeSkill> traineeSkillList) {
        this.traineeSkillList = traineeSkillList;
    }

}
