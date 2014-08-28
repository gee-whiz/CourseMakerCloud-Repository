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
@Table(name = "instructor")
@NamedQueries({
    @NamedQuery(name = "Instructor.findByCompanyID", query = "select a from Instructor a "
                + "where a.company.companyID = :id "
                + " and (a.activeFlag is null or a.activeFlag = 0) "
                + " order by a.lastName, a.firstName"),
    
    @NamedQuery(name = "Instructor.login", 
        query = "select a from Instructor a "
                    + "where a.email = :email and a.password = :pswd"),
    
    @NamedQuery(name = "Instructor.findByClass", query = 
        "select distinct a from Instructor a, InstructorClass b "
                    + " where b.trainingClass.trainingClassID = :id "
                    + " and a.instructorID = b.instructor.instructorID "
                    + " order by a.lastName, a.firstName ")})
public class Instructor implements Serializable {
    @Column(name = "activeFlag")
    private int activeFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<TraineeSkill> traineeSkillList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<TraineeSkillHistory> traineeSkillHistoryList;
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instructorID")
    private int instructorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cellphone")
    private String cellphone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Lob
    @Size(max = 65535)
    @Column(name = "GCMRegistrationID")
    private String gCMRegistrationID;
    @JoinColumn(name = "administratorID", referencedColumnName = "administratorID")
    @ManyToOne
    private Administrator administrator;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false)
    private City city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<InstructorRating> instructorRatingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<HelpResponse> helpResponseList;
    @OneToMany(mappedBy = "instructor")
    private List<LessonResource> lessonResourceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<InstructorClass> instructorClassList;
    @OneToMany(mappedBy = "instructor")
    private List<GcmDevice> gcmDeviceList;

    public Instructor() {
    }

    public Instructor(int instructorID) {
        this.instructorID = instructorID;
    }

    public Instructor(int instructorID, String firstName, String lastName, String email, String cellphone, Date dateRegistered) {
        this.instructorID = instructorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.dateRegistered = dateRegistered;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public List<TraineeSkillHistory> getTraineeSkillHistoryList() {
        return traineeSkillHistoryList;
    }

    public void setTraineeSkillHistoryList(List<TraineeSkillHistory> traineeSkillHistoryList) {
        this.traineeSkillHistoryList = traineeSkillHistoryList;
    }

    public String getgCMRegistrationID() {
        return gCMRegistrationID;
    }

    public void setgCMRegistrationID(String gCMRegistrationID) {
        this.gCMRegistrationID = gCMRegistrationID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<InstructorRating> getInstructorRatingList() {
        return instructorRatingList;
    }

    public void setInstructorRatingList(List<InstructorRating> instructorRatingList) {
        this.instructorRatingList = instructorRatingList;
    }

    public List<HelpResponse> getHelpResponseList() {
        return helpResponseList;
    }

    public void setHelpResponseList(List<HelpResponse> helpResponseList) {
        this.helpResponseList = helpResponseList;
    }

    public List<LessonResource> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResource> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }

    public List<InstructorClass> getInstructorClassList() {
        return instructorClassList;
    }

    public void setInstructorClassList(List<InstructorClass> instructorClassList) {
        this.instructorClassList = instructorClassList;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Instructor[ instructorID=" + instructorID + " ]";
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
