/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.HelpResponse;

/**
 *
 * @author aubreyM
 */
public class HelpResponseDTO {

    private int helpResponseID;
    private String message;
    private long dateResponse;
    private int scheduleMeeting;
    private int problemSorted, instructorID;
    private long meetingDate;
    private HelpRequestDTO helpRequest;

    public HelpResponseDTO(HelpResponse a) {
        helpResponseID = a.getHelpResponseID();
        message = a.getMessage();
        if (a.getInstructor() != null) {
            instructorID = a.getInstructor().getInstructorID();
        }
        if (a.getMeetingDate() != null) {
            meetingDate = a.getMeetingDate().getTime();
        }
        if (a.getHelpRequest() != null) {
            helpRequest = new HelpRequestDTO(a.getHelpRequest());
        }
        if (a.getDateResponse() != null) {
            dateResponse = a.getDateResponse().getTime();
        }
        scheduleMeeting = a.getScheduleMeeting();
        problemSorted = a.getProblemSorted();
    }

    public int getHelpResponseID() {
        return helpResponseID;
    }

    public void setHelpResponseID(int helpResponseID) {
        this.helpResponseID = helpResponseID;
    }

    public String getMessage() {
        return message;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(long dateResponse) {
        this.dateResponse = dateResponse;
    }

    public int getScheduleMeeting() {
        return scheduleMeeting;
    }

    public void setScheduleMeeting(int scheduleMeeting) {
        this.scheduleMeeting = scheduleMeeting;
    }

    public int getProblemSorted() {
        return problemSorted;
    }

    public void setProblemSorted(int problemSorted) {
        this.problemSorted = problemSorted;
    }

    public long getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(long meetingDate) {
        this.meetingDate = meetingDate;
    }

    public HelpRequestDTO getHelpRequest() {
        return helpRequest;
    }

    public void setHelpRequest(HelpRequestDTO helpRequest) {
        this.helpRequest = helpRequest;
    }
}
