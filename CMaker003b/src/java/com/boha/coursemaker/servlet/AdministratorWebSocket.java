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
import com.boha.coursemaker.util.EmailUtil;
import com.boha.coursemaker.util.GZipUtility;
import com.boha.coursemaker.util.InstructorUtil;
import com.boha.coursemaker.util.PlatformUtil;
import com.boha.coursemaker.util.TraineeUtil;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author aubreyM
 */
@ServerEndpoint("/wsadmin")
@Stateful
public class AdministratorWebSocket {

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
    @EJB
    CloudMsgUtil cloudMsgUtil;
    @EJB
    DataUtil dataUtil;

    private static final Set<Session> peers
            = Collections.synchronizedSet(new HashSet<Session>());

    public void sendData(ResponseDTO resp, String sessionID)
            throws IOException, Exception {
        for (Session session : peers) {
            if (sessionID.equals(session.getId())) {
                session.getBasicRemote().sendBinary(getZippedResponse(resp));
            }
        }
    }

    private ByteBuffer getZippedResponse(ResponseDTO resp)
            throws Exception {
        File file = GZipUtility.getZipped(gson.toJson(resp));
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream = null;
        //convert file into array of bytes
        fileInputStream = new FileInputStream(file);
        fileInputStream.read(bFile);
        fileInputStream.close();
        ByteBuffer buf = ByteBuffer.wrap(bFile);
        return buf;
    }

    @OnMessage
    public ByteBuffer onMessage(String message) {
        log.log(Level.WARNING, "onMessage, incoming: {0}", message);
        ResponseDTO resp = new ResponseDTO();
        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
            switch (dto.getRequestType()) {
                case RequestDTO.GET_COMPANY_DATA:
                    resp = administratorUtil.getCompanyData(dto.getCompanyID(), dataUtil);
                    break;
                case RequestDTO.ADD_COURSES_TO_CLASS:
                    resp = administratorUtil.addClassCourses(dto.getTrainingClassID(), dto.getCourseList(), null, dataUtil);
                    break;
                case RequestDTO.GET_COUNTRY_LIST:
                    resp = dataUtil.getProvinceListByCountryCode(dto.getCountryCode());
                    break;
                case RequestDTO.LOGIN_ADMINISTRATOR:
                    resp = administratorUtil.loginAdministrator(dto.getEmail(),
                            dto.getPassword(),
                            dto.getGcmDevice(), platformUtil, dataUtil);

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
                            dto.getAdministrator(), dto.getGcmDevice(), platformUtil, dataUtil);

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
                    resp = administratorUtil.addAuthor(dto.getAuthor(), dto.getCompanyID(), authorUtil,dataUtil);
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
                            dto.getTrainingClassID(), dto.getCityID(), traineeUtil,dataUtil);
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
                    resp = administratorUtil.addInstructor(dto.getInstructor(), instructorUtil,dataUtil);
                    if (resp.getStatusCode() == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("New Instructor Registered").append("\n\n");
                        sb.append(dto.getInstructor().getFirstName()).append(" ").append(dto.getInstructor().getLastName())
                                .append("\n");
                        sb.append(resp.getCompany().getCompanyName());
                        platformUtil.addErrorStore(0, sb.toString(), "Administrator Services");
                        ResponseDTO r = administratorUtil.getInstructorList(dto.getInstructor().getCompanyID(), dataUtil);
                        resp.setInstructorList(r.getInstructorList());
                    }

