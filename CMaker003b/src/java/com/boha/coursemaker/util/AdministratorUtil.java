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
import com.boha.coursemaker.data.Lesson;
import com.boha.coursemaker.data.Province;
import com.boha.coursemaker.data.Rating;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.data.TraineeEquipment;
import com.boha.coursemaker.data.TrainingClass;
import com.boha.coursemaker.data.TrainingClassCourse;
import com.boha.coursemaker.dto.AdministratorDTO;
import com.boha.coursemaker.dto.AuthorDTO;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CityDTO;
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
import com.boha.coursemaker.dto.ProvinceDTO;
import com.boha.coursemaker.dto.RatingDTO;
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
import javax.persistence.RollbackException;

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

    public ResponseDTO addHelpType(HelpTypeDTO helpType)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            HelpType t = new HelpType();
            t.setHelpTypeName(helpType.getHelpTypeName());
            t.setCompany(DataUtil.getCompanyByID(helpType.getCompanyID(), em));
            em.persist(t);
            //TODO - get list
            d.setHelpTypeList(new ArrayList<HelpTypeDTO>());
            d.getHelpTypeList().add(new HelpTypeDTO(t));
            d.setMessage("HelpType added");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add helptype", e);
            throw new DataException("Failed to add helptype\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteHelpType(HelpTypeDTO rating)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            HelpType t = DataUtil.getHelpTypeByID(rating.getHelpTypeID(), em);
            em.remove(t);
            d.setMessage("HelpType deleted");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update helptype", e);
            throw new DataException("Failed to update helptype\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO updateHelpType(HelpTypeDTO helpType)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            HelpType t = DataUtil.getHelpTypeByID(helpType.getHelpTypeID(), em);
            t.setHelpTypeName(helpType.getHelpTypeName());

            em.merge(t);

            d.setHelpTypeList(new ArrayList<HelpTypeDTO>());
            d.getHelpTypeList().add(new HelpTypeDTO(t));
            d.setMessage("HelpType updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update helptype", e);

            throw new DataException("Failed to update helptype\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addRating(RatingDTO rating)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            Rating t = new Rating();
            t.setRatingName(rating.getRatingName());
            t.setRatingNumber(rating.getRatingNumber());
            t.setCompany(DataUtil.getCompanyByID(rating.getCompanyID(), em));

            em.persist(t);

            d.setRatingList(new ArrayList<RatingDTO>());
            d.getRatingList().add(new RatingDTO(t));
            d.setMessage("Rating added");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add rating", e);
            throw new DataException("Failed to add rating\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateRating(RatingDTO rating)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            Rating t = DataUtil.getRatingByID(rating.getRatingID(), em);
            t.setRatingName(rating.getRatingName());
            t.setRatingNumber(rating.getRatingNumber());

            em.merge(t);

            d.setRatingList(new ArrayList<RatingDTO>());
            d.getRatingList().add(new RatingDTO(t));
            d.setMessage("Rating updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update rating", e);
            throw new DataException("Failed to update rating\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteRating(RatingDTO rating)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            Rating t = DataUtil.getRatingByID(rating.getRatingID(), em);

            em.remove(t);

            d.setMessage("Rating deleted");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to delete rating", e);
            throw new DataException("Failed to delete rating\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateTrainee(TraineeDTO trainee,
            Integer trainingClassID, Integer cityID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            Trainee t = DataUtil.getTraineeByID(trainee.getTraineeID(), em);
            t.setFirstName(trainee.getFirstName());
            t.setLastName(trainee.getLastName());
            t.setCellphone(trainee.getCellphone());
            t.setEmail(trainee.getEmail());
            t.setGender(trainee.getGender());
            t.setCity(DataUtil.getCityByID(cityID, em));
            t.setTrainingClass(DataUtil.getTrainingClassByID(trainingClassID, em));

            em.merge(t);

            d.setTrainee(new TraineeDTO(t));
            d.setMessage("Trainee updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update trainee", e);
            throw new DataException("Failed to update trainee\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteClass(Integer trainingClassID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {

            TrainingClass t = DataUtil.getTrainingClassByID(trainingClassID, em);
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
            throw new DataException("Failed to delete class\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateClass(TrainingClassDTO trainingClass)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            TrainingClass t = DataUtil.getTrainingClassByID(trainingClass.getTrainingClassID(), em);
            t.setTrainingClassName(trainingClass.getTrainingClassName());
            t.setStartDate(new Date(trainingClass.getStartDate()));
            t.setEndDate(new Date(trainingClass.getEndDate()));
            t.setIsOpen(trainingClass.getIsOpen());


            em.merge(t);

            d.setMessage("Class updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update class", e);
            throw new DataException("Failed to update class\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateInstructor(InstructorDTO instructor)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {


            Instructor t = DataUtil.getInstructorByID(instructor.getInstructorID(), em);
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
            throw new DataException("Failed to update instructor\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateAuthor(AuthorDTO author)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {


            Author t = DataUtil.getAuthorByID(author.getAuthorID(), em);
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
            throw new DataException("Failed to update author\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateAdmin(AdministratorDTO admin)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {


            Administrator t = DataUtil.getAdministratorByID(admin.getAdministratorID(), em);
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
            throw new DataException("Failed to update admin\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addTrainee(TraineeDTO trainee,
            Integer trainingClassID, Integer cityID, TraineeUtil traineeUtil)
            throws DataException {

        ResponseDTO r = traineeUtil.registerTrainee(trainee, trainingClassID, cityID);

        return r;
    }

    public ResponseDTO addAuthor(AuthorDTO author,
            Integer companyID, AuthorUtil authorUtil)
            throws DataException {
        ResponseDTO r = authorUtil.registerAuthor(author, companyID);

        return r;
    }

    public ResponseDTO addInstructor(InstructorDTO instructor,
            Integer trainingClassID, Integer cityID, InstructorUtil instructorUtil)
            throws DataException {

        ResponseDTO r = instructorUtil.registerInstructor(instructor);

        return r;
    }

    public ResponseDTO addAdministrator(AdministratorDTO admin)
            throws DataException {

        ResponseDTO r = registerAdministrator(admin);

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
    public ResponseDTO addClassCourses(Integer trainingClassID,
            List<CourseDTO> companyCourses,
            List<Integer> flags) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);

            int index = 0, cnt = 0, ign = 0;
            for (CourseDTO tcx : companyCourses) {
                if (!checkIfExists(trainingClassID, tcx.getCourseID())) {
                    TrainingClassCourse tcc = new TrainingClassCourse();
                    tcc.setTrainingClass(tc);
                    tcc.setCourse(DataUtil.getCourseByID(tcx.getCourseID(), em));
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
                Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID",TrainingClassCourse.class);
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
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException("Failed to add class courses\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO assignInstructorClass(
            Integer instructorID, Integer trainingClassID) throws DataException {
        ResponseDTO resp = new ResponseDTO();


        try {
            Instructor instructor = DataUtil.getInstructorByID(instructorID, em);
            TrainingClass trainingClass = DataUtil.getTrainingClassByID(trainingClassID, em);

            InstructorClass ic = new InstructorClass();
            ic.setDateRegistered(new Date());
            ic.setInstructor(instructor);
            ic.setTrainingClass(trainingClass);

            em.persist(ic);

            //log.log(Level.INFO, "Class assigned to instructor {0} {1} - {2}",
            //      new Object[]{instructor.getFirstName(), instructor.getLastName(),
            //trainingClass.getTrainingClassName()});
            Query q = em.createNamedQuery("InstructorClass.findByInstructorID",InstructorClass.class);
            q.setParameter("id", instructor.getInstructorID());
            List<InstructorClass> list = q.getResultList();
            List<InstructorClassDTO> dto = new ArrayList<>();
            for (InstructorClass instructorClass : list) {
                dto.add(new InstructorClassDTO(instructorClass));
            }
            resp.setInstructorClassList(dto);
            //log.log(Level.INFO, "Instructor has {0} classes assigned", dto.size());
        } catch (RollbackException e) {
            resp.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            resp.setMessage("Possible duplicate");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to assign class to instructor", e);
            throw new DataException("Failed to assign class to instructor\n" + DataUtil.getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO assignClassCoursesToTrainees(Integer trainingClassID)
            throws DataException {
        ResponseDTO resp = new ResponseDTO();


        Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
        
        q.setParameter("id", trainingClassID);
        List<TrainingClassCourse> list = q.getResultList();
        //log.log(Level.INFO, "TrainingClassCourses found: {0}", list.size());
        int cntTr = 0, cntAc = 0;
        List<Trainee> traineeList = getTraineesByClass(trainingClassID);

        try {
            for (TrainingClassCourse tcc : list) {
                List<Lesson> lessonList = getCourseLessons(tcc.getCourse(), em);
                for (Trainee trainee : traineeList) {
                    if (!checkIfEnrolmentExists(trainee, tcc)) {
                        CourseTrainee ct = new CourseTrainee();
                        ct.setTrainee(trainee);
                        ct.setTrainingClassCourse(tcc);
                        ct.setDateEnrolled(new Date());

                        em.persist(ct);

                        //log.log(Level.INFO, "Added CourseTrainee - {0} {1} - {2}", new Object[]{trainee.getFirstName(), trainee.getLastName(), tcc.getCourse().getCourseName()});
                        //write activities ...

                        for (Lesson lesson : lessonList) {
                            List<Activity> aList = getLessonActivities(lesson, em);
                            for (Activity activity : aList) {
                                if (!checkIfCTAExists(ct, activity)) {
                                    CourseTraineeActivity cta = new CourseTraineeActivity();
                                    cta.setCourseTrainee(ct);
                                    cta.setActivity(activity);
                                    cta.setLesson(lesson);
                                    cta.setDateUpdated(new Date());
                                    em.persist(cta);
                                    //log.log(Level.INFO, "Enrolled activity {0} {1} - {2}", new Object[]{trainee.getFirstName(), trainee.getLastName(), activity.getActivityName()});
                                }

                            }
                        }

                    }
                }

                //log.log(Level.INFO, "Trainees enrolled: {0} - activities: {1}", new Object[]{cntTr, cntAc});
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to assign courses to class", e);
            throw new DataException("Failed to assign courses to class\n" + DataUtil.getErrorString(e));
        }
        //resp.setTrainingClassCourseList(gList);
        return resp;
    }

   

    public List<Lesson> getCourseLessons(Course c, EntityManager em) {
        Query q = em.createNamedQuery("Lesson.findByCourse", Lesson.class);
        q.setParameter("id", c.getCourseID());
        List<Lesson> list = q.getResultList();
        return list;
    }

    public List<Activity> getLessonActivities(Lesson c, EntityManager em) {
        Query q = em.createNamedQuery("Activity.findByLesson", Activity.class);
        q.setParameter("id", c.getLessonID());
        List<Activity> list = q.getResultList();
        return list;
    }

    private boolean checkIfCTAExists(CourseTrainee ct, Activity a) {
        boolean found = false;

        Query q = em.createNamedQuery("CourseTraineeActivity.checkIfExists",CourseTraineeActivity.class);
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


    private boolean checkIfExists(Integer trainingClassID, Integer courseID) {
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
    public ResponseDTO enrollClassTrainees(Integer administratorID, Integer trainingClassID,
            List<TraineeDTO> traineeList) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);

            for (TraineeDTO dto : traineeList) {
                Trainee t = DataUtil.getTraineeByID(dto.getTraineeID(), em);
                t.setTrainingClass(tc);
                t.setAdministrator(adm);

                em.merge(t);

            }


            //log.log(Level.INFO, "Trainees registered into class: {0}", tc.getTrainingClassName());
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add class trainees", e);
            throw new DataException("Failed to add class trainees\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO getHelpRequestListByPeriod(
            Integer trainingClassID, long startDate, long endDate) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {


            Query q = em.createNamedQuery("HelpRequest.findByClassPeriod",HelpRequest.class);
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInventoryListByClass(Integer trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {


            Query q = em.createNamedQuery("TraineeEquipment.findByTrainingClassID",TraineeEquipment.class);
            q.setParameter("id", trainingClassID);
            List<TraineeEquipment> list = q.getResultList();
            List<TraineeEquipmentDTO> dto = new ArrayList<>();
            for (TraineeEquipment inv : list) {
                dto.add(new TraineeEquipmentDTO(inv));
            }
            d.setTraineeEquipmentList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInventoryList(Integer trainingCompanyID) throws DataException {
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getEquipmentList(Integer trainingCompanyID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Equipment.findByCompanyID",Equipment.class);
            q.setParameter("id", trainingCompanyID);
            List<Equipment> list = q.getResultList();
            List<EquipmentDTO> dto = new ArrayList<>();
            ResponseDTO r = getInstructorList(trainingCompanyID);
            for (Equipment equipment : list) {
                EquipmentDTO eDTO = new EquipmentDTO(equipment);
                eDTO.setInventoryList(new ArrayList<InventoryDTO>());
                for (InventoryDTO i : r.getInventoryList()) {
                    if (i.getEquipment().getEquipmentID().intValue() == equipment.getEquipmentID().intValue()) {
                        eDTO.getInventoryList().add(i);
                    }
                }
                dto.add(eDTO);
            }
            d.setEquipmentList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
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
    public ResponseDTO registerClass(Integer companyID,
            TrainingClassDTO tClass, Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Company tc = DataUtil.getCompanyByID(companyID, em);
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);
            TrainingClass cls = new TrainingClass();
            cls.setCompany(tc);
            cls.setAdministrator(adm);
            cls.setIsOpen(Integer.valueOf(1));
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
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register class", e);
            throw new DataException("Failed to register class\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO updateInventory(InventoryDTO inventory,
            Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);
            Inventory te = DataUtil.getInventoryByID(inventory.getInventoryID(), em);
            te.setConditionFlag(inventory.getConditionFlag());
            te.setDateUpdated(new Date());
            te.setModel(inventory.getModel());
            te.setSerialNumber(inventory.getSerialNumber());
            te.setYearPurchased(inventory.getYearPurchased());
            te.setAdministrator(adm);

            em.merge(te);

            d.setInventory(new InventoryDTO(te));
            //log.log(Level.INFO, "inventory updated");
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update inventory", e);
            throw new DataException("Failed to update inventory\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO addEquipment(EquipmentDTO equipment,
            Integer companyID, Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            Company tc = DataUtil.getCompanyByID(companyID, em);
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);
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
                    if (inv.getEquipment().getEquipmentID().intValue() == e.getEquipmentID().intValue()) {
                        eDTO.getInventoryList().add(new InventoryDTO(inv));
                    }
                }
                d.getEquipmentList().add(eDTO);
            }


        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding equipment", e);
            throw new DataException("Failed to add equipment\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO updateEquipment(EquipmentDTO equipment,
            Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);
            Equipment te = DataUtil.getEquipmentByID(equipment.getEquipmentID(), em);
            te.setEquipmentName(equipment.getEquipmentName());
            te.setAdministrator(adm);

            em.merge(te);

            d.setEquipment(new EquipmentDTO(te));
            //log.log(Level.INFO, "inventory updated");
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** upd equipment", e);
            throw new DataException("Failed to update equipment\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO addInventory(InventoryDTO inventory,
            Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            Equipment tc = DataUtil.getEquipmentByID(inventory.getEquipment().getEquipmentID(), em);
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);

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
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding inventory", e);
            throw new DataException("Failed to add inventory\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO addTraineeEquipment(
            Integer traineeID, Integer inventoryID, Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {
            Trainee tc = DataUtil.getTraineeByID(traineeID, em);
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);
            TraineeEquipment te = new TraineeEquipment();
            te.setAdministrator(adm);
            te.setDateRegistered(new Date());
            te.setInventory(DataUtil.getInventoryByID(inventoryID, em));
            te.setTrainee(tc);

            em.persist(te);

            ResponseDTO r = getTraineeEquipmentListByInventory(inventoryID);
            d.setTraineeEquipmentList(r.getTraineeEquipmentList());
            log.log(Level.INFO, "Trainee equipment added");
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding addTraineeEquipment", e);
            throw new DataException("Failed to add TraineeEquipment\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }
    
    public ResponseDTO updateTraineeEquipment(
            Integer traineeEquipmentID, Integer conditionFlag,
            boolean isReturn, Integer administratorID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            TraineeEquipment te = DataUtil.getTraineeEquipmentByID(
                    traineeEquipmentID, em);
            Administrator adm = DataUtil.getAdministratorByID(administratorID, em);

            te.setAdministrator(adm);
            if (conditionFlag != null) {
                te.setConditionFlag(conditionFlag);
            }
            if (isReturn) {
                te.setDateReturned(new Date());
            }
            em.merge(te);

            ResponseDTO r = getTraineeEquipmentListByInventory(te.getInventory().getInventoryID());
            d.setTraineeEquipmentList(r.getTraineeEquipmentList());
            d.setMessage("updateTraineeEquipment OK");

            log.log(Level.INFO, "Trainee equipment updated");
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update TraineeEquipment", e);
            throw new DataException("Failed to update TraineeEquipment\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO getEquipmentInventory(
            Integer equipmentID) throws DataException {
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    

    public ResponseDTO getTraineeEquipmentListByEquipmentID(
            Integer equipmentID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByEquipmentID",TraineeEquipment.class);
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getTraineeEquipmentListByInventory(
            Integer inventoryID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByInventoryID",TraineeEquipment.class);
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getTraineeEquipmentListByClass(
            Integer trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TraineeEquipment.findByTrainingClassID",TraineeEquipment.class);
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
            throw new DataException(DataUtil.getErrorString(e));
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
            Integer trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("Trainee.findByClass",Trainee.class);
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
            throw new DataException(DataUtil.getErrorString(e));
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
            Integer trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID",TrainingClassCourse.class);
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInstructorList(
            Integer companyID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {            
            Query q = em.createNamedQuery("Instructor.findByCompanyID",Instructor.class);
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
            throw new DataException(DataUtil.getErrorString(e));
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
            Integer trainingClassCourseID) throws DataException {
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
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Create training company or entity. In addition, create super
     * Administrator and the first Author and Instructor
     *
     * @param company
     * @param admin
     * @return
     * @throws DataException
     */
    public ResponseDTO registerCompany(CompanyDTO company, AdministratorDTO admin,
            GcmDeviceDTO device, PlatformUtil platformUtil)
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
                city = DataUtil.getCityByID(company.getCity().getCityID(), em);
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
            d.setRatingList(addBasicRating(tc, em));
            d.setHelpTypeList(addBasicHelpType(tc, em));
            //add device

            if (device != null) {

                GcmDevice gcm = new GcmDevice();
                gcm.setManufacturer(device.getManufacturer());
                gcm.setModel(device.getModel());
                gcm.setProduct(device.getProduct());
                gcm.setSerialNumber(device.getSerialNumber());
                gcm.setRegistrationID(device.getRegistrationID());

                gcm.setAdministrator(administrator);
                em.persist(gcm);

                //log.log(Level.INFO, "Device added for administrator");
                ResponseDTO x = CloudMessagingRegistrar.sendRegistration(device.getRegistrationID(), platformUtil);
                if (x.getStatusCode() > 0) {
                    d.setStatusCode(x.getStatusCode());
                    d.setMessage(x.getMessage());
                }
            }
            //
            //d.setCategoryList(AuthorUtil.addInitialCategories(tc.getCompanyID(), em));
            d.setCompany(new CompanyDTO(tc));
            d.setAdministrator(new AdministratorDTO(administrator));
            d.setEquipmentList(addCompanyEquipment(tc, administrator, em));
            //log.log(Level.INFO, "Training Company registered OK");
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found", e);
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Possible duplicate attempted. Ignored.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding company", e);
            throw new DataException("Failed to register company\n" + DataUtil.getErrorString(e));
        } finally {
        }

        //log.log(Level.INFO, "registerCompany done, about to return");
        return d;
    }

    private List<HelpTypeDTO> addBasicHelpType(Company co, EntityManager em) throws DataException {

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
            throw new DataException("Failed to add base helpType to company\n" + DataUtil.getErrorString(e));
        }

        return dtoList;
    }

    private List<RatingDTO> addBasicRating(Company co, EntityManager em)
            throws DataException {

        List<RatingDTO> dtoList = new ArrayList<>();
        try {

            Rating r1 = new Rating();
            r1.setRatingName("Excellent");
            r1.setRatingNumber(Integer.valueOf(100));
            r1.setCompany(co);
            //
            Rating r2 = new Rating();
            r2.setRatingName("Very Good");
            r2.setRatingNumber(Integer.valueOf(80));
            r2.setCompany(co);
            //
            Rating r3 = new Rating();
            r3.setRatingName("Good");
            r3.setRatingNumber(Integer.valueOf(60));
            r3.setCompany(co);
            //
            Rating r4 = new Rating();
            r4.setRatingName("Fair");
            r4.setRatingNumber(Integer.valueOf(40));
            r4.setCompany(co);
            //
            Rating r5 = new Rating();
            r5.setRatingName("Poor");
            r5.setRatingNumber(Integer.valueOf(20));
            r5.setCompany(co);
            //

            dtoList.add(new RatingDTO(r1));
            dtoList.add(new RatingDTO(r2));
            dtoList.add(new RatingDTO(r3));
            dtoList.add(new RatingDTO(r4));
            dtoList.add(new RatingDTO(r5));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add base rating to company", e);
            throw new DataException("Failed to add base rating to company\n" + DataUtil.getErrorString(e));
        }

        return dtoList;
    }

    private List<EquipmentDTO> addCompanyEquipment(
            Company tc, Administrator adm, EntityManager em) throws DataException {

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
            throw new DataException("Failed to add company equipment\n" + DataUtil.getErrorString(e));

        }
        return dtoList;
    }

    public Company getCompanyByID(Integer id) {

        Company c = em.find(Company.class, id);
        return c;
    }

    private List<TrainingClass> getTrainingClasses(Integer companyID) {

        Query q = em.createNamedQuery("TrainingClass.findByCompanyID");
        q.setParameter("id", companyID);
        List<TrainingClass> list = q.getResultList();
        return list;
    }

    private List<Equipment> getEquipment(Integer companyID) {

        Query q = em.createNamedQuery("Equipment.findByCompanyID");
        q.setParameter("id", companyID);
        List<Equipment> list = q.getResultList();
        return list;
    }

    private List<Instructor> getInstructors(Integer companyID) {

        Query q = em.createNamedQuery("Instructor.findByCompanyID",Instructor.class);
        q.setParameter("id", companyID);
        List<Instructor> list = q.getResultList();
        return list;
    }

    private List<Administrator> getAdmins(Integer companyID) {

        Query q = em.createNamedQuery("Administrator.findByCompanyID");
        q.setParameter("id", companyID);
        List<Administrator> list = q.getResultList();
        return list;
    }

    private List<Trainee> getTrainees(Integer companyID) {

        Query q = em.createNamedQuery("Trainee.findByCompany", Trainee.class);
        q.setParameter("id", companyID);
        List<Trainee> list = q.getResultList();
        return list;
    }

    private List<TrainingClassCourse> getTrainingClassCoursesByCompany(Integer companyID) {

        Query q = em.createNamedQuery("TrainingClassCourse.findByCompanyID", TrainingClassCourse.class);
        q.setParameter("id", companyID);
        List<TrainingClassCourse> tcList = q.getResultList();
        return tcList;
    }

    private List<Trainee> getTraineesByClass(Integer trainingClassID) {

        Query q = em.createNamedQuery("Trainee.findByClass", Trainee.class);
        q.setParameter("id", trainingClassID);
        List<Trainee> list = q.getResultList();
        return list;
    }

    private List<Author> getAuthors(Integer companyID) {
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

        Query q = em.createNamedQuery("InstructorClass.findByCompany",InstructorClass.class);
        q.setParameter("id", c.getCompanyID());
        List<InstructorClass> list = q.getResultList();
        return list;
    }

    private List<CourseAuthor> getCourseAuthorList(Integer companyID) {
        Query q = em.createNamedQuery("CourseAuthor.findByCompany", CourseAuthor.class);
        q.setParameter("id", companyID);
        List<CourseAuthor> list = q.getResultList();
        return list;
    }

    public ResponseDTO getCompanyData(Integer companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        long start = System.currentTimeMillis();

        try {
            Company co = DataUtil.getCompanyByID(companyID, em);
            if (co != null) {
                List<Author> aList = getAuthors(companyID);
                d.setAuthorList(new ArrayList<AuthorDTO>());

                List<CourseAuthor> caList = getCourseAuthorList(companyID);
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

                List<Province> list = getProvinces(co);
                d.setProvinceList(new ArrayList<ProvinceDTO>());
                for (Province province : list) {
                    d.getProvinceList().add(new ProvinceDTO(province));
                }

                List<CityDTO> cList = DataUtil.getCityListByCountryCode(co.getCity().getProvince().getCountry().getCountryCode(), em);
                for (ProvinceDTO p : d.getProvinceList()) {
                    for (CityDTO city : cList) {
                        if (city.getProvinceID().intValue() == p.getProvinceID().intValue()) {
                            p.getCityList().add(city);
                        }
                    }
                }
                List<Trainee> trList = getTrainees(companyID);
                List<TrainingClassCourse> tcc = getTrainingClassCoursesByCompany(companyID);

                d.setTrainingClassList(new ArrayList<TrainingClassDTO>());
                for (TrainingClass tc : getTrainingClasses(companyID)) {
                    TrainingClassDTO tcDTO = new TrainingClassDTO(tc);
                    tcDTO.setTraineeList(new ArrayList<TraineeDTO>());
                    tcDTO.setTrainingClassCourseList(new ArrayList<TrainingClassCourseDTO>());
                    for (Trainee trainee : trList) {
                        if (trainee.getTrainingClass().getTrainingClassID().intValue() == tc.getTrainingClassID().intValue()) {
                            tcDTO.getTraineeList().add(new TraineeDTO(trainee));
                        }
                    }
                    for (TrainingClassCourse x : tcc) {
                        if (x.getTrainingClass().getTrainingClassID().intValue() == tc.getTrainingClassID().intValue()) {
                            tcDTO.getTrainingClassCourseList().add(new TrainingClassCourseDTO(x));
                        }
                    }

                    d.getTrainingClassList().add(tcDTO);
                }
                ResponseDTO r = getInventoryList(companyID);
                List<InventoryDTO> invList = r.getInventoryList();
                d.setEquipmentList(new ArrayList<EquipmentDTO>());
                for (Equipment e : getEquipment(companyID)) {
                    EquipmentDTO edto = new EquipmentDTO(e);
                    edto.setInventoryList(new ArrayList<InventoryDTO>());
                    for (InventoryDTO inv : invList) {
                        if (inv.getEquipment().getEquipmentID().intValue() == e.getEquipmentID().intValue()) {
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
                        if (ic.getInstructor().getInstructorID().intValue() == i.getInstructorID().intValue()) {
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
                long end = System.currentTimeMillis();
                log.log(Level.INFO, "Retrieved company data: {0} - elapsed = {1} milliseconds",
                        new Object[]{co.getCompanyName(), end - start});
            } else {
                d.setStatusCode(ResponseDTO.ERROR_DATABASE);
                d.setMessage("Training Company not found.");
                log.log(Level.WARNING, "Training Company not found");
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed getCompanyData", e);
            throw new DataException("Failed getCompanyData\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO updatePassword(Integer id, int type) throws DataException {
        ResponseDTO d = new ResponseDTO();
        d.setCredential(DataUtil.getPassword(id, type, em));
        d.setMessage("Password updated");
        return d;
    }

    public ResponseDTO loginAdministrator(
            String email, String password, GcmDeviceDTO device, PlatformUtil platformUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        EntityTransaction tran;
        try {
            Query q = em.createNamedQuery("Administrator.loginAdmin", Administrator.class);
            q.setParameter("email", email);
            q.setParameter("pswd", password);
            q.setMaxResults(1);
            Administrator a = (Administrator) q.getSingleResult();

            if (a != null) {
                Integer id = a.getCompany().getCompanyID();
                log.log(Level.INFO, "company id from admin login: {0}", id.intValue());
                d = getCompanyData(id);
                try {
                    if (device != null) {
                        tran = em.getTransaction();

                        GcmDevice gcm = new GcmDevice();
                        gcm.setManufacturer(device.getManufacturer());
                        gcm.setModel(device.getModel());
                        gcm.setProduct(device.getProduct());
                        gcm.setSerialNumber(device.getSerialNumber());
                        gcm.setRegistrationID(device.getRegistrationID());
                        gcm.setDateRegistered(new Date());
                        gcm.setAdministrator(a);
                        em.persist(gcm);


                        CloudMessagingRegistrar.sendRegistration(gcm.getRegistrationID(), platformUtil);

                    }
                } catch (Exception e) {
                    log.log(Level.WARNING, "Device registration failed", e);
                    platformUtil.addErrorStore(ResponseDTO.ERROR_DATABASE,
                            "Device registration failed\n"
                            + DataUtil.getErrorString(e), "Administrator Services");
                }
                d.setAdministrator(new AdministratorDTO(a));
                d.setCompany(new CompanyDTO(a.getCompany()));
                d.setMessage(DataUtil.OK_MESSAGE);
            } else {
                d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
                d.setMessage(DataUtil.ERROR_MESSAGE);
            }

        } catch (NoResultException e) {
            d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
            d.setMessage("Email or password is invalid. Sign in rejected.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to login admin", e);
            throw new DataException("Failed to login admin\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO registerAdministrator(
            AdministratorDTO admin)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Administrator administrator = new Administrator();
            administrator.setFirstName(admin.getFirstName());
            administrator.setLastName(admin.getLastName());
            administrator.setEmail(admin.getEmail());
            administrator.setCellphone(admin.getCellphone());
            administrator.setCompany(DataUtil.getCompanyByID(admin.getCompanyID(), em));
            administrator.setPassword(DataUtil.createPassword());
            administrator.setDateRegistered(new Date());
            em.persist(administrator);

            Query q = em.createNamedQuery("Administrator.findByCompanyID",Administrator.class);
            q.setParameter("id", administrator.getCompany().getCompanyID());
            List<Administrator> list = q.getResultList();
            d.setAdministratorList(new ArrayList<AdministratorDTO>());
            for (Administrator x : list) {
                d.getAdministratorList().add(new AdministratorDTO(x));
            }

            d.setCompany(new CompanyDTO(administrator.getCompany()));
            d.setEquipmentList(getCompanyEquipment(administrator.getCompany()));
            log.log(Level.INFO, "Admin registered");
        } catch (RollbackException e) {
            log.log(Level.SEVERE, "Some kind of rollback ...duplicate found");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("An Administrator with this email already exists. "
                    + "\nPlease check or use a different email address.");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding register admin", e);
            throw new DataException("Failed to register administrator\n"
                    + DataUtil.getErrorString(e));
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

    public ResponseDTO deactivateTrainee(TraineeDTO trainee, Integer administrationID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();


        try {

            Trainee tc = DataUtil.getTraineeByID(trainee.getTraineeID(), em);
            Administrator adm = DataUtil.getAdministratorByID(administrationID, em);

            tc.setActiveFlag(1);
            tc.setAdministrator(adm);
            em.merge(tc);

            d.setMessage("Trainee deactivated");
            //log.log(Level.INFO, "Trainee deactivated {0} {1}", new Object[]{tc.getFirstName(), tc.getLastName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update trainee", e);
            throw new DataException("Failed to update trainee\n" + DataUtil.getErrorString(e));
        } finally {
        }
        return d;
    }

    public ResponseDTO deactivateInstructor(InstructorDTO instructor, Integer administrationID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            Instructor tc = DataUtil.getInstructorByID(instructor.getInstructorID(), em);
            Administrator adm = DataUtil.getAdministratorByID(administrationID, em);

            tc.setActiveFlag(1);
            tc.setAdministrator(adm);
            em.merge(tc);

            d.setMessage("Instructor deactivated");
            //log.log(Level.INFO, "Instructor deactivated {0} {1}", new Object[]{tc.getFirstName(), tc.getLastName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update instructor", e);
            throw new DataException("Failed to update instructor\n" + DataUtil.getErrorString(e));
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
    public ResponseDTO addSchedule(Integer trainingClassID,
            List<LessonScheduleDTO> scheduleList) throws DataException {
        ResponseDTO d = new ResponseDTO();



        try {
            //log.log(Level.INFO, "");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add schedule", e);
            throw new DataException(DataUtil.getErrorString(e));
        }

        return d;
    }
}
