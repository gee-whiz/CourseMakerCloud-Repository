/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Country;
import com.boha.coursemaker.data.Province;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aubreyM
 */
public class CountryDTO {

    private Integer countryID;
    private String countryName, countryCode;
    private Double latitude;
    private Double longitude;
    private List<ProvinceDTO> provinceList;

    public CountryDTO(Country a) {
        countryID = a.getCountryID();
        countryName = a.getCountryName();
        countryCode = a.getCountryCode();
        try {
        List<Province> list = a.getProvinceList();
        if (list != null) {
            provinceList = new ArrayList<>();
            for (Province p : list) {
                provinceList.add(new ProvinceDTO(p));
                
            }
        }
        } catch (Exception e) {
           Logger.getLogger("countryDTO")
              .log(Level.WARNING, "---- F..K! - Weird shit happenin here!", e); 
        }
        latitude = a.getLatitude();
        longitude = a.getLongitude();
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }
}
