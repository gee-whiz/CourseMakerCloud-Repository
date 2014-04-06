/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "instructorClass")
@NamedQueries({
    @NamedQuery(name = "InstructorClass.findByInstructorID", 
        query = "select a from InstructorClass a "
                + " where a.instructor.instructorID = :id "
                + " and (a.trainingClass.isOpen = 1 or a.trainingClass.isOpen is null) "),
@NamedQuery(name = "InstructorClass.findByCompany", 
        query = "select distinct a from InstructorClass a "
                    + " where a.instructor.company.companyID = :id "
                    + " and (a.trainingClass.isOpen = 1 or a.trainingClass.isOpen is null)"
                    + " order by a.instructor.instructorID ")})
public class InstructorClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instructorClassID")
    private Integer instructorClassID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "instructorID", referencedColumnName = "instructorID")
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "trainingClassID", referencedColumnName = "trainingClassID")
    @ManyToOne(optional = false)
    private TrainingClass trainingClass;

    public InstructorClass() {
    }

    public InstructorClass(Integer instructorClassID) {
        this.instructorClassID = instructorClassID;
    }

    public InstructorClass(Integer instructorClassID, Date dateRegistered) {
        this.instructorClassID = instructorClassID;
        this.dateRegistered = dateRegistered;
    }

    public Integer getInstructorClassID() {
        return instructorClassID;
    }

    public void setInstructorClassID(Integer instructorClassID) {
        this.instructorClassID = instructorClassID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public TrainingClass getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(TrainingClass trainingClass) {
        this.trainingClass = trainingClass;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorClassID != null ? instructorClassID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorClass)) {
            return false;
        }
        InstructorClass other = (InstructorClass) object;
        if ((this.instructorClassID == null && other.instructorClassID != null) || (this.instructorClassID != null && !this.instructorClassID.equals(other.instructorClassID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.InstructorClass[ instructorClassID=" + instructorClassID + " ]";
    }
    
}
