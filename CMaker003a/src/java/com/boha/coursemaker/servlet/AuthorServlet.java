   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.util.AuthorUtil;
import com.boha.coursemaker.util.DataException;
import com.boha.coursemaker.util.DataUtil;
import com.boha.coursemaker.util.PlatformUtil;
import com.boha.coursemaker.util.GZipUtility;
import com.google.gson.Gson;
import com.oreilly.servlet.ServletUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is the gateway manager for the Author app. All requests from the app
 * are handled by this servlet.
 * 
 * @author aubreyM
 */
@WebServlet(name = "Author Services", urlPatterns = {"/author"})
public class AuthorServlet extends HttpServlet {

    @EJB
    PlatformUtil platformUtil;
    @EJB
    AuthorUtil authorUtil;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long start = System.currentTimeMillis();
        ResponseDTO resp = new ResponseDTO();
        RequestDTO dto = new RequestDTO();
        try {
            dto = getRequest(request);
            if (dto == null) {
                dto = new RequestDTO();
                resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                resp.setMessage("Request is unknown. Verboten!!!");
                platformUtil.addErrorStore(resp.getStatusCode(),
                        "Intruder request", "Author Services");
            } else {
                log.log(Level.INFO, "AuthorServlet starting ...reqType: {0}", dto.getRequestType());
                switch (dto.getRequestType()) {
                    case RequestDTO.REGISTER_AUTHOR:
                        resp = authorUtil.registerAuthor(dto.getAuthor(),
                                dto.getCompanyID());
                        break;
                    case RequestDTO.GET_COMPANY_COURSE_LIST:
                        resp = authorUtil.getCompanyCourseList(
                                dto.getCompanyID());
                        break;
                    case RequestDTO.GET_CATEGORY_LIST_BY_COMPANY:
                        resp = authorUtil.getCategoryList(dto.getCompanyID(), dto.getAuthorID());
                        break;
                    case RequestDTO.GET_COURSE_LIST_BY_CATEGORY:
                        resp = authorUtil.getCoursesByCategory(dto.getCategoryID());
                        break;
                    case RequestDTO.GET_LESSON_LIST_BY_COURSE:
                        resp = authorUtil.getLessonsByCourse(dto.getCourseID());
                        break;
                    case RequestDTO.GET_OBJECTIVE_LIST_BY_COURSE:
                        resp = authorUtil.getObjectivesByCourse(dto.getCourseID());
                        break;
                    case RequestDTO.GET_ACTIVITY_LIST_BY_LESSON:
                        resp = authorUtil.getActivitiesByLesson(dto.getLessonID());
                        break;
                    case RequestDTO.GET_RESOURCE_LIST_BY_LESSON:
                        resp = authorUtil.getResourcesByLesson(dto.getLessonID());
                        break;
                    case RequestDTO.ADD_CATEGORY:
                        resp = authorUtil.addCategory(dto.getCompanyID(), dto.getCategory());
                        break;
                    case RequestDTO.LOGIN_AUTHOR:
                        resp = authorUtil.loginAuthor(dto.getEmail(), dto.getPassword(), dto.getGcmDevice(), platformUtil);
                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Author logging in with new device").append("\n");
                            sb.append(resp.getCompany().getCompanyName()).append("\n\n");
                            sb.append(resp.getAuthor().getFirstName()).append(" ").append(resp.getAuthor().getLastName())
                                    .append("\n");
                            platformUtil.addErrorStore(0, sb.toString(), "Author Services");
                        }
                        break;
                    case RequestDTO.REGISTER_COURSE:
                        resp = authorUtil.addCourse(dto.getCourse(),
                                dto.getCompanyID(), dto.getAuthorID());
                        break;
                    case RequestDTO.ADD_LESSON:
                        resp = authorUtil.addLesson(dto.getLesson());
                        break;

                    case RequestDTO.ADD_OBJECTIVES:
                        resp = authorUtil.addObjective(dto.getObjective(),
                                dto.getCourseID());
                        break;
                    case RequestDTO.ADD_ACTIVITIES:
                        resp = authorUtil.addActivity(dto.getActivity(),
                                dto.getLessonID());
                        break;
                    case RequestDTO.ADD_RESOURCES:
                        resp = authorUtil.addLessonResource(dto.getLessonResource(),
                                dto.getLessonID());
                        break;
                    //
                    case RequestDTO.UPDATE_ACTIVITIES:
                        resp = authorUtil.updateActivities(dto.getActivityList());
                        break;
                    case RequestDTO.UPDATE_OBJECTIVES:
                        resp = authorUtil.updateObjectives(dto.getObjectiveList());
                        break;
                    //deletes

                    case RequestDTO.DELETE_OBJECTIVES:
                        resp = authorUtil.deleteObjectives(dto.getObjectiveList(),
                                dto.getCourseID());
                        break;
                    case RequestDTO.DELETE_ACTIVITIES:
                        resp = authorUtil.deleteActivities(
                                dto.getActivityList(), dto.getLessonID());
                        break;
                    case RequestDTO.DELETE_LESSON_RESOURCES:
                        resp = authorUtil.deleteLessonResources(
                                dto.getLessonResourceList(), dto.getLessonID());
                        break;

                    case RequestDTO.DELETE_LESSON:
                        resp = authorUtil.deleteLessons(
                                dto.getLessonList(), dto.getCourseID());
                        break;
                    case RequestDTO.UPDATE_LESSON:
                        resp = authorUtil.updateLesson(dto.getLessonList());
                        break;

                    case RequestDTO.DELETE_COURSE:
                        resp = authorUtil.deleteCourse(dto.getCourseID(), dto.getAuthorID());
                        break;
                    case RequestDTO.UPDATE_COURSE:
                        resp = authorUtil.updateCourse(dto.getCourse(), dto.getAuthorID());
                        break;

                    case RequestDTO.UPDATE_CATEGORY:
                        resp = authorUtil.updateCategory(dto.getCategory());
                        break;
                    case RequestDTO.DELETE_CATEGORY:
                        resp = authorUtil.deleteCategory(dto.getCategory());
                        break;

                    default:
                        resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                        resp.setMessage("Unknown request. Verboten!!");
                        platformUtil.addErrorStore(resp.getStatusCode(),
                                "Unknown request detected. Ignored.", "Author Services");
                        break;
                }
            }
        } catch (DataException e) {
            log.log(Level.SEVERE, "Database Error", e);
            resp.setStatusCode(ResponseDTO.ERROR_DATABASE);
            resp.setMessage("Server Database Error. Contact CourseMaker support");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Database Error\n" + e.getDescription(), "Author Services");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Server Error", ex);
            resp.setStatusCode(ResponseDTO.ERROR_INVALID_REQUEST);
            resp.setMessage("Server Error. Contact CourseMaker support");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Exception\n" + DataUtil.getErrorString(ex), "Author Services");
        } finally {
            TraineeServlet.addCorsHeaders(response);
            Gson gson = new Gson();
            String json = gson.toJson(resp);
            if (dto.isZippedResponse()) {
                response.setContentType("application/zip;charset=UTF-8");
                File zipped;
                try {
                    zipped = GZipUtility.getZipped(json);
                    ServletUtils.returnFile(zipped.getAbsolutePath(), response.getOutputStream());
                    response.getOutputStream().close();
                    log.log(Level.INFO, "### Packed length: {0} -  "
                            + "unzipped: {1}", new Object[]{zipped.length(), json.length()});
                } catch (IOException e) {
                    log.log(Level.SEVERE, "Zipping problem - probably the zipper cannot find the zipped file", e);

                } catch (Exception ex) {
                    Logger.getLogger(AuthorServlet.class.getName()).log(Level.SEVERE, "Failed to compress", ex);
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(json);

            }

            long end = System.currentTimeMillis();
            platformUtil.addTimeElapsedWarning(start, end, dto, "Author Services");
            log.log(Level.INFO, "AuthorServlet done. Elapsed: {0} seconds, requestType: {1} - {2}", 
                    new Object[]{getElapsed(start, end), dto.getRequestType(), 
                        RequestDTO.getRequestString(dto.getRequestType())});
        }
    }

    private RequestDTO getRequest(HttpServletRequest req) {
        String json = req.getParameter("JSON");
        Gson gson = new Gson();
        RequestDTO dto;
        try {
            dto = gson.fromJson(json, RequestDTO.class);
            if (dto == null) {
                dto = new RequestDTO();
            }
        } catch (Exception e) {
            dto = new RequestDTO();
            dto.setRequestType(0);
            dto.setZippedResponse(false);
        }

        return dto;
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }
    private static final Logger log = Logger.getLogger("Author Services");

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
