/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.util.AuthorUtil;
import com.boha.coursemaker.util.CloudMsgUtil;
import com.boha.coursemaker.util.DataException;
import com.boha.coursemaker.util.GZipUtility;
import com.boha.coursemaker.util.PlatformUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
@ServerEndpoint("/wsauthor")
@Stateful
public class AuthorWebSocket {

    @EJB
    PlatformUtil platformUtil;
    @EJB
    AuthorUtil authorUtil;
    @EJB
    CloudMsgUtil cloudMsgUtil;
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

    public void sendData(ResponseDTO resp, List<String> sessionIDs)
            throws IOException, Exception {
        for (Session session : peers) {
            for (String id : sessionIDs) {
                if (id.equals(session.getId())) {
                    session.getBasicRemote().sendBinary(getZippedResponse(resp));
                }
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
        log.log(Level.WARNING, "onMessage: {0}", message);
        ResponseDTO resp = new ResponseDTO();
        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
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

                case RequestDTO.GET_OBJECTIVE_LIST_BY_COURSE:
                    resp = authorUtil.getObjectivesByCourse(dto.getCourseID());
                    break;
                case RequestDTO.GET_ACTIVITY_LIST_BY_LESSON:
                    resp = authorUtil.getActivitiesByLesson(dto.getLessonID());
                    break;

                case RequestDTO.ADD_CATEGORY:
                    resp = authorUtil.addCategory(dto.getCategory(), cloudMsgUtil, platformUtil);
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
                            dto.getCompanyID(), dto.getAuthorID(), cloudMsgUtil, platformUtil);
                    break;

                case RequestDTO.ADD_OBJECTIVES:
                    resp = authorUtil.addObjective(dto.getObjective(),
                            dto.getCourseID());
                    break;
                case RequestDTO.ADD_ACTIVITIES:
                    resp = authorUtil.addActivity(dto.getActivity(),
                            dto.getCourseID());
                    break;
                case RequestDTO.ADD_RESOURCES:
                    resp = authorUtil.addLessonResource(dto.getLessonResource());
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
                            dto.getActivityList(), dto.getCourseID());
                    break;
                case RequestDTO.DELETE_LESSON_RESOURCES:
                    resp = authorUtil.deleteLessonResources(
                            dto.getLessonResourceList(), dto.getCourseID());
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

        } catch (DataException ex) {
            resp.setStatusCode(111);
            resp.setMessage("Data service failed to process your request");
            log.log(Level.SEVERE, null, ex);
        } catch (JsonSyntaxException ex) {
            resp.setStatusCode(112);
            resp.setMessage("Service failed to process your request");
            log.log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
        }
    }

    @OnClose
    public void onClose(Session session
    ) {
        log.log(Level.WARNING, "onClose - remove session: {0}", session.getId());
        peers.remove(session);
    }

    @OnError
    public void onError(Throwable t
    ) {
    }
    static final Gson gson = new Gson();
    static final Logger log = Logger.getLogger(AuthorWebSocket.class.getName());
}
