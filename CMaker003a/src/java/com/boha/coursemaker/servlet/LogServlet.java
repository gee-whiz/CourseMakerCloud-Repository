/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.StatsResponseDTO;
import com.boha.coursemaker.util.PlatformUtil;
import com.boha.coursemaker.util.GZipUtility;
import com.boha.coursemaker.util.LogfileUtil;
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
 *
 * @author aubreyM
 */
@WebServlet(name = "LogServlet", urlPatterns = {"/log"})
public class LogServlet extends HttpServlet {
    @EJB
    PlatformUtil platformUtil;
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
        //log.log(Level.INFO, "LogServlet started ...");
        long start = System.currentTimeMillis();
        StatsResponseDTO resp = new StatsResponseDTO();
        File logFile;
        RequestDTO dto = null;
        try {
            dto = getRequest(request);
            if (dto == null || dto.getRequestType() == 0) {
                resp.setStatusCode(StatsResponseDTO.ERROR_UNKNOWN_REQUEST);
                resp.setMessage("Request is unknown. Verboten!!!");
                platformUtil.addErrorStore(resp.getStatusCode(),
                        "Intruder request", "LogServlet");
            } else {
                switch (dto.getRequestType()) {
                    case RequestDTO.GET_SERVER_LOG:
                        resp.setLogString(LogfileUtil.getFileString());
                        resp.setMessage("Log file string set in response");
                        break;
                }
            }

        } catch (Exception ex) {
            log.log(Level.SEVERE, "Invalid Request", ex);
            resp.setStatusCode(StatsResponseDTO.ERROR_INVALID_REQUEST);
            resp.setMessage("Server Error");
            platformUtil.addErrorStore(resp.getStatusCode(),
                    ex.toString(), "LogServlet");
        } finally {
            addCorsHeaders(response);
            response.setContentType("application/zip;charset=UTF-8");
            Gson gson = new Gson();
            String json = gson.toJson(resp);
            try {
                logFile = GZipUtility.getZipped(json);
                ServletUtils.returnFile(logFile.getAbsolutePath(), response.getOutputStream());
                response.getOutputStream().close();
                log.log(Level.INFO, "###Packed length:: {0} -  "
                        + "unzipped: {1}", new Object[]{logFile.length(), logFile.length()});
            } catch (Exception e) {
                log.log(Level.SEVERE, "Zipping problem - probably the zipper cannot find the zipped file", e);
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(json);
            } 

            long end = System.currentTimeMillis();
            log.log(Level.INFO, "LogServlet Request completed in {0} seconds - requestType: {1}", 
                    new Object[]{getElapsed(start, end), dto.getRequestType()});
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
    private static final Logger log = Logger.getLogger("PlatformServlet");
    
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
