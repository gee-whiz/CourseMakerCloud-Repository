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
    private int skillID;
    private String skillName;
    public SkillDTO(Skill a) {
        skillID = a.getSkillID();
        skillName = a.getSkillName();
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
