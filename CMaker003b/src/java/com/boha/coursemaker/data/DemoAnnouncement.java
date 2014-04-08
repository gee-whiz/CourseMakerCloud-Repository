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
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "demoAnnouncement")
@NamedQueries({
    @NamedQuery(name = "DemoAnnouncement.findByCompany", 
        query = "select a from DemoAnnouncement a "
                    + " where a.trainingClass.company.companyID = :id "
                    + " order by a.demoDate desc"),
    
    @NamedQuery(name = "DemoAnnouncement.findByTrainee", 
        query = "select a from DemoAnnouncement a where a.trainee.traineeID = :id "
                    + " order by a.demoDate desc"),
    
    @NamedQuery(name = "DemoAnnouncement.findByTeam", 
        query = "select a from DemoAnnouncement a where a.team.teamID = :id "
                    + " order by a.demoDate desc"),

@NamedQuery(name = "DemoAnnouncement.findByClass", 
        query = "select a from DemoAnnouncement a "
                    + " where a.trainingClass.trainingClassID = :id "
                    + " order by a.demoDate desc")
})
public class DemoAnnouncement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "demoAnnouncementID")
    private Integer demoAnnouncementID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "demoDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demoDate;
     @JoinColumn(name = "teamID", referencedColumnName = "teamID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRequested")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRequested;
    
    @Basic(optional = true)
    @Column(name = "cancellationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancellationDate;
    
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Trainee trainee;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TrainingClass trainingClass;

    public DemoAnnouncement() {
    }

    public DemoAnnouncement(Integer demoAnnouncementID) {
        this.demoAnnouncementID = demoAnnouncementID;
    }

    public DemoAnnouncement(Integer demoAnnouncementID, Date demoDate, Date dateRequested, String description) {
        this.demoAnnouncementID = demoAnnouncementID;
        this.demoDate = demoDate;
        this.dateRequested = dateRequested;
        this.description = description;
    }

    public Integer getDemoAnnouncementID() {
        return demoAnnouncementID;
    }

    public void setDemoAnnouncementID(Integer demoAnnouncementID) {
        this.demoAnnouncementID = demoAnnouncementID;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public Date getDemoDate() {
        return demoDate;
    }

    public void setDemoDate(Date demoDate) {
        this.demoDate = demoDate;
    }

    

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demoAnnouncementID != null ? demoAnnouncementID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemoAnnouncement)) {
            return false;
        }
        DemoAnnouncement other = (DemoAnnouncement) object;
        if ((this.demoAnnouncementID == null && other.demoAnnouncementID != null) || (this.demoAnnouncementID != null && !this.demoAnnouncementID.equals(other.demoAnnouncementID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.DemoAnnouncement[ demoAnnouncementID=" + demoAnnouncementID + " ]";
    }
    
}
