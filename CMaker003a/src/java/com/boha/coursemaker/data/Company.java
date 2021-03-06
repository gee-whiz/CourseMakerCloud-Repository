/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", 
        query = "select a from Company a "
                    + " order by a.companyName"),
    ////
    @NamedQuery(name = "Company.countCategories", 
        query = "select a.company, count(a) as total "
                    + "from Category a "
                    + " GROUP BY a.company"),
    
    @NamedQuery(name = "Company.countCourses", 
        query = "select a.company, count(a) as total "
                    + "from Course a "
                    + " GROUP BY a.company"),
    
     @NamedQuery(name = "Company.countLessons", 
        query = "select a.course.category.company, count(a) as total from Lesson a "
                    + "GROUP BY a.course.category.company"),
     
     @NamedQuery(name = "Company.countActivities", 
        query = "select a.lesson.course.category.company, count(a) as total from Activity a "
                    + "GROUP BY a.lesson.course.category.company"),
     
     @NamedQuery(name = "Company.countLinks", 
        query = "select a.lesson.course.category.company, count(a) as total from LessonResource a "
                    + "GROUP BY a.lesson.course.category.company"),
     
     @NamedQuery(name = "Company.countObjectives", 
        query = "select a.course.category.company, count(a) "
                    + "from Objective a "
                    + "GROUP BY a.course.category.company"),
      @NamedQuery(name = "Company.countTrainees", 
        query = "select a.company, count(a) from Trainee a "
                    + "GROUP BY a.company"),
      
      @NamedQuery(name = "Company.countTraineesActive", 
        query = "select a.company, count(a) "
                    + "from Trainee a where a.activeFlag is null "
                    + "or a.activeFlag = 1 "
                    + "GROUP BY a.company"),
      @NamedQuery(name = "Company.countTraineeRatings", 
        query = "select a.trainee.company, count(a) from TraineeRating a  "
                    + "GROUP BY a.trainee.company"),
      
      @NamedQuery(name = "Company.countInstructorRatings", 
        query = "select a.instructor.company, count(a) from InstructorRating a"
                    + " GROUP BY a.instructor.company"),
      
       @NamedQuery(name = "Company.countAuthors", 
        query = "select a.company, count(a) from Author a "
                    + " GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countAdministrators", 
        query = "select a.company, count(a) from Administrator a "
                    + " GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countInstructors", 
        query = "select a.company, count(a) from Instructor a "
                    + " GROUP BY a.company"),
       @NamedQuery(name = "Company.countClasses", 
        query = "select a.company, count(a) from TrainingClass a "
                    + " GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countClassesActive", 
        query = "select a.company, count(a) from TrainingClass a "
                    + " where a.isOpen = 1 or a.isOpen is null "
                    + " GROUP BY a.company"),
       @NamedQuery(name = "Company.countClassCourses", 
        query = "select a.trainingClass.company, count(a) from TrainingClassCourse a "
                    + " GROUP BY a.trainingClass.company"),
       
       @NamedQuery(name = "Company.countCourseTraineeActivities", 
        query = "select a.courseTrainee.trainee.company, count(a) from CourseTraineeActivity a "
                    + " GROUP BY a.courseTrainee.trainee.company"),
       
       
       
       
    ///////////////// - filter by company 
       @NamedQuery(name = "Company.countCategoriesByCompany", 
        query = "select a.company, count(a) from Category a "
                    + "where a.company.companyID = :id "
                    + " GROUP BY a.company"),
    
    @NamedQuery(name = "Company.countCoursesByCompany", 
        query = "select a.company, count(a) from Course a "
                    + " where a.company.companyID = :id "
                    + " GROUP BY a.company"),
    
     @NamedQuery(name = "Company.countLessonsByCompany", 
        query = "select a.course.category.company, count(a) from Lesson a  "
                    + "where a.course.category.company.companyID = :id "
                    + "GROUP BY a.course.category.company"),
     
     @NamedQuery(name = "Company.countActivitiesByCompany", 
        query = "select a.lesson.course.category.company, count(a) from Activity a "
                    + " where a.lesson.course.category.company.companyID = :id "
                    + " GROUP BY a.lesson.course.category.company"),
     
     @NamedQuery(name = "Company.countLinksByCompany", 
        query = "select a.lesson.course.category.company, count(a) from LessonResource a "
                    + " where a.lesson.course.category.company.companyID = :id "
                    + " GROUP BY a.lesson.course.category.company"),
     
     @NamedQuery(name = "Company.countObjectivesByCompany", 
        query = "select a.course.category.company, count(a) from Objective a "
                    + " where a.course.category.company.companyID = :id"
                    + " GROUP BY a.course.category.company"),
     
      @NamedQuery(name = "Company.countTraineesByCompany", 
        query = "select a.company, count(a) from Trainee a "
                    + " where a.company.companyID = :id "
                    + " GROUP BY a.company"),
      
      @NamedQuery(name = "Company.countTraineesActiveByCompany", 
        query = "select a.company, count(a) from Trainee a "
                    + "where a.activeFlag is null or a.activeFlag = 1 "
                    + " and a.company.companyID = :id "
                    + " GROUP BY a.company"),
      
      
      @NamedQuery(name = "Company.countTraineeRatingsByCompany", 
        query = "select a.trainee.company, count(a) from TraineeRating a  "
                    + " where a.trainee.company.companyID = :id "
                    + " GROUP BY a.trainee.company"),
      
      @NamedQuery(name = "Company.countInstructorRatingsByCompany", 
        query = "select a.instructor.company, count(a) from InstructorRating a"
                    + " where a.instructor.company.companyID = :id "
                    + " GROUP BY a.instructor.company"),
      
       @NamedQuery(name = "Company.countAuthorsByCompany", 
        query = "select a.company, count(a) from Author a "
                    + " where a.company.companyID = :id "
                    + " GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countAdministratorsByCompany", 
        query = "select a.company, count(a) from Administrator a "
                    + " where a.company.companyID = :id "
                    + " GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countInstructorsByCompany", 
        query = "select a.company, count(a) from Instructor a "
                    + " where a.company.companyID = :id "
                    + "GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countClassesByCompany", 
        query = "select a.company, count(a) from TrainingClass a "
                    + " where a.company.companyID = :id "
                    + " GROUP BY a.company"),
       
       @NamedQuery(name = "Company.countClassesActiveByCompany", 
        query = "select a.company, count(a) from TrainingClass a "
                    + " where a.isOpen = 1 or a.isOpen is null "
                    + " and a.company.companyID = :id "
                    + " GROUP BY a.company"),
       @NamedQuery(name = "Company.countClassCoursesByCompany", 
        query = "select a.trainingClass.company, count(a) from TrainingClassCourse a "
                    + " where a.trainingClass.company.companyID = :id "
                    + " GROUP BY a.trainingClass.company"),
       
       @NamedQuery(name = "Company.countCourseTraineeActivitiesByCompany", 
        query = "select a.courseTrainee.trainee.company, count(a) from CourseTraineeActivity a "
                    + " where a.courseTrainee.trainee.company.companyID = :id "
                    + " GROUP BY a.courseTrainee.trainee.company"),
       
       
       
       
       
       
       
       
       //////////
    @NamedQuery(name = "Company.countCategories", 
        query = "select a.company, count(a) as total "
                    + "from Category a "
                    + " GROUP BY a.company")})