                    break;
                case RequestDTO.REGISTER_ADMINISTRATOR:
                    resp = administratorUtil.addAdministrator(dto.getAdministrator(), dataUtil);
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
                    resp = dataUtil.getTrainingClassList(dto.getCompanyID());
                    break;
                case RequestDTO.GET_COMPANY_COURSE_LIST:
                    resp = authorUtil.getCompanyCourseList(
                            dto.getCompanyID(),dataUtil);
                    break;
                case RequestDTO.ADD_TRAINING_CLASS:
                    resp = administratorUtil.registerClass(dto.getCompanyID(),
                            dto.getTrainingClass(), dto.getAdministratorID(), dataUtil);
                    break;
                case RequestDTO.UPDATE_CLASS:
                    resp = administratorUtil.updateClass(dto.getTrainingClass(), dataUtil);
                    break;
                case RequestDTO.DELETE_CLASS:
                    resp = administratorUtil.deleteClass(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.ASSIGN_INSTRUCTOR_CLASS:
                    resp = administratorUtil.assignInstructorClass(dto.getInstructorID(),
                            dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.DELETE_INSTRUCTOR_CLASS:
                    resp = instructorUtil.deleteInstructorClass(dto.getInstructorClassID(),dataUtil);
                    break;
                case RequestDTO.ADD_TRAINEE_EQUPIMENT:
                    resp = administratorUtil.addTraineeEquipment(
                            dto.getTraineeID(),
                            dto.getInventoryID(),
                            dto.getAdministratorID(), dataUtil);
                    break;
                case RequestDTO.UPDATE_TRAINEE_EQUPIMENT:
                    resp = administratorUtil.updateTraineeEquipment(
                            dto.getTraineeEquipmentID(), dto.getConditionFlag(),
                            dto.isReturnEquipment(),
                            dto.getAdministratorID(), dataUtil);
                    break;
                case RequestDTO.ADD_EQUIPMENT:
                    resp = administratorUtil.addEquipment(dto.getEquipment(),
                            dto.getCompanyID(), dto.getAdministratorID(), dataUtil);
                    break;
                case RequestDTO.UPDATE_EQUIPMENT:
                    resp = administratorUtil.updateEquipment(dto.getEquipment(), dto.getAdministratorID(), dataUtil);
                    break;
                //deactivate
                case RequestDTO.DEACTIVATE_INSTRUCTOR:
                    resp = administratorUtil.deactivateInstructor(dto.getInstructor(),
                            dto.getAdministratorID(), dataUtil);
                    break;
                case RequestDTO.DEACTIVATE_TRAINEE:
                    resp = administratorUtil.deactivateTrainee(dto.getTrainee(),
                            dto.getAdministratorID(), dataUtil);
                    break;
                //    
                case RequestDTO.GET_INSTRUCTOR_LIST:
                    resp = administratorUtil.getInstructorList(dto.getCompanyID(), dataUtil);
                    break;
                case RequestDTO.GET_CLASS_TRAINEE_LIST:
                    resp = administratorUtil.getClassTraineeList(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.GET_CLASS_COURSE_LIST:
                    resp = administratorUtil.getClassCourseList(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.GET_CLASS_TRAINEE_EQUIPMENT_LIST:
                    resp = administratorUtil.getTraineeEquipmentListByClass(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.GET_CLASS_COURSE_TRAINEE_ACTIVITY_LIST:
                    resp = administratorUtil.getCourseTraineeActivityList(dto.getTrainingClassCourseID(), dataUtil);
                    break;
                case RequestDTO.GET_TRAINEE_EQUIPMENT_LIST_BY_EQUPMENTID:
                    resp = administratorUtil.getTraineeEquipmentListByEquipmentID(dto.getEquipmentID(), dataUtil);
                    break;
                case RequestDTO.GET_TRAINEE_EQUIPMENT_LIST_BY_INVENTORYID:
                    resp = administratorUtil.getTraineeEquipmentListByInventory(
                            dto.getInventoryID(), dataUtil);
                    break;
                case RequestDTO.ADD_INVENTORY:
                    resp = administratorUtil.addInventory(dto.getInventory(),
                            dto.getAdministratorID(), dataUtil);
                    break;
                case RequestDTO.UPDATE_INVENTORY:
                    resp = administratorUtil.updateInventory(dto.getInventory(),
                            dto.getAdministratorID(), dataUtil);
                    break;

                case RequestDTO.GET_COMPANY_EQUIPMENT_LIST:
                    resp = administratorUtil.getEquipmentList(dto.getCompanyID(), dataUtil);
                    break;
                case RequestDTO.GET_INVENTORY_LIST:
                    resp = administratorUtil.getInventoryList(dto.getCompanyID(), dataUtil);
                    break;
                case RequestDTO.GET_INVENTORY_LIST_BY_CLASS:
                    resp = administratorUtil.getInventoryListByClass(dto.getTrainingClassID(), dataUtil);
                    break;
                case RequestDTO.GET_INVENTORY_LIST_BY_EQUIPMENT:
                    resp = administratorUtil.getEquipmentInventory(dto.getEquipmentID(), dataUtil);
                    break;
                case RequestDTO.GET_HELP_REQUEST_LIST:
                    resp = administratorUtil.getHelpRequestListByPeriod(dto.getTrainingClassID(),
                            dto.getStartDate(), dto.getEndDate(), dataUtil);
                    break;
                case RequestDTO.UPDATE_AUTHOR:
                    resp = administratorUtil.updateAuthor(dto.getAuthor(), dataUtil);
                    break;
                case RequestDTO.UPDATE_INSTRUCTOR:
                    resp = administratorUtil.updateInstructor(dto.getInstructor(), dataUtil);
                    break;
                case RequestDTO.UPDATE_TRAINEE:
                    resp = administratorUtil.updateTrainee(dto.getTrainee(), dto.getTrainingClassID(), dto.getCityID(), dataUtil);
                    break;
                case RequestDTO.UPDATE_ADMIN:
                    resp = administratorUtil.updateAdmin(dto.getAdministrator(), dataUtil);
                    break;

                case RequestDTO.SEND_PASSWORD_ADMIN:
                    resp = administratorUtil.updatePassword(dto.getAdministratorID(),
                            EmailUtil.ADMINISTRATOR, dataUtil);
                    break;
                case RequestDTO.SEND_PASSWORD_AUTHOR:
                    resp = administratorUtil.updatePassword(dto.getAuthorID(),
                            EmailUtil.AUTHOR, dataUtil);
                    break;
                case RequestDTO.SEND_PASSWORD_INSTRUCTOR:
                    resp = administratorUtil.updatePassword(dto.getInstructorID(),
                            EmailUtil.INSTRUCTOR, dataUtil);
                    break;
                case RequestDTO.SEND_PASSWORD_TRAINEE:
                    resp = administratorUtil.updatePassword(dto.getTraineeID(),
                            EmailUtil.TRAINEE, dataUtil);
                    break;
                case RequestDTO.SEND_PASSWORD_EXECUTIVE:

                    break;
                case RequestDTO.GET_RATING_LIST:
                    resp = dataUtil.getRatingAndHelpList(dto.getCompanyID());
                    break;
                case RequestDTO.ADD_RATING:
                    resp = administratorUtil.addRating(dto.getRating(), dataUtil);
                    break;
                case RequestDTO.DELETE_RATING:
                    resp = administratorUtil.deleteRating(dto.getRating(), dataUtil);
                    break;
                case RequestDTO.UPDATE_RATING:
                    resp = administratorUtil.updateRating(dto.getRating(), dataUtil);
                    break;

                case RequestDTO.ADD_HELPTYPE:
                    resp = administratorUtil.addHelpType(dto.getHelpType(), dataUtil);
                    break;
                case RequestDTO.DELETE_HELPTYPE:
                    resp = administratorUtil.deleteHelpType(dto.getHelpType(), dataUtil);
                    break;
                case RequestDTO.UPDATE_HELPTYPE:
                    resp = administratorUtil.updateHelpType(dto.getHelpType(), dataUtil);
                    break;

                default:
                    resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                    resp.setMessage("Unknown request. Verboten!!");
                    platformUtil.addErrorStore(resp.getStatusCode(),
                            "Unknown Request", "Administrator Services");
                    break;
            }

        } catch (DataException ex) {
            resp.setStatusCode(111);
            resp.setMessage("Data service failed to process your request");
            log.log(Level.SEVERE, null, ex);
            platformUtil.addErrorStore(ResponseDTO.ERROR_DATABASE, ex.getDescription(), SOURCE);
        } catch (Exception ex) {
            resp.setStatusCode(112);
            resp.setMessage("Service failed to process your request");
            log.log(Level.SEVERE, null, ex);
            platformUtil.addErrorStore(ResponseDTO.ERROR_SERVER, ex.getMessage(), SOURCE);
        }
        ByteBuffer bb = null;
        try {
            bb = getZippedResponse(resp);
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return bb;
    }

    @OnOpen
    public void onOpen(Session session) {

        peers.add(session);
        try {
            ResponseDTO r = new ResponseDTO();
            r.setSessionID(session.getId());
            session.getBasicRemote().sendText(gson.toJson(r));
            log.log(Level.WARNING, "onOpen...sent session id: {0}", session.getId());
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Failed to open web socket session", ex);
            platformUtil.addErrorStore(ResponseDTO.ERROR_WEBSOCKET, ex.getMessage(), SOURCE);
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            platformUtil.addErrorStore(ResponseDTO.ERROR_WEBSOCKET, ex.getMessage(), SOURCE);
        }
    }

    @OnClose
    public void onClose(Session session
    ) {
        log.log(Level.WARNING, "onClose - remove session: {0}", session.getId());
        peers.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
        log.log(Level.SEVERE, "WebSocket Fail", t);
        platformUtil.addErrorStore(ResponseDTO.ERROR_WEBSOCKET, t.getMessage(), SOURCE);

    }
    static final Gson gson = new Gson();
    static final Logger log = Logger.getLogger(AdministratorWebSocket.class.getName());
    public static final String SOURCE = "AdministratorWebSocket";
}
