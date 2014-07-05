/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "helpType")
@NamedQueries({
    @NamedQuery(name = "HelpType.findByCompany", 
        query = "select a from HelpType a where a.company.companyID = :id"
                    + " order by a.helpTypeName"),
    })
public class HelpType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "helpTypeID")
    private int helpTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "helpTypeName")
    private String helpTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpType")
    private List<TraineeShout> traineeShoutList;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpType")
    private List<HelpRequest> helpRequestList;

    public HelpType() {
    }

    public HelpType(int helpTypeID) {
        this.helpTypeID = helpTypeID;
    }

    public HelpType(int helpTypeID, String helpTypeName) {
        this.helpTypeID = helpTypeID;
        this.helpTypeName = helpTypeName;
    }

    public int getHelpTypeID() {
        return helpTypeID;
    }

    public void setHelpTypeID(int helpTypeID) {
        this.helpTypeID = helpTypeID;
    }

    public String getHelpTypeName() {
        return helpTypeName;
    }

    public void setHelpTypeName(String helpTypeName) {
        this.helpTypeName = helpTypeName;
    }

    public List<TraineeShout> getTraineeShoutList() {
        return traineeShoutList;
    }

    public void setTraineeShoutList(List<TraineeShout> traineeShoutList) {
        this.traineeShoutList = traineeShoutList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<HelpRequest> getHelpRequestList() {
        return helpRequestList;
    }

    public void setHelpRequestList(List<HelpRequest> helpRequestList) {
        this.helpRequestList = helpRequestList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.HelpType[ helpTypeID=" + helpTypeID + " ]";
    }
    
}
