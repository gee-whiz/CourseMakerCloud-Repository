/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "objective")
@NamedQueries({
    @NamedQuery(name = "Objective.findByCourse", 
        query = "select a from Objective a where "
                    + " a.course.courseID = :id "),
    @NamedQuery(name = "Objective.findByLesson", 
        query = "select a from Objective a where "
                    + " a.course.courseID = :id "),
    
@NamedQuery(name = "Objective.findByCompany", 
        query = "select a from Objective a"
                + " where a.course.company.companyID = :id ")})
public class Objective implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "objectiveID")
    private int objectiveID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "objectiveName")
    private String objectiveName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course course;

    public Objective() {
    }

    public Objective(int objectiveID) {
        this.objectiveID = objectiveID;
    }

    public Objective(int objectiveID, String objectiveName, String description) {
        this.objectiveID = objectiveID;
        this.objectiveName = objectiveName;
        this.description = description;
    }

    public int getObjectiveID() {
        return objectiveID;
    }

    public void setObjectiveID(int objectiveID) {
        this.objectiveID = objectiveID;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

   

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Objective[ objectiveID=" + objectiveID + " ]";
    }
    
}
