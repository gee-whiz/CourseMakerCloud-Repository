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
@Table(name = "skillLevel")
@NamedQueries({
    @NamedQuery(name = "SkillLevel.findByCompany", 
            query = "SELECT s FROM SkillLevel s "
                    + "where s.company.companyID = :id order by s.level")
    })
public class SkillLevel implements Serializable {
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skillLevelID")
    private Integer skillLevelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "skillLevelName")
    private String skillLevelName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillLevel")
    private List<TraineeSkill> traineeSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillLevel")
    private List<TraineeSkillHistory> traineeSkillHistoryList;

    
    public SkillLevel() {
    }

    public SkillLevel(Integer skillLevelID) {
        this.skillLevelID = skillLevelID;
    }

    public SkillLevel(Integer skillLevelID, String skillLevelName, int level) {
        this.skillLevelID = skillLevelID;
        this.skillLevelName = skillLevelName;
        this.level = level;
    }

    public List<TraineeSkillHistory> getTraineeSkillHistoryList() {
        return traineeSkillHistoryList;
    }

    public void setTraineeSkillHistoryList(List<TraineeSkillHistory> traineeSkillHistoryList) {
        this.traineeSkillHistoryList = traineeSkillHistoryList;
    }

    public Integer getSkillLevelID() {
        return skillLevelID;
    }

    public void setSkillLevelID(Integer skillLevelID) {
        this.skillLevelID = skillLevelID;
    }

    public String getSkillLevelName() {
        return skillLevelName;
    }

    public void setSkillLevelName(String skillLevelName) {
        this.skillLevelName = skillLevelName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<TraineeSkill> getTraineeSkillList() {
        return traineeSkillList;
    }

    public void setTraineeSkillList(List<TraineeSkill> traineeSkillList) {
        this.traineeSkillList = traineeSkillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillLevelID != null ? skillLevelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillLevel)) {
            return false;
        }
        SkillLevel other = (SkillLevel) object;
        if ((this.skillLevelID == null && other.skillLevelID != null) || (this.skillLevelID != null && !this.skillLevelID.equals(other.skillLevelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.SkillLevel[ skillLevelID=" + skillLevelID + " ]";
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
