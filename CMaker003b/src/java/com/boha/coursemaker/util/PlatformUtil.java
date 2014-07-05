/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.data.Company;
import com.boha.coursemaker.data.ErrorStore;
import com.boha.coursemaker.data.ErrorStoreAndroid;
import com.boha.coursemaker.dto.ErrorStoreAndroidDTO;
import com.boha.coursemaker.dto.ErrorStoreDTO;
import com.boha.coursemaker.dto.platform.CompanyStatsDTO;
import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.StatsResponseDTO;
import com.boha.coursemaker.servlet.AdministratorServlet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class PlatformUtil {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
    public final int THRESHOLD_SECONDS = 5;

    public void addAndroidError(ErrorStoreAndroid e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            log.log(Level.WARNING, "failed to add android error", ex);
        }
    }
    public StatsResponseDTO getPlatformStats() throws DataException {
        long s = System.currentTimeMillis();
        StatsResponseDTO d = new StatsResponseDTO();

        try {
            Query q = em.createNamedQuery("Company.findAll",Company.class);
            List<Company> comList = q.getResultList();
            List<CompanyStatsDTO> sList = new ArrayList<>();
            for (Company company : comList) {
                CompanyStatsDTO cs = new CompanyStatsDTO();
                cs.setCompanyID(company.getCompanyID());
                cs.setCompanyName(company.getCompanyName());
                cs.setDateRegistered(company.getDateRegistered().getTime());
                sList.add(cs);
            }

            q = em.createNamedQuery("Company.countCategories");
            List<Object[]> list = q.getResultList();

            for (Object[] objects : list) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfCategories(count);
                        break;
                    }
                }
            }
            //count courses
            q = em.createNamedQuery("Company.countCourses");
            List<Object[]> listc = q.getResultList();
            for (Object[] objects : listc) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfCourses(count);
                        break;
                    }
                }
            }
            //count lessons
            q = em.createNamedQuery("Company.countLessons");
            List<Object[]> listd = q.getResultList();
            for (Object[] objects : listd) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfLessons(count);
                        break;
                    }
                }
            }
            //count activities
            q = em.createNamedQuery("Company.countActivities");
            List<Object[]> liste = q.getResultList();
            for (Object[] objects : liste) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfActivities(count);
                        break;
                    }
                }
            }
            //count resource links
            q = em.createNamedQuery("Company.countLinks");
            List<Object[]> listf = q.getResultList();
            for (Object[] objects : listf) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfResourceLinks(count);
                        break;
                    }
                }
            }//count objectives
            q = em.createNamedQuery("Company.countObjectives");
            List<Object[]> listg = q.getResultList();
            for (Object[] objects : listg) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfObjectives(count);
                        break;
                    }
                }
            }
            //count trainees
            q = em.createNamedQuery("Company.countTrainees");
            List<Object[]> listh = q.getResultList();
            for (Object[] objects : listh) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfTrainees(count);
                        break;
                    }
                }
            }
            //count active trainees
            q = em.createNamedQuery("Company.countTraineesActive");
            List<Object[]> listk = q.getResultList();
            for (Object[] objects : listk) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfActiveTrainees(count);
                        break;
                    }
                }
            }
            //count traineeRatings
            q = em.createNamedQuery("Company.countTraineeRatings");
            List<Object[]> listi = q.getResultList();
            for (Object[] objects : listi) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfTraineeRatings(count);
                        break;
                    }
                }
            }
            //count traineeRatings
            q = em.createNamedQuery("Company.countInstructorRatings");
            List<Object[]> listj = q.getResultList();
            for (Object[] objects : listj) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfInstructorRatings(count);
                        break;
                    }
                }
            }
            //count authors
            q = em.createNamedQuery("Company.countAuthors");
            List<Object[]> listm = q.getResultList();
            for (Object[] objects : listm) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfAuthors(count);
                        break;
                    }
                }
            }
            //count admins
            q = em.createNamedQuery("Company.countAdministrators");
            List<Object[]> listn = q.getResultList();
            for (Object[] objects : listn) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfAdmins(count);
                        break;
                    }
                }

            }
            //count instructors
            q = em.createNamedQuery("Company.countInstructors");
            List<Object[]> listp = q.getResultList();
            for (Object[] objects : listp) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfInstructors(count);
                        break;
                    }
                }
            }
            //count classes
            q = em.createNamedQuery("Company.countClasses");
            List<Object[]> listo = q.getResultList();
            for (Object[] objects : listo) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfClasses(count);
                        break;
                    }
                }
            }
            //count active classes
            q = em.createNamedQuery("Company.countClassesActive");
            List<Object[]> listq = q.getResultList();
            for (Object[] objects : listq) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNunmberOfActiveClasses(count);
                        break;
                    }
                }
            }
            //count trainingClassCourses 
            q = em.createNamedQuery("Company.countClassCourses");
            List<Object[]> listr = q.getResultList();
            for (Object[] objects : listr) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfTrainingClassCourses(count);
                        break;
                    }
                }
            }
            //count courseTraineeActivities 
            q = em.createNamedQuery("Company.countCourseTraineeActivities");
            List<Object[]> lists = q.getResultList();
            for (Object[] objects : lists) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfCourseTraineeActivities(count);
                        break;
                    }
                }
            }

            d.setStatsList(sList);
            long e = System.currentTimeMillis();
            log.log(Level.INFO, "Platform Stats taken: elapsed seconds: {0}",
                    AdministratorServlet.getElapsed(s, e));
        } catch (Exception e) {
            log.log(Level.INFO, "Failed to get overall stats", e);
            throw new DataException(e.getMessage());
        }

        return d;
    }
    final long ONE_MONTH = 1000 * 60 * 60 * 24 * 30;

    public StatsResponseDTO getErrorStoreList(long dateFrom, long dateTo)
            throws DataException {
        Calendar cal = GregorianCalendar.getInstance();
        Date toDate = cal.getTime();
        Date fromDate;
        if (dateFrom == 0) {
            dateFrom = new Date().getTime() + (ONE_MONTH * 3);
            cal.setTimeInMillis(dateFrom);
            fromDate = cal.getTime();

        } else {
            toDate = new Date(dateTo);
            fromDate = new Date(dateFrom);
        }
        log.log(Level.INFO, "errorList From Date: {0}\tTo Date: {1}",
                new Object[]{fromDate, toDate});
        StatsResponseDTO d = new StatsResponseDTO();

        try {
            Query q = em.createNamedQuery("ErrorStore.findInPeriod",ErrorStore.class);
            q.setParameter("from", fromDate);
            q.setParameter("to", toDate);
            List<ErrorStore> list = q.getResultList();
            List<ErrorStoreDTO> elist = new ArrayList<>();
            for (ErrorStore errorStore : list) {
                elist.add(new ErrorStoreDTO(errorStore));
            }
            d.setErrorStoreList(elist);
            //
            q = em.createNamedQuery("ErrorStoreAndroid.findInPeriod",ErrorStore.class);
            q.setParameter("from", fromDate);
            q.setParameter("to", toDate);
            List<ErrorStoreAndroid> lista = q.getResultList();
            List<ErrorStoreAndroidDTO> elista = new ArrayList<>();
            for (ErrorStoreAndroid errorStore : lista) {
                elista.add(new ErrorStoreAndroidDTO(errorStore));
            }
            d.setErrorStoreAndroidList(elista);
            
            
            log.log(Level.INFO, "ErrorStore rows found: {0}", elist.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get errorStoreList", e);
            throw new DataException("Failed to get errorStoreList\n" + e.getMessage());
        }
        return d;
    }

    public void addTimeElapsedWarning(long start, long end, RequestDTO dto, String origin) {
        if (dto == null) {
            dto = new RequestDTO();
        }
        if (end - start > (1000 * THRESHOLD_SECONDS)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Servlet took more than ").append(THRESHOLD_SECONDS)
                    .append(" seconds to process request\nRequest type is ")
                    .append(dto.getRequestType()).append("\n");
            sb.append("Elapsed time in seconds: ").append(AdministratorServlet.getElapsed(start, end));
            addErrorStore(111, sb.toString(), origin);
        }
    }

    public void addErrorStore(int statusCode, String message, String origin) {
        log.log(Level.OFF, "------ adding errorStore, message: {0} origin: {1}", new Object[]{message, origin});
        try {
            ErrorStore t = new ErrorStore();
            t.setDateOccured(new Date());
            t.setMessage(message);
            t.setStatusCode(statusCode);
            t.setOrigin(origin);
            em.persist(t);
            log.log(Level.INFO, "####### ErrorStore row added, origin {0} message: {1}",
                    new Object[]{origin, message});
        } catch (Exception e) {
            log.log(Level.SEVERE, "####### Failed to add errorStore from " + origin + "\n" + message, e);
        }
    }

    public StatsResponseDTO getCompanyStats(Integer companyID) throws DataException {
        long s = System.currentTimeMillis();
        StatsResponseDTO d = new StatsResponseDTO();

        try {
            Query q = em.createNamedQuery("Company.countCategoriesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> list = q.getResultList();
            List<CompanyStatsDTO> sList = new ArrayList<>();
            for (Object[] objects : list) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                CompanyStatsDTO cs = new CompanyStatsDTO();
                cs.setCompanyID(c.getCompanyID());
                cs.setCompanyName(c.getCompanyName());
                cs.setDateRegistered(c.getDateRegistered().getTime());
                cs.setNumberOfCategories(count);
                sList.add(cs);
            }
            //count courses
            q = em.createNamedQuery("Company.countCoursesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listc = q.getResultList();
            for (Object[] objects : listc) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfCourses(count);
                        break;
                    }
                }
            }
            //count lessons
            q = em.createNamedQuery("Company.countLessonsByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listd = q.getResultList();
            for (Object[] objects : listd) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfLessons(count);
                        break;
                    }
                }
            }
            //count activities
            q = em.createNamedQuery("Company.countActivitiesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> liste = q.getResultList();
            for (Object[] objects : liste) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfActivities(count);
                        break;
                    }
                }
            }
            //count resource links
            q = em.createNamedQuery("Company.countLinksByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listf = q.getResultList();
            for (Object[] objects : listf) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfResourceLinks(count);
                        break;
                    }
                }
            }//count obj
            q = em.createNamedQuery("Company.countObjectivesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listg = q.getResultList();
            for (Object[] objects : listg) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfObjectives(count);
                        break;
                    }
                }
            }
            //count trainees
            q = em.createNamedQuery("Company.countTraineesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listh = q.getResultList();
            for (Object[] objects : listh) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfTrainees(count);
                        break;
                    }
                }
            }
            //count active trainees
            q = em.createNamedQuery("Company.countTraineesActiveByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listk = q.getResultList();
            for (Object[] objects : listk) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfActiveTrainees(count);
                        break;
                    }
                }
            }
            //count traineeRatings
            q = em.createNamedQuery("Company.countTraineeRatingsByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listi = q.getResultList();
            for (Object[] objects : listi) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfTraineeRatings(count);
                        break;
                    }
                }
            }
            //count traineeRatings
            q = em.createNamedQuery("Company.countInstructorRatingsByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listj = q.getResultList();
            for (Object[] objects : listj) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfInstructorRatings(count);
                        break;
                    }
                }
            }
            //count authors
            q = em.createNamedQuery("Company.countAuthorsByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listm = q.getResultList();
            for (Object[] objects : listm) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfAuthors(count);
                        break;
                    }
                }
            }
            //count admins
            q = em.createNamedQuery("Company.countAdministratorsByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listn = q.getResultList();
            for (Object[] objects : listn) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfAdmins(count);
                        break;
                    }
                }
            }
            //count instructors
            q = em.createNamedQuery("Company.countInstructorsByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listp = q.getResultList();
            for (Object[] objects : listp) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfInstructors(count);
                        break;
                    }
                }
            }
            //count classes
            q = em.createNamedQuery("Company.countClassesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listo = q.getResultList();
            for (Object[] objects : listo) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfClasses(count);
                        break;
                    }
                }
            }
            //count active classes
            q = em.createNamedQuery("Company.countClassesActiveByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listq = q.getResultList();
            for (Object[] objects : listq) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNunmberOfActiveClasses(count);
                        break;
                    }
                }
            }
            //count trainingClassCourses 
            q = em.createNamedQuery("Company.countClassCoursesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> listr = q.getResultList();
            for (Object[] objects : listr) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfTrainingClassCourses(count);
                        break;
                    }
                }
            }
            //count courseTraineeActivities 
            q = em.createNamedQuery("Company.countCourseTraineeActivitiesByCompany");
            q.setParameter("id", companyID);
            List<Object[]> lists = q.getResultList();
            for (Object[] objects : lists) {
                Company c = (Company) objects[0];
                int count = (int) ((Number) objects[1]);
                for (CompanyStatsDTO cs : sList) {
                    if (cs.getCompanyID() == c.getCompanyID()) {
                        cs.setNumberOfCourseTraineeActivities(count);
                        break;
                    }
                }
            }

            d.setStatsList(sList);
            long e = System.currentTimeMillis();
            log.log(Level.INFO, "Platform Stats taken: elapsed seconds: {0}",
                    AdministratorServlet.getElapsed(s, e));
        } catch (Exception e) {
            log.log(Level.INFO, "Failed to get company stats", e);
            throw new DataException(e.getMessage());
        }
        return d;
    }
    private final Logger log = Logger.getLogger("ErrorStoreUtil");
}
