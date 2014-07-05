/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Institution;

/**
 *
 * @author aubreyM
 */
public class InstitutionDTO {
     private int institutionID;
   
    private String institutionName;
    private CityDTO city;
    
    public InstitutionDTO(Institution a) {
        institutionID = a.getInstitutionID();
        institutionName = a.getInstitutionName();
        if (a.getCity() != null) {
            city = new CityDTO(a.getCity());
        }
    }

    public int getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(int institutionID) {
        this.institutionID = institutionID;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
