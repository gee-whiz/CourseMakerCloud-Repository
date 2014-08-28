/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.SkillLevel;

/**
 *
 * @author aubreyM
 */
public class SkillLevelDTO {
    private int skillLevelID, level, companyID;
    private String skillLevelName;
    public SkillLevelDTO(SkillLevel a) {
        skillLevelID = a.getSkillLevelID();
        skillLevelName = a.getSkillLevelName();
        level = a.getLevel();
        companyID = a.getCompany().getCompanyID();
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getSkillLevelID() {
        return skillLevelID;
    }

    public void setSkillLevelID(int skillLevelID) {
        this.skillLevelID = skillLevelID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkillLevelName() {
        return skillLevelName;
    }

    public void setSkillLevelName(String skillLevelName) {
        this.skillLevelName = skillLevelName;
    }
    
}
