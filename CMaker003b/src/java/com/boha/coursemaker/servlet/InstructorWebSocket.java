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
@ServerEndpoint("/wsinstructor")
@Stateful
public class InstructorWebSocket {

    @EJB
    PlatformUtil platformUtil;
    @EJB
    TraineeUtil traineeUtil;
    @EJB
    CloudMsgUtil cloudMsgUtil;
    @EJB
    AdministratorUtil administratorUtil;
    @EJB
    InstructorUtil instructorUtil;
    @EJB
    AuthorUtil authorUtil;
    @EJB
    DynamicUtil dynamicUtil;

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
        log.log(Level.WARNING, "onMessage, missile incoming: {0}", message);
        //
        ResponseDTO resp = new ResponseDTO();
        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
            switch (dto.getRequestType()) {
                case RequestDTO.GET_TRAINEE_DATA:
                    resp = traineeUtil.getTraineeData(dto.getTrainingClassID(),
                            dto.getTraineeID(), dto.getCompanyID(),
                            dto.getCountryCode());
                    break;
                case RequestDTO.DELETE_EVENT:
                    resp = instructorUtil.deleteTrainingClassEvent(dto.getTrainingClassEventID());
                    break;
                case RequestDTO.UPDATE_EVENT:
                    resp = instructorUtil.updateTrainingClassEvent(dto.getTrainingClassEvent());
                    break;
                case RequestDTO.ADD_TRAINEE_SKILLS:
                    resp = instructorUtil.addTraineeSkills(dto.getTraineeSkillList());
                    break;
                case RequestDTO.ADD_COMPANY_SKILL:
                    resp = instructorUtil.addSkill(dto.getSkill());
                    break;
                case RequestDTO.UPDATE_COMPANY_SKILL:
                    resp = instructorUtil.updateSkill(dto.getSkill());
                    break;
                case RequestDTO.ADD_COMPANY_SKILL_LEVEL:
                    resp = instructorUtil.addSkillLevel(dto.getSkillLevel());
                    break;
                case RequestDTO.UPDATE_COMPANY_SKILL_LEVEL:
                    resp = instructorUtil.updateSkillLevel(dto.getSkillLevel());
                    break;
                case RequestDTO.ADD_EVENTS:
                    resp = instructorUtil.addTrainingClassEvent(dto.getTrainingClassEvent());
                    break;
                case RequestDTO.GET_EVENTS_BY_CLASS:
                    resp = instructorUtil.getTrainingClassEvents(dto.getTrainingClassID());
                    break;
                case RequestDTO.GET_TRAINING_CLASSES_BY_INSTRUCTOR:
                    resp = instructorUtil.getTrainingClassesByInstructor(dto.getInstructorID());
                    break;

                case RequestDTO.ADD_INSTRUCTOR_RATINGS:
                    resp = instructorUtil.rateTrainee(dto.getCourseTraineeActivity(), dto.getInstructorID());
                    break;
                case RequestDTO.HELP_REQUESTS_BY_INSTRUCTOR:
                    resp = instructorUtil.getHelpRequests(
                            dto.getInstructorID(), dto.getStartDate(), dto.getEndDate());
                    break;
                case RequestDTO.GET_COUNTRY_LIST:
                    resp = DataUtil.getProvinceListByCountryCode(dto.getCountryCode(), administratorUtil.getEm());
                    break;
                case RequestDTO.GCM_SEND_INSTRUCTOR_TO_TRAINEE_MSG:
                    resp = cloudMsgUtil.sendInstructorToTraineeMessage(dto.getHelpResponse(), platformUtil);
                    break;
                case RequestDTO.REGISTER_INSTRUCTOR:
                    resp = instructorUtil.registerInstructor(dto.getInstructor());
                    break;
                case RequestDTO.GET_COMPANY_CLASS_LIST:
                    resp = DataUtil.getTrainingClassList(dto.getCompanyID(), administratorUtil.getEm());
                    break;

                case RequestDTO.GET_CLASS_ACTIVITY_LIST:
                    resp = instructorUtil.getClassActivities(dto.getTrainingClassID());
                    break;

                case RequestDTO.LOGIN_INSTRUCTOR:
                    resp = instructorUtil.loginInstructor(dto.getEmail(),
                            dto.getPassword(), dto.getGcmDevice(), platformUtil);
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
                            dto.getStartDate(), dto.getEndDate());
                    break;

                case RequestDTO.GET_COMPANY_COURSE_LIST:
                    resp = authorUtil.getCompanyCourseList(
                            dto.getCompanyID());
                    break;
                case RequestDTO.GET_TRAINEE_ACTIVITY_TOTALS:
                    resp = instructorUtil.getTraineeActivityTotalsByClass(dto.getTrainingClassID());
                    break;
                case RequestDTO.GET_TRAINEE_ACTIVITY_TOTALS_BY_COMPANY:
                    resp = instructorUtil.getTraineeActivityByCompany(dto.getCompanyID());
                    break;
                case RequestDTO.GET_TRAINEE_ACTIVITY_TOTALS_BY_INSTRUCTOR:
                    resp = instructorUtil.getTraineeActivityByInstructor(
                            dto.getInstructorID());
                    break;

                case RequestDTO.GET_CLASS_TRAINEE_LIST:
                    resp = instructorUtil.getClassTrainees(dto.getTrainingClassID());
                    break;
                case RequestDTO.GET_CATEGORIES_BY_COMPANY:
                    resp = instructorUtil.getCategoriesByCompany(dto.getCompanyID());
                    break;
                case RequestDTO.GET_COURSE_LIST_BY_CLASS:
                    resp = instructorUtil.getCourseByClass(dto.getTrainingClassID());
                    break;
                case RequestDTO.GET_INSTRUCTOR_CLASSES:
                    resp = instructorUtil.getInstructorClasses(dto.getInstructorID());
                    break;
                case RequestDTO.ENROLL_IN_COURSE:
                    resp = administratorUtil.assignClassCoursesToTrainees(dto.getTrainingClassID());
                    break;

                case RequestDTO.ENROLL_TRAINEES_FOR_ACTIVITIES:
                    resp = dynamicUtil.updateActivityEnrolment(dto.getTrainingClassID(), dto.getInstructorID(),
                            administratorUtil, instructorUtil);
                    break;
                default:
                    resp.setStatusCode(ResponseDTO.ERROR_UNKNOWN_REQUEST);
                    resp.setMessage("Invalid request detected. Verboten!!");
                    platformUtil.addErrorStore(ResponseDTO.ERROR_UNKNOWN_REQUEST, "Invalid request detected. Ignored.", "Instructor Services");
                    break;
            }
        } catch (DataException ex) {
            resp.setStatusCode(ResponseDTO.ERROR_DATABASE);
            resp.setMessage("Data service failed to process your request");
            log.log(Level.SEVERE, null, ex);
            platformUtil.addErrorStore(ResponseDTO.ERROR_DATABASE, ex.getDescription(), SOURCE);
        } catch (Exception ex) {
            resp.setStatusCode(ResponseDTO.ERROR_SERVER);
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
    public void onClose(Session session) {
        log.log(Level.WARNING, "onClose - remove session: {0}", session.getId());
        peers.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
        log.log(Level.SEVERE, "WebSocket Fail", t);
        platformUtil.addErrorStore(ResponseDTO.ERROR_WEBSOCKET, t.getMessage(), SOURCE);

    }
    static final Gson gson = new Gson();
    static final Logger log = Logger.getLogger(InstructorWebSocket.class.getName());
    public static final String SOURCE = "InstructorWebSocket";
}
