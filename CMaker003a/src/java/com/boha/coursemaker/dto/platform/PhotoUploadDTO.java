/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto.platform;

/**
 *
 * @author aubreyM
 */
public class PhotoUploadDTO {
    private long  traineeID, companyID, instructorID, authorID, administratorID;
    private int numberOfImages;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(long traineeID) {
        this.traineeID = traineeID;
    }

    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        this.companyID = companyID;
    }

    public long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(long instructorID) {
        this.instructorID = instructorID;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    public long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(long administratorID) {
        this.administratorID = administratorID;
    }

   

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

   public static final int INSTRUCTOR = 1, TRAINEE = 2, ADMINISTRATOR = 3, AUTHOR = 4;
}
