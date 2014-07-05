/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.data.LessonSchedule;

/**
 *
 * @author aubreyM
 */
public class LessonScheduleDTO {
 private int lessonScheduleID;
    
    private long scheduleDate;
    
    private long endDate;
    
    private int activityID;
    
    private int trainingClassID;   
    
    public LessonScheduleDTO(LessonSchedule a) {
        lessonScheduleID = a.getLessonScheduleID();
        activityID = a.getActivity().getActivityID();
        trainingClassID = a.getTrainingClass().getTrainingClassID();
        if (a.getScheduleDate() != null) {
            scheduleDate = a.getScheduleDate().getTime();
        }
        if (a.getEndDate()!= null) {
            endDate = a.getEndDate().getTime();
        }
    }

    public int getLessonScheduleID() {
        return lessonScheduleID;
    }

    public void setLessonScheduleID(int lessonScheduleID) {
        this.lessonScheduleID = lessonScheduleID;
    }

    public long getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(long scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(int trainingClassID) {
        this.trainingClassID = trainingClassID;
    }
}
