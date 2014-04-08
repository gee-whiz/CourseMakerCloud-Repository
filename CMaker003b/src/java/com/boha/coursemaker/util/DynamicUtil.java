package com.boha.coursemaker.util;

import com.boha.coursemaker.data.Activity;
import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.CourseTrainee;
import com.boha.coursemaker.data.CourseTraineeActivity;
import com.boha.coursemaker.data.Lesson;
import com.boha.coursemaker.data.TrainingClass;
import com.boha.coursemaker.data.TrainingClassCourse;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.servlet.TraineeServlet;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DynamicUtil {

    @PersistenceContext
    EntityManager em;

    public ResponseDTO updateActivityEnrolment(Integer trainingClassID, Integer instructorID,
            AdministratorUtil administratorUtil, InstructorUtil instructorUtil) throws
            DataException {
        long start = System.currentTimeMillis();
        ResponseDTO d = new ResponseDTO();

        TrainingClass tc = DataUtil.getTrainingClassByID(trainingClassID, em);
        List<TrainingClassCourse> list = getTrainingClassCourseList(tc, em);

        int cnt = 0;

        try {

            for (TrainingClassCourse tcc : list) {
                Course c = tcc.getCourse();
                List<CourseTrainee> ctList = getCourseTraineeList(tcc, em);
                for (CourseTrainee courseTrainee : ctList) {
                    for (Lesson lesson : administratorUtil.getCourseLessons(c, em)) {
                        List<Activity> acList = administratorUtil.getLessonActivities(lesson, em);
                        for (Activity activity : acList) {
                            if (!isEnrolled(courseTrainee, activity, em)) {
                                CourseTraineeActivity cta = new CourseTraineeActivity();
                                cta.setCourseTrainee(courseTrainee);
                                cta.setActivity(activity);
                                cta.setLesson(lesson);
                                cta.setDateUpdated(new Date());
                                em.persist(cta);
                                cnt++;
                                log.log(Level.INFO, "Enrolled courseTraineeID {0} lesson - {1} \nactivity - {2}",
                                        new Object[]{cta.getCourseTrainee().getCourseTraineeID(),
                                            lesson.getLessonName(), activity.getActivityName()});
                            }
                        }
                    }
                }
            }

            log.log(Level.INFO, "Trainee Activity enrolment done, total assigned: {0}", cnt);
            if (cnt > 0) {
                d = instructorUtil.getTraineeActivityByInstructor(instructorID);
            }
            d.setMessage("Trainee Activity enrolment done: " + cnt);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add trainee activity", e);
            throw new DataException("Failed to add trainee activity");
        }

        long end = System.currentTimeMillis();
        log.log(Level.INFO, "Elapsed time for activity enrolment process: {0}",
                TraineeServlet.getElapsed(start, end));
        return d;
    }

    private boolean isEnrolled(CourseTrainee ct, Activity act, EntityManager em) {
        boolean found = false;
        Query q = em.createNamedQuery("CourseTraineeActivity.isEnrolled", CourseTraineeActivity.class);
        q.setParameter("act", act);
        q.setParameter("ct", ct);
        List<CourseTraineeActivity> list = q.getResultList();
        if (list.size() > 0) {
            found = true;
        }

        return found;
    }

    private List<CourseTrainee> getCourseTraineeList(TrainingClassCourse tc, EntityManager em) {
        Query q = em.createNamedQuery("CourseTrainee.findByClassCourse", CourseTrainee.class);
        q.setParameter("id", tc.getTrainingClassCourseID());
        List<CourseTrainee> list = q.getResultList();
        return list;
    }

    private List<Activity> getLessonActivityList(Lesson tc, EntityManager em) {
        Query q = em.createNamedQuery("Activity.findByLesson", Activity.class);
        q.setParameter("id", tc.getLessonID());
        List<Activity> list = q.getResultList();
        return list;
    }

    private List<TrainingClassCourse> getTrainingClassCourseList(TrainingClass tc, EntityManager em) {
        Query q = em.createNamedQuery("TrainingClassCourse.findByTrainingClassID", TrainingClassCourse.class);
        q.setParameter("id", tc.getTrainingClassID());
        List<TrainingClassCourse> list = q.getResultList();
        return list;
    }
    final Logger log = Logger.getLogger(DynamicUtil.class.getName());

}
