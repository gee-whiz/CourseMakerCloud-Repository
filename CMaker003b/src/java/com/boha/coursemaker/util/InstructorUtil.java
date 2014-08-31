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
import com.boha.coursemaker.data.TraineeSkillHistory;
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
import javax.persistence.PersistenceException;
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

    public ResponseDTO addSkill(SkillDTO skill, DataUtil dataUtil)
            throws DataException {
        log.log(Level.INFO, "adding skill: {0} companyID: {1}",
                new Object[]{skill.getSkillName(), skill.getCompanyID()});
        ResponseDTO d = new ResponseDTO();

        try {
            Company t = em.find(Company.class, skill.getCompanyID());
            Skill s = new Skill();
            s.setCompany(t);
            s.setSkillName(skill.getSkillName());
            em.persist(s);
            Query q = em.createNamedQuery("Skill.findByCompany", Skill.class);
            q.setParameter("id", skill.getCompanyID());
            List<Skill> skills = q.getResultList();
            d.setSkillList(new ArrayList<SkillDTO>());
            for (Skill x : skills) {
                d.getSkillList().add(new SkillDTO(x));
            }

            log.log(Level.INFO, "Skill added:{0} total skills: {1}", new Object[]{skill.getSkillName(), d.getSkillList().size()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add skill", e);
            throw new DataException("Failed to add skill\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateSkillLevel(SkillLevelDTO skill, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            SkillLevel s = em.find(SkillLevel.class, skill.getSkillLevelID());
            s.setSkillLevelName(skill.getSkillLevelName());
            s.setLevel(skill.getLevel());
            em.merge(s);
            Query q = em.createNamedQuery("SkillLevel.findByCompany", SkillLevel.class);
            q.setParameter("id", skill.getCompanyID());
            List<SkillLevel> skills = q.getResultList();
            d.setSkillLevelList(new ArrayList<SkillLevelDTO>());
            for (SkillLevel x : skills) {
                d.getSkillLevelList().add(new SkillLevelDTO(x));
            }

            log.log(Level.INFO, "SkillLevel updated {0}", skill.getSkillLevelName());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update skillLevel", e);
            throw new DataException("Failed to update skillLevel\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateSkill(SkillDTO skill, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Skill s = em.find(Skill.class, skill.getSkillID());
            s.setSkillName(skill.getSkillName());
            em.merge(s);
            Query q = em.createNamedQuery("Skill.findByCompany", Skill.class);
            q.setParameter("id", skill.getCompanyID());
            List<Skill> skills = q.getResultList();
            d.setSkillList(new ArrayList<SkillDTO>());
            for (Skill x : skills) {
                d.getSkillList().add(new SkillDTO(x));
            }

            log.log(Level.INFO, "Skill updated {0}", skill.getSkillName());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update skill", e);
            throw new DataException("Failed to update skill\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addSkillLevel(SkillLevelDTO skillLevel, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Company t = em.find(Company.class, skillLevel.getCompanyID());
            SkillLevel s = new SkillLevel();
            s.setCompany(t);
            s.setLevel(skillLevel.getLevel());
            s.setSkillLevelName(skillLevel.getSkillLevelName());
            em.persist(s);
            Query q = em.createNamedQuery("SkillLevel.findByCompany", SkillLevel.class);
            q.setParameter("id", skillLevel.getCompanyID());
            List<SkillLevel> skills = q.getResultList();
            d.setSkillLevelList(new ArrayList<SkillLevelDTO>());
            for (SkillLevel x : skills) {
                d.getSkillLevelList().add(new SkillLevelDTO(x));
            }

            log.log(Level.INFO, "SkillLevel added {0}", skillLevel.getSkillLevelName());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add skillLevel", e);
            throw new DataException("Failed to add skillLevel\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO getSkillLookups(int companyID, DataUtil dataUtil) throws DataException {
        log.log(Level.OFF, "getting skill lookups");
        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Skill.findByCompany", Skill.class);
            q.setParameter("id", companyID);
            List<Skill> list = q.getResultList();
            d.setSkillList(new ArrayList<SkillDTO>());
            for (Skill ts : list) {
                d.getSkillList().add(new SkillDTO(ts));
            }
            //
            q = em.createNamedQuery("SkillLevel.findByCompany", SkillLevel.class);
            q.setParameter("id", companyID);
            List<SkillLevel> blist = q.getResultList();
            d.setSkillLevelList(new ArrayList<SkillLevelDTO>());
            for (SkillLevel ts : blist) {
                d.getSkillLevelList().add(new SkillLevelDTO(ts));
            }
            log.log(Level.INFO, "Skills found: {0} levels: {1}",
                    new Object[]{d.getSkillList().size(), d.getSkillLevelList().size()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get skill lookups", e);
            throw new DataException("Failed to get skill lookups\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO getTraineeSkills(int traineeID, DataUtil dataUtil) throws DataException {
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
            throw new DataException("Failed to add trainee skills\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateTraineeSkills(List<TraineeSkillDTO> list, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Instructor i = em.find(Instructor.class, list.get(0).getInstructorID());
            SkillLevel sl = em.find(SkillLevel.class, list.get(0).getSkillLevelID());
            for (TraineeSkillDTO x : list) {
                TraineeSkill z = em.find(TraineeSkill.class, list.get(0).getTraineeSkillID());
                z.setDateAssessed(new Date());
                z.setInstructor(i);
                z.setSkillLevel(sl);
                em.persist(z);
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update trainee skills", e);
            throw new DataException("Failed to update trainee skills\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    private TraineeSkill getExistingTraineeSkill(List<TraineeSkill> list, int skillID) {
        Skill s = em.find(Skill.class, skillID);
        for (TraineeSkill ts : list) {
            if (ts.getSkill().getSkillID() == s.getSkillID()) {
                return ts;
            }
        }

        return null;
    }

    public ResponseDTO addTraineeSkills(List<TraineeSkillDTO> list, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Trainee t = em.find(Trainee.class, list.get(0).getTraineeID());
            Instructor i = em.find(Instructor.class, list.get(0).getInstructorID());
            Query a = em.createNamedQuery("TraineeSkill.findByTrainee", TraineeSkill.class);
            a.setParameter("id", list.get(0).getTraineeID());
            List<TraineeSkill> tsList = a.getResultList();

            for (TraineeSkillDTO x : list) {
                TraineeSkill z = getExistingTraineeSkill(tsList, x.getSkillID());
                if (z != null) {
                    z.setSkillLevel(em.find(SkillLevel.class, x.getSkillLevelID()));
                    em.merge(z);
                    writeTraineeSkillHistory(z);

                } else {
                    z = new TraineeSkill();
                    z.setDateAssessed(new Date());
                    z.setInstructor(i);
                    z.setSkill(em.find(Skill.class, x.getSkillID()));
                    z.setSkillLevel(em.find(SkillLevel.class, x.getSkillLevelID()));
                    z.setTrainee(t);
                    em.persist(z);
                    writeTraineeSkillHistory(z);

                }

            }
            Query q = em.createNamedQuery("TraineeSkill.findByTrainee", TraineeSkill.class);
            q.setParameter("id", list.get(0).getTraineeID());
            List<TraineeSkill> tlist = q.getResultList();
            d.setTraineeSkillList(new ArrayList<TraineeSkillDTO>());
            for (TraineeSkill ts : tlist) {
                d.getTraineeSkillList().add(new TraineeSkillDTO(ts));
            }
            log.log(Level.OFF, "Trainee skill added/updated");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add trainee skills", e);
            throw new DataException("Failed to add trainee skills\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    private void writeTraineeSkillHistory(TraineeSkill z) {
        //write history record
        TraineeSkillHistory tsh = new TraineeSkillHistory();
        tsh.setDateAssessed(z.getDateAssessed());
        tsh.setInstructor(z.getInstructor());
        tsh.setSkill(z.getSkill());
        tsh.setSkillLevel(z.getSkillLevel());
        tsh.setTrainee(z.getTrainee());
        em.persist(tsh);
        log.log(Level.OFF, "Trainee skill History added");
        
    }

    public ResponseDTO deleteTrainingClassEvent(int id, DataUtil dataUtil) throws DataException {

        ResponseDTO d = new ResponseDTO();
        try {
            TrainingClassEvent tce = em.find(TrainingClassEvent.class, id);
            em.remove(tce);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to delete TrainingClassEvent", e);
            throw new DataException("Failed to delete TrainingClassEvent\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO updateTrainingClassEvent(TrainingClassEventDTO event, DataUtil dataUtil) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {
            TrainingClassEvent tce = em.find(TrainingClassEvent.class, event.getTrainingClassEventID());
            // tce.setTrainingClass(dataUtil.getTrainingClassByID(event.getTrainingClassID()));
            tce.setDescription(event.getDescription());
            tce.setEventName(event.getEventName());
            tce.setLocation(event.getLocation());
            tce.setStartDate(new Date(event.getStartDate()));
            tce.setEndDate(new Date(event.getEndDate()));

            em.merge(tce);
            d.setTrainingClassEvent(new TrainingClassEventDTO(tce));

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update TrainingClassEvent", e);
            throw new DataException("Failed to update TrainingClassEvent\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO addTrainingClassEvent(TrainingClassEventDTO event, DataUtil dataUtil) throws DataException {

        ResponseDTO d = new ResponseDTO();
        TrainingClassCourse tcc = null;

        try {
            TrainingClass tc = dataUtil.getTrainingClassByID(event.getTrainingClassID());
            TrainingClassEvent tce = new TrainingClassEvent();
            if (event.getTrainingClassCourseID() > 0) {
                tcc = dataUtil.getTrainingClassCourseByID(event.getTrainingClassCourseID());
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
                throw new DataException("Failed to add TrainingClassEvent\n" + dataUtil.getErrorString(e));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add TrainingClassEvent", e);
            throw new DataException("Failed to add TrainingClassEvent\n" + dataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO getTrainingClassesByInstructor(int instructorID, DataUtil dataUtil) throws DataException {
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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO deleteInstructorClass(int classID, DataUtil dataUtil) throws DataException {
        InstructorClass ic = dataUtil.getInstructorClassByID(classID);
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
                    + dataUtil.getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO rateTrainee(CourseTraineeActivityDTO dto,
            int instructorID, DataUtil dataUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();

        try {
            Instructor i = dataUtil.getInstructorByID(instructorID);
            InstructorRating ir = new InstructorRating();
            CourseTraineeActivity cta = dataUtil.getCourseTraineeActivityByID(dto.getCourseTraineeActivityID());
            log.log(Level.INFO, "rateTrainee instructor ratings: {0}", cta.getTraineeRatingList().size());
            ir.setInstructor(i);
            ir.setCompletedFlag(dto.getCompletedFlag());
            ir.setCourseTraineeActivity(cta);
            ir.setDateUpdated(new Date());
            ir.setRating(dataUtil.getRatingByID(dto.getRating().getRatingID()));

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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getTraineeActivityByCompany(int companyID, DataUtil dataUtil) throws DataException {
        ResponseDTO response = new ResponseDTO();
        response.setTotals(new ArrayList<TotalsDTO>());

        try {
            Company company = dataUtil.getCompanyByID(companyID);
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return response;
    }

    public long countTrainingClassCoursesByInstructor(int instructorID) {

        Query q = em.createNamedQuery("TrainingClassCourse.countByInstructor");
        q.setParameter("instructorID", instructorID);
        long x = (long) q.getSingleResult();

        return x;

    }

    public ResponseDTO getClassCoursesByInstructor(int instructorID, DataUtil dataUtil) throws DataException {
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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getTraineeActivityByInstructor(int instructorID, DataUtil dataUtil) throws DataException {
        ResponseDTO response = new ResponseDTO();
        response.setTotals(new ArrayList<TotalsDTO>());

        try {
            Instructor instructor = dataUtil.getInstructorByID(instructorID);
            response.setRatingList(dataUtil.getRatingAndHelpList(instructor.getCompany().getCompanyID()).getRatingList());
            response.setHelpTypeList(dataUtil.getHelpTypeList(instructor.getCompany().getCompanyID()).getHelpTypeList());
            ResponseDTO xx = getSkillLookups(instructor.getCompany().getCompanyID(), dataUtil);
            response.setSkillLevelList(xx.getSkillLevelList());
            response.setSkillList(xx.getSkillList());
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return response;
    }

    private List<InstructorClassDTO> getInstructorClassList(int id) {

        Query q = em.createNamedQuery("InstructorClass.findByInstructorID", InstructorClass.class);
        q.setParameter("id", id);
        List<InstructorClass> list = q.getResultList();
        List<InstructorClassDTO> dto = new ArrayList<>();
        q = em.createNamedQuery("Trainee.CountByClass", Trainee.class);

        for (InstructorClass ic : list) {
            InstructorClassDTO d = new InstructorClassDTO(ic);
            q.setParameter("id", ic.getTrainingClass().getTrainingClassID());
            Number cResults = (Number) q.getSingleResult();
            d.setNumberOfTrainees(cResults.intValue());
            log.log(Level.OFF, "Number of trainees " + cResults.intValue());
            dto.add(d);
        }
        return dto;
    }

    public ResponseDTO getTraineeActivityTotalsByClass(int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO response = new ResponseDTO();
        response.setTotals(new ArrayList<TotalsDTO>());

        try {
            TrainingClass tc = dataUtil.getTrainingClassByID(trainingClassID);
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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getClassTrainees(int trainingClassID, DataUtil dataUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            TrainingClass tc = dataUtil.getTrainingClassByID(trainingClassID);
            List<TraineeDTO> traineeList = new ArrayList<>();
            for (Trainee t : getTrainees(tc, em)) {
                traineeList.add(new TraineeDTO(t));
            }

            List<CourseTraineeActivity> ctaList = getCourseTraineeActivitiesByClass(trainingClassID, em);
            for (TraineeDTO t : traineeList) {
                t.setTraineeSkillList(new ArrayList<TraineeSkillDTO>());
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
                    t.setPercComplete(dataUtil.getPercentage(
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
            throw new DataException(dataUtil.getErrorString(e));
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

    private TraineeDTO getTraineeDTO(Trainee a, boolean getActivity, DataUtil dataUtil) {
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
                t.setPercComplete(dataUtil.getPercentage(totTasks, totCompleted));
            }
        }
        return t;
    }

    public ResponseDTO getInstructorClasses(int instructorID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getCourseByClass(int trainingClassID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getCategoriesByCompany(int companyID, DataUtil dataUtil)
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
                    if (c.getCategory().getCategoryID() == cat.getCategoryID()) {
                        cat.getCourseList().add(c);
                    }
                }
            }

            d.setCategoryList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getClassActivities(int trainingClassID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO rateTraineeActivities(List<CourseTraineeActivityDTO> list,
            int instructorID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Instructor tc = dataUtil.getInstructorByID(instructorID);

            for (CourseTraineeActivityDTO cta : list) {
                InstructorRating r = new InstructorRating();
                r.setComment(cta.getComment());
                r.setCompletedFlag(cta.getCompletedFlag());
                r.setDateUpdated(new Date());
                r.setCourseTraineeActivity(dataUtil.getCourseTraineeActivityByID(
                        cta.getCourseTraineeActivityID()));
                r.setInstructor(tc);
                r.setRating(dataUtil.getRatingByID(cta.getRating().getRatingID()));
                em.persist(r);

            }

            d.setMessage("Class activities rated");
            //log.log(Level.INFO, "Class activities rated by instructor");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to rate activities by instructor", e);
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO loginInstructor(String email, String password, DataUtil dataUtil) throws DataException {
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
                d.setRatingList(dataUtil.getRatingAndHelpList(inst.getCompany().getCompanyID()).getRatingList());
                d.setHelpTypeList(dataUtil.getHelpTypeList(inst.getCompany().getCompanyID()).getHelpTypeList());
                d.setEquipmentList(dataUtil.getEquipmentList(inst.getCompany().getCompanyID()).getEquipmentList());
                d.setTrainingClassList(dataUtil.getTrainingClassList(
                        inst.getCompany().getCompanyID()).getTrainingClassList());
               

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
                    + dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO registerInstructor(InstructorDTO instructor, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Company tc = dataUtil.getCompanyByID(instructor.getCompanyID());
            City city = dataUtil.getCityByID(instructor.getCityID());

            Instructor a = new Instructor();
            a.setFirstName(instructor.getFirstName());
            a.setLastName(instructor.getLastName());
            a.setEmail(instructor.getEmail());
            a.setCellphone(instructor.getCellphone());
            a.setCity(city);
            a.setCompany(tc);
            a.setPassword(dataUtil.createPassword());
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

        } catch (PersistenceException e) {
            log.log(Level.WARNING, "Just a warning, might be duplicate");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Instructor with this email already exists. Please Sign In");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register instructor", e);
            throw new DataException("Failed to register instructor\n"
                    + dataUtil.getErrorString(e));
        }
        return d;
    }
    private final Logger log = Logger.getLogger("InstructorUtil");
}
