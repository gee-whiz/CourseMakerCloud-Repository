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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "errorStore")
@NamedQueries({
    @NamedQuery(name = "ErrorStore.findInPeriod", 
        query = "select a from ErrorStore a "
                    + " where a.dateOccured between :from and :to "
                    + " order by a.dateOccured desc")})
public class ErrorStore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "errorStoreID")
    private Integer errorStoreID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusCode")
    private int statusCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "origin")
    private String origin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOccured")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOccured;

    public ErrorStore() {
    }

    public ErrorStore(Integer errorStoreID) {
        this.errorStoreID = errorStoreID;
    }

    public ErrorStore(Integer errorStoreID, int statusCode, String message, Date dateOccured) {
        this.errorStoreID = errorStoreID;
        this.statusCode = statusCode;
        this.message = message;
        this.dateOccured = dateOccured;
    }

    public Integer getErrorStoreID() {
        return errorStoreID;
    }

    public void setErrorStoreID(Integer errorStoreID) {
        this.errorStoreID = errorStoreID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOccured() {
        return dateOccured;
    }

    public void setDateOccured(Date dateOccured) {
        this.dateOccured = dateOccured;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorStoreID != null ? errorStoreID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorStore)) {
            return false;
        }
        ErrorStore other = (ErrorStore) object;
        if ((this.errorStoreID == null && other.errorStoreID != null) || (this.errorStoreID != null && !this.errorStoreID.equals(other.errorStoreID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.ErrorStore[ errorStoreID=" + errorStoreID + " ]";
    }
    
}
