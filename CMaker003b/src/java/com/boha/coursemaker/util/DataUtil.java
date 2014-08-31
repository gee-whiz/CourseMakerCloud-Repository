/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.data.Activity;
import com.boha.coursemaker.data.Administrator;
import com.boha.coursemaker.data.Author;
import com.boha.coursemaker.data.Category;
import com.boha.coursemaker.data.City;
import com.boha.coursemaker.data.Country;
import com.boha.coursemaker.data.CourseTrainee;
import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.Equipment;
import com.boha.coursemaker.data.HelpType;
import com.boha.coursemaker.data.Instructor;
import com.boha.coursemaker.data.Inventory;
import com.boha.coursemaker.data.LessonResource;
import com.boha.coursemaker.data.Province;
import com.boha.coursemaker.data.Rating;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.data.TraineeEquipment;
import com.boha.coursemaker.data.TrainingClass;
import com.boha.coursemaker.data.TrainingClassCourse;
import com.boha.coursemaker.data.Company;
import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.HelpRequest;
import com.boha.coursemaker.data.HelpResponse;
import com.boha.coursemaker.data.InstructorClass;
import com.boha.coursemaker.data.Objective;
import com.boha.coursemaker.dto.AdministratorDTO;
import com.boha.coursemaker.dto.CityDTO;
import com.boha.coursemaker.dto.EquipmentDTO;
import com.boha.coursemaker.dto.HelpTypeDTO;
import com.boha.coursemaker.dto.InstructorDTO;
import com.boha.coursemaker.dto.ProvinceDTO;
import com.boha.coursemaker.dto.RatingDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.dto.TrainingClassDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Utility class with all  methods to handle database access
 *
 * @author Aubrey
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {
@PersistenceContext
    private EntityManager em;
    private  final Logger log = Logger.getLogger("DataUtil");

    public  String getErrorString(Exception e) {
        StringBuilder sb = new StringBuilder();
        if (e.getMessage() != null) {
            sb.append(e.getMessage()).append("\n\n");
        }
        if (e.toString() != null) {
            sb.append(e.toString()).append("\n\n");
        }
        StackTraceElement[] s = e.getStackTrace();
        if (s.length > 0) {
            StackTraceElement ss = s[0];
            String method = ss.getMethodName();
            String cls = ss.getClassName();
            int line = ss.getLineNumber();
            sb.append("Class: ").append(cls).append("\n");
            sb.append("Method: ").append(method).append("\n");
            sb.append("Line Number: ").append(line).append("\n");
        }

        return sb.toString();
    }

    public  ResponseDTO getTrainingClassList(Integer companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("TrainingClass.findByCompanyID");
            q.setParameter("id", companyID);
            List<TrainingClass> list = q.getResultList();
            List<TrainingClassDTO> dto = new ArrayList<>();
            for (TrainingClass ht : list) {
                dto.add(new TrainingClassDTO(ht));
            }
            d.setTrainingClassList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO getProvinceListByCountryCode(String countryCode)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Province.findByCountryCode");
            q.setParameter("code", countryCode);

            List<Province> list = q.getResultList();
            List<ProvinceDTO> dto = new ArrayList<>();
            for (Province ht : list) {
                dto.add(new ProvinceDTO(ht));
            }

            List<CityDTO> cList = getCityListByCountryCode(countryCode);
            for (ProvinceDTO p : dto) {
                for (CityDTO city : cList) {
                    if (city.getProvinceID() == p.getProvinceID()) {
                        p.getCityList().add(city);
                    }
                }
            }

            d.setProvinceList(dto);
            log.log(Level.INFO, "Provinces found in country: {0}", dto.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }

    public  List<CityDTO> getCityListByCountryCode(String countryCode)
            throws DataException {
        List<CityDTO> dto;
        try {

            Query q = em.createNamedQuery("City.findByCountryCode");
            q.setParameter("code", countryCode);
            List<City> list = q.getResultList();
            dto = new ArrayList<>();
            for (City ht : list) {
                dto.add(new CityDTO(ht));
            }
            log.log(Level.INFO, "Cities found in country: {0}", dto.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(getErrorString(e));
        }
        return dto;
    }

    public  ResponseDTO getEquipmentList(Integer trainingCompanyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Equipment.findByCompanyID");
            q.setParameter("id", trainingCompanyID);
            List<Equipment> list = q.getResultList();
            List<EquipmentDTO> dto = new ArrayList<>();
            for (Equipment ht : list) {
                dto.add(new EquipmentDTO(ht));
            }
            d.setEquipmentList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO getRatingAndHelpList(Integer companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Rating.findByCompany");
            q.setParameter("id", companyID);
            List<Rating> list = q.getResultList();
            List<RatingDTO> dto = new ArrayList<>();
            for (Rating ht : list) {
                dto.add(new RatingDTO(ht));
            }
            d.setRatingList(dto);
            d.setHelpTypeList(getHelpTypeList(companyID).getHelpTypeList());
            log.log(Level.INFO, "found Ratings: {0}", d.getRatingList().size());
            
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO getHelpTypeList(Integer companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("HelpType.findByCompany");
            q.setParameter("id", companyID);
            List<HelpType> list = q.getResultList();
            List<HelpTypeDTO> dto = new ArrayList<>();
            for (HelpType ht : list) {
                dto.add(new HelpTypeDTO(ht));
            }
            d.setHelpTypeList(dto);
            log.log(Level.INFO, "found HelpTypes: {0}", d.getHelpTypeList().size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO deactivateInstructor(InstructorDTO instructor, Integer administrationID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            EntityTransaction tran = em.getTransaction();

            Instructor tc = getInstructorByID(instructor.getInstructorID());
            Administrator adm = getAdministratorByID(administrationID);
            tran.begin();
            tc.setActiveFlag(1);
            tc.setAdministrator(adm);
            em.merge(tc);
            tran.commit();
            d.setMessage("Instructor deactivated");
            log.log(Level.INFO, "Instructor deactivated {0} {1}", new Object[]{tc.getFirstName(), tc.getLastName()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to deactivate instructor", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO registerAdministrator(AdministratorDTO admin, Integer companyID,
            Integer administrationID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            EntityTransaction tran = em.getTransaction();

            Administrator superUser = getAdministratorByID(administrationID);
            if (superUser.getSuperUserFlag() == 0) {
                throw new DataException("A non-superUser admin tried to register another admin. This is a No-No!");
            }
            Company tc = getCompanyByID(companyID);
            tran.begin();
            Administrator a = new Administrator();
            a.setFirstName(admin.getFirstName());
            a.setLastName(admin.getLastName());
            a.setEmail(admin.getEmail());
            a.setCellphone(admin.getCellphone());
            a.setCompany(tc);
            a.setPassword(admin.getPassword());
            a.setDateRegistered(new Date());
            em.persist(a);
            tran.commit();
            d.setAdministrator(new AdministratorDTO(a));
            log.log(Level.INFO, "Training Company: {0} Administrator registered: {1} {2}",
                    new Object[]{tc.getCompanyName(), a.getFirstName(), a.getLastName()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register Administrator", e);
            throw new DataException(getErrorString(e));
        }
        return d;
    }
    public  final String OK_MESSAGE = "Signed in OK! Welcome.";
    public  final String ERROR_MESSAGE = "Email or password invalid. Please try again or contact Support";
    public  final int TRAINEE = 1, INSTRUCTOR = 2, AUTHOR = 3, ADMIN = 4, EXECUTIVE = 5;

    public  City getCityByID(Integer id) {

        City c = em.find(City.class, id);
        return c;
    }

    public  Company getCompanyByID(Integer id) {

        Company c = em.find(Company.class, id);
        return c;
    }

    public  Author getAuthorByID(Integer id) {

        Author c = em.find(Author.class, id);
        return c;
    }

   
    public  Objective getObjectiveByID(Integer id) {

        Objective c = em.find(Objective.class, id);
        return c;
    }

    public  LessonResource getLessonResourceByID(Integer id) {

        LessonResource c = em.find(LessonResource.class, id);
        return c;
    }

    public  Activity getActivityByID(Integer id) {

        Activity c = em.find(Activity.class, id);
        return c;
    }

    public  Country getCountryByID(Integer id) {

        Country c = em.find(Country.class, id);
        return c;
    }

    public  Province getProvinceByID(Integer id) {

        Province c = em.find(Province.class, id);
        return c;
    }

    public  CourseTrainee getCourseTraineeByID(Integer id) {

        CourseTrainee c = em.find(CourseTrainee.class, id);
        return c;
    }

    public  CourseTraineeActivity getCourseTraineeActivityByID(Integer id) {

        CourseTraineeActivity c = em.find(CourseTraineeActivity.class, id);
        return c;
    }

    public  Rating getRatingByID(Integer id) {

        Rating c = em.find(Rating.class, id);
        return c;
    }

    public  TraineeEquipment getTraineeEquipmentByID(Integer id) {

        TraineeEquipment c = em.find(TraineeEquipment.class, id);
        return c;
    }

    public  Equipment getEquipmentByID(Integer id) {

        Equipment c = em.find(Equipment.class, id);
        return c;
    }

    public  Course getCourseByID(Integer id) {

        Course c = em.find(Course.class, id);
        return c;
    }

    public  TrainingClass getTrainingClassByID(Integer id) {

        TrainingClass c = em.find(TrainingClass.class, id);
        return c;
    }

    public  Trainee getTraineeByID(Integer id) {

        Trainee c = em.find(Trainee.class, id);
        return c;
    }

    public  HelpType getHelpTypeByID(Integer id) {

        HelpType c = em.find(HelpType.class, id);
        return c;
    }

    public  Instructor getInstructorByID(Integer id) {

        Instructor c = em.find(Instructor.class, id);
        return c;
    }

    public  InstructorClass getInstructorClassByID(Integer id) {

        InstructorClass c = em.find(InstructorClass.class, id);
        return c;
    }

    public  Inventory getInventoryByID(Integer id) {

        Inventory c = em.find(Inventory.class, id);
        return c;
    }

    public  Administrator getAdministratorByID(Integer id) {

        Administrator c = em.find(Administrator.class, id);
        return c;
    }

    public  TrainingClassCourse getTrainingClassCourseByID(Integer id) {

        TrainingClassCourse c = em.find(TrainingClassCourse.class, id);
        return c;
    }

    public  Category getCategoryByID(Integer id) {

        Category c = em.find(Category.class, id);
        return c;
    }

    public  HelpRequest getHelpRequestByID(Integer id) {

        HelpRequest c = em.find(HelpRequest.class, id);
        return c;
    }

    public  HelpResponse getHelpResponseByID(Integer id) {

        HelpResponse c = em.find(HelpResponse.class, id);
        return c;
    }

    public  double getPercentage(int total, int complete) {
        if (total == 0) {
            return 0;
        }
        Double t = new Double("" + total);
        Double c = new Double("" + complete);
        Double p = (c / t) * 100;
        return p.doubleValue();
    }

    public  String getPassword(Integer id, int type)
            throws DataException {
        log.log(Level.OFF, "getPassword, id = " + id);
        String password = createPassword();
        try {

            switch (type) {
                case AUTHOR:
                    Author author = getAuthorByID(id);
                    author.setPassword(password);
                    em.merge(author);
                    break;
                case TRAINEE:
                    Trainee trainee = getTraineeByID(id);
                    trainee.setPassword(password);
                    em.merge(trainee);
                    break;
                case INSTRUCTOR:
                    Instructor instructor = getInstructorByID(id);
                    instructor.setPassword(password);
                    em.merge(instructor);
                    break;
                case ADMIN:
                    Administrator a = getAdministratorByID(id);
                    a.setPassword(password);
                    em.merge(a);
                    break;
            }
            log.log(Level.INFO, "User password updated");

        } catch (Exception ex) {
            log.log(Level.SEVERE, "Failed to update password", ex);
            throw new DataException("Failed to update password");
        }
        return password;
    }

    public  String createPassword() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random(System.currentTimeMillis());

        for (int i = 0; i < 4; i++) {
            int x = rand.nextInt(alphabet.length - 1);
            sb.append(alphabet[x]);
        }
        int x1 = rand.nextInt(special.length - 1);
        sb.append(special[x1]);
        for (int i = 0; i < 3; i++) {
            int x = rand.nextInt(numbers.length - 1);
            sb.append(numbers[x]);
        }


        return sb.toString();
    }
    private  final String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
        "i", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private  final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private  final String[] special = {"@", "#", "$", "&"};
}
