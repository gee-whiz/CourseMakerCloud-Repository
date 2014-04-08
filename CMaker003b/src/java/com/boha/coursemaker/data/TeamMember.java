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
import javax.persistence.FetchType;
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
    private Integer teamMemberID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "activeFlag")
    private Integer activeFlag;
    @JoinColumn(name = "teamID", referencedColumnName = "teamID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Team team;
    @JoinColumn(name = "traineeID", referencedColumnName = "traineeID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Trainee trainee;

    public TeamMember() {
    }

    public TeamMember(Integer teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public TeamMember(Integer teamMemberID, Date dateRegistered) {
        this.teamMemberID = teamMemberID;
        this.dateRegistered = dateRegistered;
    }

    public Integer getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(Integer teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamMemberID != null ? teamMemberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMember)) {
            return false;
        }
        TeamMember other = (TeamMember) object;
        if ((this.teamMemberID == null && other.teamMemberID != null) || (this.teamMemberID != null && !this.teamMemberID.equals(other.teamMemberID))) {
            return false;
        }
        return true;
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
