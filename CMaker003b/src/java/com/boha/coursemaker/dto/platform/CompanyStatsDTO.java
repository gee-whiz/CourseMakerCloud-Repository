
package com.boha.coursemaker.dto.platform;

/**
 *
 * @author aubreyM
 */
public class CompanyStatsDTO {

    private Integer companyID;
    private String companyName;
    private long dateRegistered;
    private int numberOfAdmins, numberOfAuthors, numberOfInstructors, numberOfClasses, nunmberOfActiveClasses,
            numberOfCategories, numberOfCourses, numberOfLessons, numberOfActivities,
            numberOfObjectives,
            numberOfResourceLinks, numberOfTrainees, numberOfActiveTrainees, numberOfTraineeRatings,
            numberOfInstructorRatings, numberOfCourseTraineeActivities, numberOfTrainingClassCourses;

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfObjectives() {
        return numberOfObjectives;
    }

    public void setNumberOfObjectives(int numberOfObjectives) {
        this.numberOfObjectives = numberOfObjectives;
    }

    public int getNumberOfAuthors() {
        return numberOfAuthors;
    }

    public void setNumberOfAuthors(int numberOfAuthors) {
        this.numberOfAuthors = numberOfAuthors;
    }

    public int getNumberOfTraineeRatings() {
        return numberOfTraineeRatings;
    }

    public void setNumberOfTraineeRatings(int numberOfTraineeRatings) {
        this.numberOfTraineeRatings = numberOfTraineeRatings;
    }

    public int getNumberOfInstructorRatings() {
        return numberOfInstructorRatings;
    }

    public void setNumberOfInstructorRatings(int numberOfInstructorRatings) {
        this.numberOfInstructorRatings = numberOfInstructorRatings;
    }

    public int getNumberOfCourseTraineeActivities() {
        return numberOfCourseTraineeActivities;
    }

    public void setNumberOfCourseTraineeActivities(int numberOfCourseTraineeActivities) {
        this.numberOfCourseTraineeActivities = numberOfCourseTraineeActivities;
    }

    public int getNumberOfTrainingClassCourses() {
        return numberOfTrainingClassCourses;
    }

    public void setNumberOfTrainingClassCourses(int numberOfTrainingClassCourses) {
        this.numberOfTrainingClassCourses = numberOfTrainingClassCourses;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public int getNumberOfAdmins() {
        return numberOfAdmins;
    }

    public void setNumberOfAdmins(int numberOfAdmins) {
        this.numberOfAdmins = numberOfAdmins;
    }

    public int getNumberOfInstructors() {
        return numberOfInstructors;
    }

    public void setNumberOfInstructors(int numberOfInstructors) {
        this.numberOfInstructors = numberOfInstructors;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public int getNunmberOfActiveClasses() {
        return nunmberOfActiveClasses;
    }

    public void setNunmberOfActiveClasses(int nunmberOfActiveClasses) {
        this.nunmberOfActiveClasses = nunmberOfActiveClasses;
    }

    public int getNumberOfCategories() {
        return numberOfCategories;
    }

    public void setNumberOfCategories(int numberOfCategories) {
        this.numberOfCategories = numberOfCategories;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }

    public int getNumberOfActivities() {
        return numberOfActivities;
    }

    public void setNumberOfActivities(int numberOfActivities) {
        this.numberOfActivities = numberOfActivities;
    }

    public int getNumberOfResourceLinks() {
        return numberOfResourceLinks;
    }

    public void setNumberOfResourceLinks(int numberOfResourceLinks) {
        this.numberOfResourceLinks = numberOfResourceLinks;
    }

    public int getNumberOfTrainees() {
        return numberOfTrainees;
    }

    public void setNumberOfTrainees(int numberOfTrainees) {
        this.numberOfTrainees = numberOfTrainees;
    }

    public int getNumberOfActiveTrainees() {
        return numberOfActiveTrainees;
    }

    public void setNumberOfActiveTrainees(int numberOfActiveTrainees) {
        this.numberOfActiveTrainees = numberOfActiveTrainees;
    }
}
