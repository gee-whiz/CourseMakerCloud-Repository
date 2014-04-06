/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.util.CourseMakerProperties;
import com.boha.coursemaker.util.LogFormatter;
import com.boha.coursemaker.util.PlatformUtil;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.ConsoleHandler;
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
 * @author malengatiger
 */
@WebServlet(name = "HouseKeeping", urlPatterns = {"/HouseKeeping"}, loadOnStartup = 3)
public class HouseKeeping extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }

    @Override
    public void init() {
        StringBuilder sb = new StringBuilder();

        sb.append("### ##########################################################################\n");
        sb.append("### CourseMaker BackEnd is UP and STARTED\n");
        sb.append("### ##########################################################################\n\n");
        logger.log(Level.INFO, sb.toString());
        Timer timer = new Timer();
        Calendar cal = GregorianCalendar.getInstance();
        for (int i = 0; i < 10; i++) {
            cal.roll(Calendar.MINUTE, true);
        }
        
        Date date = cal.getTime();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                startDiskCleanup();
            }
        }, date, FOUR_HOURS);

    }

   

    private void startDiskCleanup() {
        long s = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("### #######################################################\n");
        sb.append("### CourseMaker HouseKeeping Routine kicked off\n");
        sb.append("### #########################################################\n");
        logger.log(Level.INFO, sb.toString());
        int count = 0;
        File dir = CourseMakerProperties.getTemporaryDir();
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                long now = new Date().getTime();
                long cutOff = now - ONE_HOUR;
                if (file.lastModified() < cutOff) {
                    boolean OK = file.delete();
                    if (OK) {
                        count++;
                    }
                }
            }
        }
        logger.log(Level.INFO, "### CourseMaker HouseKeeping cleaned up {0} temporary files on {1}", 
                new Object[]{count, new Date().toString()});
        long end = System.currentTimeMillis();
        try {
            sb = new StringBuilder();
            sb.append("Temporary files HouseKeeping task completed\n");
            sb.append("Number of files cleaned up: ").append(count).append("\n");
            sb.append("Time elapsed: ").append(AdministratorServlet.getElapsed(s, end)).append(" seconds");
            platformUtil.addErrorStore(0, sb.toString(), "Server HouseKeeping");
            logger.log(Level.INFO, "Housekeeping errorStore record added");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to add to errorStore table", e);
        }
    }
    private static final Logger logger = Logger.getLogger(HouseKeeping.class.getName());
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
    private final static long ONCE_PER_DAY = 1000 * 60 * 60 * 24;
    private final static long EVERY_2_HOURS = 1000 * 60 * 60 * 2;
    private final static int ONE_DAY = 1;
    private final static int FOUR_AM = 4;
    private final static int HALF_HOUR = 1000 * 60 * 30;
    private final static int ONE_HOUR = 1000 * 60 * 60;
    private final static int FOUR_HOURS = 1000 * 60 * 60 * 4;
    static {
        LogFormatter formatter = new LogFormatter();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(formatter);
        logger.addHandler(consoleHandler);
    }
}
