/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.PhotoUploadDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.util.CourseMakerProperties;
import com.boha.coursemaker.util.DataUtil;
import com.boha.coursemaker.util.LogFormatter;
import com.boha.coursemaker.util.PlatformUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

/**
 *  This servlet accepts image files uploaded from CourseMaker devices and saves them on disk according to the requestor's role.
 * 
 * @author aubreyM
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/photo"})
public class PhotoServlet extends HttpServlet {
    @EJB
    PlatformUtil platformUtil;
    @EJB
    DataUtil dataUtil;
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
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        long start = System.currentTimeMillis();     

        ResponseDTO ur = new ResponseDTO();
        String json;
        Gson gson = new Gson();
        try {
            // Check that we have a file upload request
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                ur = downloadPhotos(request);
            } else {
                Logger.getLogger(PhotoServlet.class.getName()).log(Level.SEVERE, "Request invalid. multipart required");
                ur.setMessage("Request is not expected multi-part format");
                ur.setStatusCode(ResponseDTO.ERROR_INVALID_REQUEST);
                platformUtil.addErrorStore(ur.getStatusCode(),
                        "Not a multipart request, no photo to download", "Photo Services");
            }

        } catch (FileUploadException ex) {
            Logger.getLogger(PhotoServlet.class.getName()).log(Level.SEVERE, "File upload fucked", ex);
            ur.setStatusCode(ResponseDTO.ERROR_FILE_DOWNLOAD);
            ur.setMessage("Error. Unable to download file(s) sent. Contact Support");
            platformUtil.addErrorStore(ur.getStatusCode(),
                    ex.toString(), "Photo Services");

        } catch (Exception e) {
            Logger.getLogger(PhotoServlet.class.getName()).log(Level.SEVERE, "Servlet file upload fucked", e);
            ur.setStatusCode(ResponseDTO.ERROR_FILE_DOWNLOAD);
            ur.setMessage("Error. Generic server exception");
            platformUtil.addErrorStore(ur.getStatusCode(),
                    e.toString(), "Photo Services");

        } finally {
            json = gson.toJson(ur);
            out.println(json);
            out.close();
            long end = System.currentTimeMillis();
            platformUtil.addTimeElapsedWarning(start, end, null, "Photo Services");
            logger.log(Level.INFO, "PhotoServlet completed in {0} seconds ", getElapsed(start, end));
        }
    }

    private ResponseDTO downloadPhotos(HttpServletRequest request) throws FileUploadException {
        logger.log(Level.INFO, "######### starting PHOTO DOWNLOAD process\n\n");
        ResponseDTO resp = new ResponseDTO();
        FileOutputStream fos = null;
        InputStream stream = null;
        File rootDir;
        try {
            rootDir = CourseMakerProperties.getImageDir();
            logger.log(Level.INFO, "rootDir - {0}", rootDir.getAbsolutePath());
            if (!rootDir.exists()) {
                rootDir.mkdir();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Properties file problem", ex);
            resp.setMessage("Server file unavailable. Please try later");
            resp.setStatusCode(ResponseDTO.ERROR_SERVER);
            platformUtil.addErrorStore(99, "Failed to uplaod photo\n" 
                    + dataUtil.getErrorString(ex), "PhotoServlet");
            return resp;
        }

        int fileCnt = 0;
        PhotoUploadDTO dto = null;
        Gson gson = new Gson();
        File companyDir = null, instructorDir = null, traineeDir = null, authorDir = null,
                adminDir = null;
        try {
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                String name = item.getFieldName();
                stream = item.openStream();
                if (item.isFormField()) {
                    if (name.equalsIgnoreCase("JSON")) {
                        String json = Streams.asString(stream);
                        if (json != null) {
                            logger.log(Level.INFO, "picture with associated json: {0}", json);
                            dto = gson.fromJson(json, PhotoUploadDTO.class);
                            if (dto != null) {
                                companyDir = new File(rootDir, COMPANY_PREFIX + dto.getCompanyID());
                                if (!companyDir.exists()) {
                                    companyDir.mkdir();
                                    logger.log(Level.INFO, "company directory created - {0}", companyDir.getAbsolutePath());
                                }
                                switch (dto.getType()) {
                                    case PhotoUploadDTO.INSTRUCTOR:
                                        logger.log(Level.INFO, "instructor photo to be downloaded");
                                        instructorDir = new File(companyDir, INSTRUCTOR_PREFIX);
                                        if (!instructorDir.exists()) {
                                            instructorDir.mkdir();
                                            logger.log(Level.INFO, "instructor directory created - {0}", instructorDir.getAbsolutePath());
                                        }
                                        break;
                                    case PhotoUploadDTO.TRAINEE:
                                        logger.log(Level.INFO, "trainee photo to be downloaded");
                                        traineeDir = new File(companyDir, TRAINEE_PREFIX);
                                        if (!traineeDir.exists()) {
                                            traineeDir.mkdir();
                                            logger.log(Level.INFO, "trainee directory created - {0}", traineeDir.getAbsolutePath());
                                        }
                                        break;
                                    case PhotoUploadDTO.ADMINISTRATOR:
                                        logger.log(Level.INFO, "admin photo to be downloaded");
                                        adminDir = new File(companyDir, ADMIN_PREFIX);
                                        if (!adminDir.exists()) {
                                            adminDir.mkdir();
                                            logger.log(Level.INFO, "admin directory created - {0}", adminDir.getAbsolutePath());
                                        }
                                    case PhotoUploadDTO.AUTHOR:
                                        logger.log(Level.INFO, "author photo to be downloaded");
                                        authorDir = new File(companyDir, AUTHOR_PREFIX);
                                        if (!authorDir.exists()) {
                                            authorDir.mkdir();
                                            logger.log(Level.INFO, "author directory created - {0}", authorDir.getAbsolutePath());
                                        }
                                        break;

                                }


                            }
                        } else {
                            logger.log(Level.WARNING, "JSON input seems fucked up! is NULL..");
                        }
                    }
                } else {
                    File imageFile = null;
                    if (dto == null) {
                        continue;
                    }
                    if (!companyDir.exists()) {
                        logger.log(Level.WARNING, "company directory does not EXIST! {0}",
                                companyDir.getAbsolutePath());
                        companyDir.mkdir();

                    }
                    switch (dto.getType()) {
                        case PhotoUploadDTO.INSTRUCTOR:
                            imageFile = new File(instructorDir, "" + dto.getInstructorID() + ".jpg");
                            break;
                        case PhotoUploadDTO.TRAINEE:
                            imageFile = new File(traineeDir, "" + dto.getTraineeID() + ".jpg");
                            break;
                        case PhotoUploadDTO.AUTHOR:
                            imageFile = new File(authorDir, "" + dto.getAuthorID() + ".jpg");
                            break;
                        case PhotoUploadDTO.ADMINISTRATOR:
                            imageFile = new File(adminDir, "" + dto.getAdministratorID() + ".jpg");
                            break;

                    }


                    fos = new FileOutputStream(imageFile);
                    int read;
                    byte[] bytes = new byte[2048];
                    while ((read = stream.read(bytes)) != -1) {
                        fos.write(bytes, 0, read);
                    }
                    stream.close();
                    fos.flush();
                    fos.close();

                    fileCnt++;
                    resp.setMessage("Photos downloaded from mobile app " + fileCnt);

                    logger.log(Level.INFO, "\n### File downloaded: {0} size: {1}",
                            new Object[]{imageFile.getAbsolutePath(), imageFile.length()});
                    platformUtil.addErrorStore(0, "Photo downloaded to web app\n"
                            + "file: " + imageFile.getAbsolutePath(), "PhotoServlet");
                }
            }

        } catch (FileUploadException | IOException | JsonSyntaxException ex) {
            logger.log(Level.SEVERE, "Servlet failed on IOException, images NOT uploaded", ex);
            platformUtil.addErrorStore(99, "Photo upload failed\n" 
                    + dataUtil.getErrorString(ex), "PhotoServlet");
            throw new FileUploadException();
        } finally {
            try {
                stream.close();
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (IOException ex) {
                logger.log(Level.WARNING, "closing stream", ex);
            }

        }

        return resp;
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }
    static final Logger logger = Logger.getLogger("PhotoServlet");
    private static final String COMPANY_PREFIX = "company";
    private static final String TRAINEE_PREFIX = "trainee";
    private static final String INSTRUCTOR_PREFIX = "instructor";
    private static final String ADMIN_PREFIX = "admin";
    private static final String AUTHOR_PREFIX = "author";
static {
        LogFormatter formatter = new LogFormatter();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(formatter);
        logger.addHandler(consoleHandler);
    }
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
