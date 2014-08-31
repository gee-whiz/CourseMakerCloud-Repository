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
import com.boha.coursemaker.data.Company;
import com.boha.coursemaker.data.Country;
import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.CourseAuthor;
import com.boha.coursemaker.data.CourseTrainee;
import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.Equipment;
import com.boha.coursemaker.data.GcmDevice;
import com.boha.coursemaker.data.HelpRequest;
import com.boha.coursemaker.data.HelpType;
import com.boha.coursemaker.data.Instructor;
import com.boha.coursemaker.data.InstructorClass;
import com.boha.coursemaker.data.Inventory;
import com.boha.coursemaker.data.Province;
import com.boha.coursemaker.data.Rating;
import com.boha.coursemaker.data.Skill;
import com.boha.coursemaker.data.SkillLevel;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.data.TraineeEquipment;
import com.boha.coursemaker.data.TrainingClass;
import com.boha.coursemaker.data.TrainingClassCourse;
import com.boha.coursemaker.dto.AdministratorDTO;
import com.boha.coursemaker.dto.AuthorDTO;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CourseTraineeActivityDTO;
import com.boha.coursemaker.dto.EquipmentDTO;
import com.boha.coursemaker.dto.HelpRequestDTO;
import com.boha.coursemaker.dto.InstructorDTO;
import com.boha.coursemaker.dto.InventoryDTO;
import com.boha.coursemaker.dto.LessonScheduleDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.dto.TraineeDTO;
import com.boha.coursemaker.dto.TraineeEquipmentDTO;
import com.boha.coursemaker.dto.TrainingClassCourseDTO;
import com.boha.coursemaker.dto.TrainingClassDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.dto.CompanyDTO;
import com.boha.coursemaker.dto.GcmDeviceDTO;
import com.boha.coursemaker.dto.HelpTypeDTO;
import com.boha.coursemaker.dto.InstructorClassDTO;
import com.boha.coursemaker.dto.RatingDTO;
import com.boha.coursemaker.dto.SkillDTO;
import com.boha.coursemaker.dto.SkillLevelDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.PersistenceException;

