package com.boha.coursemaker.util;

import com.boha.coursemaker.data.Activity;
import com.boha.coursemaker.data.Category;
import com.boha.coursemaker.data.City;
import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.Instructor;
import com.boha.coursemaker.data.InstructorRating;
import com.boha.coursemaker.data.Company;
import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.CourseTrainee;
import com.boha.coursemaker.data.GcmDevice;
import com.boha.coursemaker.data.HelpRequest;
import com.boha.coursemaker.data.InstructorClass;
import com.boha.coursemaker.data.LessonResource;
import com.boha.coursemaker.data.Skill;
import com.boha.coursemaker.data.SkillLevel;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.data.TraineeRating;
import com.boha.coursemaker.data.TraineeSkill;
import com.boha.coursemaker.data.TrainingClass;
import com.boha.coursemaker.data.TrainingClassCourse;
import com.boha.coursemaker.data.TrainingClassEvent;
import com.boha.coursemaker.dto.ActivityDTO;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CompanyDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.dto.CourseTraineeActivityDTO;
import com.boha.coursemaker.dto.GcmDeviceDTO;
import com.boha.coursemaker.dto.HelpRequestDTO;
import com.boha.coursemaker.dto.InstructorClassDTO;
import com.boha.coursemaker.dto.InstructorDTO;
import com.boha.coursemaker.dto.InstructorRatingDTO;
import com.boha.coursemaker.dto.LessonResourceDTO;
import com.boha.coursemaker.dto.SkillDTO;
import com.boha.coursemaker.dto.SkillLevelDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.dto.platform.TotalsDTO;
import com.boha.coursemaker.dto.TraineeDTO;
import com.boha.coursemaker.dto.TraineeSkillDTO;
import com.boha.coursemaker.dto.TrainingClassCourseDTO;
import com.boha.coursemaker.dto.TrainingClassDTO;
import com.boha.coursemaker.dto.TrainingClassEventDTO;
import com.boha.coursemaker.servlet.AdministratorServlet;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InstructorUtil {

    @PersistenceContext
    EntityManager em;

    public ResponseDTO getSkillLookups() throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Skill.findAll", Skill.class);
            List<Skill> list = q.getResultList();
            d.setSkillList(new ArrayList<SkillDTO>());
            for (Skill ts : list) {
                d.getSkillList().add(new SkillDTO(ts));
            }
             q = em.createNamedQuery("SkillLevel.findAll", SkillLevel.class);
            List<SkillLevel> blist = q.getResultList();
            d.setSkillLevelList(new ArrayList<SkillLevelDTO>());
            for (SkillLevel ts : blist) {
                d.getSkillLevelList().add(new SkillLevelDTO(ts));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get skill lookups", e);
            throw new DataException("Failed to get skill lookups\n" + DataUtil.getErrorString(e));
        }

        return d;
    }
    public ResponseDTO getTraineeSkills(int traineeID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("TraineeSkill.findByTrainee", TraineeSkill.class);
            q.setParameter("id", traineeID);
            List<TraineeSkill> list = q.getResultList();
            d.setTraineeSkillList(new ArrayList<TraineeSkillDTO>());
            for (TraineeSkill ts : list) {
                d.getTraineeSkillList().add(new TraineeSkillDTO(ts));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add trainee skills", e);
            throw new DataException("Failed to add trainee skills\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addTraineeSkills(List<TraineeSkillDTO> list) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Trainee t = em.find(Trainee.class, list.get(0).getTraineeID());
            Instructor i = em.find(Instructor.class, list.get(0).getInstructorID());
            Skill s = em.find(Skill.class, list.get(0).getSkillID());
            SkillLevel sl = em.find(SkillLevel.class, list.get(0).getSkillLevelID());
            for (TraineeSkillDTO x : list) {
                TraineeSkill z = new TraineeSkill();
                z.setDateAssessed(new Date());
                z.setInstructor(i);
                z.setSkill(s);
                z.setSkillLevel(sl);
                z.setTrainee(t);
                em.persist(z);
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add trainee skills", e);
            throw new DataException("Failed to add trainee skills\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO deleteTrainingClassEvent(int id) throws DataException {

        ResponseDTO d = new ResponseDTO();
        try {
            TrainingClassEvent tce = em.find(TrainingClassEvent.class, id);
            em.remove(tce);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to delete TrainingClassEvent", e);
            throw new DataException("Failed to delete TrainingClassEvent\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateTrainingClassEvent(TrainingClassEventDTO event) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {
            TrainingClassEvent tce = em.find(TrainingClassEvent.class, event.getTrainingClassEventID());
            // tce.setTrainingClass(DataUtil.getTrainingClassByID(event.getTrainingClassID()));
            tce.setDescription(event.getDescription());
            tce.setEventName(event.getEventName());
            tce.setLocation(event.getLocation());
            tce.setStartDate(new Date(event.getStartDate()));
            tce.setEndDate(new Date(event.getEndDate()));

            em.merge(tce);
            d.setTrainingClassEvent(new TrainingClassEventDTO(tce));

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update TrainingClassEvent", e);
            throw new DataException("Failed to update TrainingClassEvent\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addTrainingClassEvent(TrainingClassEventDTO event) throws DataException {

        ResponseDTO d = new ResponseDTO();
        TrainingClassCourse tcc = null;

        try {
            TrainingClass tc = DataUtil.getTrainingClassByID(event.getTrainingClassID(), em);
            TrainingClassEvent tce = new TrainingClassEvent();
            if (event.getTrainingClassCourseID() > 0) {
                tcc = DataUtil.getTrainingClassCourseByID(event.getTrainingClassCourseID(), em);
                tce.setTrainingClassCourse(tcc);
            }

            tce.setTrainingClass(tc);
            tce.setDateRegistered(new Date());
            tce.setDescription(event.getDescription());
            tce.setEventName(event.getEventName());
            if (event.getLocation() == null) {
                tce.setLocation(" ");
            } else {
                tce.setLocation(event.getLocation());
            }
            tce.setStartDate(new Date(event.getStartDate()));
            tce.setEndDate(new Date(event.getEndDate()));

            em.persist(tce);
            Query q = em.createNamedQuery("TrainingClassEvent.findByClass", TrainingClassEvent.class);
            q.setParameter("id", tc.getTrainingClassID());
            List<TrainingClassEvent> list = q.getResultList();
            List<TrainingClassEventDTO> dto = new ArrayList<>();
            for (TrainingClassEvent tcex : list) {
                dto.add(new TrainingClassEventDTO(tcex));
            }
            d.setTrainingClassEventList(dto);
            log.log(Level.INFO, "class event added - {0}", event.getEventName());
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> set = e.getConstraintViolations();
            for (Iterator<ConstraintViolation<?>> it = set.iterator(); it.hasNext();) {
                ConstraintViolation<? extends Object> constraintViolation = it.next();
                log.log(Level.SEVERE, constraintViolation.getMessage());
                throw new DataException("Failed to add TrainingClassEvent\n" + DataUtil.getErrorString(e));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add TrainingClassEvent", e);
            throw new DataException("Failed to add TrainingClassEvent\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO getTrainingClassesByInstructor(int instructorID) throws DataException {
        long s = System.currentTimeMillis();
        ResponseDTO r = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("TrainingClass.findByInstructor", TrainingClass.class);
            q.setParameter("id", instructorID);
            List<TrainingClass> rList = q.getResultList();
            List<TrainingClassDTO> dto = new ArrayList<>();
            for (TrainingClass tc : rList) {
                dto.add(new TrainingClassDTO(tc));
            }
            List<TraineeDTO> trList = getTraineesByInstructor(instructorID);

            List<TrainingClassCourseDTO> tccList = getTrainingClassCoursesByInstructor(instructorID);

            for (TrainingClassDTO tc : dto) {
                tc.setTrainingClassCourseList(new ArrayList<TrainingClassCourseDTO>());
                int cnt = 0;
                for (TrainingClassCourseDTO tcc : tccList) {
                    if (tcc.getTrainingClassID() == tc.getTrainingClassID()) {
                        tc.getTrainingClassCourseList().add(tcc);
                        cnt++;
                    }

                }
                log.log(Level.OFF, "Found {0} courses for class {1}", new Object[]{cnt, tc.getTrainingClassName()});
                tc.setTraineeList(new ArrayList<TraineeDTO>());
                int cnt2 = 0;
                for (TraineeDTO t : trList) {
                    if (t.getTrainingClassID() == tc.getTrainingClassID()) {
                        tc.getTraineeList().add(t);
                        cnt2++;
                    }

                }
                log.log(Level.OFF, "Found {0} trainees for class: {1}", new Object[]{cnt2, tc.getTrainingClassName()});
                log.log(Level.INFO, "================== class finished ++++++++++++++++++++");
            }
            r.setTrainingClassList(dto);
            log.log(Level.OFF, "Training classes for instructorID: {0} count: {1}", new Object[]{instructorID, dto.size()});
            long e = System.currentTimeMillis();
            log.log(Level.INFO, "Retrieved instructor classes, elapsed: {0} seconds", AdministratorServlet.getElapsed(s, e));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return r;
    }

    private List<TraineeDTO> getTraineesByInstructor(int instructorID) {

        Query q2 = em.createNamedQuery("Trainee.findByInstructor", Trainee.class);
        q2.setParameter("id", instructorID);
        List<Trainee> tList = q2.getResultList();
        List<TraineeDTO> traineeList = new ArrayList<>();
        for (Trainee t : tList) {
            traineeList.add(new TraineeDTO(t));
        }
        return traineeList;
    }

    private List<TrainingClassCourseDTO> getTrainingClassCoursesByInstructor(int instructorID) {

        Query q = em.createNamedQuery("TrainingClassCourse.findByInstructor", TrainingClassCourse.class);
        q.setParameter("id", instructorID);
        List<TrainingClassCourse> list = q.getResultList();
        List<TrainingClassCourseDTO> dList = new ArrayList<>();
        for (TrainingClassCourse tcc : list) {
            dList.add(new TrainingClassCourseDTO(tcc));
        }

        log.log(Level.OFF, "TrainingClassCourses for instructor: {0}", dList.size());
        return dList;
    }

    public ResponseDTO getTrainingClassEvents(int trainingClassID) throws DataException {

        ResponseDTO r = new ResponseDTO();
        List<TrainingClassEventDTO> list = new ArrayList<>();

        Query q = em.createNamedQuery("TrainingClassEvent.findByClass", TrainingClassEvent.class);
        q.setParameter("id", trainingClassID);
        List<TrainingClassEvent> rList = q.getResultList();
        for (TrainingClassEvent tce : rList) {
            list.add(new TrainingClassEventDTO(tce));
        }
        r.setTrainingClassEventList(list);
        return r;
    }

    public List<InstructorRatingDTO> getInstructorRatings(int courseTraineeActivityID) throws DataException {

        List<InstructorRatingDTO> list = new ArrayList<>();

        Query q = em.createNamedQuery("InstructorRating.findByInstructor", InstructorRating.class);
        q.setParameter("id", courseTraineeActivityID);
        List<InstructorRating> rList = q.getResultList();
        for (InstructorRating r : rList) {
            list.add(new InstructorRatingDTO(r));
        }

        return list;
    }

    public ResponseDTO deleteInstructorClass(int classID) throws DataException {
        InstructorClass ic = DataUtil.getInstructorClassByID(classID, em);
        if (ic == null) {
            throw new DataException("InstructorClass is NULL, cannot delete the record");
        }
        Instructor ins = ic.getInstructor();
        ResponseDTO resp = new ResponseDTO();

        try {

            em.remove(ic);

            Query q = em.createNamedQuery("InstructorClass.findByInstructorID", InstructorClass.class);
            q.setParameter("id", ins.getInstructorID());
            List<InstructorClass> rList = q.getResultList();
            List<InstructorClassDTO> dto = new ArrayList<>();
            for (InstructorClass cc : rList) {
                dto.add(new InstructorClassDTO(cc));
            }
            resp.setInstructorClassList(dto);

        } catch (ConstraintViolationException e) {
            resp.setStatusCode(ResponseDTO.ERROR_DELETE_NOT_POSSIBLE);
            resp.setMessage("Record cannot be deleted because of dependent data");
        } catch (Exception e) {
            log.log(Level.INFO, "Failed to remove instructorClass", e);
            throw new DataException("Failed to remove instructorClass\n"
                    + DataUtil.getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO rateTrainee(CourseTraineeActivityDTO dto,
            int instructorID) throws DataException {
        ResponseDTO resp = new ResponseDTO();

        try {
            Instructor i = DataUtil.getInstructorByID(instructorID, em);
            InstructorRating ir = new InstructorRating();
            CourseTraineeActivity cta = DataUtil.getCourseTraineeActivityByID(dto.getCourseTraineeActivityID(), em);
            log.log(Level.INFO, "rateTrainee instructor ratings: {0}", cta.getTraineeRatingList().size());
            ir.setInstructor(i);
            ir.setCompletedFlag(dto.getCompletedFlag());
            ir.setCourseTraineeActivity(cta);
            ir.setDateUpdated(new Date());
            ir.setRating(DataUtil.getRatingByID(dto.getRating().getRatingID(), em));

            em.persist(ir);

            //log.log(Level.INFO, "Instructor rating added OK");
            //update trainee completion flag
            if (dto.getCompletedFlag() > 0) {
                cta.setCompletedFlag(dto.getCompletedFlag());
                cta.setDateUpdated(new Date());
                if (dto.getCompletedFlag() == 1) {
                    cta.setCompletionDate(new Date());
                }
                em.merge(cta);

                //log.log(Level.INFO, "CourseTraineeActivity updated with completedFlag {0}", dto.getCompletedFlag());
            }
            CourseTraineeActivityDTO dx = new CourseTraineeActivityDTO(cta);
            resp.setCourseTraineeActivity(dx);
            resp.setMessage("Trainee evaluated by instructor");
        } catch (Exception e) {
            log.log(Level.INFO, "Failed to rate trainee activity", e);
            throw new DataException(DataUtil.getErrorString(e));
        }

        return resp;
    }

    public ResponseDTO getHelpRequests(int instructorID,
            long startDate, long endDate) {
        ResponseDTO resp = new ResponseDTO();

        Query q;
        if (startDate == 0) {
            q = em.createNamedQuery("HelpRequest.findByInstructor", HelpRequest.class);
            q.setMaxResults(100);
        } else {
            q = em.createNamedQuery("HelpRequest.findByInstructorPeriod", HelpRequest.class);
            q.setParameter("start", new Date(startDate));
            q.setParameter("end", new Date(endDate));
        }
        q.setParameter("id", instructorID);
        List<HelpRequest> list = q.getResultList();
        List<HelpRequestDTO> dto = new ArrayList<>();
        for (HelpRequest hr : list) {
            dto.add(new HelpRequestDTO(hr));
        }
        resp.setHelpRequestList(dto);
        resp.setMessage("Instructor HelpRequests found " + dto.size());
        return resp;
    }

    public List<Instructor> getInstructorsByClass(int trainingClassID) {

        Query q = em.createNamedQuery("Instructor.findByClass", Instructor.class);
        q.setParameter("id", trainingClassID);
        List<Instructor> iList = q.getResultList();
        for (Instructor ic : iList) {
            if (ic.getGcmDeviceList() != null) {
                log.log(Level.INFO, "instructor device list: {0}", ic.getGcmDeviceList().size());
            }
        }

        log.log(Level.INFO, "Found instructors for class: {0}", iList.size());
        return iList;

    }

    public ResponseDTO getTraineeActivityByCompany(int companyID) throws DataException {
        ResponseDTO response = new ResponseDTO();
        response.setTotals(new ArrayList<TotalsDTO>());

        try {
            Company company = DataUtil.getCompanyByID(companyID, em);
            for (TrainingClass tc : company.getTrainingClassList()) {
                if (tc.getIsOpen() > 0) {
                    for (Trainee trainee : tc.getTraineeList()) {
                        for (CourseTrainee ct : trainee.getCourseTraineeList()) {
                            int complete = 0, tasks = 0, totRatings = 0, totalRated = 0;
                            for (CourseTraineeActivity cta : ct.getCourseTraineeActivityList()) {
                                if (cta.getCompletedFlag() > 0) {
                                    complete++;
                                }
                                if (cta.getRating() != null) {
                                    totRatings += cta.getRating().getRatingNumber();
                                    totalRated++;
                                }
                                tasks++;
                            }
                            TotalsDTO tot = new TotalsDTO();
                            tot.setTraineeID(trainee.getTraineeID());
                            tot.setTotalComplete(complete);
                            tot.setTotalTasks(tasks);
                            tot.setTotalRatings(totRatings);
                            tot.setCourseID(ct.getTrainingClassCourse().getCourse().getCourseID());
                            tot.setCourseName(ct.getTrainingClassCourse().getCourse().getCourseName());
                            tot.setTrainingClassCourseID(ct.getTrainingClassCourse().getTrainingClassCourseID());

                            if (tasks > 0) {
                                BigDecimal bTasks = new BigDecimal(tasks);
                                BigDecimal bComplete = new BigDecimal(complete);
                                BigDecimal bPerc = bComplete.divide(bTasks, 4, RoundingMode.HALF_UP);
                                bPerc = bPerc.multiply(new BigDecimal(100));
                                tot.setPercComplete(bPerc.doubleValue());
                            }

                            if (totalRated > 0) {
                                BigDecimal bTotalRated = new BigDecimal(totalRated);
                                BigDecimal bRankings = new BigDecimal(totRatings);
                                BigDecimal avgRating = bRankings.divide(bTotalRated, 4, RoundingMode.HALF_UP);
                                tot.setAverageRating(avgRating.doubleValue());
                            }

                            tot.setTrainingClassID(tc.getTrainingClassID());
                            tot.setTrainingClassName(tc.getTrainingClassName());

                            response.getTotals().add(tot);

                        }

                    }
                }
            }
            response.setMessage("Trainee Activity totals calculated, rows: " + response.getTotals().size());

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return response;
    }

    public long countTrainingClassCoursesByInstructor(int instructorID) {

        Query q = em.createNamedQuery("TrainingClassCourse.countByInstructor");
        q.setParameter("instructorID", instructorID);
        long x = (long) q.getSingleResult();

        return x;

    }

    public ResponseDTO getClassCoursesByInstructor(int instructorID) throws DataException {
        ResponseDTO response = new ResponseDTO();

        try {
            Query q = em.createNamedQuery("TrainingClassCourse.findByInstructor", TrainingClassCourse.class);
            q.setParameter("instructorID", instructorID);
            List<TrainingClassCourse> list = q.getResultList();
            response.setTrainingClassCourseList(new ArrayList<TrainingClassCourseDTO>());
            for (TrainingClassCourse tcc : list) {
                response.getTrainingClassCourseList().add(new TrainingClassCourseDTO(tcc));
            }

            response.setMessage("TrainingClassCourses for instructor found: " + list.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }

        return response;
    }

    private List<InstructorClass> getInstructorClasses(Instructor instructor, EntityManager em) {
        Query q = em.createNamedQuery("InstructorClass.findByInstructorID", InstructorClass.class);
        q.setParameter("id", instructor.getInstructorID());
        List<InstructorClass> list = q.getResultList();
        //log.log(Level.INFO, "Instructor classes found: {0}", list.size());
        return list;
    }

    private List<Trainee> getTrainees(TrainingClass tc, EntityManager em) {
        Query q = em.createNamedQuery("Trainee.findByClass", Trainee.class);
        q.setParameter("id", tc.getTrainingClassID());
        List<Trainee> list = q.getResultList();
        return list;
    }

    private List<TraineeRating> getTraineeRatingsByClass(int trainingClassID, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("TraineeRating.findByClass", TraineeRating.class);
        q.setParameter("id", trainingClassID);
        List<TraineeRating> list = q.getResultList();
        return list;
    }

    private List<TraineeRating> getTraineeRatings(Trainee tc, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("TraineeRating.findByTrainee", TraineeRating.class);
        q.setParameter("id", tc.getTraineeID());
        List<TraineeRating> list = q.getResultList();
        return list;
    }

    private List<InstructorRating> getInstructorRatingsByClass(int trainingClassID, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("InstructorRating.findByClass", InstructorRating.class);
        q.setParameter("id", trainingClassID);
        List<InstructorRating> list = q.getResultList();
        return list;
    }

    private List<CourseTrainee> getCourseTrainees(Trainee tc, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("CourseTrainee.findByTrainee", CourseTrainee.class);
        q.setParameter("tc", tc);
        List<CourseTrainee> list = q.getResultList();
        return list;
    }

    public List<CourseTrainee> getCourseTraineesByClass(int trainingClassID, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("CourseTrainee.findByClass", CourseTrainee.class);
        q.setParameter("id", trainingClassID);
        List<CourseTrainee> list = q.getResultList();
        return list;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivitiesByClass(
            int trainingClassID, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("CourseTraineeActivity.findByClass", CourseTraineeActivity.class);
        q.setParameter("id", trainingClassID);
        List<CourseTraineeActivity> list = q.getResultList();
        return list;
    }

    public List<CourseTraineeActivity> getCourseTraineeActivities(
            CourseTrainee tc, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("CourseTraineeActivity.findByCourseTrainee", CourseTraineeActivity.class);
        q.setParameter("tc", tc);
        List<CourseTraineeActivity> list = q.getResultList();
        return list;
    }

    public ResponseDTO getTraineeActivityByInstructor(int instructorID) throws DataException {
        ResponseDTO response = new ResponseDTO();
        response.setTotals(new ArrayList<TotalsDTO>());
        // response.setTrainingClassCourseList(
        //       getTrainingClassCoursesByInstructor(instructorID)
        //     .getTrainingClassCourseList());

        try {
            Instructor instructor = DataUtil.getInstructorByID(instructorID, em);
            response.setRatingList(DataUtil.getRatingList(instructor.getCompany().getCompanyID(), em).getRatingList());
            response.setHelpTypeList(DataUtil.getHelpTypeList(instructor.getCompany().getCompanyID(), em).getHelpTypeList());

            for (InstructorClass tc : getInstructorClasses(instructor, em)) {
                log.log(Level.WARNING, "Processing instructor class: {0} for {1} {2}", new Object[]{tc.getTrainingClass().getTrainingClassName(), tc.getInstructor().getFirstName(), tc.getInstructor().getLastName()});
                if (tc.getTrainingClass().getIsOpen() > 0) {
                    for (Trainee trainee : getTrainees(tc.getTrainingClass(), em)) {
                        //log.log(Level.INFO, "Processing trainee activities: {0} {1}", new Object[]{trainee.getFirstName(), trainee.getLastName()});
                        for (CourseTrainee ct : getCourseTrainees(trainee, em)) {
                            int complete = 0, tasks = 0, totRatings = 0, totalRated = 0;
                            for (CourseTraineeActivity cta : getCourseTraineeActivities(ct, em)) {
                                if (cta.getCompletedFlag() > 0) {
                                    complete++;
                                }
                                if (cta.getRating() != null) {
                                    totRatings += cta.getRating().getRatingNumber();
                                    totalRated++;
                                }
                                tasks++;
                            }
                            TotalsDTO tot = new TotalsDTO();
                            tot.setTraineeID(trainee.getTraineeID());
                            tot.setTotalComplete(complete);
                            tot.setTotalTasks(tasks);
                            tot.setTotalRatings(totRatings);
                            tot.setCourseID(ct.getTrainingClassCourse().getCourse().getCourseID());
                            tot.setCourseName(ct.getTrainingClassCourse().getCourse().getCourseName());
                            tot.setTrainingClassCourseID(ct.getTrainingClassCourse().getTrainingClassCourseID());

                            if (tasks > 0) {
                                BigDecimal bTasks = new BigDecimal(tasks);
                                BigDecimal bComplete = new BigDecimal(complete);
                                BigDecimal bPerc = bComplete.divide(bTasks, 4, RoundingMode.HALF_UP);
                                bPerc = bPerc.multiply(new BigDecimal(100));
                                tot.setPercComplete(bPerc.doubleValue());
                            }

                            if (totalRated > 0) {
                                BigDecimal bTotalRated = new BigDecimal(totalRated);
                                BigDecimal bRankings = new BigDecimal(totRatings);
                                BigDecimal avgRating = bRankings.divide(bTotalRated, 4, RoundingMode.HALF_UP);
                                tot.setAverageRating(avgRating.doubleValue());
                            }

                            tot.setTrainingClassID(tc.getTrainingClass().getTrainingClassID());
                            tot.setTrainingClassName(tc.getTrainingClass().getTrainingClassName());
                            response.getTotals().add(tot);

                        }

                    }
                }
            }
            response.setTotalCourses(countTrainingClassCoursesByInstructor(instructorID));
            InstructorDTO ix = new InstructorDTO(instructor);
            ix.setInstructorClassList(getInstructorClassList(instructorID));
            response.setInstructor(ix);
            response.setMessage("Trainee Activity totals calculated, rows: " + response.getTotals().size());
            log.log(Level.INFO, "Instructor's Trainee Activity totals calculated, rows: {0}", response.getTotals().size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return response;
    }

    private List<InstructorClassDTO> getInstructorClassList(int id) {

        Query q = em.createNamedQuery("InstructorClass.findByInstructorID", InstructorClass.class);
        q.setParameter("id", id);
        List<InstructorClass> list = q.getResultList();
        List<InstructorClassDTO> dto = new ArrayList<>();
        for (InstructorClass ic : list) {
            dto.add(new InstructorClassDTO(ic));
        }
        return dto;
    }

    public ResponseDTO getTraineeActivityTotalsByClass(int trainingClassID) throws DataException {
        ResponseDTO response = new ResponseDTO();
        response.setTotals(new ArrayList<TotalsDTO>());

        try {
            TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);
            tc.getTraineeList().get(0).getCourseTraineeList().get(0).getCourseTraineeActivityList();
            for (Trainee trainee : tc.getTraineeList()) {
                for (CourseTrainee ct : trainee.getCourseTraineeList()) {
                    int complete = 0, tasks = 0, totRatings = 0, totalRated = 0;
                    for (CourseTraineeActivity cta : ct.getCourseTraineeActivityList()) {
                        if (cta.getCompletedFlag() > 0) {
                            complete++;
                        }
                        if (cta.getRating() != null) {
                            totRatings += cta.getRating().getRatingNumber();
                            totalRated++;
                        }
                        tasks++;
                    }
                    TotalsDTO tot = new TotalsDTO();
                    tot.setTraineeID(trainee.getTraineeID());
                    tot.setTotalComplete(complete);
                    tot.setTotalTasks(tasks);
                    tot.setTotalRatings(totRatings);
                    tot.setCourseID(ct.getTrainingClassCourse().getCourse().getCourseID());
                    tot.setCourseName(ct.getTrainingClassCourse().getCourse().getCourseName());
                    tot.setTrainingClassCourseID(ct.getTrainingClassCourse().getTrainingClassCourseID());

                    BigDecimal bTasks = new BigDecimal(tasks);
                    BigDecimal bComplete = new BigDecimal(complete);
                    BigDecimal bPerc = bComplete.divide(bTasks).multiply(new BigDecimal(100));
                    tot.setPercComplete(bPerc.doubleValue());

                    BigDecimal bTotalRated = new BigDecimal(totalRated);
                    BigDecimal bRankings = new BigDecimal(totRatings);
                    BigDecimal avgRating = bRankings.divide(bTotalRated);
                    tot.setAverageRating(avgRating.doubleValue());

                    response.getTotals().add(tot);

                }

            }
            response.setMessage("Trainee Activity totals calculated, rows: " + response.getTotals().size());

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return response;
    }

    public List<GcmDevice> getDevices(Trainee t, EntityManager em) {
        if (em == null) {
            em = EMUtil.getEntityManager();
        }
        Query q = em.createNamedQuery("GcmDevice.findByTrainee", GcmDevice.class);
        q.setParameter("t", t);
        List<GcmDevice> list = q.getResultList();
        return list;
    }

    public ResponseDTO getClassTrainees(int trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);
            List<TraineeDTO> traineeList = new ArrayList<>();
            for (Trainee t : getTrainees(tc, em)) {
                traineeList.add(new TraineeDTO(t));
            }

            List<CourseTraineeActivity> ctaList = getCourseTraineeActivitiesByClass(trainingClassID, em);
            for (TraineeDTO t : traineeList) {
                List<Dates> dates = new ArrayList<>();
                for (CourseTraineeActivity cta : ctaList) {
                    if (cta.getCourseTrainee().getTrainee()
                            .getTraineeID() == t.getTraineeID()) {
                        if (cta.getCompletedFlag() > 0) {
                            if (cta.getCompletionDate() != null) {
                                t.setTotalCompleted(t.getTotalCompleted() + 1);
                                dates.add(new Dates(cta.getCompletionDate().getTime()));
                            }
                        }
                        t.setTotalTasks(t.getTotalTasks() + 1);
                    }
                }
                if (dates.size() > 0) {
                    Collections.sort(dates);
                    t.setLastDate(dates.get(0).date);
                    t.setPercComplete(DataUtil.getPercentage(
                            t.getTotalTasks(), t.getTotalCompleted()));
                }
                List<InstructorRating> irList = getInstructorRatingsByClass(
                        trainingClassID, em);
                int totalRating = 0, ratings = 0;
                for (InstructorRating ir : irList) {
                    if (ir.getCourseTraineeActivity().getCourseTrainee()
                            .getTrainee().getTraineeID()
                            == t.getTraineeID()) {
                        totalRating += ir.getRating().getRatingNumber();
                        ratings++;
                    }
                }
                if (totalRating > 0) {
                    t.setAverageInstructorRating(new Double(totalRating) / new Double(ratings));
                }
                //
                totalRating = 0;
                ratings = 0;
                List<TraineeRating> trList = getTraineeRatingsByClass(trainingClassID, em);
                for (TraineeRating tr : trList) {
                    if (tr.getTrainee().getTraineeID()
                            == t.getTraineeID()) {
                        totalRating += tr.getRating().getRatingNumber();
                        ratings++;
                    }
                }
                if (totalRating > 0) {
                    t.setAverageTraineeRating(new Double(totalRating) / new Double(ratings));
                }
            }

            d.setTraineeList(traineeList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    class Dates implements Comparable<Dates> {

        long date;

        public Dates(long date) {
            this.date = date;
        }

        @Override
        public int compareTo(Dates t) {
            if (date > t.date) {
                return 1;
            }
            if (date < t.date) {
                return -1;
            }
            return 0;
        }
    }

    private TraineeDTO getTraineeDTO(Trainee a, boolean getActivity, EntityManager em) {
        TraineeDTO t = new TraineeDTO();
        t.setTraineeID(a.getTraineeID());
        t.setCompanyID(a.getCompany().getCompanyID());
        t.setFirstName(a.getFirstName());
        t.setMiddleName(a.getMiddleName());
        t.setLastName(a.getLastName());
        t.setEmail(a.getEmail());
        t.setActiveFlag(a.getActiveFlag());
        t.setPassword(a.getPassword());
        t.setCellphone(a.getCellphone());
        t.setAddress(a.getAddress());
        t.setDateRegistered(a.getDateRegistered().getTime());
        if (a.getDateUpdated() != null) {
            t.setDateUpdated(a.getDateUpdated().getTime());
        }
        t.setGender(a.getGender());
        t.setiDNumber(a.getIDNumber());
        if (a.getCity() != null) {
            t.setCityID(a.getCity().getCityID());
            t.setCityName(a.getCity().getCityName());
            t.setProvinceID(a.getCity().getProvince().getProvinceID());
            t.setProvinceName(a.getCity().getProvince().getProvinceName());
        }
        if (a.getInstitution() != null) {
            t.setInstitutionID(a.getInstitution().getInstitutionID());
        }
        if (a.getTrainingClass() != null) {
            t.setTrainingClassID(a.getTrainingClass().getTrainingClassID());
            t.setTrainingClassName(a.getTrainingClass().getTrainingClassName());
        }

        t.setGcmDeviceList(new ArrayList<GcmDeviceDTO>());
        for (GcmDevice g : getDevices(a, em)) {
            t.getGcmDeviceList().add(new GcmDeviceDTO(g));
        }
        int totCompleted = 0, totTasks = 0;
        if (getActivity) {
            int totalRating = 0, numberOfRatings = 0;
            List<Dates> dates = new ArrayList<>();
            for (CourseTrainee ct : getCourseTrainees(a, em)) {
                for (CourseTraineeActivity cta : getCourseTraineeActivities(ct, null)) {
                    if (cta.getRating() != null) {
                        numberOfRatings++;
                        totalRating += cta.getRating().getRatingNumber();
                    }
                    if (cta.getCompletedFlag() > 0) {
                        if (cta.getCompletionDate() != null) {
                            totCompleted++;
                            dates.add(new Dates(cta.getCompletionDate().getTime()));
                        }
                    }
                    totTasks++;

                }
            }
            t.setTotalCompleted(totCompleted);
            t.setTotalTasks(totTasks);
            //if (totalRating > 0) {
            //  t.setAverageRating(new Double(totalRating) / new Double(numberOfRatings));
            //}
            if (dates.size() > 0) {
                Collections.sort(dates);
                t.setLastDate(dates.get(0).date);
                t.setPercComplete(DataUtil.getPercentage(totTasks, totCompleted));
            }
        }
        return t;
    }

    public ResponseDTO getInstructorClasses(int instructorID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("InstructorClass.findByInstructorID", InstructorClass.class);

            q.setParameter("id", instructorID);
            List<InstructorClass> list = q.getResultList();
            List<InstructorClassDTO> dto = new ArrayList<>();

            for (InstructorClass cta : list) {
                dto.add(new InstructorClassDTO(cta));
            }
            d.setInstructorClassList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getCourseByClass(int trainingClassID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
            q.setParameter("id", trainingClassID);
            List<TrainingClassCourse> list = q.getResultList();
            List<TrainingClassCourseDTO> dto = new ArrayList<>();

            for (TrainingClassCourse cta : list) {
                dto.add(new TrainingClassCourseDTO(cta));
            }

            d.setTrainingClassCourseList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public List<TrainingClassEventDTO> getEventsByClass(int trainingClassID) {
        Query q = em.createNamedQuery("TrainingClassEvent.findByClass", TrainingClassEvent.class);
        q.setParameter("id", trainingClassID);
        List<TrainingClassEvent> list = q.getResultList();
        List<TrainingClassEventDTO> dto = new ArrayList<>();
        for (TrainingClassEvent tce : list) {
            dto.add(new TrainingClassEventDTO(tce));
        }
        return dto;
    }

    public ResponseDTO getCategoriesByCompany(int companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);
            q.setParameter("id", companyID);
            List<Category> list = q.getResultList();
            List<CategoryDTO> dto = new ArrayList<>();

            for (Category cta : list) {
                dto.add(new CategoryDTO(cta));
            }
            List<CourseDTO> corsList = getCourseByCompany(companyID);

            for (CategoryDTO cat : dto) {
                cat.setCourseList(new ArrayList<CourseDTO>());
                for (CourseDTO c : corsList) {
                    if (c.getCategoryID() == cat.getCategoryID()) {
                        cat.getCourseList().add(c);
                    }
                }
            }

            d.setCategoryList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public List<CourseDTO> getCourseByCompany(int companyID) {
        Query q = em.createNamedQuery("Course.findByCompanyID", Course.class);
        q.setParameter("id", companyID);
        List<Course> list = q.getResultList();
        List<CourseDTO> dto = new ArrayList<>();
        for (Course a : list) {
            dto.add(new CourseDTO(a));
        }
        return dto;
    }

    public List<ActivityDTO> getActivitiesByCategory(int categoryID) {
        Query q = em.createNamedQuery("Activity.findByCategory", Activity.class);
        q.setParameter("id", categoryID);
        List<Activity> list = q.getResultList();
        List<ActivityDTO> dto = new ArrayList<>();
        for (Activity a : list) {
            dto.add(new ActivityDTO(a));
        }
        return dto;
    }

    public List<LessonResourceDTO> getLinksByCategory(int categoryID) {
        Query q = em.createNamedQuery("LessonResource.findByCategoryID", LessonResource.class);
        q.setParameter("id", categoryID);
        List<LessonResource> list = q.getResultList();
        List<LessonResourceDTO> dto = new ArrayList<>();
        for (LessonResource a : list) {
            dto.add(new LessonResourceDTO(a));
        }
        return dto;
    }

    public ResponseDTO getClassActivities(int trainingClassID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("CourseTraineeActivity.findByClass", CourseTraineeActivity.class);
            q.setParameter("id", trainingClassID);
            List<CourseTraineeActivity> list = q.getResultList();
            List<CourseTraineeActivityDTO> dto = new ArrayList<>();
            for (CourseTraineeActivity cta : list) {
                dto.add(new CourseTraineeActivityDTO(cta));
            }
            d.setCourseTraineeActivityList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO rateTraineeActivities(List<CourseTraineeActivityDTO> list,
            int instructorID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Instructor tc = DataUtil.getInstructorByID(instructorID, em);

            for (CourseTraineeActivityDTO cta : list) {
                InstructorRating r = new InstructorRating();
                r.setComment(cta.getComment());
                r.setCompletedFlag(cta.getCompletedFlag());
                r.setDateUpdated(new Date());
                r.setCourseTraineeActivity(DataUtil.getCourseTraineeActivityByID(
                        cta.getCourseTraineeActivityID(), em));
                r.setInstructor(tc);
                r.setRating(DataUtil.getRatingByID(cta.getRating().getRatingID(), em));
                em.persist(r);

            }

            d.setMessage("Class activities rated");
            //log.log(Level.INFO, "Class activities rated by instructor");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to rate activities by instructor", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO loginInstructor(String email, String password, GcmDeviceDTO device, PlatformUtil platformUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Instructor.login", Instructor.class);
            q.setParameter("email", email);
            q.setParameter("pswd", password);
            q.setMaxResults(1);
            Instructor inst = (Instructor) q.getSingleResult();

            if (inst != null) {
                d.setInstructor(new InstructorDTO(inst));
                d.setCompany(new CompanyDTO(inst.getCompany()));
                //get classes, courses, rating, helptype
                d.setRatingList(DataUtil.getRatingList(inst.getCompany().getCompanyID(), em).getRatingList());
                d.setHelpTypeList(DataUtil.getHelpTypeList(inst.getCompany().getCompanyID(), em).getHelpTypeList());
                d.setEquipmentList(DataUtil.getEquipmentList(inst.getCompany().getCompanyID(), em).getEquipmentList());
                d.setTrainingClassList(DataUtil.getTrainingClassList(
                        inst.getCompany().getCompanyID(), em).getTrainingClassList());
                try {
                    if (device != null) {
                        GcmDevice gcm = new GcmDevice();
                        gcm.setManufacturer(device.getManufacturer());
                        gcm.setModel(device.getModel());
                        gcm.setProduct(device.getProduct());
                        gcm.setSerialNumber(device.getSerialNumber());
                        gcm.setRegistrationID(device.getRegistrationID());
                        gcm.setDateRegistered(new Date());
                        gcm.setInstructor(inst);
                        em.persist(gcm);

                        CloudMessagingRegistrar.sendRegistration(gcm.getRegistrationID(), platformUtil);
                    }
                } catch (Exception e) {
                    log.log(Level.WARNING, "Device registration failed", e);
                    platformUtil.addErrorStore(ResponseDTO.ERROR_DATABASE,
                            "Device registration failed\n"
                            + DataUtil.getErrorString(e), "Instructor Services");
                }

                log.log(Level.INFO, "Instructor signed in: {1} {2}",
                        new Object[]{inst.getEmail(), inst.getFirstName(), inst.getLastName()});

            } else {
                d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
                d.setMessage("Sign in failed");
            }
        } catch (NoResultException e) {
            d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
            d.setMessage("Email or password invalid. Please check!");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to sign Instructor in", e);
            throw new DataException("Failed to sign Instructor in\n"
                    + DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO registerInstructor(InstructorDTO instructor)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Company tc = DataUtil.getCompanyByID(instructor.getCompanyID(), em);
            City city = DataUtil.getCityByID(instructor.getCityID(), em);

            Instructor a = new Instructor();
            a.setFirstName(instructor.getFirstName());
            a.setLastName(instructor.getLastName());
            a.setEmail(instructor.getEmail());
            a.setCellphone(instructor.getCellphone());
            a.setCity(city);
            a.setCompany(tc);
            a.setPassword(DataUtil.createPassword());
            a.setDateRegistered(new Date());
            em.persist(a);

            Query q = em.createNamedQuery("Instructor.findByCompanyID", Instructor.class);
            q.setParameter("id", tc.getCompanyID());
            List<Instructor> list = q.getResultList();
            List<InstructorDTO> dto = new ArrayList<>();
            for (Instructor i : list) {
                dto.add(new InstructorDTO(i));
            }
            d.setInstructorList(dto);
            d.setCompany(new CompanyDTO(tc));
            d.setMessage("Instructor registered OK");

        } catch (RollbackException e) {
            log.log(Level.WARNING, "Just a warning, might be duplicate");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Instructor with this email already exists. Please Sign In");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register instructor", e);
            throw new DataException("Failed to register instructor\n"
                    + DataUtil.getErrorString(e));
        }
        return d;
    }
    private final Logger log = Logger.getLogger("InstructorUtil");
}