public class Company implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private List<Rating> ratingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<HelpType> helpTypeList;
    @OneToMany(mappedBy = "company")
    private List<ReportUser> reportUserList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyID")
    private Integer companyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "companyName")
    private String companyName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER)
    private List<Instructor> instructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Equipment> equipmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Course> courseList;
    @OneToMany(mappedBy = "company")
    private List<Author> authorList;
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Trainee> traineeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER)
    private List<TrainingClass> trainingClassList;
    @OneToMany(mappedBy = "company")
    private List<Category> categoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER)
    private List<Administrator> administratorList;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne
    private City city;

    public Company() {
    }

    public Company(Integer companyID) {
        this.companyID = companyID;
    }

    public Company(Integer companyID, String companyName, Date dateRegistered) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.dateRegistered = dateRegistered;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Trainee> getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List<Trainee> traineeList) {
        this.traineeList = traineeList;
    }

    public List<TrainingClass> getTrainingClassList() {
        return trainingClassList;
    }

    public void setTrainingClassList(List<TrainingClass> trainingClassList) {
        this.trainingClassList = trainingClassList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.coursemaker.data.Company[ companyID=" + companyID + " ]";
    }

    public List<ReportUser> getReportUserList() {
        return reportUserList;
    }

    public void setReportUserList(List<ReportUser> reportUserList) {
        this.reportUserList = reportUserList;
    }

    public List<HelpType> getHelpTypeList() {
        return helpTypeList;
    }

    public void setHelpTypeList(List<HelpType> helpTypeList) {
        this.helpTypeList = helpTypeList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
    
}
