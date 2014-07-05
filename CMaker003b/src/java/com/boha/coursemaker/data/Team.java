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
@Table(name = "team")
@NamedQueries({
    @NamedQuery(name = "Team.findByCompany",
            query = "select a from Team a "
            + " where a.trainingClass.company.companyID = :id "
            + " order by a.trainingClass.trainingClassName"),
    @NamedQuery(name = "Team.findByNameInClass",
            query = "select a from Team a where a.trainingClass.trainingClassID = :id AND a.teamName = :name"),
    @NamedQuery(name = "Team.findByClass",
            query = "select a from Team a "
            + "where a.trainingClass.trainingClassID = :id")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teamID")
    private int teamID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "teamName")
    private String teamName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @OneToMany(mappedBy = "team")
    private List<DemoAnnouncement> demoAnnouncementList;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false)
    private TrainingClass trainingClass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<TeamMember> teamMemberList;

    public Team() {
    }

    public Team(int teamID) {
        this.teamID = teamID;
    }

    public Team(int teamID, String teamName, Date dateRegistered) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.dateRegistered = dateRegistered;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public List<DemoAnnouncement> getDemoAnnouncementList() {
        return demoAnnouncementList;
    }

    public void setDemoAnnouncementList(List<DemoAnnouncement> demoAnnouncementList) {
        this.demoAnnouncementList = demoAnnouncementList;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }

    public List<TeamMember> getTeamMemberList() {
        return teamMemberList;
    }

    public void setTeamMemberList(List<TeamMember> teamMemberList) {
        this.teamMemberList = teamMemberList;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Team[ teamID=" + teamID + " ]";
    }

}
