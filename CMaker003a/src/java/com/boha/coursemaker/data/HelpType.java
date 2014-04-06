/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpType", fetch = FetchType.EAGER)
    private List<TraineeShout> traineeShoutList;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "helpTypeID")
    private Integer helpTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "helpTypeName")
    private String helpTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpType")
    private List<HelpRequest> helpRequestList;

    public HelpType() {
    }

    public HelpType(Integer helpTypeID) {
        this.helpTypeID = helpTypeID;
    }

    public HelpType(Integer helpTypeID, String helpTypeName) {
        this.helpTypeID = helpTypeID;
        this.helpTypeName = helpTypeName;
    }

    public Integer getHelpTypeID() {
        return helpTypeID;
    }

    public void setHelpTypeID(Integer helpTypeID) {
        this.helpTypeID = helpTypeID;
    }

    public String getHelpTypeName() {
        return helpTypeName;
    }

    public void setHelpTypeName(String helpTypeName) {
        this.helpTypeName = helpTypeName;
    }

    public List<HelpRequest> getHelpRequestList() {
        return helpRequestList;
    }

    public void setHelpRequestList(List<HelpRequest> helpRequestList) {
        this.helpRequestList = helpRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (helpTypeID != null ? helpTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HelpType)) {
            return false;
        }
        HelpType other = (HelpType) object;
        if ((this.helpTypeID == null && other.helpTypeID != null) || (this.helpTypeID != null && !this.helpTypeID.equals(other.helpTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.HelpType[ helpTypeID=" + helpTypeID + " ]";
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<TraineeShout> getTraineeShoutList() {
        return traineeShoutList;
    }

    public void setTraineeShoutList(List<TraineeShout> traineeShoutList) {
        this.traineeShoutList = traineeShoutList;
    }

   
    
}
