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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "author")
@NamedQueries({
    @NamedQuery(name = "Author.findByCompany", query = "select a from Author a where a.company.companyID = :id "
                + " and a.activeFlag is null "
                + " order by a.lastName, a.firstName"),
@NamedQuery(name = "Author.login", 
        query = "select a from Author a "
                    + "where a.email = :email and a.password = :pswd")})
public class Author implements Serializable {
    @OneToMany(mappedBy = "author")
    private List<GcmDevice> gcmDeviceList;
    @Size(max = 100)
    @Column(name = "GCMRegistrationID")
    private String gCMRegistrationID;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authorID")
    private Integer authorID;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "activeFlag")
    private Integer activeFlag;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<CourseAuthor> courseAuthorList;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne
    private Company company;
    @OneToMany(mappedBy = "author")
    private List<LessonResource> lessonResourceList;

    public Author() {
    }

    public Author(Integer authorID) {
        this.authorID = authorID;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
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

   

    public List<CourseAuthor> getCourseAuthorList() {
        return courseAuthorList;
    }

    public void setCourseAuthorList(List<CourseAuthor> courseAuthorList) {
        this.courseAuthorList = courseAuthorList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        hash += (authorID != null ? authorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorID == null && other.authorID != null) || (this.authorID != null && !this.authorID.equals(other.authorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Author[ authorID=" + authorID + " ]";
    }

    public String getGCMRegistrationID() {
        return gCMRegistrationID;
    }

    public void setGCMRegistrationID(String gCMRegistrationID) {
        this.gCMRegistrationID = gCMRegistrationID;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }
    
}
