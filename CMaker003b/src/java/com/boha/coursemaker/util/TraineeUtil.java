/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.data.Activity;
import com.boha.coursemaker.data.City;
import com.boha.coursemaker.data.CourseTrainee;
import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.HelpRequest;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.data.TraineeRating;
import com.boha.coursemaker.data.TrainingClassCourse;
import com.boha.coursemaker.data.Company;
import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.GcmDevice;
import com.boha.coursemaker.data.Instructor;
import com.boha.coursemaker.data.InstructorClass;
import com.boha.coursemaker.data.InstructorRating;
import com.boha.coursemaker.data.Rating;
import com.boha.coursemaker.data.TrainingClass;
import com.boha.coursemaker.dto.AdministratorDTO;
import com.boha.coursemaker.dto.CourseTraineeActivityDTO;
import com.boha.coursemaker.dto.CourseTraineeDTO;
import com.boha.coursemaker.dto.HelpRequestDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.dto.TraineeDTO;
import com.boha.coursemaker.dto.CompanyDTO;
import com.boha.coursemaker.dto.GcmDeviceDTO;
import com.boha.coursemaker.dto.InstructorClassDTO;
import com.boha.coursemaker.dto.InstructorDTO;
import com.boha.coursemaker.dto.InstructorRatingDTO;
import com.boha.coursemaker.dto.TraineeRatingDTO;
import com.boha.coursemaker.dto.TrainingClassCourseDTO;
import com.boha.coursemaker.dto.TrainingClassDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TraineeUtil {

    private static final Logger log = Logger.getLogger("TraineeUtil");
    @PersistenceContext
    EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public ResponseDTO updateTraineeProfile(TraineeDTO trainee)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Trainee t = DataUtil.getTraineeByID(trainee.getTraineeID(), em);

            t.setFirstName(trainee.getFirstName());
            t.setLastName(trainee.getLastName());
            t.setCellphone(trainee.getCellphone());
            t.setAddress(trainee.getAddress());
            t.setIDNumber(trainee.getiDNumber());
            if (trainee.getPassword() != null) {
                t.setPassword(trainee.getPassword());
            }
            t.setGender(trainee.getGender());
            t.setCity(DataUtil.getCityByID(trainee.getCityID(), em));
            t.setDateUpdated(new Date());
            em.merge(t);

            d.setTrainee(new TraineeDTO(t));
            d.setMessage("Trainee updated");
            log.log(Level.INFO, "Trainee profile updated");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to update trainee", e);
            throw new DataException("Failed to update trainee\n" + DataUtil.getErrorString(e));
        }

        return d;
    }

    public ResponseDTO getTraineeRatingsByActivity(
            int courseTraineeActivityID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("TraineeRating.findByActivity", TraineeRating.class);
            q.setParameter("id", courseTraineeActivityID);
            List<TraineeRating> list = q.getResultList();
            List<TraineeRatingDTO> dto = new ArrayList<>();
            for (TraineeRating cta : list) {
                dto.add(new TraineeRatingDTO(cta));
            }
            d.setTraineeRatingList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getTraineeRatings(
            int traineeID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("TraineeRating.findByTrainee", TraineeRating.class);
            q.setParameter("id", traineeID);
            List<TraineeRating> list = q.getResultList();
            List<TraineeRatingDTO> dto = new ArrayList<>();
            for (TraineeRating cta : list) {
                dto.add(new TraineeRatingDTO(cta));
            }
            d.setTraineeRatingList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getInstructorsByClass(
            int trainingClassID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);
        Company co = tc.getCompany();
        try {

            Query q = em.createNamedQuery("Instructor.findByClass", Instructor.class);
            q.setParameter("id", trainingClassID);
            List<Instructor> list = q.getResultList();
            List<InstructorDTO> dto = new ArrayList<>();
            for (Instructor cta : list) {
                dto.add(new InstructorDTO(cta));
            }
            List<InstructorClassDTO> icList = getInstructorClassesByCompany(co.getCompanyID());
            for (InstructorDTO ins : dto) {
                ins.setInstructorClassList(new ArrayList<InstructorClassDTO>());
                for (InstructorClassDTO ic : icList) {
                    if (ic.getInstructorID() == ins.getInstructorID()) {
                        ins.getInstructorClassList().add(ic);
                    }
                }
            }
            d.setInstructorList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    private List<InstructorClassDTO> getInstructorClassesByCompany(
            int companyID)
            throws DataException {
        List<InstructorClassDTO> dtoList = null;
        try {

            Query q = em.createNamedQuery("InstructorClass.findByCompany", InstructorClass.class);
            q.setParameter("id", companyID);
            List<InstructorClass> list = q.getResultList();
            dtoList = new ArrayList<>();
            for (InstructorClass cta : list) {
                dtoList.add(new InstructorClassDTO(cta));
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return dtoList;
    }

    public ResponseDTO addHelpRequest(
            HelpRequestDTO help)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            HelpRequest a = new HelpRequest();
            a.setHelpType(DataUtil.getHelpTypeByID(help.getHelpType().
                    getHelpTypeID(), em));
            a.setCourseTraineeActivity(DataUtil.getCourseTraineeActivityByID(
                    help.getCourseTraineeActivity().getCourseTraineeActivityID(), em));
            a.setComment(help.getComment());
            a.setDateRequested(new Date());
            em.persist(a);

            d.setHelpRequest(new HelpRequestDTO(a));
            //log.log(Level.INFO, "Help requested");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register Trainee", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    private List<TraineeDTO> getClassmates(int trainingClassID) {

        Query q = em.createNamedQuery("Trainee.findByClass", Trainee.class);
        q.setParameter("id", trainingClassID);
        List<Trainee> list = q.getResultList();
        List<TraineeDTO> dto = new ArrayList<>();
        for (Trainee trainee : list) {
            dto.add(new TraineeDTO(trainee));
        }
        return dto;
    }

    public ResponseDTO getTraineeData(int trainingClassID,
            int traineeID, int companyID) throws DataException {
        log.log(Level.OFF, "getTraineeData trainingClassID: {0} traineeID: {1} companyID: {2}", new Object[]{trainingClassID, traineeID, companyID});
        ResponseDTO d = new ResponseDTO();
        try {
            List<CourseTraineeActivityDTO> ctaList = getActivitiesByTrainee(traineeID);
            log.log(Level.OFF, "activities: {0}", ctaList.size());
            Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
            q.setParameter("id", trainingClassID);
            List<TrainingClassCourse> xlist = q.getResultList();
            List<TrainingClassCourseDTO> list = new ArrayList<>();
            for (TrainingClassCourse tcc : xlist) {
                TrainingClassCourseDTO z = new TrainingClassCourseDTO(tcc);
                z.setCourseTraineeActivityList(new ArrayList());
                 for (CourseTraineeActivityDTO cta : ctaList) {
                     if (cta.getCourseID() == tcc.getCourse().getCourseID()) {
                         z.getCourseTraineeActivityList().add(cta);
                     }
                 }
                list.add(z);
            }
            d.setTrainingClassCourseList(list);
            d.setTraineeList(getClassmates(trainingClassID));
            d.setRatingList(DataUtil.getRatingList(companyID, em).getRatingList());
            d.setHelpTypeList(DataUtil.getHelpTypeList(companyID, em).getHelpTypeList());
            log.log(Level.WARNING, "Trainee data retrieved, number courses: {0} classMates: {1}", new Object[]{d.getTrainingClassCourseList().size(), d.getTraineeList().size()});
        } catch (Exception e) {
            log.log(Level.WARNING, "Failed to get Trainee data", e);
            throw new DataException(DataUtil.getErrorString(e));
        }

        return d;
    }

    

//    public class Bucket {
//
//        public Bucket(int courseID, List<LessonDTO> list) {
//            this.courseID = courseID;
//            for (LessonDTO lessonDTO : list) {
//                lessonDTO.setCourseTraineeActivityList(new ArrayList<CourseTraineeActivityDTO>());
//            }
//            lessonList = list;
//        }
//        int courseID;
//        List<LessonDTO> lessonList;
//    }
    /**
     * Register new trainee, typically from their mobile app
     *
     * @param trainee
     * @param trainingClassID
     * @param cityID
     * @param companyID
     * @return
     * @throws DataException
     */
    public ResponseDTO registerTrainee(TraineeDTO trainee,
            int trainingClassID, int cityID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);
            Company c = DataUtil.getCompanyByID(tc.getCompany().getCompanyID(), em);
            City city = DataUtil.getCityByID(cityID, em);

            Trainee tr = new Trainee();
            tr.setFirstName(trainee.getFirstName());
            tr.setLastName(trainee.getLastName());
            tr.setEmail(trainee.getEmail());
            tr.setCellphone(trainee.getCellphone());
            tr.setGender(trainee.getGender());
            tr.setCompany(c);
            tr.setCity(city);
            tr.setTrainingClass(tc);
            tr.setPassword(DataUtil.createPassword());
            tr.setDateRegistered(new Date());
            tr.setActiveFlag(0);
            em.persist(tr);

            //
            Query q = em.createNamedQuery("Trainee.findByCompany", Trainee.class);
            q.setParameter("id", c.getCompanyID());
            List<Trainee> list = q.getResultList();
            d.setTraineeList(new ArrayList<TraineeDTO>());
            for (Trainee x : list) {
                d.getTraineeList().add(new TraineeDTO(x));
            }
            d.setCompany(new CompanyDTO(c));
            try {
                for (TrainingClassCourseDTO tcc : getCoursesByClass(trainingClassID)) {
                    enrollTraineeInCourse(tr.getTraineeID(), tcc.getTrainingClassCourseID());
                }
            } catch (Exception e) {
                //swallow exception - instructor can update later
            }
            log.log(Level.INFO, "Trainee registered {0} {1} class: {2}",
                    new Object[]{tr.getFirstName(), tr.getLastName(), tc.getTrainingClassName()});
            d.setMessage("Trainee registered. OK!");

        } catch (RollbackException e) {
            log.log(Level.WARNING, "Possible duplicate encountered, trainee");
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("A trainee with this email address already exists. "
                    + "Please try again or use a different email address.");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register Trainee", e);
            throw new DataException("Failed to register Trainee\n"
                    + DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO loginTrainee(String email, String password,
            GcmDeviceDTO device, PlatformUtil platformUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Trainee.login", Trainee.class);
            q.setParameter("email", email);
            q.setParameter("pswd", password);
            q.setMaxResults(1);
            Trainee trainee = (Trainee) q.getSingleResult();

            if (trainee != null) {
                d.setTrainee(new TraineeDTO(trainee));
                d.setCompany(new CompanyDTO(trainee.getCompany()));
                if (trainee.getAdministrator() != null) {
                    d.setAdministrator(new AdministratorDTO(trainee.getAdministrator()));
                }
                d.setTrainingClass(new TrainingClassDTO(trainee.getTrainingClass()));
                d.setTrainingClassCourseList(getCoursesByClass(trainee.getTrainingClass().getTrainingClassID()));
                d.setCourseTraineeActivityList(getActivitiesByTrainee(trainee.getTraineeID()));

                d.setRatingList(DataUtil.getRatingList(trainee.getCompany().getCompanyID(), em).getRatingList());
                d.setHelpTypeList(DataUtil.getHelpTypeList(trainee.getCompany().getCompanyID(), em).getHelpTypeList());
                try {
                    if (device != null) {
                        GcmDevice gcm = new GcmDevice();
                        gcm.setManufacturer(device.getManufacturer());
                        gcm.setModel(device.getModel());
                        gcm.setProduct(device.getProduct());
                        gcm.setSerialNumber(device.getSerialNumber());
                        gcm.setRegistrationID(device.getRegistrationID());
                        gcm.setDateRegistered(new Date());
                        gcm.setTrainee(trainee);
                        em.persist(gcm);

                        CloudMessagingRegistrar.sendRegistration(gcm.getRegistrationID(), platformUtil);
                    }
                } catch (Exception e) {
                    log.log(Level.WARNING, "Device registration failed", e);
                    platformUtil.addErrorStore(ResponseDTO.ERROR_DATABASE,
                            "Device registration failed\n"
                            + DataUtil.getErrorString(e), "Trainee Services");
                }

                d.setMessage(DataUtil.OK_MESSAGE);
            } else {
                d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
                d.setMessage(DataUtil.ERROR_MESSAGE);
            }
        } catch (NoResultException e) {
            d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
            d.setMessage("Email or password invalid. Please check!");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to login user", e);
            throw new DataException("Failed to sign trainee in\n"
                    + DataUtil.getErrorString(e));
        }
        return d;
    }

    private List<CourseTraineeActivityDTO> getActivitiesByTrainee(int traineeID) {
        Query q = em.createNamedQuery("CourseTraineeActivity.findByTrainee", CourseTraineeActivity.class);
        q.setParameter("id", traineeID);
        List<CourseTraineeActivity> list = q.getResultList();
        List<CourseTraineeActivityDTO> dto = new ArrayList<>();

        Query q2 = em.createNamedQuery("TraineeRating.findByTrainee", TraineeRating.class);
        q2.setParameter("id", traineeID);
        List<TraineeRating> trList = q2.getResultList();

        Query q3 = em.createNamedQuery("InstructorRating.findByTrainee", InstructorRating.class);
        q3.setParameter("id", traineeID);
        List<InstructorRating> irList = q3.getResultList();

        for (CourseTraineeActivity cta : list) {
            dto.add(new CourseTraineeActivityDTO(cta));
        }
        for (CourseTraineeActivityDTO cta : dto) {
            cta.setTraineeRatingList(new ArrayList<TraineeRatingDTO>());
            cta.setInstructorRatingList(new ArrayList<InstructorRatingDTO>());
            for (TraineeRating tr : trList) {
                if (tr.getCourseTraineeActivity().getCourseTraineeActivityID() == cta.getCourseTraineeActivityID()) {
                    cta.getTraineeRatingList().add(new TraineeRatingDTO(tr));
                }
            }
            for (InstructorRating ir : irList) {
                if (ir.getCourseTraineeActivity().getCourseTraineeActivityID() == cta.getCourseTraineeActivityID()) {
                    cta.getInstructorRatingList().add(new InstructorRatingDTO(ir));
                }
            }
        }
        return dto;
    }

    public List<TrainingClassCourseDTO> getCoursesByClass(int trainingClassID) {
        List<TrainingClassCourseDTO> list = new ArrayList<>();

        Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
        q.setParameter("id", trainingClassID);
        List<TrainingClassCourse> xlist = q.getResultList();
        for (TrainingClassCourse tcc : xlist) {
            list.add(new TrainingClassCourseDTO(tcc));
        }
        return list;
    }

    /**
     * Enroll Trainee in Course. Performed directly by tr Trainee. All expected
     * activities are added to the trainee's enrolment.
     *
     * @param traineeID
     * @param trainingClassCourseID
     * @return
     * @throws DataException
     */
    private void enrollTraineeInCourse(int traineeID,
            int trainingClassCourseID) throws DataException {
        try {

            Trainee tc = DataUtil.getTraineeByID(traineeID, em);
            TrainingClassCourse tcc = DataUtil.getTrainingClassCourseByID(trainingClassCourseID, em);
            CourseTrainee a = new CourseTrainee();
            a.setDateEnrolled(new Date());
            a.setTrainee(tc);
            a.setTrainingClassCourse(tcc);

            em.persist(a);

            //add all activities in this course
            Course c = tcc.getCourse();

            int cnt = 0;
            for (Activity act : c.getActivityList()) {
                CourseTraineeActivity cta = new CourseTraineeActivity();
                cta.setActivity(act);
                cta.setCourseTrainee(a);
                cta.setDateUpdated(new Date());
                em.persist(cta);
                cnt++;

            }
            log.log(Level.INFO, "Trainee enrolled in course: {0} : {1} {2} activities: {3}", 
                    new Object[]{tcc.getCourse().getCourseName(), tc.getFirstName(), tc.getLastName(), cnt});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to enroll Trainee in Course", e);
            throw new DataException("Failed to enroll trainee in coures\n" + DataUtil.getErrorString(e));
        }
    }

    /**
     * Trainee course evaluation. Set course Rating and possible comment
     *
     * @param courseTraineeID
     * @param ratingID
     * @param comment
     * @return
     * @throws DataException
     */
    public ResponseDTO traineeCourseEvaluation(int courseTraineeID,
            int ratingID, String comment) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            CourseTrainee tc = DataUtil.getCourseTraineeByID(courseTraineeID, em);

            tc.setComment(comment);
            tc.setRating(DataUtil.getRatingByID(ratingID, em));
            tc.setRatingDate(new Date());
            em.merge(tc);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to evaluate course", e);
            throw new DataException("Failed to evaluate course\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO addTraineeActivity(
            int activityID, CourseTraineeDTO ct) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            CourseTrainee courseTrainee = DataUtil.getCourseTraineeByID(ct.getCourseTraineeID(), em);
            Activity activity = DataUtil.getActivityByID(activityID, em);

            CourseTraineeActivity cta = new CourseTraineeActivity();
            cta.setActivity(activity);
            cta.setCourseTrainee(courseTrainee);
            cta.setDateUpdated(new Date());
            cta.setComment(ct.getComment());
            if (ct.getRating() != null) {
                cta.setRating(DataUtil.getRatingByID(ct.getRating().getRatingID(), em));
            }

            em.persist(cta);

            d.setCourseTraineeActivity(new CourseTraineeActivityDTO(cta));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add activity to trainee", e);
            throw new DataException("Failed to add trainee activity\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Trainee evaluates and updates own activity
     *
     * @param courseTraineeActivityID
     * @param ratingID
     * @param comment
     * @param completed
     * @return
     * @throws DataException
     */
    public ResponseDTO traineeActivityEvaluation(
            CourseTraineeActivityDTO cta, int traineeID) throws DataException {

        ResponseDTO d = new ResponseDTO();
        try {

            CourseTraineeActivity tc = DataUtil.getCourseTraineeActivityByID(
                    cta.getCourseTraineeActivityID(), em);

            Rating rating = DataUtil.getRatingByID(cta.getRating().getRatingID(), em);
            if (cta.getComment() != null) {
                tc.setComment(cta.getComment());
            }
            tc.setRating(rating);
            tc.setDateUpdated(new Date());
            tc.setCompletedFlag(cta.getCompletedFlag());
            if (cta.getCompletedFlag() > 0) {
                tc.setCompletionDate(new Date());
            }
            em.merge(tc);

            d.setCourseTraineeActivity(new CourseTraineeActivityDTO(tc));

            try {
                TraineeRating tr = new TraineeRating();
                tr.setCourseTraineeActivity(tc);
                tr.setComment(cta.getComment());
                tr.setRating(rating);
                tr.setDateUpdated(new Date());
                tr.setTrainee(DataUtil.getTraineeByID(traineeID, em));

                em.persist(tr);

                d.setTraineeRating(new TraineeRatingDTO(tr));
                List<TraineeRatingDTO> trList = getTraineeRatingsByActivity(cta.getCourseTraineeActivityID()).getTraineeRatingList();
                d.getCourseTraineeActivity().setTraineeRatingList(trList);
            } catch (Exception e) {
                log.log(Level.WARNING, "TraineeRating insert FAILED", e);
            }

            d.setMessage("trainee activity evaluated OK");
            log.log(Level.INFO, "Trainee evaluated activity");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to evaluate activity", e);
            throw new DataException("Failure to rate activity" + DataUtil.getErrorString(e));
        }
        return d;
    }

    /**
     * Trainee evaluates another trainee's activity
     *
     * @param traineeID
     * @param courseTraineeActivityID
     * @param ratingID
     * @param comment
     * @param completed
     * @return
     * @throws DataException
     */
    public ResponseDTO traineeActivityPeerEvaluation(
            int traineeID,
            int courseTraineeActivityID,
            int ratingID, String comment) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Trainee trainee = DataUtil.getTraineeByID(traineeID, em);
            CourseTraineeActivity tc = DataUtil.getCourseTraineeActivityByID(courseTraineeActivityID, em);

            TraineeRating tr = new TraineeRating();
            tr.setComment(comment);
            tr.setCourseTraineeActivity(tc);
            tr.setDateUpdated(new Date());
            tr.setRating(DataUtil.getRatingByID(ratingID, em));
            tr.setTrainee(trainee);
            em.persist(tr);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to peer evaluate activity", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }
}
