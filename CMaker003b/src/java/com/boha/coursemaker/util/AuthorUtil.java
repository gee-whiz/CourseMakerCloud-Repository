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
import javax.persistence.PersistenceException;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuthorUtil {

    @PersistenceContext
    EntityManager em;

    public ResponseDTO copyCourses(int fromCompanyID, int toCompanyID) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);
            q.setParameter("id", fromCompanyID);
            List<Category> cats = q.getResultList();
            Company toComp = em.find(Company.class, toCompanyID);
            for (Category category : cats) {
                Category nc = new Category();
                nc.setCategoryName(category.getCategoryName());
                nc.setCompany(toComp);
                nc.setPriorityFlag(category.getPriorityFlag());
                em.persist(nc);
                Query x = em.createNamedQuery("Category.findByNameInCompany", Category.class);
                x.setParameter("name", nc.getCategoryName());
                x.setParameter("id", toCompanyID);
                x.setMaxResults(1);
                Category fc = (Category) x.getSingleResult();
                log.log(Level.INFO, "Category {0} copied", fc.getCategoryName());
                for (Course course : category.getCourseList()) {
                    Course ncrs = new Course();
                    ncrs.setCategory(fc);
                    ncrs.setCompany(toComp);
                    ncrs.setCourseName(course.getCourseName());
                    ncrs.setDescription(course.getDescription());
                    ncrs.setDateUpdated(new Date());
                    ncrs.setPriorityFlag(course.getPriorityFlag());                  
                    em.persist(ncrs);
                    
                    x = em.createNamedQuery("Course.findByNameInCategory", Course.class);
                    x.setParameter("courseName", ncrs.getCourseName());
                    x.setParameter("id", fc.getCategoryID());
                    x.setMaxResults(1);
                    Course fcc = (Course) x.getSingleResult();
                    log.log(Level.OFF, "Course {0} copied", fcc.getCourseName());

                    for (Activity act : course.getActivityList()) {
                        Activity a = new Activity();
                        a.setCourse(fcc);
                        a.setActivityName(act.getActivityName());
                        a.setDescription(act.getDescription());
                        a.setPriorityFlag(act.getPriorityFlag());
                        
                        em.persist(a);
                        log.log(Level.INFO, "Activity {0} copied", a.getActivityName());
                    }
                    for (LessonResource link : course.getLessonResourceList()) {
                        LessonResource r = new LessonResource();
                        r.setCourse(fcc);
                        r.setDateUpdated(new Date());
                        r.setResourceName(link.getResourceName());
                        r.setUrl(link.getUrl());
                        em.persist(r);
                        log.log(Level.INFO, "Link {0} copied", r.getUrl());
                    }
                    for (Objective link : course.getObjectiveList()) {
                        Objective r = new Objective();
                        r.setCourse(fcc);
                        r.setDescription(link.getDescription());
                        r.setObjectiveName(link.getObjectiveName());
                        em.persist(r);
                        log.log(Level.OFF, "Objective {0} copied", r.getObjectiveName());
                    }

                }
                resp.setMessage("Category hierarchy copied to new company");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            throw new DataException("Failed to copy categories & hierarchy");
        }
        
        return resp;
    }

    public ResponseDTO updateObjectives(List<ObjectiveDTO> list, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int courseID = list.get(0).getCourseID();
        try {

            for (ObjectiveDTO dto : list) {
                Objective a = dataUtil.getObjectiveByID(dto.getObjectiveID());
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
            throw new DataException(dataUtil.getErrorString(e));

        } finally {
        }
        return d;
    }

    public ResponseDTO updateActivities(List<ActivityDTO> list, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));

        } finally {
        }
        return d;
    }

    public ResponseDTO loginAuthor(String email, String password, DataUtil dataUtil) throws DataException {
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO registerAuthor(AuthorDTO author, int companyID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {

            Company tc = dataUtil.getCompanyByID(companyID);

            Author a = new Author();
            a.setFirstName(author.getFirstName());
            a.setLastName(author.getLastName());
            a.setEmail(author.getEmail());
            a.setCellphone(author.getCellphone());
            a.setCompany(tc);
            a.setPassword(dataUtil.createPassword());
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
        } catch (PersistenceException e) {
            log.log(Level.WARNING, "Failed, might be duplicate", e);
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Author with this email already exists. Please Sign In");

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register Author", e);
            throw new DataException("Failed to register Author\n"
                    + dataUtil.getErrorString(e));

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

    public List<CategoryDTO> getCategories(int companyID, boolean getCourses, DataUtil dataUtil) {
        Company co = dataUtil.getCompanyByID(companyID);
        List<Category> list = co.getCategoryList();
        List<CategoryDTO> gList = new ArrayList<>();
        for (Category c : list) {
            gList.add(new CategoryDTO(c));
        }
        return gList;
    }

    public List<CategoryDTO> addInitialCategories(
            int companyID, DataUtil dataUtil) throws DataException {

        List<CategoryDTO> dto = new ArrayList<>();
        try {
            Company tc = dataUtil.getCompanyByID(companyID);

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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return dto;
    }

    public ResponseDTO addCategory(
            CategoryDTO category, CloudMsgUtil cloudMsgUtil, PlatformUtil platformUtil, DataUtil dataUtil) throws DataException {
        log.log(Level.INFO, "......starting to add category");
        ResponseDTO d = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Category.findByNameInCompany", Category.class);
            q.setParameter("id", category.getCompanyID());
            q.setParameter("name", category.getCategoryName());
            Category cat = null;
            try {
                cat = (Category) q.getSingleResult();
            } catch (javax.persistence.NoResultException e) {
            }

            Company tc = em.find(Company.class, category.getCompanyID());
            if (cat == null) {
                log.log(Level.INFO, "new category to be added: {0}", category.getCategoryName());
                Category a = new Category();
                a.setCategoryName(category.getCategoryName());
                a.setCompany(tc);
                a.setPriorityFlag(category.getPriorityFlag());
                em.persist(a);
                cat = (Category) q.getSingleResult();
            }
            d.setCategory(new CategoryDTO(cat));
            d.setCategoryList(getCompanyCategories(category.getCompanyID()));

            log.log(Level.INFO, "category added or ignored: {0}", category.getCategoryName());
            cloudMsgUtil.sendNewCourseMessageToInstructors(category.getCompanyID(), platformUtil);
        } catch (PersistenceException e) {
            log.log(Level.WARNING, "Duplicate category", e);
            d.setMessage("The category already exists");
            d.setCategoryList(getCompanyCategories(category.getCompanyID()));
            for (CategoryDTO c : d.getCategoryList()) {
                if (c.getCategoryName().equalsIgnoreCase(category.getCategoryName())) {
                    d.setCategory(c);
                    break;
                }
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding category", e);
            throw new DataException(dataUtil.getErrorString(e));
        }

        return d;
    }

    private List<CategoryDTO> getCompanyCategories(int companyID) {
        em.clear();
        Query q = em.createNamedQuery("Category.findByCompanyID", Category.class);
        q.setParameter("id", companyID);
        List<Category> list = q.getResultList();
        List<CategoryDTO> dto = new ArrayList<>();
        for (Category c : list) {
            dto.add(new CategoryDTO(c));
        }
        return dto;
    }

    public ResponseDTO deleteCategory(
            CategoryDTO category, DataUtil dataUtil) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {

            Category a = dataUtil.getCategoryByID(category.getCategoryID());
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
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO updateCategory(
            CategoryDTO category, DataUtil dataUtil) throws DataException {

        ResponseDTO d = new ResponseDTO();

        try {

            Category a = dataUtil.getCategoryByID(category.getCategoryID());
            a.setCategoryName(category.getCategoryName());
            a.setPriorityFlag(category.getPriorityFlag());
            em.merge(a);

            d = getCategoryList(category.getCompanyID(),dataUtil);
            d.setMessage("category updated on server");
        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** update category", e);
            throw new DataException(dataUtil.getErrorString(e));
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
            int companyID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
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
            int courseID, DataUtil dataUtil)
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
        } catch (PersistenceException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The activity already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding act", e);
            throw new DataException(dataUtil.getErrorString(e));
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
    public ResponseDTO addObjective(ObjectiveDTO objective, int courseID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        Course course;
        try {

            course = dataUtil.getCourseByID(courseID);
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
        } catch (PersistenceException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The objective already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding objective", e);
            throw new DataException(dataUtil.getErrorString(e));
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
    public ResponseDTO addLessonResource(LessonResourceDTO l, DataUtil dataUtil)
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
        } catch (PersistenceException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The link already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding resource", e);
            throw new DataException(dataUtil.getErrorString(e));
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
            int lessonID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    public ResponseDTO getObjectivesByCourse(
            int courseID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getCoursesByCategory(int categoryID, DataUtil dataUtil)
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
            throw new DataException(dataUtil.getErrorString(e));
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

    public ResponseDTO getCategoryList(int trainingCompanyID, DataUtil dataUtil)
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
            List<Course> courseList = getCourses(trainingCompanyID, em);
            List<Activity> ativitycList = getActivity(trainingCompanyID, em);
            List<LessonResource> resourceList = getResources(trainingCompanyID, em);
            for (CategoryDTO cat : dtoList) {
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
            throw new DataException(dataUtil.getErrorString(e));
        }
        return d;
    }

    private List<Activity> getActivity(int companyID, EntityManager em) {
        Query q = em.createNamedQuery("Activity.findByCompany", Activity.class);
        q.setParameter("id", companyID);
        List<Activity> list = q.getResultList();
        log.log(Level.INFO, "Author activities : {0}", list.size());
        return list;
    }

    private List<LessonResource> getResources(int companyID, EntityManager em) {
        Query q = em.createNamedQuery("LessonResource.findByCompany", LessonResource.class);
        q.setParameter("id", companyID);
        List<LessonResource> list = q.getResultList();
        log.log(Level.INFO, "Author links : {0}", list.size());
        return list;
    }

    public ResponseDTO shuffleCategories(List<Integer> IDs, DataUtil dataUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            int index = 0, companyID = 0;
            for (Integer id : IDs) {
                Category cat = em.find(Category.class, id);
                cat.setPriorityFlag(index + 1);
                em.merge(cat);
                if (companyID == 0) {
                    companyID = cat.getCompany().getCompanyID();
                }
                index++;
            }
            resp = getCategoryList(companyID,dataUtil);
            log.log(Level.INFO, "Cats shuffled");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Fail", e);
            throw new DataException("Failed to shuffle categories");
        }
        return resp;
    }

    public ResponseDTO shuffleCourses(List<Integer> IDs, DataUtil dataUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            int index = 0, companyID = 0;
            for (Integer id : IDs) {
                Course cat = em.find(Course.class, id);
                cat.setPriorityFlag(index + 1);
                em.merge(cat);
                if (companyID == 0) {
                    companyID = cat.getCompany().getCompanyID();
                }
                index++;
            }
            resp = getCategoryList(companyID, dataUtil);
            log.log(Level.INFO, "Courses shuffled");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Fail", e);
            throw new DataException("Failed to shuffle categories");
        }
        return resp;
    }

    public ResponseDTO shuffleActivities(List<Integer> IDs, DataUtil dataUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            int index = 0, companyID = 0;
            for (Integer id : IDs) {
                Activity cat = em.find(Activity.class, id);
                cat.setPriorityFlag(index + 1);
                em.merge(cat);
                index++;
                if (companyID == 0) {
                    companyID = cat.getCourse().getCompany().getCompanyID();
                }
            }
            resp = getCategoryList(companyID,dataUtil);
            log.log(Level.INFO, "Activities shuffled");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Fail", e);
            throw new DataException("Failed to shuffle categories");
        }
        return resp;
    }

    /**
     * Get all Courses that belong to the Author
     *
     * @param authorID
     * @param em
     * @return
     */
    private List<Course> getCourses(int companyID, EntityManager em) {
        Query q = em.createNamedQuery("Course.findByCompanyID", Course.class);
        q.setParameter("id", companyID);
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
     * @param cloudMsgUtil
     * @param platformUtil
     * @return
     * @throws DataException
     */
    public ResponseDTO addCourse(CourseDTO course,
            int companyID,
            int authorID, CloudMsgUtil cloudMsgUtil, PlatformUtil platformUtil, DataUtil dataUtil)
            throws DataException {
        log.log(Level.INFO, "### adding course, company: {0} author: {1}", new Object[]{companyID, authorID});
        ResponseDTO d = new ResponseDTO();
        boolean isNew = false;
        try {
            Query qx = em.createNamedQuery("Course.findByNameInCategory", Course.class);
            qx.setParameter("id", course.getCategory().getCategoryID());
            qx.setParameter("courseName", course.getCourseName());
            qx.setMaxResults(1);
            Course cx = null;
            try {
                cx = (Course) qx.getSingleResult();
            } catch (javax.persistence.NoResultException e) {
            }
            if (cx == null) {
                isNew = true;
                Course c = new Course();
                c.setCourseName(course.getCourseName());
                c.setDescription(course.getDescription());
                c.setDateUpdated(new Date());
                c.setCategory(em.find(Category.class, course.getCategory().getCategoryID()));
                c.setCompany(em.find(Company.class, companyID));
                c.setDateUpdated(new Date());
                c.setPriorityFlag(course.getPriorityFlag());
                em.persist(c);
                cx = (Course) qx.getSingleResult();
            } else {
                cx.setDescription(course.getDescription());
                cx.setDateUpdated(new Date());
                em.merge(cx);
            }

            d.setCourse(new CourseDTO(cx));
            if (authorID > 0 && isNew) {

                CourseAuthor ca = new CourseAuthor();
                ca.setAuthor(em.find(Author.class, authorID));
                ca.setCourse(cx);
                ca.setDateUpdated(new Date());
                em.persist(ca);

            }
            if (course.getActivityList() != null) {
                for (ActivityDTO a : course.getActivityList()) {
                    Query qv = em.createNamedQuery("Activity.findByActivityNameInCourse", Activity.class);
                    qv.setParameter("id", cx.getCourseID());
                    qv.setParameter("name", a.getActivityName());
                    qv.setMaxResults(1);
                    Activity realActivity = null;
                    try {
                        realActivity = (Activity) qv.getSingleResult();
                    } catch (javax.persistence.NoResultException e) {
                    }
                    if (realActivity == null) {
                        Activity act = new Activity();
                        act.setCourse(cx);
                        act.setActivityName(a.getActivityName());
                        act.setDescription(a.getDescription());
                        em.persist(act);
                        realActivity = (Activity) qv.getSingleResult();
                    } else {
                        realActivity.setDescription(a.getDescription());
                        em.merge(realActivity);
                    }

                }
            }
            if (course.getLessonResourceList() != null) {
                for (LessonResourceDTO a : course.getLessonResourceList()) {
                    Query qv = em.createNamedQuery("LessonResource.findByLinkInCourse", LessonResource.class);
                    qv.setParameter("id", cx.getCourseID());
                    qv.setParameter("url", a.getUrl());
                    qv.setMaxResults(1);
                    LessonResource realLink = null;
                    try {
                        realLink = (LessonResource) qv.getSingleResult();
                    } catch (javax.persistence.NoResultException e) {
                    }
                    if (realLink == null) {
                        LessonResource link = new LessonResource();
                        link.setCourse(cx);
                        link.setUrl(a.getUrl());
                        link.setDateUpdated(new Date());
                        link.setResourceName(a.getResourceName());
                        link.setAuthor(em.find(Author.class, authorID));
                        em.persist(link);
                        realLink = (LessonResource) qv.getSingleResult();
                    } else {
                        realLink.setResourceName(a.getResourceName());
                        em.merge(realLink);
                    }
                }
            }
            if (course.getObjectiveList() != null) {
                for (ObjectiveDTO a : course.getObjectiveList()) {
                    Query qv = em.createNamedQuery("Objective.findByNameInCourse", Objective.class);
                    qv.setParameter("id", cx.getCourseID());
                    qv.setParameter("name", a.getObjectiveName());
                    qv.setMaxResults(1);
                    Objective realObj = null;
                    try {
                        realObj = (Objective) qv.getSingleResult();
                    } catch (javax.persistence.NoResultException e) {
                    }
                    if (realObj == null) {
                        Objective objective = new Objective();
                        objective.setCourse(cx);
                        objective.setObjectiveName(a.getObjectiveName());
                        if (a.getDescription() == null) {
                            a.setDescription("");
                        }
                        objective.setDescription(a.getDescription());
                        em.persist(objective);
                    } else {
                        realObj.setDescription(a.getDescription());
                        em.merge(realObj);
                    }
                }
            }

            Query q = em.createNamedQuery("Course.findByCategoryID", Course.class);
            q.setParameter("id", course.getCategory().getCategoryID());
            List<Course> list = q.getResultList();
            List<CourseDTO> dto = new ArrayList<>();

            for (Course crs : list) {
                dto.add(new CourseDTO(crs));
            }
            d.setCourseList(dto);
            d.setMessage("course added on server");
            log.log(Level.INFO, "### Course added: {0} courses: {1}", new Object[]{course.getCourseName(), dto.size()});
            cloudMsgUtil.sendNewCourseMessageToInstructors(companyID, platformUtil);
        } catch (PersistenceException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("The course already exists");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO updateCourse(CourseDTO course,
            int authorID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            Course c = dataUtil.getCourseByID(course.getCourseID());
            if (course.getCourseName() != null) {
                c.setCourseName(course.getCourseName());
            }
            if (course.getDescription() != null) {
                c.setDescription(course.getDescription());
            }
            c.setPriorityFlag(course.getPriorityFlag());
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
                    ca.setAuthor(dataUtil.getAuthorByID(authorID));
                    ca.setDateUpdated(new Date());
                    em.persist(ca);

                }
            }

            d = getCategoryList(course.getCompanyID(),  dataUtil);
            d.setMessage("course updated on server");

            //log.log(Level.INFO, "### Course added: {0}", course.getCourseName());
        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** Adding course", e);
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteCourse(int courseID,
            int authorID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            Course c = dataUtil.getCourseByID(courseID);
            em.remove(c);

            d = getCategoryList(c.getCompany().getCompanyID(),dataUtil);
            d.setMessage(c.getCourseName() + " deleted from server");

        } catch (Exception e) {
            log.log(Level.SEVERE, "***ERROR*** deleting course", e);
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteActivities(List<ActivityDTO> actList,
            int courseID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {

            for (ActivityDTO activity : actList) {
                Activity a = dataUtil.getActivityByID(activity.getActivityID());
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
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteObjectives(List<ObjectiveDTO> objectiveList,
            int courseID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int cnt = 0;
        try {

            for (ObjectiveDTO l : objectiveList) {
                Objective ls = dataUtil.getObjectiveByID(l.getObjectiveID());
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
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }

    public ResponseDTO deleteLessonResources(List<LessonResourceDTO> resourceList, int lessonID, DataUtil dataUtil)
            throws DataException {
        ResponseDTO d = new ResponseDTO();

        int cnt = 0;
        try {

            for (LessonResourceDTO l : resourceList) {
                LessonResource ls = dataUtil.getLessonResourceByID(l.getLessonResourceID());
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
            throw new DataException(dataUtil.getErrorString(e));
        } finally {
        }

        return d;
    }
    private final Logger log = Logger.getLogger("AuthorUtil");
}
