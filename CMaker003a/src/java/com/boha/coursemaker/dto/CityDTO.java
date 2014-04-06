/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.City;

/**
 *
 * @author aubreyM
 */
public class CityDTO {
    private Integer cityID, provinceID;  
    private String cityName; 
    private Double latitude;
    private Double longitude;
    
    public CityDTO (City a) {
        cityID = a.getCityID();
        provinceID = a.getProvince().getProvinceID();
        cityName = a.getCityName();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
