/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.util.CloudMsgUtil;
import com.boha.coursemaker.util.DataException;
import com.boha.coursemaker.util.DataUtil;
import com.boha.coursemaker.util.PlatformUtil;
import com.boha.coursemaker.util.GZipUtility;
import com.boha.coursemaker.util.InstructorUtil;
import com.boha.coursemaker.util.TeamUtil;
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
 *  All the requests from the Trainee mobile app are handled by this servlet
 * 
 * @author aubreyM
 */
@WebServlet(name = "Trainee Services", urlPatterns = {"/trainee"})
public class TraineeServlet extends HttpServlet {

    @EJB
    PlatformUtil platformUtil;
    @EJB
    TraineeUtil traineeUtil;
    @EJB
    InstructorUtil instructorUtil;
    @EJB
    CloudMsgUtil cloudMsgUtil;
    @EJB
    DataUtil dataUtil;
    @EJB
    TeamUtil teamUtil;
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
        log.log(Level.INFO, "TraineeServlet started ...");
        long start = System.currentTimeMillis();
        ResponseDTO resp = new ResponseDTO();
        RequestDTO dto = new RequestDTO();
        try {
            dto = getRequest(request);
            if (dto == null || dto.getRequestType() == 0) {
                resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                resp.setMessage("Request is unknown. Verboten!!!");
                platformUtil.addErrorStore(resp.getStatusCode(),
                        "Intruder request detected. Ignored", "Trainee Services");
            } else {
                switch (dto.getRequestType()) {
                     case RequestDTO.GET_COUNTRY_LIST:
                    resp = dataUtil.getProvinceListByCountryCode(dto.getCountryCode());
                    break;
                case RequestDTO.GCM_SEND_TRAINEE_TO_INSTRUCTOR_MSG:
                    resp = cloudMsgUtil.sendTraineeToInstructorMessage(
                            dto.getHelpRequest(), null, dto.getTrainingClassID(), 
                            platformUtil, instructorUtil, dataUtil);
                    break;
                case RequestDTO.SEND_TRAINEE_SHOUT:
                    resp = cloudMsgUtil.sendTraineeToInstructorMessage(
                            null, dto.getTraineeShout(), dto.getTrainingClassID(), 
                            platformUtil, instructorUtil, dataUtil);
                    break;

                case RequestDTO.EVALUATE_TRAINEE_ACTIVITY:
                    resp = traineeUtil.traineeActivityEvaluation(
                            dto.getCourseTraineeActivity(), dto.getTraineeID(), dataUtil);
                    break;
                case RequestDTO.LOGIN_TRAINEE:
                    resp = traineeUtil.loginTrainee(dto.getEmail(),
                            dto.getPassword(), dataUtil);
                    resp.setProvinceList(dataUtil.getProvinceListByCountryCode(dto.getCountryCode()).getProvinceList());
                    if (resp.getStatusCode() == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Trainee logging in with new device").append("\n");
                        sb.append(resp.getCompany().getCompanyName()).append("\n\n");
                        sb.append(resp.getTrainee().getFirstName()).append(" ").append(resp.getTrainee().getLastName())
                                .append("\n");
                        platformUtil.addErrorStore(0, sb.toString(), "Trainee Services");
                    }
                    break;
                    
                case RequestDTO.ADD_HELP_REQUEST:
                    resp = traineeUtil.addHelpRequest(dto.getHelpRequest(), dataUtil);
                    break;
                case RequestDTO.UPDATE_TRAINEE:
                    resp = traineeUtil.updateTraineeProfile(dto.getTrainee(), dataUtil);
                    break;
                case RequestDTO.GET_TRAINEE_DATA:
                    resp = traineeUtil.getTraineeData(dto.getTrainingClassID(),
                            dto.getTraineeID(), dto.getCompanyID(), 
                            dto.getCountryCode(), dataUtil);
                    resp.setTeamList(teamUtil.getTeamsByClass(dto.getTrainingClassID(), dataUtil).getTeamList());        
                    break;
                case RequestDTO.GET_RATING_LIST:
                    resp = dataUtil.getRatingAndHelpList(dto.getCompanyID());
                    break;
                case RequestDTO.GET_INSTRUCTOR_LIST_BY_CLASS:
                    resp = traineeUtil.getInstructorsByClass(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.GET_TEAMS_BY_CLASS:
                    resp = teamUtil.getTeamsByClass(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.GET_TEAMS_BY_COMPANY:
                    resp = teamUtil.getTeamsByCompany(dto.getCompanyID(), dataUtil);
                    break;
                default:
                    resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                    resp.setMessage("Unknown request. Verboten!!");
                    platformUtil.addErrorStore(resp.getStatusCode(),
                            "Unknown request detected. Whazzup??", "Trainee Services");
                    break;
                }
            }
        } catch (DataException e) {
            log.log(Level.SEVERE, "Database Error", e);
            resp.setStatusCode(ResponseDTO.ERROR_DATABASE);
            resp.setMessage("Server Database Error, contact CourseMaker support");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Server Database Error\n" + e.getDescription(), "Trainee Services");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Invalid Request", ex);
            resp.setStatusCode(ResponseDTO.ERROR_INVALID_REQUEST);
            resp.setMessage("Server Error");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    "Unexpected Server Exception\n" + dataUtil.getErrorString(ex), "Trainee Services");
        } finally {
            addCorsHeaders(response);
            Gson gson = new Gson();
            String json = gson.toJson(resp);

            if (dto.isZippedResponse()) {
                response.setContentType("application/zip;charset=UTF-8");
                File zipped;
                try {
                    zipped = GZipUtility.getZipped(json);
                    ServletUtils.returnFile(zipped.getAbsolutePath(), response.getOutputStream());
                    response.getOutputStream().close();
                    log.log(Level.INFO, "### Packed length:: {0} -  "
                            + "unzipped: {1}", new Object[]{zipped.length(), json.length()});
                } catch (IOException e) {
                    log.log(Level.SEVERE, "Zipping problem - probably the zipper cannot find the zipped file", e);

                } catch (Exception ex) {
                    Logger.getLogger(TraineeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(json);

            }

            long end = System.currentTimeMillis();

            platformUtil.addTimeElapsedWarning(start, end, dto, "Trainee Services");
            log.log(Level.INFO, "TraineeServlet done. Elapsed: {0} seconds, requestType: {1} - {2}", 
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

    /**
     * Add Cross-site headers to enable accessing this server from pages not
     * served by this server
     *
     * See: http://www.html5rocks.com/en/tutorials/cors/ and
     * http://enable-cors.org/server.html
     */
    public static void addCorsHeaders(HttpServletResponse res) {
        res.setHeader("Access-Control-Allow-Origin", "*, ");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }
    private static final Logger log = Logger.getLogger("Trainee Services");

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
