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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
                + " and a.activeFlag is null "
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<HelpResponse> helpResponseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<InstructorClass> instructorClassList;
    @OneToMany(mappedBy = "instructor")
    private List<GcmDevice> gcmDeviceList;
    @Size(max = 100)
    @Column(name = "GCMRegistrationID")
    private String GCMRegistrationID;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instructorID")
    private Integer instructorID;
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
    @Column(name = "activeFlag")
    private Integer activeFlag;
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
    @OneToMany(mappedBy = "instructor")
    private List<LessonResource> lessonResourceList;
    

    public Instructor() {
    }

    public Instructor(Integer instructorID) {
        this.instructorID = instructorID;
    }

    public Instructor(Integer instructorID, String firstName, String lastName, String email, String cellphone, Date dateRegistered) {
        this.instructorID = instructorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.dateRegistered = dateRegistered;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
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

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
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

    public List<LessonResource> getLessonResourceList() {
        return lessonResourceList;
    }

    public void setLessonResourceList(List<LessonResource> lessonResourceList) {
        this.lessonResourceList = lessonResourceList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorID != null ? instructorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorID == null && other.instructorID != null) || (this.instructorID != null && !this.instructorID.equals(other.instructorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Instructor[ instructorID=" + instructorID + " ]";
    }

    public String getGCMRegistrationID() {
        return GCMRegistrationID;
    }

    public void setGCMRegistrationID(String gCMRegistrationID) {
        this.GCMRegistrationID = gCMRegistrationID;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public List<InstructorClass> getInstructorClassList() {
        return instructorClassList;
    }

    public void setInstructorClassList(List<InstructorClass> instructorClassList) {
        this.instructorClassList = instructorClassList;
    }

    public List<HelpResponse> getHelpResponseList() {
        return helpResponseList;
    }

    public void setHelpResponseList(List<HelpResponse> helpResponseList) {
        this.helpResponseList = helpResponseList;
    }
    
}
