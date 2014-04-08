/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.Course;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class CourseDTO {

    private Integer courseID, activeFlag, shareFlag;
    private long dateUpdated;
    private String courseName, description;
    private Integer categoryID;
    private String categoryName;
    private Integer companyID;
    private BigInteger localID;
    private long syncDate;
    private List<LessonDTO> lessonList;
    private List<ObjectiveDTO> objectiveList;

    public CourseDTO(Course a) {
        courseID = a.getCourseID();
        dateUpdated = a.getDateUpdated().getTime();
        activeFlag = a.getActiveFlag();
        courseName = a.getCourseName();
        description = a.getDescription();
        activeFlag = a.getActiveFlag();
        categoryID = a.getCategory().getCategoryID();
        categoryName = a.getCategory().getCategoryName();
        companyID = a.getCompany().getCompanyID();
        
       

    }

    public CourseDTO() {
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public BigInteger getLocalID() {
        return localID;
    }

    public List<ObjectiveDTO> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(List<ObjectiveDTO> objectiveList) {
        this.objectiveList = objectiveList;
    }

    public void setLocalID(BigInteger localID) {
        this.localID = localID;
    }

    public long getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(long syncDate) {
        this.syncDate = syncDate;
    }

    public List<LessonDTO> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<LessonDTO> lessonList) {
        this.lessonList = lessonList;
    }

    public Integer getShareFlag() {
        return shareFlag;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setShareFlag(Integer shareFlag) {
        this.shareFlag = shareFlag;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }
}
