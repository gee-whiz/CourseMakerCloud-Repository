/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.util.AdministratorUtil;
import com.boha.coursemaker.util.AuthorUtil;
import com.boha.coursemaker.util.CloudMsgUtil;
import com.boha.coursemaker.util.DataException;
import com.boha.coursemaker.util.DataUtil;
import com.boha.coursemaker.util.DynamicUtil;
import com.boha.coursemaker.util.PlatformUtil;
import com.boha.coursemaker.util.GZipUtility;
import com.boha.coursemaker.util.InstructorUtil;
import com.boha.coursemaker.util.TraineeUtil;
import com.google.gson.Gson;
import com.oreilly.servlet.ServletUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The InstructorServlet handles all requests from the Instructor mobile or web
 * app. It is essentially the server API for any caller that requires these
 * operations.
 *
 * @author aubreyM
 */
@WebServlet(name = "Instructor Services", urlPatterns = {"/instructor"})
public class InstructorServlet extends HttpServlet {
    @EJB
    PlatformUtil platformUtil;
    @EJB
    InstructorUtil instructorUtil;
    @EJB
    AuthorUtil authorUtil;
    @EJB
    AdministratorUtil administratorUtil;
    @EJB
    DynamicUtil dynamicUtil;
    @EJB
    CloudMsgUtil cloudMsgUtil;
    @EJB
    DataUtil dataUtil;
    @EJB 
    TraineeUtil traineeUtil;
    /**
     * Processes requests for all CourseMaker Instructor API commands It
     * processes both <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.log(Level.INFO, "InstructorServlet started ...{0}", new Date().toString());
        long start = System.currentTimeMillis();
        ResponseDTO resp = new ResponseDTO();
        RequestDTO dto = new RequestDTO();
        try {
            dto = getRequest(request);
            if (dto == null || dto.getRequestType() == 0) {
                resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                resp.setMessage("Request is unknown. Verboten!!!");
                platformUtil.addErrorStore(resp.getStatusCode(),
                        "Intruder request detected. Ignored", "Instructor Services");
            } else {
                switch (dto.getRequestType()) {
                case RequestDTO.GET_TRAINEE_DATA:
                    resp = traineeUtil.getTraineeData(dto.getTrainingClassID(),
                            dto.getTraineeID(), dto.getCompanyID(),
                            dto.getCountryCode(),dataUtil);
                    break;
                case RequestDTO.ADD_COURSES_TO_CLASS:
                    resp = administratorUtil.addClassCourses(
                            dto.getTrainingClassID(), dto.getCourseList(), null,dataUtil);
                    break;
                case RequestDTO.DELETE_EVENT:
                    resp = instructorUtil.deleteTrainingClassEvent(dto.getTrainingClassEventID(),dataUtil);
                    break;
                case RequestDTO.UPDATE_EVENT:
                    resp = instructorUtil.updateTrainingClassEvent(dto.getTrainingClassEvent(),dataUtil);
                    break;
                case RequestDTO.ADD_TRAINEE_SKILLS:
                    resp = instructorUtil.addTraineeSkills(dto.getTraineeSkillList(),dataUtil);
                    break;
                case RequestDTO.ADD_COMPANY_SKILL:
                    resp = instructorUtil.addSkill(dto.getSkill(),dataUtil);
                    break;
                case RequestDTO.UPDATE_COMPANY_SKILL:
                    resp = instructorUtil.updateSkill(dto.getSkill(),dataUtil);
                    break;
                case RequestDTO.ADD_COMPANY_SKILL_LEVEL:
                    resp = instructorUtil.addSkillLevel(dto.getSkillLevel(),dataUtil);
                    break;
                case RequestDTO.UPDATE_COMPANY_SKILL_LEVEL:
                    resp = instructorUtil.updateSkillLevel(dto.getSkillLevel(),dataUtil);
                    break;
                case RequestDTO.ADD_EVENTS:
                    resp = instructorUtil.addTrainingClassEvent(dto.getTrainingClassEvent(),dataUtil);
                    break;
                case RequestDTO.GET_EVENTS_BY_CLASS:
                    resp = instructorUtil.getTrainingClassEvents(dto.getTrainingClassID());
                    break;
                case RequestDTO.GET_TRAINING_CLASSES_BY_INSTRUCTOR:
                    resp = instructorUtil.getTrainingClassesByInstructor(dto.getInstructorID(),dataUtil);
                    break;

                case RequestDTO.ADD_INSTRUCTOR_RATINGS:
                    resp = instructorUtil.rateTrainee(dto.getCourseTraineeActivity(), 
                            dto.getInstructorID(),dataUtil);
                    break;
                case RequestDTO.HELP_REQUESTS_BY_INSTRUCTOR:
                    resp = instructorUtil.getHelpRequests(
                            dto.getInstructorID(), dto.getStartDate(), dto.getEndDate());
                    break;
                case RequestDTO.GET_COUNTRY_LIST:
                    resp = dataUtil.getProvinceListByCountryCode(dto.getCountryCode());
                    break;
                case RequestDTO.GCM_SEND_INSTRUCTOR_TO_TRAINEE_MSG:
                    resp = cloudMsgUtil.sendInstructorToTraineeMessage(dto.getHelpResponse(), 
                            platformUtil,dataUtil);
                    break;
                case RequestDTO.REGISTER_INSTRUCTOR:
                    resp = instructorUtil.registerInstructor(dto.getInstructor(),dataUtil);
                    break;
                case RequestDTO.GET_COMPANY_CLASS_LIST:
                    resp = dataUtil.getTrainingClassList(dto.getCompanyID());
                    break;

                case RequestDTO.GET_CLASS_ACTIVITY_LIST:
                    resp = instructorUtil.getClassActivities(dto.getTrainingClassID(),dataUtil);
                    break;

                case RequestDTO.LOGIN_INSTRUCTOR:
                    resp = instructorUtil.loginInstructor(dto.getEmail(),
                            dto.getPassword(),dataUtil);
                    resp.setProvinceList(dataUtil.getProvinceListByCountryCode(dto.getCountryCode()).getProvinceList());
                    if (resp.getStatusCode() == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Instructor logging in with new device").append("\n");
                        sb.append(resp.getCompany().getCompanyName()).append("\n\n");
                        sb.append(resp.getInstructor().getFirstName()).append(" ").append(resp.getInstructor().getLastName())
                                .append("\n");
                        platformUtil.addErrorStore(0, sb.toString(), "Instructor Services");
                    }
                    break;
                case RequestDTO.GET_HELP_REQUEST_LIST:
                    resp = administratorUtil.getHelpRequestListByPeriod(dto.getTrainingClassID(),
                            dto.getStartDate(), dto.getEndDate(), dataUtil);
                    break;

                case RequestDTO.GET_COMPANY_COURSE_LIST:
                    resp = authorUtil.getCompanyCourseList(
                            dto.getCompanyID(),dataUtil);
                    break;
                case RequestDTO.GET_TRAINEE_ACTIVITY_TOTALS:
                    resp = instructorUtil.getTraineeActivityTotalsByClass(dto.getTrainingClassID(),dataUtil);
                    break;
                case RequestDTO.GET_TRAINEE_ACTIVITY_TOTALS_BY_COMPANY:
                    resp = instructorUtil.getTraineeActivityByCompany(dto.getCompanyID(),dataUtil);
                    break;
                case RequestDTO.GET_TRAINEE_ACTIVITY_TOTALS_BY_INSTRUCTOR:
                    resp = instructorUtil.getTraineeActivityByInstructor(
                            dto.getInstructorID(),dataUtil);
                    break;

                case RequestDTO.GET_CLASS_TRAINEE_LIST:
                    resp = instructorUtil.getClassTrainees(dto.getTrainingClassID(),dataUtil);
                    break;
                case RequestDTO.GET_CATEGORIES_BY_COMPANY:
                    resp = instructorUtil.getCategoriesByCompany(dto.getCompanyID(),dataUtil);
                    break;
                case RequestDTO.GET_COURSE_LIST_BY_CLASS:
                    resp = instructorUtil.getCourseByClass(dto.getTrainingClassID(),dataUtil);
                    break;
                case RequestDTO.GET_INSTRUCTOR_CLASSES:
                    resp = instructorUtil.getInstructorClasses(dto.getInstructorID(),dataUtil);
                    break;
                case RequestDTO.ENROLL_IN_COURSE:
                    resp = administratorUtil.assignClassCoursesToTrainees(dto.getTrainingClassID(),dataUtil);
                    break;

                case RequestDTO.ENROLL_TRAINEES_FOR_ACTIVITIES:
                    resp = dynamicUtil.updateActivityEnrolment(dto.getTrainingClassID(), 
                            dto.getInstructorID(),
                            administratorUtil, instructorUtil,dataUtil);
                    break;
                default:
                    resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                    resp.setMessage("Invalid request detected. Verboten!!");
                    platformUtil.addErrorStore(ResponseDTO.ERROR_UNKNOWN_REQUEST, "Invalid request detected. Ignored.", "Instructor Services");
                    break;
                }
            }
        } catch (DataException e) {
            log.log(Level.SEVERE, "Database Error", e);
            resp.setStatusCode(ResponseDTO.ERROR_DATABASE);
            resp.setMessage("Server Database Error. Contact CourseMaker support");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Database Error\n" + e.getDescription(), "Instructor Services");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Invalid Request", ex);
            resp.setStatusCode(ResponseDTO.ERROR_INVALID_REQUEST);
            resp.setMessage("Server Error. Contact CourseMaker support");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Exception\n" + dataUtil.getErrorString(ex), "Instructor Services");
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
                    log.log(Level.INFO, "###Packed length: {0} -  "
                            + "unzipped: {1}", new Object[]{zipped.length(), json.length()});
                } catch (IOException e) {
                    log.log(Level.SEVERE, "Zipping problem - probably the zipper cannot find the zipped file", e);

                } catch (Exception ex) {
                    Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, "Failed to compress", ex);
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(json);

            }

            long end = System.currentTimeMillis();
            platformUtil.addTimeElapsedWarning(start, end, dto, "Instructor Services");
            log.log(Level.INFO, "InstructorServlet done. Elapsed: {0} seconds, requestType: {1} - {2}", 
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
            log.log(Level.SEVERE, "Gson failed", e);
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
    private static final Logger log = Logger.getLogger("Instructor Services");

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