/**
 *
 * @ins aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministratorUtil {

    private static final Logger log = Logger.getLogger("AdministratorUtil");
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public ResponseDTO addHelpType(HelpTypeDTO helpType, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            HelpType t = new HelpType();
            t.setHelpTypeName(helpType.getHelpTypeName());
            t.setCompany(dataUtil.getCompanyByID(helpType.getCompanyID()));
            em.persist(t);
            //TODO - get list
            d.setHelpTypeList(new ArrayList<HelpTypeDTO>());
            d.getHelpTypeList().add(new HelpTypeDTO(t));
            d.setMessage("HelpType added");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add helptype", e);
            throw new DataException("Failed to add helptype\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteHelpType(HelpTypeDTO rating, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            HelpType t = dataUtil.getHelpTypeByID(rating.getHelpTypeID());
            em.remove(t);
            d.setMessage("HelpType deleted");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update helptype", e);
            throw new DataException("Failed to update helptype\n" + dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO updateHelpType(HelpTypeDTO helpType, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            HelpType t = dataUtil.getHelpTypeByID(helpType.getHelpTypeID());
            t.setHelpTypeName(helpType.getHelpTypeName());

            em.merge(t);

            d.setHelpTypeList(new ArrayList<HelpTypeDTO>());
            d.getHelpTypeList().add(new HelpTypeDTO(t));
            d.setMessage("HelpType updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update helptype", e);

            throw new DataException("Failed to update helptype\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addRating(RatingDTO rating, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Rating t = new Rating();
            t.setRatingName(rating.getRatingName());
            t.setRatingNumber(rating.getRatingNumber());
            t.setCompany(dataUtil.getCompanyByID(rating.getCompanyID()));

            em.persist(t);

            d.setRatingList(new ArrayList<RatingDTO>());
            d.getRatingList().add(new RatingDTO(t));
            d.setMessage("Rating added");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add rating", e);
            throw new DataException("Failed to add rating\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateRating(RatingDTO rating, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Rating t = dataUtil.getRatingByID(rating.getRatingID());
            t.setRatingName(rating.getRatingName());
            t.setRatingNumber(rating.getRatingNumber());

            em.merge(t);

            d.setRatingList(new ArrayList<RatingDTO>());
            d.getRatingList().add(new RatingDTO(t));
            d.setMessage("Rating updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update rating", e);
            throw new DataException("Failed to update rating\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteRating(RatingDTO rating, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Rating t = dataUtil.getRatingByID(rating.getRatingID());

            em.remove(t);

            d.setMessage("Rating deleted");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to delete rating", e);
            throw new DataException("Failed to delete rating\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateTrainee(TraineeDTO trainee,
            int trainingClassID, int cityID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Trainee t = dataUtil.getTraineeByID(trainee.getTraineeID());
            t.setFirstName(trainee.getFirstName());
            t.setLastName(trainee.getLastName());
            t.setCellphone(trainee.getCellphone());
            t.setEmail(trainee.getEmail());
            t.setGender(trainee.getGender());
            t.setCity(dataUtil.getCityByID(cityID));
            t.setTrainingClass(dataUtil.getTrainingClassByID(trainingClassID));

            em.merge(t);

            d.setTrainee(new TraineeDTO(t));
            d.setMessage("Trainee updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update trainee", e);
            throw new DataException("Failed to update trainee\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteClass(int trainingClassID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            TrainingClass t = dataUtil.getTrainingClassByID(trainingClassID);
            if (t != null) {
                if (t.getTraineeList().size() > 0
                        || t.getTrainingClassCourseList().size() > 0
                        || t.getTrainingClassCourseList().size() > 0) {
                    t.setIsOpen(0);
                    em.merge(t);
                } else {
                    em.remove(t);
                }
            }

            d.setMessage("Class flagged/deleted");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to delete class", e);
            throw new DataException("Failed to delete class\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateClass(TrainingClassDTO trainingClass, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            TrainingClass t = dataUtil.getTrainingClassByID(trainingClass.getTrainingClassID());
            t.setTrainingClassName(trainingClass.getTrainingClassName());
            t.setStartDate(new Date(trainingClass.getStartDate()));
            t.setEndDate(new Date(trainingClass.getEndDate()));
            t.setIsOpen(trainingClass.getIsOpen());

            em.merge(t);

            d.setMessage("Class updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update class", e);
            throw new DataException("Failed to update class\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateInstructor(InstructorDTO instructor, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Instructor t = dataUtil.getInstructorByID(instructor.getInstructorID());
            t.setFirstName(instructor.getFirstName());
            t.setLastName(instructor.getLastName());
            t.setCellphone(instructor.getCellphone());
            t.setPassword(instructor.getPassword());

            em.merge(t);

            d.setMessage("Instructor updated");
            d.setInstructor(new InstructorDTO(t));
            log.log(Level.INFO, "Instructor updated: {0} {1}",
                    new Object[]{t.getFirstName(), t.getLastName()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update instructor", e);
            throw new DataException("Failed to update instructor\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateAuthor(AuthorDTO author, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Author t = dataUtil.getAuthorByID(author.getAuthorID());
            t.setFirstName(author.getFirstName());
            t.setLastName(author.getLastName());
            t.setCellphone(author.getCellphone());
            t.setPassword(author.getPassword());

            em.merge(t);

            d.setMessage("Author updated");
            d.setAuthor(new AuthorDTO(t));
            log.log(Level.INFO, "Author updated: {0} {1}",
                    new Object[]{t.getFirstName(), t.getLastName()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update author", e);
            throw new DataException("Failed to update author\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateAdmin(AdministratorDTO admin, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Administrator t = dataUtil.getAdministratorByID(admin.getAdministratorID());
            t.setFirstName(admin.getFirstName());
            t.setLastName(admin.getLastName());
            t.setCellphone(admin.getCellphone());
            t.setPassword(admin.getPassword());

            em.merge(t);

            d.setMessage("Admin updated");
            d.setAdministrator(new AdministratorDTO(t));
            log.log(Level.INFO, "Admin updated: {0} {1}",
                    new Object[]{admin.getFirstName(), admin.getLastName()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update admin", e);
            throw new DataException("Failed to update admin\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addTrainee(TraineeDTO trainee,
            int trainingClassID, int cityID, TraineeUtil traineeUtil, DataUtil dataUtil)
            throws DataException {

        ResponseDTO r = traineeUtil.registerTrainee(trainee, trainingClassID, cityID,dataUtil);
        return r;
    }

    public ResponseDTO addAuthor(AuthorDTO author,
            int companyID, AuthorUtil authorUtil, DataUtil dataUtil)
            throws DataException {
        ResponseDTO r = authorUtil.registerAuthor(author, companyID, dataUtil);
        return r;
    }

    public ResponseDTO addInstructor(InstructorDTO instructor,
             InstructorUtil instructorUtil, DataUtil dataUtil)
            throws DataException {

        ResponseDTO r = instructorUtil.registerInstructor(instructor, dataUtil);
        return r;
    }

    public ResponseDTO addAdministrator(AdministratorDTO admin, DataUtil dataUtil)
            throws DataException {

        ResponseDTO r = registerAdministrator(admin,dataUtil);

        return r;
    }

    /**
     * Administrator applications use this method to add courses to a training
     * class
     *
     * @param trainingClassID
     * @param companyCourses
     * @param flags
     * @return
     * @throws DataException
     */
    public ResponseDTO addClassCourses(int trainingClassID,
            List<CourseDTO> companyCourses,
            List<Integer> flags, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            TrainingClass tc = dataUtil.getTrainingClassByID(trainingClassID);

            int index = 0, cnt = 0, ign = 0;
            for (CourseDTO tcx : companyCourses) {
                if (!checkIfExists(trainingClassID, tcx.getCourseID())) {
                    TrainingClassCourse tcc = new TrainingClassCourse();
                    tcc.setTrainingClass(tc);
                    tcc.setCourse(dataUtil.getCourseByID(tcx.getCourseID()));
                    tcc.setDateUpdated(new Date());
                    if (flags != null) {
                        tcc.setPriorityFlag(flags.get(index));
                    }
                    em.persist(tcc);
                    cnt++;
                    log.log(Level.INFO, "Course added to class: {0} - course: {1}",
                            new Object[]{tc.getTrainingClassName(), tcc.getCourse()});
                } else {
                    ign++;
                }

            }

            if (cnt > 0) {
                Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
                q.setParameter("id", trainingClassID);
                List<TrainingClassCourse> list = q.getResultList();
                List<TrainingClassCourseDTO> gList = new ArrayList<>();
                for (TrainingClassCourse tcc : list) {
                    gList.add(new TrainingClassCourseDTO(tcc));
                }
                d.setTrainingClassCourseList(gList);
            } else {
                d.setTrainingClassCourseList(new ArrayList<TrainingClassCourseDTO>());
            }
            //log.log(Level.INFO, "Class courses added: {0}or ignored: {1}", new Object[]{cnt, ign});
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException("Failed to add class courses\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO assignInstructorClass(
            int instructorID, int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();

        try {
            Instructor instructor = dataUtil.getInstructorByID(instructorID);
            TrainingClass trainingClass = dataUtil.getTrainingClassByID(trainingClassID);

            InstructorClass ic = new InstructorClass();
            ic.setDateRegistered(new Date());
            ic.setInstructor(instructor);
            ic.setTrainingClass(trainingClass);

            em.persist(ic);

            //log.log(Level.INFO, "Class assigned to instructor {0} {1} - {2}",
            //      new Object[]{instructor.getFirstName(), instructor.getLastName(),
            //trainingClass.getTrainingClassName()});
            Query q = em.createNamedQuery("InstructorClass.findByInstructorID", InstructorClass.class);
            q.setParameter("id", instructor.getInstructorID());
            List<InstructorClass> list = q.getResultList();
            List<InstructorClassDTO> dto = new ArrayList<>();
            for (InstructorClass instructorClass : list) {
                dto.add(new InstructorClassDTO(instructorClass));
            }
            resp.setInstructorClassList(dto);
            //log.log(Level.INFO, "Instructor has {0} classes assigned", dto.size());
        } catch (PersistenceException e) {
            resp.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            resp.setMessage("Possible duplicate");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to assign class to instructor", e);
            throw new DataException("Failed to assign class to instructor\n" + dataUtil.getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO assignClassCoursesToTrainees(int trainingClassID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
        q.setParameter("id", trainingClassID);
        List<TrainingClassCourse> list = q.getResultList();
        log.log(Level.INFO, "TrainingClassCourses found: {0}", list.size());
        List<Trainee> traineeList = getTraineesByClass(trainingClassID);
        try {
            for (TrainingClassCourse tcc : list) {
                List<Activity> activityList = getCourseActivities(tcc.getCourse());
                for (Trainee trainee : traineeList) {
                    if (!checkIfEnrolmentExists(trainee, tcc)) {
                        CourseTrainee ct = new CourseTrainee();
                        ct.setTrainee(trainee);
                        ct.setTrainingClassCourse(tcc);
                        ct.setDateEnrolled(new Date());

                        em.persist(ct);
                        Query xq = em.createNamedQuery("CourseTrainee.findByClassCourseTrainee", CourseTrainee.class);
                        xq.setParameter("id", tcc.getTrainingClassCourseID());
                        xq.setParameter("traineeID", trainee.getTraineeID());
                        xq.setMaxResults(1);
                        CourseTrainee ctx = (CourseTrainee) xq.getSingleResult();

                        for (Activity activity : activityList) {
                            if (!checkIfCTAExists(ct, activity)) {
                                CourseTraineeActivity cta = new CourseTraineeActivity();
                                cta.setCourseTrainee(ctx);
                                cta.setActivity(activity);
                                cta.setDateUpdated(new Date());
                                em.persist(cta);
                            }

                        }

                    }
                }

                log.log(Level.INFO, "Trainees enrolled:");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to assign courses to class", e);
            throw new DataException("Failed to assign courses to class\n" + dataUtil.getErrorString(e));
        }
        //resp.setTrainingClassCourseList(gList);
        return resp;
    }

    public List<Activity> getCourseActivities(Course c) {
        Query q = em.createNamedQuery("Activity.findByCourseID", Activity.class);
        q.setParameter("id", c.getCourseID());
        List<Activity> list = q.getResultList();
        return list;
    }

    private boolean checkIfCTAExists(CourseTrainee ct, Activity a) {
        boolean found = false;

        Query q = em.createNamedQuery("CourseTraineeActivity.checkIfExists", CourseTraineeActivity.class);
        q.setParameter("ct", ct);
        q.setParameter("ac", a);
        List<CourseTrainee> list = q.getResultList();
        if (list.size() > 0) {
            found = true;
        }
        return found;
    }

    private boolean checkIfEnrolmentExists(Trainee t, TrainingClassCourse tcc) {
        boolean found = false;

        Query q = em.createNamedQuery("CourseTrainee.checkIfEnrolled", CourseTrainee.class);
        q.setParameter("t", t);
        q.setParameter("tcc", tcc);
        List<CourseTrainee> list = q.getResultList();
        if (list.size() > 0) {
            found = true;
        }
        return found;
    }

    private boolean checkIfExists(int trainingClassID, int courseID) {
        boolean found = false;

        Query q = em.createNamedQuery("TrainingClassCourse.checkIfExists", TrainingClassCourse.class);
        q.setParameter("tcID", trainingClassID);
        q.setParameter("cID", courseID);
        List<TrainingClassCourse> list = q.getResultList();
        if (list.size() > 0) {
            found = true;
        }
        return found;
    }

    /**
     * Administrator app registers a bunch of trainees into a class
     *
     * @param trainingCompanyID
     * @param trainingClassID
     * @param traineeList
     * @return
     * @throws DataException
     */
    public ResponseDTO enrollClassTrainees(int administratorID, int trainingClassID,
            List<TraineeDTO> traineeList, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            TrainingClass tc = dataUtil.getTrainingClassByID(trainingClassID);
            Administrator adm = dataUtil.getAdministratorByID(administratorID);

            for (TraineeDTO dto : traineeList) {
                Trainee t = dataUtil.getTraineeByID(dto.getTraineeID());
                t.setTrainingClass(tc);
                t.setAdministrator(adm);

                em.merge(t);

            }

            //log.log(Level.INFO, "Trainees registered into class: {0}", tc.getTrainingClassName());
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add class trainees", e);
            throw new DataException("Failed to add class trainees\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO getHelpRequestListByPeriod(
            int trainingClassID, long startDate, long endDate, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("HelpRequest.findByClassPeriod", HelpRequest.class);
            q.setParameter("id", trainingClassID);
            q.setParameter("start", new Date(startDate));
            q.setParameter("end", new Date(endDate));
            List<HelpRequest> list = q.getResultList();
            List<HelpRequestDTO> dto = new ArrayList<>();
            for (HelpRequest inv : list) {
                dto.add(new HelpRequestDTO(inv));
            }
            d.setHelpRequestList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInventoryListByClass(int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByTrainingClassID", TraineeEquipment.class);
            q.setParameter("id", trainingClassID);
            List<TraineeEquipment> list = q.getResultList();
            List<TraineeEquipmentDTO> dto = new ArrayList<>();
            for (TraineeEquipment inv : list) {
                dto.add(new TraineeEquipmentDTO(inv));
            }
            d.setTraineeEquipmentList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInventoryList(int trainingCompanyID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Inventory.findByCompany");
            q.setParameter("id", trainingCompanyID);
            List<Inventory> list = q.getResultList();
            List<InventoryDTO> dto = new ArrayList<>();

            for (Inventory inv : list) {
                dto.add(new InventoryDTO(inv));
            }
            d.setInventoryList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getEquipmentList(int trainingCompanyID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Equipment.findByCompanyID", Equipment.class);
            q.setParameter("id", trainingCompanyID);
            List<Equipment> list = q.getResultList();
            List<EquipmentDTO> dto = new ArrayList<>();
            ResponseDTO r = getInstructorList(trainingCompanyID,dataUtil);
            for (Equipment equipment : list) {
                EquipmentDTO eDTO = new EquipmentDTO(equipment);
                eDTO.setInventoryList(new ArrayList<InventoryDTO>());
                for (InventoryDTO i : r.getInventoryList()) {
                    if (i.getEquipment().getEquipmentID() == equipment.getEquipmentID()) {
                        eDTO.getInventoryList().add(i);
                    }
                }
                dto.add(eDTO);
            }
            d.setEquipmentList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Administrator app registers new training class for the company. Trainees
     * will be enrolled into this class.
     *
     * @param companyID
     * @param tClass
     * @param administratorID
     * @return
     * @throws DataException
     */
    public ResponseDTO registerClass(int companyID,
            TrainingClassDTO tClass, int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Company tc = dataUtil.getCompanyByID(companyID);
            Administrator adm = dataUtil.getAdministratorByID(administratorID);
            TrainingClass cls = new TrainingClass();
            cls.setCompany(tc);
            cls.setAdministrator(adm);
            cls.setIsOpen(1);
            cls.setTrainingClassName(tClass.getTrainingClassName());
            if (tClass.getStartDate() > 0) {
                cls.setStartDate(new Date(tClass.getStartDate()));
            }
            if (tClass.getEndDate() > 0) {
                cls.setEndDate(new Date(tClass.getEndDate()));
            }
            em.persist(cls);
//TODO -- refresh
            d.setTrainingClass(new TrainingClassDTO(cls));
            //log.log(Level.INFO, "Training class registered: {0}", tClass.getTrainingClassName());
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register class", e);
            throw new DataException("Failed to register class\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO updateInventory(InventoryDTO inventory,
            int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Administrator adm = dataUtil.getAdministratorByID(administratorID);
            Inventory te = dataUtil.getInventoryByID(inventory.getInventoryID());
            te.setConditionFlag(inventory.getConditionFlag());
            te.setDateUpdated(new Date());
            te.setModel(inventory.getModel());
            te.setSerialNumber(inventory.getSerialNumber());
            te.setYearPurchased(inventory.getYearPurchased());
            te.setAdministrator(adm);

            em.merge(te);

            d.setInventory(new InventoryDTO(te));
            //log.log(Level.INFO, "inventory updated");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update inventory", e);
            throw new DataException("Failed to update inventory\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO addEquipment(EquipmentDTO equipment,
            int companyID, int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Company tc = dataUtil.getCompanyByID(companyID);
            Administrator adm = dataUtil.getAdministratorByID(administratorID);
            Equipment te = new Equipment();
            te.setEquipmentName(equipment.getEquipmentName());
            te.setCompany(tc);
            te.setAdministrator(adm);

            em.persist(te);
            Query q = em.createNamedQuery("Equipment.findByCompanyID");
            q.setParameter("id", companyID);
            List<Equipment> list = q.getResultList();
            d.setEquipmentList(new ArrayList<EquipmentDTO>());

            Query q2 = em.createNamedQuery("Equipment.findByCompanyID");
            q2.setParameter("id", companyID);
            List<Inventory> inlist = q2.getResultList();

            for (Equipment e : list) {
                EquipmentDTO eDTO = new EquipmentDTO(e);
                eDTO.setInventoryList(new ArrayList<InventoryDTO>());
                for (Inventory inv : inlist) {
                    if (inv.getEquipment().getEquipmentID() == e.getEquipmentID()) {
                        eDTO.getInventoryList().add(new InventoryDTO(inv));
                    }
                }
                d.getEquipmentList().add(eDTO);
            }

        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding equipment", e);
            throw new DataException("Failed to add equipment\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO updateEquipment(EquipmentDTO equipment,
            int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Administrator adm = dataUtil.getAdministratorByID(administratorID);
            Equipment te = dataUtil.getEquipmentByID(equipment.getEquipmentID());
            te.setEquipmentName(equipment.getEquipmentName());
            te.setAdministrator(adm);

            em.merge(te);

            d.setEquipment(new EquipmentDTO(te));
            //log.log(Level.INFO, "inventory updated");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** upd equipment", e);
            throw new DataException("Failed to update equipment\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO addInventory(InventoryDTO inventory,
            int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Equipment tc = dataUtil.getEquipmentByID(inventory.getEquipment().getEquipmentID());
            Administrator adm = dataUtil.getAdministratorByID(administratorID);

            Inventory te = new Inventory();
            te.setEquipment(tc);
            te.setAdministrator(adm);
            te.setDateRegistered(new Date());
            te.setDateUpdated(new Date());
            te.setModel(inventory.getModel());
            te.setSerialNumber(inventory.getSerialNumber());
            te.setYearPurchased(inventory.getYearPurchased());

            em.persist(te);
            Query q = em.createNamedQuery("Inventory.findByEquipment");
            q.setParameter("id", tc.getEquipmentID());
            List<Inventory> list = q.getResultList();
            d.setInventoryList(new ArrayList<InventoryDTO>());
            for (Inventory i : list) {
                d.getInventoryList().add(new InventoryDTO(i));
            }

            log.log(Level.INFO, " inventory added");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding inventory", e);
            throw new DataException("Failed to add inventory\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO addTraineeEquipment(
            int traineeID, int inventoryID, int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Trainee tc = dataUtil.getTraineeByID(traineeID);
            Administrator adm = dataUtil.getAdministratorByID(administratorID);
            TraineeEquipment te = new TraineeEquipment();
            te.setAdministrator(adm);
            te.setDateRegistered(new Date());
            te.setInventory(dataUtil.getInventoryByID(inventoryID));
            te.setTrainee(tc);

            em.persist(te);

            ResponseDTO r = getTraineeEquipmentListByInventory(inventoryID, dataUtil);
            d.setTraineeEquipmentList(r.getTraineeEquipmentList());
            log.log(Level.INFO, "Trainee equipment added");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding addTraineeEquipment", e);
            throw new DataException("Failed to add TraineeEquipment\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO updateTraineeEquipment(
            int traineeEquipmentID, int conditionFlag,
            boolean isReturn, int administratorID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            TraineeEquipment te = dataUtil.getTraineeEquipmentByID(
                    traineeEquipmentID);
            Administrator adm = dataUtil.getAdministratorByID(administratorID);

            te.setAdministrator(adm);
            te.setConditionFlag(conditionFlag);

            if (isReturn) {
                te.setDateReturned(new Date());
            }
            em.merge(te);

            ResponseDTO r = getTraineeEquipmentListByInventory(te.getInventory().getInventoryID(),dataUtil);
            d.setTraineeEquipmentList(r.getTraineeEquipmentList());
            d.setMessage("updateTraineeEquipment OK");

            log.log(Level.INFO, "Trainee equipment updated");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update TraineeEquipment", e);
            throw new DataException("Failed to update TraineeEquipment\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO getEquipmentInventory(
            int equipmentID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Inventory.findByEquipment", Inventory.class);
            q.setParameter("id", equipmentID);
            List<Inventory> list = q.getResultList();
            List<InventoryDTO> dtoList = new ArrayList<>();
            for (Inventory te : list) {
                dtoList.add(new InventoryDTO(te));
            }

            //log.log(Level.INFO, "Inventory rows found: {0}", dtoList.size());
            d.setInventoryList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list equipment inventory", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getTraineeEquipmentListByEquipmentID(
            int equipmentID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByEquipmentID", TraineeEquipment.class);
            q.setParameter("id", equipmentID);
            List<TraineeEquipment> list = q.getResultList();
            List<TraineeEquipmentDTO> dtoList = new ArrayList<>();
            for (TraineeEquipment te : list) {
                dtoList.add(new TraineeEquipmentDTO(te));
            }
            if (dtoList.isEmpty()) {
                d.setMessage("No equipment list found for the equipmentID");
            }
            d.setTraineeEquipmentList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list trainee equipment", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getTraineeEquipmentListByInventory(
            int inventoryID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByInventoryID", TraineeEquipment.class);
            q.setParameter("id", inventoryID);
            List<TraineeEquipment> list = q.getResultList();
            List<TraineeEquipmentDTO> dtoList = new ArrayList<>();
            for (TraineeEquipment te : list) {
                dtoList.add(new TraineeEquipmentDTO(te));
            }
            if (dtoList.isEmpty()) {
                d.setMessage("No equipment list found for the class");
            }
            d.setTraineeEquipmentList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list trainee equipment", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getTraineeEquipmentListByClass(
            int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByTrainingClassID", TraineeEquipment.class);
            q.setParameter("id", trainingClassID);
            List<TraineeEquipment> list = q.getResultList();
            List<TraineeEquipmentDTO> dtoList = new ArrayList<>();
            for (TraineeEquipment te : list) {
                dtoList.add(new TraineeEquipmentDTO(te));
            }
            if (dtoList.isEmpty()) {
                d.setMessage("No equipment list found for the class");
            }
            d.setTraineeEquipmentList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list trainee equipment", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Get list of trainees enrolled in class
     *
     * @param trainingClassID
     * @return ResponseDTO
     * @throws DataException
     */
    public ResponseDTO getClassTraineeList(
            int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("Trainee.findByClass", Trainee.class);
            q.setParameter("id", trainingClassID);
            List<Trainee> list = q.getResultList();
            List<TraineeDTO> dtoList = new ArrayList<>();
            for (Trainee te : list) {
                dtoList.add(new TraineeDTO(te));
            }
            if (dtoList.isEmpty()) {
                d.setMessage("No trainee list found for the class");
            }
            d.setTraineeList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list trainee list", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Get list of courses attached to the class
     *
     * @param trainingClassID
     * @return
     * @throws DataException
     */
    public ResponseDTO getClassCourseList(
            int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
            q.setParameter("id", trainingClassID);
            List<TrainingClassCourse> list = q.getResultList();
            List<TrainingClassCourseDTO> dtoList = new ArrayList<>();
            for (TrainingClassCourse te : list) {
                dtoList.add(new TrainingClassCourseDTO(te));
            }

            if (dtoList.isEmpty()) {
                d.setMessage("No course list found for the class");
            }
            d.setTrainingClassCourseList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list class course list", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInstructorList(
            int companyID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Instructor.findByCompanyID", Instructor.class);
            q.setParameter("id", companyID);
            List<Instructor> list = q.getResultList();
            List<InstructorDTO> dtoList = new ArrayList<>();
            for (Instructor te : list) {
                dtoList.add(new InstructorDTO(te));
            }
            if (dtoList.isEmpty()) {
                d.setMessage("No course list found for the class");
            }
            d.setInstructorList(dtoList);
            log.log(Level.OFF, "query of instructors gets: {0}", dtoList.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list class course list", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Get all trainee activities for the class course
     *
     * @param trainingClassCourseID
     * @return
     * @throws DataException
     */
    public ResponseDTO getCourseTraineeActivityList(
            int trainingClassCourseID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Query q = em.createNamedQuery("CourseTraineeActivity.findByClassCourse");
            q.setParameter("id", trainingClassCourseID);
            List<CourseTraineeActivity> list = q.getResultList();
            List<CourseTraineeActivityDTO> dtoList = new ArrayList<>();
            for (CourseTraineeActivity te : list) {
                dtoList.add(new CourseTraineeActivityDTO(te));
            }
            if (dtoList.isEmpty()) {
                d.setMessage("No course list found for the class");
            }
            d.setCourseTraineeActivityList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to list class course activity list", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Create training company or entity. In addition, create super
     * Administrator and the first Author and Instructor
     *
     * @param company
     * @param admin
     * @param device
     * @param platformUtil
     * @return
     * @throws DataException
     */
    public ResponseDTO registerCompany(CompanyDTO company, AdministratorDTO admin,
            GcmDeviceDTO device, PlatformUtil platformUtil, DataUtil dataUtil)
            throws DataException {
        log.log(Level.INFO, "Starting company registration ");
        ResponseDTO d = new ResponseDTO();

//TODO - refresh admin and companu to get id's
        City city;

        try {
            Company tc = new Company();
            tc.setCompanyName(company.getCompanyName());
            tc.setEmail(company.getEmail());
            tc.setDateRegistered(new Date());
            if (company.getCity() != null) {
                city = dataUtil.getCityByID(company.getCity().getCityID());
                tc.setCity(city);
            }

            em.persist(tc);

            log.log(Level.INFO, "Company added ... Yay!");
            //add superUser administrator ...

            Administrator administrator = new Administrator();
            administrator.setFirstName(admin.getFirstName());
            administrator.setLastName(admin.getLastName());
            administrator.setEmail(admin.getEmail());
            administrator.setCellphone(admin.getCellphone());
            if (administrator.getCellphone() == null) {
                administrator.setCellphone("");
            }
            administrator.setCompany(tc);
            administrator.setPassword(admin.getPassword());
            administrator.setDateRegistered(new Date());
            administrator.setSuperUserFlag(1);
            em.persist(administrator);

            //log.log(Level.INFO, "Super Admin added {0} {1}", new Object[]{admin.getFirstName(), admin.getLastName()});
            //add basic ratings
            d.setRatingList(addBasicRating(tc, dataUtil));
            d.setHelpTypeList(addBasicHelpType(tc,dataUtil));

            //
            Query q = em.createNamedQuery("Company.findByNameAndEmail", Company.class);
            q.setParameter("companyName", tc.getCompanyName());
            q.setParameter("email", tc.getEmail());
            q.setMaxResults(1);
            Company cc = (Company) q.getSingleResult();
            d.setCompany(new CompanyDTO(cc));

            q = em.createNamedQuery("Administrator.loginAdmin", Administrator.class);
            q.setParameter("email", administrator.getEmail());
            q.setParameter("pswd", administrator.getPassword());
            q.setMaxResults(1);
            Administrator ad = (Administrator) q.getSingleResult();
            d.setAdministrator(new AdministratorDTO(ad));
            d.setEquipmentList(addCompanyEquipment(tc, administrator, dataUtil));
            d.setHelpTypeList(addInitialHelpTypes(cc));
            d.setRatingList(addInitialRatings(cc));
            d.setSkillList(addInitialSkills(cc));
            d.setSkillLevelList(addInitialSkillLevels(cc));

            log.log(Level.INFO, "Training Company registered OK");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found", e);
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding company", e);
            throw new DataException("Failed to register company\n" + dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    private List<SkillLevelDTO> addInitialSkillLevels(Company c) {
        SkillLevel sk1 = new SkillLevel();
        sk1.setCompany(c);
        sk1.setSkillLevelName("Beginner");
        sk1.setLevel(1);
        em.persist(sk1);

        SkillLevel sk2 = new SkillLevel();
        sk2.setCompany(c);
        sk2.setSkillLevelName("Intermediate");
        sk2.setLevel(2);
        em.persist(sk2);

        SkillLevel sk3 = new SkillLevel();
        sk3.setCompany(c);
        sk3.setSkillLevelName("Advanced");
        sk3.setLevel(3);
        em.persist(sk3);

        SkillLevel sk4 = new SkillLevel();
        sk4.setCompany(c);
        sk4.setSkillLevelName("Expert");
        sk4.setLevel(4);
        em.persist(sk4);

        SkillLevel sk5 = new SkillLevel();
        sk5.setCompany(c);
        sk5.setSkillLevelName("Guru");
        sk5.setLevel(5);
        em.persist(sk5);

        Query q = em.createNamedQuery("SkillLevel.findByCompany", SkillLevel.class);
        q.setParameter("id", c.getCompanyID());
        List<SkillLevel> list = q.getResultList();
        List<SkillLevelDTO> dtoList = new ArrayList<>();
        for (SkillLevel skillLevel : list) {
            dtoList.add(new SkillLevelDTO(skillLevel));
        }
        return dtoList;
    }

    private List<SkillDTO> addInitialSkills(Company c) {
        Skill s1 = new Skill();
        s1.setCompany(c);
        s1.setSkillName("Android Development");
        em.persist(s1);

        Skill s2 = new Skill();
        s2.setCompany(c);
        s2.setSkillName("Java Development");
        em.persist(s2);

        Skill s3 = new Skill();
        s3.setCompany(c);
        s3.setSkillName("Web Development");
        em.persist(s3);

        Query q = em.createNamedQuery("Skill.findByCompany", Skill.class);
        q.setParameter("id", c.getCompanyID());
        List<Skill> list = q.getResultList();
        List<SkillDTO> dtoList = new ArrayList<>();
        for (Skill skill : list) {
            dtoList.add(new SkillDTO(skill));
        }
        return dtoList;
    }

    private List<HelpTypeDTO> addInitialHelpTypes(Company c) {
        HelpType h1 = new HelpType();
        h1.setCompany(c);
        h1.setHelpTypeName("I do not understand");
        em.persist(h1);

        HelpType h2 = new HelpType();
        h2.setCompany(c);
        h2.setHelpTypeName("I have network problems");
        em.persist(h2);

        HelpType h3 = new HelpType();
        h3.setCompany(c);
        h3.setHelpTypeName("I have a problem with my computer");
        em.persist(h3);

        HelpType h4 = new HelpType();
        h4.setCompany(c);
        h4.setHelpTypeName("I have a problem with my tablet");
        em.persist(h4);

        HelpType h6 = new HelpType();
        h6.setCompany(c);
        h6.setHelpTypeName("My code is not working");
        em.persist(h6);

        Query q = em.createNamedQuery("HelpType.findByCompany", HelpType.class);
        q.setParameter("id", c.getCompanyID());
        List<HelpType> list = q.getResultList();
        List<HelpTypeDTO> dtoList = new ArrayList<>();
        for (HelpType ht : list) {
            dtoList.add(new HelpTypeDTO(ht));
        }
        return dtoList;
    }

    private List<RatingDTO> addInitialRatings(Company c) {

        Rating r = new Rating();
        r.setCompany(c);
        r.setRatingName("Did Not Present");
        r.setRatingNumber(0);
        em.persist(r);

        Rating r2 = new Rating();
        r2.setCompany(c);
        r2.setRatingName("Poor");
        r2.setRatingNumber(20);
        em.persist(r2);

        Rating r3 = new Rating();
        r3.setCompany(c);
        r3.setRatingName("Fair");
        r3.setRatingNumber(40);
        em.persist(r3);

        Rating r4 = new Rating();
        r4.setCompany(c);
        r4.setRatingName("Good");
        r4.setRatingNumber(60);
        em.persist(r4);
        Rating r5 = new Rating();
        r5.setCompany(c);
        r5.setRatingName("Very Good");
        r5.setRatingNumber(80);
        em.persist(r5);

        Rating r6 = new Rating();
        r6.setCompany(c);
        r6.setRatingName("Excellent");
        r6.setRatingNumber(100);
        em.persist(r6);

        Query q = em.createNamedQuery("Rating.findByCompany", Rating.class);
        q.setParameter("id", c.getCompanyID());
        List<Rating> list = q.getResultList();
        List<RatingDTO> dtoList = new ArrayList<>();
        for (Rating ht : list) {
            dtoList.add(new RatingDTO(ht));
        }
        return dtoList;

    }

    public ResponseDTO addAdministratorDevice(GcmDeviceDTO device,
            int administratorID, PlatformUtil platformUtil) throws DataException {
        //add device
        ResponseDTO resp = new ResponseDTO();
        try {
            GcmDevice gcm = new GcmDevice();
            gcm.setManufacturer(device.getManufacturer());
            gcm.setModel(device.getModel());
            gcm.setProduct(device.getProduct());
            gcm.setSerialNumber(device.getSerialNumber());
            gcm.setRegistrationID(device.getRegistrationID());
            gcm.setDateRegistered(new Date());
            gcm.setAdministrator(em.find(Administrator.class, administratorID));
            em.persist(gcm);

            CloudMessagingRegistrar.sendRegistration(device.getRegistrationID(), platformUtil);
            log.log(Level.INFO, "Device added for administrator");
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
            throw new DataException("Failed to add device");
        }
        return resp;
    }

    public ResponseDTO addAuthorDevice(GcmDeviceDTO device,
            int authorID, PlatformUtil platformUtil) throws DataException {
        //add device
        ResponseDTO resp = new ResponseDTO();
        try {
            GcmDevice gcm = new GcmDevice();
            gcm.setManufacturer(device.getManufacturer());
            gcm.setModel(device.getModel());
            gcm.setProduct(device.getProduct());
            gcm.setSerialNumber(device.getSerialNumber());
            gcm.setRegistrationID(device.getRegistrationID());
            gcm.setDateRegistered(new Date());
            gcm.setAuthor(em.find(Author.class, authorID));
            em.persist(gcm);

            CloudMessagingRegistrar.sendRegistration(device.getRegistrationID(), platformUtil);
            log.log(Level.INFO, "Device added for author");
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
            throw new DataException("Failed to add device");
        }
        return resp;
    }

    public ResponseDTO addInstructorDevice(GcmDeviceDTO device,
            int instructorID, PlatformUtil platformUtil) throws DataException {
        //add device
        ResponseDTO resp = new ResponseDTO();
        try {
            GcmDevice gcm = new GcmDevice();
            gcm.setManufacturer(device.getManufacturer());
            gcm.setModel(device.getModel());
            gcm.setProduct(device.getProduct());
            gcm.setSerialNumber(device.getSerialNumber());
            gcm.setRegistrationID(device.getRegistrationID());
            gcm.setDateRegistered(new Date());
            gcm.setInstructor(em.find(Instructor.class, instructorID));
            em.persist(gcm);

            CloudMessagingRegistrar.sendRegistration(device.getRegistrationID(), platformUtil);
            log.log(Level.INFO, "Device added for instructor");
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
            throw new DataException("Failed to add device");
        }
        return resp;
    }

    public ResponseDTO addTraineeDevice(GcmDeviceDTO device,
            int traineeID, PlatformUtil platformUtil) throws DataException {
        //add device
        ResponseDTO resp = new ResponseDTO();
        try {
            GcmDevice gcm = new GcmDevice();
            gcm.setManufacturer(device.getManufacturer());
            gcm.setModel(device.getModel());
            gcm.setProduct(device.getProduct());
            gcm.setSerialNumber(device.getSerialNumber());
            gcm.setRegistrationID(device.getRegistrationID());
            gcm.setDateRegistered(new Date());
            gcm.setTrainee(em.find(Trainee.class, traineeID));
            em.persist(gcm);

            CloudMessagingRegistrar.sendRegistration(device.getRegistrationID(), platformUtil);
            log.log(Level.INFO, "Device added for administrator");
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
            throw new DataException("Failed to add device");
        }
        return resp;
    }

    private List<HelpTypeDTO> addBasicHelpType(Company co,  DataUtil dataUtil) throws DataException {

        List<HelpTypeDTO> dtoList = new ArrayList<>();
        try {

            HelpType h1 = new HelpType();
            h1.setCompany(co);
            h1.setHelpTypeName("I do not understand");
            //
            HelpType h2 = new HelpType();
            h2.setCompany(co);
            h2.setHelpTypeName("I have an equipment problem");
            //
            HelpType h3 = new HelpType();
            h3.setCompany(co);
            h3.setHelpTypeName("I have a network problem");
            //
            HelpType h4 = new HelpType();
            h4.setCompany(co);
            h4.setHelpTypeName("I have an electric power problem");
            //

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add base helpType to company", e);
            throw new DataException("Failed to add base helpType to company\n" + dataUtil.getErrorString(e));
        }

        return dtoList;
    }

    private List<RatingDTO> addBasicRating(Company co, DataUtil dataUtil)
            throws DataException {

        List<RatingDTO> dtoList = new ArrayList<>();
        try {

            Rating r1 = new Rating();
            r1.setRatingName("Excellent");
            r1.setRatingNumber(100);
            r1.setCompany(co);
            //
            Rating r2 = new Rating();
            r2.setRatingName("Very Good");
            r2.setRatingNumber(80);
            r2.setCompany(co);
            //
            Rating r3 = new Rating();
            r3.setRatingName("Good");
            r3.setRatingNumber(60);
            r3.setCompany(co);
            //
            Rating r4 = new Rating();
            r4.setRatingName("Fair");
            r4.setRatingNumber(40);
            r4.setCompany(co);
            //
            Rating r5 = new Rating();
            r5.setRatingName("Poor");
            r5.setRatingNumber(20);
            r5.setCompany(co);
            //

            dtoList.add(new RatingDTO(r1));
            dtoList.add(new RatingDTO(r2));
            dtoList.add(new RatingDTO(r3));
            dtoList.add(new RatingDTO(r4));
            dtoList.add(new RatingDTO(r5));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add base rating to company", e);
            throw new DataException("Failed to add base rating to company\n" + dataUtil.getErrorString(e));
        }

        return dtoList;
    }

    private List<EquipmentDTO> addCompanyEquipment(
            Company tc, Administrator adm, DataUtil dataUtil) throws DataException {

        List<EquipmentDTO> dtoList = new ArrayList<>();
        try {

            Equipment eq = new Equipment();
            eq.setAdministrator(adm);
            eq.setCompany(tc);
            eq.setEquipmentName("Server Computer");
            em.persist(eq);
            //
            Equipment eq1 = new Equipment();
            eq1.setAdministrator(adm);
            eq1.setCompany(tc);
            eq1.setEquipmentName("Desktop Computer");
            em.persist(eq1);
            //
            Equipment eq2 = new Equipment();
            eq2.setAdministrator(adm);
            eq2.setCompany(tc);
            eq2.setEquipmentName("Projector");
            em.persist(eq2);
            //
            Equipment eq3 = new Equipment();
            eq3.setAdministrator(adm);
            eq3.setCompany(tc);
            eq3.setEquipmentName("Whiteboard");
            em.persist(eq3);
            Equipment eq4 = new Equipment();
            eq4.setAdministrator(adm);
            eq4.setCompany(tc);
            eq4.setEquipmentName("Laptop Computer");
            em.persist(eq4);
            Equipment eq5 = new Equipment();
            eq5.setAdministrator(adm);
            eq5.setCompany(tc);
            eq5.setEquipmentName("Tablet");
            em.persist(eq5);
            //
            Equipment eq6 = new Equipment();
            eq6.setAdministrator(adm);
            eq6.setCompany(tc);
            eq6.setEquipmentName("Smartphone");
            em.persist(eq6);
            //
            Equipment eq7 = new Equipment();
            eq7.setAdministrator(adm);
            eq7.setCompany(tc);
            eq7.setEquipmentName("Feature Phone");
            em.persist(eq7);
            //
            Equipment eq8 = new Equipment();
            eq8.setAdministrator(adm);
            eq8.setCompany(tc);
            eq8.setEquipmentName("WIFI Router");
            em.persist(eq8);
            //
            Equipment eq9 = new Equipment();
            eq9.setAdministrator(adm);
            eq9.setCompany(tc);
            eq9.setEquipmentName("Display Monitor");
            em.persist(eq9);
            //
            Equipment eq10 = new Equipment();
            eq10.setAdministrator(adm);
            eq10.setCompany(tc);
            eq10.setEquipmentName("Stationery");
            em.persist(eq10);

            Query q = em.createNamedQuery("Equipment.findByAdmin");
            q.setParameter("adm", adm);
            List<Equipment> lsList = q.getResultList();
            dtoList = new ArrayList<>();
            for (Equipment l : lsList) {
                dtoList.add(new EquipmentDTO(l));
            }
            //log.log(Level.INFO, "Equipment records added : {0} - added: {1}",
            //      new Object[]{tc.getCompanyName(), dtoList.size()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding equipment", e);
            throw new DataException("Failed to add company equipment\n" + dataUtil.getErrorString(e));

        }
        return dtoList;
    }

    public Company getCompanyByID(int id) {

        Company c = em.find(Company.class, id);
        return c;
    }

    private List<TrainingClass> getTrainingClasses(int companyID) {

        Query q = em.createNamedQuery("TrainingClass.findByCompanyID");
        q.setParameter("id", companyID);
        List<TrainingClass> list = q.getResultList();
        return list;
    }

    private List<Equipment> getEquipment(int companyID) {

        Query q = em.createNamedQuery("Equipment.findByCompanyID");
        q.setParameter("id", companyID);
        List<Equipment> list = q.getResultList();
        return list;
    }

    private List<Instructor> getInstructors(int companyID) {

        Query q = em.createNamedQuery("Instructor.findByCompanyID", Instructor.class);
        q.setParameter("id", companyID);
        List<Instructor> list = q.getResultList();
        return list;
    }

    private List<Administrator> getAdmins(int companyID) {

        Query q = em.createNamedQuery("Administrator.findByCompanyID");
        q.setParameter("id", companyID);
        List<Administrator> list = q.getResultList();
        return list;
    }

    private List<Trainee> getTrainees(int companyID) {

        Query q = em.createNamedQuery("Trainee.findByCompany", Trainee.class);
        q.setParameter("id", companyID);
        List<Trainee> list = q.getResultList();
        return list;
    }

    private List<TrainingClassCourse> getTrainingClassCoursesByCompany(int companyID) {

        Query q = em.createNamedQuery("TrainingClassCourse.findByCompanyID", TrainingClassCourse.class);
        q.setParameter("id", companyID);
        List<TrainingClassCourse> tcList = q.getResultList();
        return tcList;
    }

    private List<Trainee> getTraineesByClass(int trainingClassID) {

        Query q = em.createNamedQuery("Trainee.findByClass", Trainee.class);
        q.setParameter("id", trainingClassID);
        List<Trainee> list = q.getResultList();
        return list;
    }

    private List<Author> getAuthors(int companyID) {
        Query q = em.createNamedQuery("Author.findByCompany", Author.class);
        q.setParameter("id", companyID);
        List<Author> list = q.getResultList();
        return list;
    }

    private List<Province> getProvinces(Company c) {

        Country country = c.getCity().getProvince().getCountry();
        Query q = em.createNamedQuery("Province.findByCountry", Province.class);
        q.setParameter("c", country);
        List<Province> list = q.getResultList();
        return list;
    }

    private List<InstructorClass> getInstructorClasses(Company c) {

        Query q = em.createNamedQuery("InstructorClass.findByCompany", InstructorClass.class);
        q.setParameter("id", c.getCompanyID());
        List<InstructorClass> list = q.getResultList();
        return list;
    }

    private List<CourseAuthor> getCourseAuthorList(int companyID, DataUtil dataUtil) {
        Query q = em.createNamedQuery("CourseAuthor.findByCompany", CourseAuthor.class);
        q.setParameter("id", companyID);
        List<CourseAuthor> list = q.getResultList();
        return list;
    }

    public ResponseDTO getCompanyData(int companyID, DataUtil dataUtil)
            throws DataException {
        log.log(Level.OFF, "getCompanyData - companyID: {0}", companyID);
        ResponseDTO d = new ResponseDTO();
        long start = System.currentTimeMillis();

        try {
            Company co = dataUtil.getCompanyByID(companyID);
            if (co != null) {
                List<Author> aList = getAuthors(companyID);
                d.setAuthorList(new ArrayList<AuthorDTO>());

                List<CourseAuthor> caList = getCourseAuthorList(companyID, dataUtil);
                for (Author author : aList) {
                    AuthorDTO adto = new AuthorDTO(author);
                    adto.setCourseList(new ArrayList<CourseDTO>());
                    for (CourseAuthor ca : caList) {
                        if (ca.getAuthor() == author) {
                            CourseDTO crs = new CourseDTO(ca.getCourse());
                            crs.setDescription(null);
                            adto.getCourseList().add(crs);
                        }
                    }
                    d.getAuthorList().add(adto);

                }

                List<Trainee> trList = getTrainees(companyID);
                log.log(Level.OFF, "TraineeList for company: {0}", trList.size());
                List<TrainingClassCourse> tcc = getTrainingClassCoursesByCompany(companyID);

                d.setTrainingClassList(new ArrayList<TrainingClassDTO>());
                for (TrainingClass tc : getTrainingClasses(companyID)) {
                    log.log(Level.OFF, "TrainingClass: {0} trainees: {1}", new Object[]{tc.getTrainingClassName(), tc.getTraineeList().size()});

                    TrainingClassDTO tcDTO = new TrainingClassDTO(tc);
                    tcDTO.setTraineeList(new ArrayList<TraineeDTO>());
                    tcDTO.setTrainingClassCourseList(new ArrayList<TrainingClassCourseDTO>());

                    for (Trainee trainee : trList) {
                        if (trainee.getTraineeID() > 150) {
                            //log.log(Level.OFF, "#### {0} trainingClassID: {1} compare to: {2}", new Object[]{trainee.getFirstName(), trainee.getTrainingClass().getTrainingClassID(), tc.getTrainingClassID()});
                        }
                        if (trainee.getTrainingClass().getTrainingClassID() == tc.getTrainingClassID()) {
                            tcDTO.getTraineeList().add(new TraineeDTO(trainee));
                            // log.log(Level.INFO, "Trainee added to list: {0} {1}", new Object[]{trainee.getFirstName(), trainee.getLastName()});
                        }
                    }
                    for (TrainingClassCourse x : tcc) {
                        if (x.getTrainingClass().getTrainingClassID() == tc.getTrainingClassID()) {
                            tcDTO.getTrainingClassCourseList().add(new TrainingClassCourseDTO(x));
                        }
                    }

                    d.getTrainingClassList().add(tcDTO);
                }

                ResponseDTO r = getInventoryList(companyID, dataUtil);
                List<InventoryDTO> invList = r.getInventoryList();
                d.setEquipmentList(new ArrayList<EquipmentDTO>());
                for (Equipment e : getEquipment(companyID)) {
                    EquipmentDTO edto = new EquipmentDTO(e);
                    edto.setInventoryList(new ArrayList<InventoryDTO>());
                    for (InventoryDTO inv : invList) {
                        if (inv.getEquipment().getEquipmentID() == e.getEquipmentID()) {
                            edto.getInventoryList().add(inv);
                        }
                    }

                    d.getEquipmentList().add(edto);
                }

                List<InstructorClass> icList = getInstructorClasses(co);
                d.setInstructorList(new ArrayList<InstructorDTO>());
                for (Instructor i : getInstructors(companyID)) {
                    InstructorDTO iDTO = new InstructorDTO(i);
                    iDTO.setInstructorClassList(new ArrayList<InstructorClassDTO>());
                    for (InstructorClass ic : icList) {
                        if (ic.getInstructor().getInstructorID() == i.getInstructorID()) {
                            iDTO.getInstructorClassList().add(new InstructorClassDTO(ic));
                        }
                    }
                    d.getInstructorList().add(iDTO);
                }
                d.setAdministratorList(new ArrayList<AdministratorDTO>());
                for (Administrator adm : getAdmins(companyID)) {
                    d.getAdministratorList().add(new AdministratorDTO(adm));

                }
                d.setCategoryList(new ArrayList<CategoryDTO>());
                for (Category category : co.getCategoryList()) {
                    d.getCategoryList().add(new CategoryDTO(category));
                }
                ResponseDTO xx = dataUtil.getRatingAndHelpList(companyID);
                d.setRatingList(xx.getRatingList());
                d.setHelpTypeList(xx.getHelpTypeList());
                Query q = em.createNamedQuery("Skill.findByCompany", Skill.class);
                q.setParameter("id", companyID);
                List<Skill> skills = q.getResultList();
                d.setSkillList(new ArrayList<SkillDTO>());
                for (Skill x : skills) {
                    d.getSkillList().add(new SkillDTO(x));
                }
                q = em.createNamedQuery("SkillLevel.findByCompany", SkillLevel.class);
                q.setParameter("id", companyID);
                List<SkillLevel> skillsx = q.getResultList();
                d.setSkillLevelList(new ArrayList<SkillLevelDTO>());
                for (SkillLevel x : skillsx) {
                    d.getSkillLevelList().add(new SkillLevelDTO(x));
                }
                long end = System.currentTimeMillis();
                log.log(Level.INFO, "Retrieved company data: {0} - elapsed = {1} milliseconds",
                        new Object[]{co.getCompanyName(), end - start});
            } else {
                d.setStatusCode(ResponseDTO.ERROR_DATABASE);
                d.setMessage("Training Company has not found.");
                log.log(Level.WARNING, "Training Company not found");
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed getCompanyData", e);
            throw new DataException("Failed getCompanyData\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updatePassword(int id, int type, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        d.setCredential(dataUtil.getPassword(id, type));
        d.setMessage("Password updated");

        return d;
    }

    public ResponseDTO loginAdministrator(
            String email, String password, GcmDeviceDTO device,
            PlatformUtil platformUtil, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        EntityTransaction tran;
        try {
            Query q = em.createNamedQuery("Administrator.loginAdmin", Administrator.class);
            q.setParameter("email",email);
            q.setParameter("pswd", password);
            q.setMaxResults(1);
            Administrator a = (Administrator) q.getSingleResult();

            if (a != null) {
                int id = a.getCompany().getCompanyID();
                log.log(Level.INFO, "company id from admin login: {0}", id);
                d = getCompanyData(id, dataUtil);

                d.setAdministrator(new AdministratorDTO(a));
                d.setCompany(new CompanyDTO(a.getCompany()));

                d.setMessage(dataUtil.OK_MESSAGE);
            } else {
                d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
                d.setMessage(dataUtil.ERROR_MESSAGE);
            }

        } catch (NoResultException e) {
            d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
            d.setMessage("Email or password is invalid. Sign in rejected.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to login admin", e);
            throw new DataException("Failed to login admin\n" + dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO registerAdministrator(
            AdministratorDTO admin, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Administrator administrator = new Administrator();
            administrator.setFirstName(admin.getFirstName());
            administrator.setLastName(admin.getLastName());
            administrator.setEmail(admin.getEmail());
            administrator.setCellphone(admin.getCellphone());
            administrator.setCompany(dataUtil.getCompanyByID(admin.getCompanyID()));
            administrator.setPassword(dataUtil.createPassword());
            administrator.setDateRegistered(new Date());
            em.persist(administrator);

            Query q = em.createNamedQuery("Administrator.findByCompanyID", Administrator.class);
            q.setParameter("id", administrator.getCompany().getCompanyID());
            List<Administrator> list = q.getResultList();
            d.setAdministratorList(new ArrayList<AdministratorDTO>());
            for (Administrator x : list) {
                d.getAdministratorList().add(new AdministratorDTO(x));
            }

            d.setCompany(new CompanyDTO(administrator.getCompany()));
            d.setEquipmentList(getCompanyEquipment(administrator.getCompany()));
            log.log(Level.INFO, "Admin registered");
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("An Administrator with this email already exists. "
                    + "\nPlease check or use a different email address.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding register admin", e);
            throw new DataException("Failed to register administrator\n"
                    + dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    private List<EquipmentDTO> getCompanyEquipment(Company c) {

        Query q = em.createNamedQuery("Equipment.findByCompanyID");
        q.setParameter("id", c.getCompanyID());
        List<Equipment> list = q.getResultList();
        List<EquipmentDTO> dto = new ArrayList<>();
        for (Equipment equipment : list) {
            dto.add(new EquipmentDTO(equipment));
        }
        return dto;

    }

    public ResponseDTO deactivateTrainee(TraineeDTO trainee, int administrationID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Trainee tc = dataUtil.getTraineeByID(trainee.getTraineeID());
            Administrator adm = dataUtil.getAdministratorByID(administrationID);

            tc.setActiveFlag(1);
            tc.setAdministrator(adm);
            em.merge(tc);

            d.setMessage("Trainee deactivated");
            //log.log(Level.INFO, "Trainee deactivated {0} {1}", new Object[]{tc.getFirstName(), tc.getLastName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update trainee", e);
            throw new DataException("Failed to update trainee\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO deactivateInstructor(InstructorDTO instructor, int administrationID
    , DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Instructor tc = dataUtil.getInstructorByID(instructor.getInstructorID());
            Administrator adm = dataUtil.getAdministratorByID(administrationID);

            tc.setActiveFlag(1);
            tc.setAdministrator(adm);
            em.merge(tc);

            d.setMessage("Instructor deactivated");
            //log.log(Level.INFO, "Instructor deactivated {0} {1}", new Object[]{tc.getFirstName(), tc.getLastName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update instructor", e);
            throw new DataException("Failed to update instructor\n" + dataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    /**
     * Add Lesson schedules for a specific training class
     *
     * @param trainingClassID
     * @param scheduleList
     * @return
     * @throws DataException
     */
    public ResponseDTO addSchedule(int trainingClassID,
            List<LessonScheduleDTO> scheduleList, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            //log.log(Level.INFO, "");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add schedule", e);
            throw new DataException(dataUtil.getErrorString(e));
        }

        return d;
    }
}
