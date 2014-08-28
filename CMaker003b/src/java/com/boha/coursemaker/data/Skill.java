/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "skill")
@NamedQueries({
    @NamedQuery(name = "Skill.findByCompany", 
            query = "SELECT s FROM Skill s "
                    + "where s.company.companyID = :id order by s.skillName")
    })
public class Skill implements Serializable {
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skillID")
    private int skillID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "skillName")
    private String skillName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private List<TraineeSkill> traineeSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private List<TraineeSkillHistory> traineeSkillHistoryList;

    public Skill() {
    }

    public Skill(int skillID) {
        this.skillID = skillID;
    }

    public Skill(int skillID, String skillName) {
        this.skillID = skillID;
        this.skillName = skillName;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public List<TraineeSkillHistory> getTraineeSkillHistoryList() {
        return traineeSkillHistoryList;
    }

    public void setTraineeSkillHistoryList(List<TraineeSkillHistory> traineeSkillHistoryList) {
        this.traineeSkillHistoryList = traineeSkillHistoryList;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<TraineeSkill> getTraineeSkillList() {
        return traineeSkillList;
    }

    public void setTraineeSkillList(List<TraineeSkill> traineeSkillList) {
        this.traineeSkillList = traineeSkillList;
    }

 

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Skill[ skillID=" + skillID + " ]";
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
