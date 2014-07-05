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
    private int ratingID;
    private String ratingName;
    private int ratingNumber, companyID;
    
    public RatingDTO(Rating a) {
        ratingID = a.getRatingID();
        ratingName = a.getRatingName();
        ratingNumber = a.getRatingNumber();
        companyID = a.getCompany().getCompanyID();
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public String getRatingName() {
        return ratingName;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
}
