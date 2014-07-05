/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "helpResponse")
@NamedQueries({
    @NamedQuery(name = "HelpResponse.findAll", query = "SELECT h FROM HelpResponse h"),
    @NamedQuery(name = "HelpResponse.findByHelpResponseID", query = "SELECT h FROM HelpResponse h WHERE h.helpResponseID = :helpResponseID"),
    @NamedQuery(name = "HelpResponse.findByDateResponse", query = "SELECT h FROM HelpResponse h WHERE h.dateResponse = :dateResponse"),
    @NamedQuery(name = "HelpResponse.findByScheduleMeeting", query = "SELECT h FROM HelpResponse h WHERE h.scheduleMeeting = :scheduleMeeting"),
    @NamedQuery(name = "HelpResponse.findByProblemSorted", query = "SELECT h FROM HelpResponse h WHERE h.problemSorted = :problemSorted"),
    @NamedQuery(name = "HelpResponse.findByMeetingDate", query = "SELECT h FROM HelpResponse h WHERE h.meetingDate = :meetingDate")})
public class HelpResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "helpResponseID")
    private int helpResponseID;
    @Lob
    @Size(max = 65535)
    @Column(name = "message")
    private String message;
    @Column(name = "dateResponse")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateResponse;
    @Column(name = "scheduleMeeting")
    private int scheduleMeeting;
    @Column(name = "problemSorted")
    private int problemSorted;
    @Column(name = "meetingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date meetingDate;
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "helpRequestID", referencedColumnName = "helpRequestID")
    @ManyToOne(optional = false)
    private HelpRequest helpRequest;

    public HelpResponse() {
    }

    public HelpResponse(int helpResponseID) {
        this.helpResponseID = helpResponseID;
    }

    public int getHelpResponseID() {
        return helpResponseID;
    }

    public void setHelpResponseID(int helpResponseID) {
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

    public int getScheduleMeeting() {
        return scheduleMeeting;
    }

    public void setScheduleMeeting(int scheduleMeeting) {
        this.scheduleMeeting = scheduleMeeting;
    }

    public int getProblemSorted() {
        return problemSorted;
    }

    public void setProblemSorted(int problemSorted) {
        this.problemSorted = problemSorted;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public HelpRequest getHelpRequest() {
        return helpRequest;
    }

    public void setHelpRequest(HelpRequest helpRequest) {
        this.helpRequest = helpRequest;
    }

  

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.HelpResponse[ helpResponseID=" + helpResponseID + " ]";
    }
    
}
