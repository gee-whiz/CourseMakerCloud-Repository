/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.data.Activity;
import com.boha.coursemaker.data.Author;
import com.boha.coursemaker.data.Category;
import com.boha.coursemaker.data.Company;
import com.boha.coursemaker.data.Course;
import com.boha.coursemaker.data.CourseAuthor;
import com.boha.coursemaker.data.GcmDevice;
import com.boha.coursemaker.data.LessonResource;
import com.boha.coursemaker.data.Objective;

import com.boha.coursemaker.dto.ActivityDTO;
import com.boha.coursemaker.dto.AuthorDTO;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.ObjectiveDTO;
import com.boha.coursemaker.dto.LessonResourceDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.dto.CompanyDTO;
import com.boha.coursemaker.dto.GcmDeviceDTO;
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
public class AuthorUtil {

    @PersistenceContext
    EntityManager em;

    public ResponseDTO updateObjectives(List<ObjectiveDTO> list)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int courseID = list.get(0).getCourseID();
        try {

            for (ObjectiveDTO dto : list) {
                Objective a = DataUtil.getObjectiveByID(dto.getObjectiveID(), em);
                if (a != null) {
                    if (dto.getObjectiveName() != null) {
                        a.setObjectiveName(dto.getObjectiveName());
                    }
                    if (dto.getDescription() != null) {
                        a.setDescription(dto.getDescription());
                    }

                    em.merge(a);
                } else {
                    log.log(Level.SEVERE, "***ERROR*** Objective not found");
                    throw new DataException("Objective not found for update");
                }
            }

            Query q = em.createNamedQuery("Objective.findByCourse");
            q.setParameter("id", courseID);
            List<Objective> listx = q.getResultList();
            List<ObjectiveDTO> dto = new ArrayList<>();
            for (Objective crs : listx) {
                dto.add(new ObjectiveDTO(crs));
            }
            d.setObjectiveList(dto);
            d.setMessage("Objectives updated OK");
            log.log(Level.INFO, "Objectives updated ");
        } catch (Exception e) {
            throw new DataException(DataUtil.getErrorString(e));

        } finally {
        }
        return d;
    }

    public ResponseDTO updateActivities(List<ActivityDTO> list)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            for (ActivityDTO dto : list) {
                Activity a = em.find(Activity.class, dto.getActivityID());
                if (a != null) {
                    if (dto.getActivityName() != null) {
                        a.setActivityName(dto.getActivityName());
                    }

                    if (dto.getDescription() != null) {
                        a.setDescription(dto.getDescription());
                    }

                    a.setPriorityFlag(dto.getPriorityFlag());

                    em.merge(a);
                } else {
                    log.log(Level.SEVERE, "***ERROR*** activity not found");
                    throw new DataException("Activity not found for update");
                }
            }

            Query q = em.createNamedQuery("Activity.findByCourseID", Activity.class);
            q.setParameter("id", list.get(0).getCourseID());
            List<Activity> listx = q.getResultList();
            List<ActivityDTO> dto = new ArrayList<>();
            for (Activity crs : listx) {
                dto.add(new ActivityDTO(crs));
            }
            d.setActivityList(dto);
            d.setMessage("Activities updated OK");
            //log.log(Level.INFO, "Activities updated ");
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            throw new DataException(DataUtil.getErrorString(e));

        } finally {
        }
        return d;
    }

    public ResponseDTO loginAuthor(String email, String password, GcmDeviceDTO device, PlatformUtil platformUtil) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Author.login", Author.class);
            q.setParameter("email", email);
            q.setParameter("pswd", password);
            q.setMaxResults(1);
            Author author = (Author) q.getSingleResult();

            if (author != null) {
                d.setAuthor(new AuthorDTO(author));
                d.setCompany(new CompanyDTO(author.getCompany()));
                d.setCategoryList(getCategories(author.getCompany(), false));

                try {
                    if (device != null) {
                        GcmDevice gcm = new GcmDevice();
                        gcm.setManufacturer(device.getManufacturer());
                        gcm.setModel(device.getModel());
                        gcm.setProduct(device.getProduct());
                        gcm.setSerialNumber(device.getSerialNumber());
                        gcm.setRegistrationID(device.getRegistrationID());
                        gcm.setDateRegistered(new Date());
                        gcm.setAuthor(author);
                        em.persist(gcm);

                        CloudMessagingRegistrar.sendRegistration(gcm.getRegistrationID(), platformUtil);

                    }
                } catch (Exception e) {
                    log.log(Level.WARNING, "Device registration failed", e);
                    platformUtil.addErrorStore(ResponseDTO.ERROR_DATABASE,
                            "Device registration failed\n"
                            + DataUtil.getErrorString(e), "Author Services");
                }
                //log.log(Level.INFO, "Author signed in: {1} {2}",
                //      new Object[]{author.getEmail(), author.getFirstName(), author.getLastName()});
            } else {
                d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
                d.setMessage("Sign in failed");
            }
        } catch (NoResultException e) {
            d.setStatusCode(ResponseDTO.ERROR_USER_LOGIN);
            d.setMessage("Email or password invalid. Please check!");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to login user", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO registerAuthor(AuthorDTO author, int companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Company tc = DataUtil.getCompanyByID(companyID, em);

            Author a = new Author();
            a.setFirstName(author.getFirstName());
            a.setLastName(author.getLastName());
            a.setEmail(author.getEmail());
            a.setCellphone(author.getCellphone());
            a.setCompany(tc);
            a.setPassword(DataUtil.createPassword());
            a.setDateRegistered(new Date());
            em.persist(a);

            Query q = em.createNamedQuery("Author.findByCompany", Author.class);
            q.setParameter("id", companyID);
            List<Author> list = q.getResultList();
            d.setAuthorList(new ArrayList<AuthorDTO>());
            for (Author x : list) {
                d.getAuthorList().add(new AuthorDTO(x));
            }
            d.setCompany(new CompanyDTO(tc));
            d.setMessage("Author registered OK");

            //log.log(Level.INFO, " Company: {0} Author registered: {1} {2}",
            //      new Object[]{tc.getCompanyName(), a.getFirstName(), a.getLastName()});
        } catch (RollbackException e) {
            log.log(Level.WARNING, "Failed, might be duplicate", e);
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Author with this email already exists. Please Sign In");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register Author", e);
            throw new DataException("Failed to register Author\n"
                    + DataUtil.getErrorString(e));

        } finally {
        }
        return d;
    }

    public List<CategoryDTO> getCategories(Company co, boolean getCourses) {
        List<Category> list = co.getCategoryList();
        List<CategoryDTO> gList = new ArrayList<>();
        for (Category c : list) {
            gList.add(new CategoryDTO(c));
        }
        return gList;
    }

    public List<CategoryDTO> getCategoriesx(int companyID, boolean getCourses) {
        Company co = DataUtil.getCompanyByID(companyID, em);
        List<Category> list = co.getCategoryList();
        List<CategoryDTO> gList = new ArrayList<>();
        for (Category c : list) {
            gList.add(new CategoryDTO(c));
        }
        return gList;
    }

    public List<CategoryDTO> addInitialCategories(
            int companyID, EntityManager em) throws DataException {

        List<CategoryDTO> dto = new ArrayList<>();
        try {
            Company tc = DataUtil.getCompanyByID(companyID, em);

            Category a = new Category();
            a.setCategoryName("Cloud Application Computing");
            a.setCompany(tc);
            a.setLocalID(System.currentTimeMillis());
            em.persist(a);
            //
            Thread.sleep(3);
            Category a1 = new Category();
            a1.setCategoryName("Android Development");
            a1.setCompany(tc);
            a1.setLocalID(System.currentTimeMillis());
            em.persist(a1);
            //
            Thread.sleep(3);
            Category a2 = new Category();
            a2.setCategoryName("Database Development");
            a2.setCompany(tc);
            a2.setLocalID(System.currentTimeMillis());
            em.persist(a2);
            //
            Thread.sleep(3);
            Category a3 = new Category();
            a3.setCategoryName("HTML5 App Development");
            a3.setCompany(tc);
            a3.setLocalID(System.currentTimeMillis());
            em.persist(a3);
            //
            Thread.sleep(3);
            Category a4 = new Category();
            a4.setCategoryName("Windows Phone Development");
            a4.setCompany(tc);
            a4.setLocalID(System.currentTimeMillis());
            em.persist(a4);
            //
            Thread.sleep(3);
            Category a5 = new Category();
            a5.setCategoryName("Feature Phone Development");
            a5.setCompany(tc);
            a5.setLocalID(System.currentTimeMillis());
            em.persist(a5);
            //
            Thread.sleep(3);
            Category a6 = new Category();
            a6.setCategoryName("Ubuntu Touch Development");
            a6.setCompany(tc);
            a6.setLocalID(System.currentTimeMillis());
            em.persist(a6);

            Query q = em.createNamedQuery("Category.findByCompanyID");
            q.setParameter("id", companyID);
            List<Category> list = q.getResultList();

            for (Category inv : list) {
                dto.add(new CategoryDTO(inv));
                //log.log(Level.INFO, "sorted Category added to author: {0}", inv.getCategoryName());
            }
            //log.log(Level.INFO, "Initial Categories loaded: {0}",
            //      new Object[]{dto.size()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding category", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return dto;
    }

    public ResponseDTO addCategory(int companyID,
            CategoryDTO category) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {
            Company tc = DataUtil.getCompanyByID(companyID, em);

            Category a = new Category();
            a.setCategoryName(category.getCategoryName());
            a.setCompany(tc);
            em.persist(a);

            d.setCategory(new CategoryDTO(a));

            Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);
            q.setParameter("id", companyID);
            List<Category> list = q.getResultList();
            List<CategoryDTO> dto = new ArrayList<>();
            for (Category c : list) {
                dto.add(new CategoryDTO(c));
            }
            d.setCategoryList(dto);
            d.setMessage("category added on server");
            //log.log(Level.INFO, "Category loaded: {0}",
            //      new Object[]{a.getCategoryName()});
        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The category already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding category", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteCategory(
            CategoryDTO category) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {

            Category a = DataUtil.getCategoryByID(category.getCategoryID(), em);
            em.remove(a);

            Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);
            q.setParameter("id", category.getCompanyID());
            List<Category> list = q.getResultList();
            List<CategoryDTO> dto = new ArrayList<>();
            for (Category c : list) {
                dto.add(new CategoryDTO(c));
            }
            d.setCategoryList(dto);
            d.setMessage("category deleted on server");
            //log.log(Level.INFO, "Category deleted: {0}",
            //      new Object[]{a.getCategoryName()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** deleting category", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO updateCategory(
            CategoryDTO category) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {

            Category a = DataUtil.getCategoryByID(category.getCategoryID(), em);
            a.setCategoryName(category.getCategoryName());
            em.merge(a);

            d.setCategory(new CategoryDTO(a));

            Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);;
            q.setParameter("id", category.getCompanyID());
            List<Category> list = q.getResultList();
            List<CategoryDTO> dto = new ArrayList<>();
            for (Category c : list) {
                dto.add(new CategoryDTO(c));
            }
            d.setCategoryList(dto);
            d.setMessage("category updated on server");
            //log.log(Level.INFO, "Category updated: {0}",
            //      new Object[]{a.getCategoryName()});

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** update category", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    /**
     * Get course listx for training company
     *
     * @param companyID
     * @return
     * @throws DataException
     */
    public ResponseDTO getCompanyCourseList(
            int companyID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Course.findByCompanyID", Course.class);
            q.setParameter("id", companyID);
            List<Course> list = q.getResultList();
            List<CourseDTO> dtoList = new ArrayList<>();
            for (Course tcc : list) {
                dtoList.add(new CourseDTO(tcc));
            }

            List<ObjectiveDTO> objectiveList = getCompanyObjectives(companyID);
            List<LessonResourceDTO> linkList = getCompanyLinks(companyID);
            List<ActivityDTO> actList = getCompanyActivities(companyID);
            //
            for (CourseDTO c : dtoList) {
                c.setActivityList(new ArrayList<ActivityDTO>());
                c.setObjectiveList(new ArrayList<ObjectiveDTO>());
                c.setLessonResourceList(new ArrayList<LessonResourceDTO>());

                for (ObjectiveDTO o : objectiveList) {
                    if (o.getCourseID() == c.getCourseID()) {
                        c.getObjectiveList().add(o);
                    }
                }

                for (ActivityDTO act : actList) {
                    if (act.getCourseID() == c.getCourseID()) {
                        c.getActivityList().add(act);
                    }

                }
                for (LessonResourceDTO link : linkList) {
                    if (c.getCourseID() == link.getCourseID()) {
                        c.getLessonResourceList().add(link);
                    }
                }

            }

            d.setCourseList(dtoList);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(DataUtil.getErrorString(e));
        }

        return d;
    }

    private List<ActivityDTO> getCompanyActivities(int companyID) {
        List<ActivityDTO> list;

        Query q = em.createNamedQuery("Activity.findByCompany", Activity.class);
        q.setParameter("id", companyID);
        List<Activity> mlist = q.getResultList();
        list = new ArrayList<>();
        for (Activity tcc : mlist) {
            list.add(new ActivityDTO(tcc));
        }

        return list;
    }

    private List<LessonResourceDTO> getCompanyLinks(int companyID) {
        List<LessonResourceDTO> list;

        Query q = em.createNamedQuery("LessonResource.findByCompany", LessonResource.class);
        q.setParameter("id", companyID);
        List<LessonResource> mlist = q.getResultList();
        list = new ArrayList<>();
        for (LessonResource tcc : mlist) {
            list.add(new LessonResourceDTO(tcc));
        }

        return list;
    }

    private List<ObjectiveDTO> getCompanyObjectives(int companyID) {
        List<ObjectiveDTO> list;

        Query q = em.createNamedQuery("Objective.findByCompany");
        q.setParameter("id", companyID);
        List<Objective> mlist = q.getResultList();
        list = new ArrayList<>();
        for (Objective tcc : mlist) {
            list.add(new ObjectiveDTO(tcc));
        }

        return list;
    }

    /**
     * Add listx of Activities that comprise a1 Lesson to the database
     *
     * @param a
     * @param courseID
     * @return
     * @throws DataException
     */
    public ResponseDTO addActivity(ActivityDTO a,
            int courseID)
            throws DataException {
        log.log(Level.OFF, "------- add activity, courseID: {0}", courseID);
        ResponseDTO d = new ResponseDTO();

        Course course;
        try {

            course = em.find(Course.class, courseID);
            Activity activity = new Activity();
            activity.setCourse(course);
            activity.setDescription(a.getDescription());
            activity.setActivityName(a.getActivityName());

            activity.setPriorityFlag(a.getPriorityFlag());
            activity.setLocalID(a.getLocalID());
            em.persist(activity);

            Query q = em.createNamedQuery("Activity.findByCourseID", Activity.class);
            q.setParameter("id", courseID);
            List<Activity> list = q.getResultList();
            List<ActivityDTO> dto = new ArrayList<>();
            for (Activity crs : list) {
                dto.add(new ActivityDTO(crs));
            }
            d.setActivityList(dto);
            d.setMessage("activity added on server");
            //log.log(Level.INFO, "Activity added to course: {0} - added: {1}",
            //      new Object[]{lesson.getLessonName(), activity.getActivityName()});
        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The activity already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding act", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    /**
     * Write listx of LessonObjectives for a1 specific Lesson to the database
     *
     * @param objectiveList
     * @param courseID
     * @return
     * @throws DataException
     */
    public ResponseDTO addObjective(ObjectiveDTO objective, int courseID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        Course course;
        try {

            course = DataUtil.getCourseByID(courseID, em);
            Objective ls = new Objective();
            ls.setCourse(course);
            ls.setDescription(objective.getDescription());
            ls.setObjectiveName(objective.getObjectiveName());

            em.persist(ls);

            d.setObjective(new ObjectiveDTO(ls));
            Query q = em.createNamedQuery("Objective.findByCourse");
            q.setParameter("id", courseID);
            List<Objective> list = q.getResultList();
            List<ObjectiveDTO> dto = new ArrayList<>();
            for (Objective crs : list) {
                dto.add(new ObjectiveDTO(crs));
            }
            d.setObjectiveList(dto);
            d.setMessage("objective added on server");
            //log.log(Level.INFO, "Objective added to course: {0} - added objective: {1}",
            //      new Object[]{course.getCourseName(), ls.getObjectiveName()});
        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The objective already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding objective", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {

            return d;
        }
    }

    /**
     * Write listx of LessonRessources for a1 specific Lesson to the database
     *
     * @param l
     * @return
     * @throws DataException
     */
    public ResponseDTO addLessonResource(LessonResourceDTO l)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        log.log(Level.OFF, "addLessonResource courseID: {0}", l.getCourseID());
        Course act;
        try {

            act = em.find(Course.class, l.getCourseID());
            LessonResource ls = new LessonResource();
            ls.setCourse(act);
            ls.setDateUpdated(new Date());
            ls.setResourceName(l.getResourceName());
            ls.setUrl(l.getUrl());
            em.persist(ls);

            Query q = em.createNamedQuery("LessonResource.findByCourse", LessonResource.class);
            q.setParameter("id", l.getCourseID());
            List<LessonResource> list = q.getResultList();
            List<LessonResourceDTO> dto = new ArrayList<>();
            for (LessonResource crs : list) {
                dto.add(new LessonResourceDTO(crs));
            }

            d.setLessonResourceList(dto);
            d.setMessage("resource added on server");
            //log.log(Level.INFO, "Lesson Resource added to lesson: {0} - added resources: {1}",
            //      new Object[]{lesson.getLessonName(), ls.getUrl()});
        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The link already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding resource", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {

            return d;
        }
    }

    private List<LessonResourceDTO> getCourseLinks(int courseID) {

        Query q = em.createNamedQuery("LessonResource.findByCourse", LessonResource.class);
        q.setParameter("id", courseID);
        List<LessonResource> list = q.getResultList();
        List<LessonResourceDTO> dto = new ArrayList<>();
        for (LessonResource r : list) {
            dto.add(new LessonResourceDTO(r));
        }
        return dto;
    }

    private List<ActivityDTO> getCourseActivities(int courseID) {

        Query q = em.createNamedQuery("Activity.findByCourseID", Activity.class);
        q.setParameter("id", courseID);
        List<Activity> list = q.getResultList();
        List<ActivityDTO> dto = new ArrayList<>();
        for (Activity activity : list) {
            dto.add(new ActivityDTO(activity));
        }
        return dto;
    }

    public ResponseDTO getActivitiesByLesson(
            int lessonID)
            throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("Activity.findByLesson", Activity.class);
            q.setParameter("id", lessonID);
            List<Activity> lsList = q.getResultList();
            List<ActivityDTO> dtoList = new ArrayList<>();
            for (Activity lesson : lsList) {
                dtoList.add(new ActivityDTO(lesson));
            }
            d.setActivityList(dtoList);
            d.setMessage("activities listed");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getObjectivesByCourse(
            int courseID)
            throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {

            Query q = em.createNamedQuery("Objective.findByCourse");
            q.setParameter("id", courseID);
            List<Objective> lsList = q.getResultList();
            List<ObjectiveDTO> dtoList = new ArrayList<>();
            for (Objective lesson : lsList) {
                dtoList.add(new ObjectiveDTO(lesson));
            }
            d.setObjectiveList(dtoList);
            d.setMessage("objectives listed");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    public List<LessonResourceDTO> getLinksByCourse(int courseID) {

        Query q = em.createNamedQuery("LessonResource.findByCourse", LessonResource.class);
        q.setParameter("id", courseID);
        List<LessonResource> resourceList = q.getResultList();

        List<LessonResourceDTO> lessonResourceList = new ArrayList<>();
        for (LessonResource lo : resourceList) {
            lessonResourceList.add(new LessonResourceDTO(lo));
        }

        return lessonResourceList;

    }

    private List<ActivityDTO> getActivitiesByCourse(int courseID) {
        Query q = em.createNamedQuery("Activity.findByCourseID", Activity.class);
        q.setParameter("id", courseID);
        List<Activity> actList = q.getResultList();
        List<ActivityDTO> dto = new ArrayList<>();
        for (Activity a : actList) {
            dto.add(new ActivityDTO(a));
        }
        return dto;
    }

    public ResponseDTO getCoursesByCategory(int categoryID)
            throws DataException {

        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Course.findByCategoryID", Course.class);
            q.setParameter("id", categoryID);
            List<Course> lsList = q.getResultList();
            List<CourseDTO> dtoList = new ArrayList<>();
            for (Course c : lsList) {
                dtoList.add(new CourseDTO(c));
            }
            List<ActivityDTO> actList = getActivitiesByCategory(categoryID);
            List<LessonResourceDTO> linkList = getLinksByCategory(categoryID);

            for (CourseDTO course : dtoList) {
                course.setActivityList(new ArrayList<ActivityDTO>());
                course.setLessonResourceList(new ArrayList<LessonResourceDTO>());
                for (ActivityDTO act : actList) {

                    if (act.getCourseID() == course.getCourseID()) {
                        course.getActivityList().add(act);
                    }
                }
                for (LessonResourceDTO lr : linkList) {
                    if (lr.getCourseID() == course.getCourseID()) {
                        course.getLessonResourceList().add(lr);
                    }
                }
            }

            d.setCourseList(dtoList);
            d.setMessage("courses listed " + dtoList.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
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

    public ResponseDTO getCategoryList(int trainingCompanyID,
            int authorID)
            throws DataException {

        ResponseDTO d = new ResponseDTO();
        try {

            Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);
            q.setParameter("id", trainingCompanyID);
            List<Category> lsList = q.getResultList();
            List<CategoryDTO> dtoList = new ArrayList<>();
            for (Category c : lsList) {
                dtoList.add(new CategoryDTO(c));
            }
            List<Course> courseList = getCourses(authorID, em);
            List<Activity> ativitycList = getActivity(authorID, em);
            List<LessonResource> resourceList = getResources(authorID, em);

            for (CategoryDTO cat : dtoList) {
                //log.log(Level.OFF, "setting up category: {0}", cat.getCategoryName());
                cat.setCourseList(new ArrayList<CourseDTO>());
                for (Course course : courseList) {
                    if (course.getCategory().getCategoryID()
                            == cat.getCategoryID()) {
                        CourseDTO cDTO = new CourseDTO(course);
                        cDTO.setActivityList(new ArrayList<ActivityDTO>());
                        cDTO.setLessonResourceList(new ArrayList<LessonResourceDTO>());
                        for (Activity act : ativitycList) {
                            if (act.getCourse().getCourseID() == course.getCourseID()) {

                                ActivityDTO aa = new ActivityDTO(act);

                                cDTO.getActivityList().add(aa);

                            }
                        }
                        for (LessonResource res : resourceList) {
                            if (res.getCourse().getCourseID() == course.getCourseID()) {
                                cDTO.getLessonResourceList().add(new LessonResourceDTO(res));
                            }
                        }
                        cat.getCourseList().add(cDTO);
                    }

                }
            }

            d.setCategoryList(dtoList);
            d.setMessage("categories listed " + dtoList.size());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ", e);
            throw new DataException(DataUtil.getErrorString(e));
        }
        return d;
    }

    private List<Activity> getActivity(int authorID, EntityManager em) {
        Query q = em.createNamedQuery("Activity.findByAuthor", Activity.class);
        q.setParameter("authorID", authorID);
        List<Activity> list = q.getResultList();
        log.log(Level.INFO, "Author activities : {0}", list.size());
        return list;
    }

    private List<LessonResource> getResources(int authorID, EntityManager em) {
        Query q = em.createNamedQuery("LessonResource.findByAuthorID", LessonResource.class);
        q.setParameter("authorID", authorID);
        List<LessonResource> list = q.getResultList();
        log.log(Level.INFO, "Author links : {0}", list.size());
        return list;
    }

    /**
     * Get all Courses that belong to the Author
     *
     * @param authorID
     * @param em
     * @return
     */
    private List<Course> getCourses(int authorID, EntityManager em) {
        Query q = em.createNamedQuery("Course.findByAuthorID", Course.class);
        q.setParameter("authorID", authorID);
        List<Course> list = q.getResultList();
        //log.log(Level.INFO, "Author courses : {0}", list.size());
        return list;
    }

    /**
     * Add a1 course to the database. This happens as the first action before
     * adding lessons.
     *
     * @param course
     * @param companyID
     * @param authorID
     * @return
     * @throws DataException
     */
    public ResponseDTO addCourse(CourseDTO course,
            int companyID,
            int authorID)
            throws DataException {
        log.log(Level.INFO, "### adding course, company: {0} author: {1}", new Object[]{companyID, authorID});
        ResponseDTO d = new ResponseDTO();

        try {

            Course c = new Course();
            c.setCourseName(course.getCourseName());
            c.setDescription(course.getDescription());
            c.setDateUpdated(new Date());
            c.setCategory(em.find(Category.class, course.getCategoryID()));
            c.setCompany(em.find(Company.class, companyID));
            c.setDateUpdated(new Date());

            em.persist(c);
            if (authorID > 0) {
                CourseAuthor ca = new CourseAuthor();
                ca.setAuthor(em.find(Author.class, authorID));
                ca.setCourse(c);
                ca.setDateUpdated(new Date());
                em.persist(ca);
            }
            Query q = em.createNamedQuery("Course.findByCategoryID", Course.class);
            q.setParameter("id", course.getCategoryID());
            List<Course> list = q.getResultList();
            List<CourseDTO> dto = new ArrayList<>();
            for (Course crs : list) {
                dto.add(new CourseDTO(crs));
            }
            d.setCourseList(dto);
            d.setMessage("course added on server");
            log.log(Level.INFO, "### Course added: {0} courses: {1}", new Object[]{course.getCourseName(), dto.size()});
        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The course already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO updateCourse(CourseDTO course,
            int authorID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            Course c = DataUtil.getCourseByID(course.getCourseID(), em);
            if (course.getCourseName() != null) {
                c.setCourseName(course.getCourseName());
            }
            if (course.getDescription() != null) {
                c.setDescription(course.getDescription());
            }
            c.setDateUpdated(new Date());

            em.merge(c);

            d.setCourse(new CourseDTO(c));
            List<CourseAuthor> authors = c.getCourseAuthorList();
            boolean isFound = false;
            if (authorID > 0) {
                for (CourseAuthor ca : authors) {
                    if (ca.getAuthor().getAuthorID() == authorID) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {

                    CourseAuthor ca = new CourseAuthor();
                    ca.setCourse(c);
                    ca.setAuthor(DataUtil.getAuthorByID(authorID, em));
                    ca.setDateUpdated(new Date());
                    em.persist(ca);

                }
            }

            Query q = em.createNamedQuery("Course.findByCategoryID", Course.class);
            q.setParameter("id", course.getCategoryID());
            List<Course> list = q.getResultList();
            List<CourseDTO> dto = new ArrayList<>();
            for (Course crs : list) {
                dto.add(new CourseDTO(crs));
            }
            d.setCourseList(dto);
            d.setMessage("course added on server");

            //log.log(Level.INFO, "### Course added: {0}", course.getCourseName());
        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteCourse(int courseID,
            int authorID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int categoryID;
        try {

            Course c = DataUtil.getCourseByID(courseID, em);
            categoryID = c.getCategory().getCategoryID();
            em.remove(c);

            Query q = em.createNamedQuery("Course.findByCategoryID", Course.class);
            q.setParameter("id", categoryID);
            List<Course> list = q.getResultList();
            List<CourseDTO> dto = new ArrayList<>();
            for (Course course : list) {
                dto.add(new CourseDTO(course));
            }
            d.setCourseList(dto);
            d.setMessage(c.getCourseName() + " deleted from server");

            //log.log(Level.INFO, "### Course deleted: {0}", c.getCourseName());
        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** deleting course", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteActivities(List<ActivityDTO> actList,
            int courseID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            for (ActivityDTO activity : actList) {
                Activity a = DataUtil.getActivityByID(activity.getActivityID(), em);
                em.remove(a);
            }

            Query q = em.createNamedQuery("Activity.findByCourseID", Activity.class);
            q.setParameter("id", courseID);
            List<Activity> lsList = q.getResultList();
            List<ActivityDTO> dtoList = new ArrayList<>();
            for (Activity l : lsList) {
                dtoList.add(new ActivityDTO(l));
            }
            d.setActivityList(dtoList);
            //log.log(Level.INFO, "Lesson Activities deleted from lesson: {0} - deleted activities: {1}",
            //new Object[]{lesson.getLessonName(), cnt});

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteObjectives(List<ObjectiveDTO> objectiveList,
            int courseID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int cnt = 0;
        try {

            for (ObjectiveDTO l : objectiveList) {
                Objective ls = DataUtil.getObjectiveByID(l.getObjectiveID(), em);
                em.remove(ls);
                cnt++;
            }

            Query q = em.createNamedQuery("Objective.findByCourse");
            q.setParameter("id", courseID);
            List<Objective> lsList = q.getResultList();
            List<ObjectiveDTO> dtoList = new ArrayList<>();
            for (Objective l : lsList) {
                dtoList.add(new ObjectiveDTO(l));
            }
            d.setObjectiveList(dtoList);
            //log.log(Level.INFO, "Objectives deleted from lesson: {0} - deleted objectives: {1}",
            //new Object[]{courseID, cnt});

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR***", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteLessonResources(List<LessonResourceDTO> resourceList, int lessonID)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int cnt = 0;
        try {

            for (LessonResourceDTO l : resourceList) {
                LessonResource ls = DataUtil.getLessonResourceByID(l.getLessonResourceID(), em);
                em.remove(ls);
                cnt++;
            }

            Query q = em.createNamedQuery("LessonResource.findByLessonID", LessonResource.class);
            q.setParameter("id", lessonID);
            List<LessonResource> lsList = q.getResultList();
            List<LessonResourceDTO> dtoList = new ArrayList<>();
            for (LessonResource l : lsList) {
                dtoList.add(new LessonResourceDTO(l));
            }
            d.setLessonResourceList(dtoList);
            //log.log(Level.INFO, "Lesson Resources deleted from lesson: {0} - deleted resources: {1}",
            //new Object[]{lessonID, cnt});

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** del resorce", e);
            throw new DataException(DataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }
    private final Logger log = Logger.getLogger("AuthorUtil");
}
