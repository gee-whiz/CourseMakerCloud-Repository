/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.HelpRequest;
import com.boha.coursemaker.data.Trainee;

/**
 *
 * @author aubreyM
 */
public class HelpRequestDTO {

    private int helpRequestID;
    private long dateRequested;
    private String comment;
    private CourseTraineeActivityDTO courseTraineeActivity;
    private HelpTypeDTO helpType;

    public HelpRequestDTO(HelpRequest a) {
        helpRequestID = a.getHelpRequestID();
        dateRequested = a.getDateRequested().getTime();
        comment = a.getComment();
        helpType = new HelpTypeDTO(a.getHelpType());
        
        if (a.getCourseTraineeActivity() != null) {
            courseTraineeActivity = new CourseTraineeActivityDTO();
            courseTraineeActivity.setCourseID(a.getCourseTraineeActivity().getCourseTrainee().getTrainingClassCourse().getCourse().getCourseID());
            courseTraineeActivity.setCompletedFlag(a.getCourseTraineeActivity().getCompletedFlag());
            courseTraineeActivity.setCourseName(a.getCourseTraineeActivity().getCourseTrainee().getTrainingClassCourse().getCourse().getCourseName());
            Trainee t = a.getCourseTraineeActivity().getCourseTrainee().getTrainee();
            courseTraineeActivity.setTraineeID(t.getTraineeID());
            courseTraineeActivity.setTraineeName(t.getFirstName() + " " + t.getLastName());
            courseTraineeActivity.setActivity(new ActivityDTO(a.getCourseTraineeActivity().getActivity()));

            if (a.getCourseTraineeActivity().getCompletionDate() != null) {
                courseTraineeActivity.setCompletionDate(a.getCourseTraineeActivity().getCompletionDate().getTime());
            }
            if (a.getCourseTraineeActivity().getRating() != null) {
                courseTraineeActivity.setRating(new RatingDTO(a.getCourseTraineeActivity().getRating()));
            }

        }
    }

    public int getHelpRequestID() {
        return helpRequestID;
    }

    public void setHelpRequestID(int helpRequestID) {
        this.helpRequestID = helpRequestID;
    }

    public long getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(long dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CourseTraineeActivityDTO getCourseTraineeActivity() {
        return courseTraineeActivity;
    }

    public void setCourseTraineeActivity(CourseTraineeActivityDTO courseTraineeActivity) {
        this.courseTraineeActivity = courseTraineeActivity;
    }

    public HelpTypeDTO getHelpType() {
        return helpType;
    }

    public void setHelpType(HelpTypeDTO helpType) {
        this.helpType = helpType;
    }
}
