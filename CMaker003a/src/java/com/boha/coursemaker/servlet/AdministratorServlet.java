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
import com.boha.coursemaker.util.DataException;
import com.boha.coursemaker.util.DataUtil;
import com.boha.coursemaker.util.EmailUtil;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is the gateway manager for the Admin app. All requests from the app
 * are handled by this servlet.
 * 
 * @author aubreyM
 */
@WebServlet(name = "Administrator Services", urlPatterns = {"/admin"})
public class AdministratorServlet extends HttpServlet {

    @EJB
    AdministratorUtil administratorUtil;
    @EJB
    PlatformUtil platformUtil;
    @EJB
    InstructorUtil instructorUtil;
    @EJB
    AuthorUtil authorUtil;
    @EJB
    TraineeUtil traineeUtil;
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
        log.log(Level.INFO, "AdministratorServlet started .....");
        long start = System.currentTimeMillis();
        ResponseDTO resp = new ResponseDTO();
        RequestDTO dto = new RequestDTO();

        try {
            dto = getRequest(request);
            if (dto == null || dto.getRequestType() == 0) {
                resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                resp.setMessage("Request is unknown. Verboten!!!");
                platformUtil.addErrorStore(resp.getStatusCode(),
                        "Intruder request detected. Ignored.", "Administrator Services");
            } else {
                switch (dto.getRequestType()) {
                    case RequestDTO.GET_COMPANY_DATA:
                        resp = administratorUtil.getCompanyData(dto.getCompanyID());
                        break;
                    case RequestDTO.ADD_COURSES_TO_CLASS:
                        resp = administratorUtil.addClassCourses(dto.getTrainingClassID(), dto.getCourseList(), null);
                        break;
                    case RequestDTO.GET_COUNTRY_LIST:
                        resp = DataUtil.getProvinceListByCountryCode(dto.getCountryCode(), administratorUtil.getEm());
                        break;
                    case RequestDTO.LOGIN_ADMINISTRATOR:
                        resp = administratorUtil.loginAdministrator(dto.getEmail(),
                                dto.getPassword(),
                                dto.getGcmDevice(), platformUtil);
                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Administrator signing in and registering device").append("\n");
                            sb.append(resp.getCompany().getCompanyName()).append("\n\n");
                            sb.append(resp.getAdministrator().getFirstName()).append(" ").append(resp.getAdministrator().getLastName())
                                    .append("\n");
                            platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                        }
                        break;
                    case RequestDTO.REGISTER_TRAINING_COMPANY:
                        resp = administratorUtil.registerCompany(dto.getCompany(),
                                dto.getAdministrator(), dto.getGcmDevice(), platformUtil);

                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("New Company Registered").append("\n\n");
                            sb.append(resp.getCompany().getCompanyName()).append("\n");
                            sb.append("Administrator: \n");
                            sb.append(resp.getAdministrator().getFirstName()).append(" ").append(resp.getAdministrator().getLastName())
                                    .append("\n");
                            platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                        }
                        break;

                    case RequestDTO.REGISTER_AUTHOR:
                        resp = administratorUtil.addAuthor(dto.getAuthor(), dto.getCompanyID(), authorUtil);
                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("New CourseMaker Author Registered").append("\n\n");
                            sb.append(dto.getAuthor().getFirstName()).append(" ").append(dto.getAuthor().getLastName())
                                    .append("\n");
                            sb.append(resp.getCompany().getCompanyName());
                            platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                        }
                        break;
                    case RequestDTO.REGISTER_TRAINEE:
                        resp = administratorUtil.addTrainee(dto.getTrainee(),
                                dto.getTrainingClassID(), dto.getCityID(), traineeUtil);
                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("New Trainee Registered").append("\n\n");
                            sb.append(dto.getTrainee().getFirstName()).append(" ").append(dto.getTrainee().getLastName())
                                    .append("\n");
                            sb.append(resp.getCompany().getCompanyName());
                            platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                            
                        }
                        break;
                    case RequestDTO.REGISTER_INSTRUCTOR:
                        resp = administratorUtil.addInstructor(dto.getInstructor(),
                                dto.getTrainingClassID(), dto.getCityID(), instructorUtil);
                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("New Instructor Registered").append("\n\n");
                            sb.append(dto.getInstructor().getFirstName()).append(" ").append(dto.getInstructor().getLastName())
                                    .append("\n");
                            sb.append(resp.getCompany().getCompanyName());
                            platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                            ResponseDTO r = administratorUtil.getInstructorList(dto.getInstructor().getCompanyID());
                            resp.setInstructorList(r.getInstructorList());
                        }
                        
                        break;
                    case RequestDTO.REGISTER_ADMINISTRATOR:
                        resp = administratorUtil.addAdministrator(dto.getAdministrator());
                        if (resp.getStatusCode() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("New Administrator Registered").append("\n\n");
                            sb.append(dto.getAdministrator().getFirstName()).append(" ").append(dto.getAdministrator().getLastName())
                                    .append("\n");
                            sb.append(resp.getCompany().getCompanyName());
                            platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                        }
                        break;

                    case RequestDTO.GET_COMPANY_CLASS_LIST:
                        resp = DataUtil.getTrainingClassList(dto.getCompanyID(), administratorUtil.getEm());
                        break;
                    case RequestDTO.GET_COMPANY_COURSE_LIST:
                        resp = authorUtil.getCompanyCourseList(
                                dto.getCompanyID());
                        break;
                    case RequestDTO.ADD_TRAINING_CLASS:
                        resp = administratorUtil.registerClass(dto.getCompanyID(),
                                dto.getTrainingClass(), dto.getAdministratorID());
                        break;
                    case RequestDTO.UPDATE_CLASS:
                        resp = administratorUtil.updateClass(dto.getTrainingClass());
                        break;
                    case RequestDTO.DELETE_CLASS:
                        resp = administratorUtil.deleteClass(dto.getTrainingClassID());
                        break;
                    case RequestDTO.ASSIGN_INSTRUCTOR_CLASS:
                        resp = administratorUtil.assignInstructorClass(dto.getInstructorID(),
                                dto.getTrainingClassID());
                        break;
                    case RequestDTO.DELETE_INSTRUCTOR_CLASS:
                        resp = instructorUtil.deleteInstructorClass(dto.getInstructorClassID());
                        break;
                    case RequestDTO.ADD_TRAINEE_EQUPIMENT:
                        resp = administratorUtil.addTraineeEquipment(
                                dto.getTraineeID(),
                                dto.getInventoryID(),
                                dto.getAdministratorID());
                        break;
                    case RequestDTO.UPDATE_TRAINEE_EQUPIMENT:
                        resp = administratorUtil.updateTraineeEquipment(
                                dto.getTraineeEquipmentID(), dto.getConditionFlag(),
                                dto.isReturnEquipment(),
                                dto.getAdministratorID());
                        break;
                    case RequestDTO.ADD_EQUIPMENT:
                        resp = administratorUtil.addEquipment(dto.getEquipment(),
                                dto.getCompanyID(), dto.getAdministratorID());
                        break;
                    case RequestDTO.UPDATE_EQUIPMENT:
                        resp = administratorUtil.updateEquipment(dto.getEquipment(), dto.getAdministratorID());
                        break;
                    //deactivate
                    case RequestDTO.DEACTIVATE_INSTRUCTOR:
                        resp = administratorUtil.deactivateInstructor(dto.getInstructor(),
                                dto.getAdministratorID());
                        break;
                    case RequestDTO.DEACTIVATE_TRAINEE:
                        resp = administratorUtil.deactivateTrainee(dto.getTrainee(),
                                dto.getAdministratorID());
                        break;
                    //    
                    case RequestDTO.GET_INSTRUCTOR_LIST:
                        resp = administratorUtil.getInstructorList(dto.getCompanyID());
                        break;
                    case RequestDTO.GET_CLASS_TRAINEE_LIST:
                        resp = administratorUtil.getClassTraineeList(dto.getTrainingClassID());
                        break;
                    case RequestDTO.GET_CLASS_COURSE_LIST:
                        resp = administratorUtil.getClassCourseList(dto.getTrainingClassID());
                        break;
                    case RequestDTO.GET_CLASS_TRAINEE_EQUIPMENT_LIST:
                        resp = administratorUtil.getTraineeEquipmentListByClass(dto.getTrainingClassID());
                        break;
                    case RequestDTO.GET_CLASS_COURSE_TRAINEE_ACTIVITY_LIST:
                        resp = administratorUtil.getCourseTraineeActivityList(dto.getTrainingClassCourseID());
                        break;
                    case RequestDTO.GET_TRAINEE_EQUIPMENT_LIST_BY_EQUPMENTID:
                        resp = administratorUtil.getTraineeEquipmentListByEquipmentID(dto.getEquipmentID());
                        break;
                    case RequestDTO.GET_TRAINEE_EQUIPMENT_LIST_BY_INVENTORYID:
                        resp = administratorUtil.getTraineeEquipmentListByInventory(
                                dto.getInventoryID());
                        break;
                    case RequestDTO.ADD_INVENTORY:
                        resp = administratorUtil.addInventory(dto.getInventory(),
                                dto.getAdministratorID());
                        break;
                    case RequestDTO.UPDATE_INVENTORY:
                        resp = administratorUtil.updateInventory(dto.getInventory(),
                                dto.getAdministratorID());
                        break;

                    case RequestDTO.GET_COMPANY_EQUIPMENT_LIST:
                        resp = administratorUtil.getEquipmentList(dto.getCompanyID());
                        break;
                    case RequestDTO.GET_INVENTORY_LIST:
                        resp = administratorUtil.getInventoryList(dto.getCompanyID());
                        break;
                    case RequestDTO.GET_INVENTORY_LIST_BY_CLASS:
                        resp = administratorUtil.getInventoryListByClass(dto.getTrainingClassID());
                        break;
                    case RequestDTO.GET_INVENTORY_LIST_BY_EQUIPMENT:
                        resp = administratorUtil.getEquipmentInventory(dto.getEquipmentID());
                        break;
                    case RequestDTO.GET_HELP_REQUEST_LIST:
                        resp = administratorUtil.getHelpRequestListByPeriod(dto.getTrainingClassID(),
                                dto.getStartDate(), dto.getEndDate());
                        break;
                    case RequestDTO.UPDATE_AUTHOR:
                        resp = administratorUtil.updateAuthor(dto.getAuthor());
                        break;
                    case RequestDTO.UPDATE_INSTRUCTOR:
                        resp = administratorUtil.updateInstructor(dto.getInstructor());
                        break;
                    case RequestDTO.UPDATE_TRAINEE:
                        resp = administratorUtil.updateTrainee(dto.getTrainee(), dto.getTrainingClassID(), dto.getCityID());
                        break;
                    case RequestDTO.UPDATE_ADMIN:
                        resp = administratorUtil.updateAdmin(dto.getAdministrator());
                        break;

                    case RequestDTO.SEND_PASSWORD_ADMIN:
                        resp = administratorUtil.updatePassword(dto.getAdministratorID(),
                                EmailUtil.ADMINISTRATOR);
                        break;
                    case RequestDTO.SEND_PASSWORD_AUTHOR:
                        resp = administratorUtil.updatePassword(dto.getAuthorID(),
                                EmailUtil.AUTHOR);
                        break;
                    case RequestDTO.SEND_PASSWORD_INSTRUCTOR:
                        resp = administratorUtil.updatePassword(dto.getInstructorID(),
                                EmailUtil.INSTRUCTOR);
                        break;
                    case RequestDTO.SEND_PASSWORD_TRAINEE:
                        resp = administratorUtil.updatePassword(dto.getTraineeID(),
                                EmailUtil.TRAINEE);
                        break;
                    case RequestDTO.SEND_PASSWORD_EXECUTIVE:

                        break;

                    case RequestDTO.ADD_RATING:
                        resp = administratorUtil.addRating(dto.getRating());
                        break;
                    case RequestDTO.DELETE_RATING:
                        resp = administratorUtil.deleteRating(dto.getRating());
                        break;
                    case RequestDTO.UPDATE_RATING:
                        resp = administratorUtil.updateRating(dto.getRating());
                        break;

                    case RequestDTO.ADD_HELPTYPE:
                        
                        resp = administratorUtil.addHelpType(dto.getHelpType());
                        break;
                    case RequestDTO.DELETE_HELPTYPE:
                        resp = administratorUtil.deleteHelpType(dto.getHelpType());
                        break;
                    case RequestDTO.UPDATE_HELPTYPE:
                        resp = administratorUtil.updateHelpType(dto.getHelpType());
                        break;

                    default:
                        resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                        resp.setMessage("Unknown request. Verboten!!");
                        platformUtil.addErrorStore(resp.getStatusCode(),
                                "Unknown Request", "Administrator Services");
                        break;
                }
            }
        } catch (DataException e) {
            log.log(Level.SEVERE, "Database Error", e);
            resp.setStatusCode(ResponseDTO.ERROR_DATABASE);
            resp.setMessage("Server Database Error");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Database Error\n" + e.getDescription(), "Administrator Services");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Invalid Request", ex);
            resp.setStatusCode(ResponseDTO.ERROR_SERVER);
            resp.setMessage("Server problem encountered");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Exception\n" + DataUtil.getErrorString(ex), "Administrator Services");
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
                    Logger.getLogger(AdministratorServlet.class.getName()).log(Level.SEVERE, "Failed to compress!", ex);
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(json);

            }

            long end = System.currentTimeMillis();
            platformUtil.addTimeElapsedWarning(start, end, dto, "Administrator Services");
            log.log(Level.INFO, "AdministratorServlet done. Elapsed: {0} seconds, requestType: {1} - {2}", 
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
            log.log(Level.SEVERE, "Failed to parse JSON", e);
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
    private static final Logger log = Logger.getLogger("Administrator Services");
   
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
