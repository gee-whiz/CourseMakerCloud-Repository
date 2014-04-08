/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.HelpType;

/**
 *
 * @author aubreyM
 */
public class HelpTypeDTO {
   private Integer helpTypeID, companyID;
   private String helpTypeName;
   
   public HelpTypeDTO(HelpType a) {
       helpTypeID = a.getHelpTypeID();
       helpTypeName = a.getHelpTypeName();
       companyID = a.getCompany().getCompanyID();
   }

    public Integer getHelpTypeID() {
        return helpTypeID;
    }

    public void setHelpTypeID(Integer helpTypeID) {
        this.helpTypeID = helpTypeID;
    }

    public String getHelpTypeName() {
        return helpTypeName;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public void setHelpTypeName(String helpTypeName) {
        this.helpTypeName = helpTypeName;
    }
}
