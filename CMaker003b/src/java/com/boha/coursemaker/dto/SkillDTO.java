/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Skill;

/**
 *
 * @author aubreyM
 */
public class SkillDTO {
    private int skillID, companyID;
    private String skillName;
    public SkillDTO(Skill a) {
        skillID = a.getSkillID();
        skillName = a.getSkillName();
        companyID = a.getCompany().getCompanyID();
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
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

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    
}
