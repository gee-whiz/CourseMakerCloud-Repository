/*
 * To change this template, choose Tools | Templates
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
@Table(name = "helpResponse")
@NamedQueries({
    @NamedQuery(name = "HelpResponse.findAll", query = "SELECT h FROM HelpResponse h")})
public class HelpResponse implements Serializable {
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne(optional = false)
    private Instructor instructor;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "helpResponseID")
    private Integer helpResponseID;
    @Size(max = 255)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateResponse")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateResponse;
    @Column(name = "scheduleMeeting")
    private Integer scheduleMeeting;
    @Column(name = "problemSorted")
    private Integer problemSorted;
    @Column(name = "meetingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date meetingDate;
    @JoinColumn(name = "helpRequestID", referencedColumnName = "helpRequestID")
    @ManyToOne(optional = false)
    private HelpRequest helpRequest;

    public HelpResponse() {
    }

    public HelpResponse(Integer helpResponseID) {
        this.helpResponseID = helpResponseID;
    }

    public HelpRequest getHelpRequest() {
        return helpRequest;
    }

    public void setHelpRequest(HelpRequest helpRequest) {
        this.helpRequest = helpRequest;
    }

    public HelpResponse(Integer helpResponseID, Date dateResponse) {
        this.helpResponseID = helpResponseID;
        this.dateResponse = dateResponse;
    }

    public Integer getHelpResponseID() {
        return helpResponseID;
    }

    public void setHelpResponseID(Integer helpResponseID) {
        this.helpResponseID = helpResponseID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(Date dateResponse) {
        this.dateResponse = dateResponse;
    }

    public Integer getScheduleMeeting() {
        return scheduleMeeting;
    }

    public void setScheduleMeeting(Integer scheduleMeeting) {
        this.scheduleMeeting = scheduleMeeting;
    }

    public Integer getProblemSorted() {
        return problemSorted;
    }

    public void setProblemSorted(Integer problemSorted) {
        this.problemSorted = problemSorted;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (helpResponseID != null ? helpResponseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HelpResponse)) {
            return false;
        }
        HelpResponse other = (HelpResponse) object;
        if ((this.helpResponseID == null && other.helpResponseID != null) || (this.helpResponseID != null && !this.helpResponseID.equals(other.helpResponseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.HelpResponse[ helpResponseID=" + helpResponseID + " ]";
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

   
    
}
