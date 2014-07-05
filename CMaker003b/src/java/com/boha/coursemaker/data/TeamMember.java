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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "teamMember")
@NamedQueries({
    @NamedQuery(name = "TeamMember.findByCompany",
            query = "select a from TeamMember a, Team b "
            + " where b.trainingClass.company.companyID = :id and a.team.teamID = b.teamID "
            + " order by a.team.teamID"),

    @NamedQuery(name = "TeamMember.findByTeam",
            query = "select a from TeamMember a where a.team.teamID = :id "),

    @NamedQuery(name = "TeamMember.findByClass",
            query = "select a from TeamMember a, Team b "
            + " where b.trainingClass.trainingClassID = :id and a.team.teamID = b.teamID "
            + " order by a.team.teamID")})
public class TeamMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teamMemberID")
    private int teamMemberID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "activeFlag")
    private int activeFlag;
    @JoinColumn(name = "teamID", referencedColumnName = "teamID")
    @ManyToOne(optional = false)
    private Team team;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false)
    private Trainee trainee;

    public TeamMember() {
    }

    public TeamMember(int teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public TeamMember(int teamMemberID, Date dateRegistered) {
        this.teamMemberID = teamMemberID;
        this.dateRegistered = dateRegistered;
    }

    public int getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(int teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.TeamMember[ teamMemberID=" + teamMemberID + " ]";
    }

}
