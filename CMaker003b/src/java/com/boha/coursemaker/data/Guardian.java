/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "guardian")
@NamedQueries({
    @NamedQuery(name = "Guardian.findAll", query = "SELECT g FROM Guardian g"),
    @NamedQuery(name = "Guardian.findByGuardianID", query = "SELECT g FROM Guardian g WHERE g.guardianID = :guardianID"),
    @NamedQuery(name = "Guardian.findByName", query = "SELECT g FROM Guardian g WHERE g.name = :name"),
    @NamedQuery(name = "Guardian.findByLastName", query = "SELECT g FROM Guardian g WHERE g.lastName = :lastName"),
    @NamedQuery(name = "Guardian.findByEmail", query = "SELECT g FROM Guardian g WHERE g.email = :email"),
    @NamedQuery(name = "Guardian.findByCellphone", query = "SELECT g FROM Guardian g WHERE g.cellphone = :cellphone"),
    @NamedQuery(name = "Guardian.findByDateRegistered", query = "SELECT g FROM Guardian g WHERE g.dateRegistered = :dateRegistered")})
public class Guardian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "guardianID")
    private int guardianID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "lastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cellphone")
    private String cellphone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guardian")
    private List<GuardianTrainee> guardianTraineeList;

    public Guardian() {
    }

    public Guardian(int guardianID) {
        this.guardianID = guardianID;
    }

    public Guardian(int guardianID, String name, String email, String cellphone, Date dateRegistered) {
        this.guardianID = guardianID;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.dateRegistered = dateRegistered;
    }

    public int getGuardianID() {
        return guardianID;
    }

    public void setGuardianID(int guardianID) {
        this.guardianID = guardianID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public List<GuardianTrainee> getGuardianTraineeList() {
        return guardianTraineeList;
    }

    public void setGuardianTraineeList(List<GuardianTrainee> guardianTraineeList) {
        this.guardianTraineeList = guardianTraineeList;
    }


    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Guardian[ guardianID=" + guardianID + " ]";
    }
    
}
