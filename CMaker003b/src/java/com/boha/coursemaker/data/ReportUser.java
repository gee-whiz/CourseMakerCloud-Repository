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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "reportUser")
@NamedQueries({
    @NamedQuery(name = "ReportUser.findAll", query = "SELECT r FROM ReportUser r"),
    @NamedQuery(name = "ReportUser.findByReportUserID", query = "SELECT r FROM ReportUser r WHERE r.reportUserID = :reportUserID"),
    @NamedQuery(name = "ReportUser.findByFirstName", query = "SELECT r FROM ReportUser r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "ReportUser.findByLastName", query = "SELECT r FROM ReportUser r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "ReportUser.findByEmail", query = "SELECT r FROM ReportUser r WHERE r.email = :email"),
    @NamedQuery(name = "ReportUser.findByCellphone", query = "SELECT r FROM ReportUser r WHERE r.cellphone = :cellphone"),
    @NamedQuery(name = "ReportUser.findByDateRegistered", query = "SELECT r FROM ReportUser r WHERE r.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "ReportUser.findByPassword", query = "SELECT r FROM ReportUser r WHERE r.password = :password")})
public class ReportUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reportUserID")
    private int reportUserID;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
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
    @Lob
    @Size(max = 65535)
    @Column(name = "GCMRegistrationID")
    private String gCMRegistrationID;
    @OneToMany(mappedBy = "reportUser")
    private List<GcmDevice> gcmDeviceList;

    public ReportUser() {
    }

    public ReportUser(int reportUserID) {
        this.reportUserID = reportUserID;
    }

    public int getReportUserID() {
        return reportUserID;
    }

    public void setReportUserID(int reportUserID) {
        this.reportUserID = reportUserID;
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

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.ReportUser[ reportUserID=" + reportUserID + " ]";
    }
    
}
