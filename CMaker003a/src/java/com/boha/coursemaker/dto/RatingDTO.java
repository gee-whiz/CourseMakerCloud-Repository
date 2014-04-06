/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Rating;

/**
 *
 * @author aubreyM
 */
public class RatingDTO {
    private Integer ratingID;
    private String ratingName;
    private Integer ratingNumber, companyID;
    
    public RatingDTO(Rating a) {
        ratingID = a.getRatingID();
        ratingName = a.getRatingName();
        ratingNumber = a.getRatingNumber();
        companyID = a.getCompany().getCompanyID();
    }

    public Integer getRatingID() {
        return ratingID;
    }

    public void setRatingID(Integer ratingID) {
        this.ratingID = ratingID;
    }

    public String getRatingName() {
        return ratingName;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public Integer getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(Integer ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
}
