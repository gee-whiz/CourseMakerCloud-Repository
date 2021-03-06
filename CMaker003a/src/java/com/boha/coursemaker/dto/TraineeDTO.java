/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Trainee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class TraineeDTO {

    private Integer traineeID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String cellphone;
    private long dateRegistered, dateUpdated;
    private Integer gender, activeFlag;
    private String iDNumber;
    private String address, password;
    private Integer cityID;
    private Integer companyID;
    private Integer trainingClassID;
    private String trainingClassName, cityName, provinceName;
    private List<GcmDeviceDTO> gcmDeviceList;
    private Integer institutionID, provinceID;
    private int totalTasks, totalCompleted;
    private double percComplete, averageInstructorRating, averageTraineeRating;
    private long lastDate;

    public TraineeDTO() {
    }

    public TraineeDTO(Trainee a) {
        traineeID = a.getTraineeID();
        companyID = a.getCompany().getCompanyID();
        firstName = a.getFirstName();
        middleName = a.getMiddleName();
        lastName = a.getLastName();
        email = a.getEmail();
        activeFlag = a.getActiveFlag();
        password = a.getPassword();
        cellphone = a.getCellphone();
        address = a.getAddress();
        dateRegistered = a.getDateRegistered().getTime();
        if (a.getDateUpdated() != null) {
            dateUpdated = a.getDateUpdated().getTime();
        }
        gender = a.getGender();
        iDNumber = a.getIDNumber();
        if (a.getCity() != null) {
            cityID = a.getCity().getCityID();
            cityName = a.getCity().getCityName();
            provinceID = a.getCity().getProvince().getProvinceID();
            provinceName = a.getCity().getProvince().getProvinceName();
        }
        if (a.getInstitution() != null) {
            institutionID = a.getInstitution().getInstitutionID();
        }
        if (a.getTrainingClass() != null) {
            trainingClassID = a.getTrainingClass().getTrainingClassID();
            trainingClassName = a.getTrainingClass().getTrainingClassName();
        }

        gcmDeviceList = new ArrayList<>();
      
    }

    class Dates implements Comparable<Dates> {

        long date;

        public Dates(long date) {
            this.date = date;
        }

        @Override
        public int compareTo(Dates t) {
            if (date > t.date) {
                return 1;
            }
            if (date < t.date) {
                return -1;
            }
            return 0;
        }
    }

    public String getProvinceName() {
        return provinceName;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

   

    public int getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(int totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public double getAverageInstructorRating() {
        return averageInstructorRating;
    }

    public void setAverageInstructorRating(double averageInstructorRating) {
        this.averageInstructorRating = averageInstructorRating;
    }

    public double getAverageTraineeRating() {
        return averageTraineeRating;
    }

    public void setAverageTraineeRating(double averageTraineeRating) {
        this.averageTraineeRating = averageTraineeRating;
    }

    public double getPercComplete() {
        return percComplete;
    }

    public void setPercComplete(double percComplete) {
        this.percComplete = percComplete;
    }

    public long getLastDate() {
        return lastDate;
    }

    public void setLastDate(long lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }

    public String getTrainingClassName() {
        return trainingClassName;
    }

    public List<GcmDeviceDTO> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public void setTrainingClassName(String trainingClassName) {
        this.trainingClassName = trainingClassName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer trainingCompanyID) {
        this.companyID = trainingCompanyID;
    }

    public Integer getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Integer institutionID) {
        this.institutionID = institutionID;
    }
}
