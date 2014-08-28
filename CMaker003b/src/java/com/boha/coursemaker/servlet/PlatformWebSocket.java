/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.dto.platform.RequestDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import com.boha.coursemaker.dto.platform.StatsResponseDTO;
import com.boha.coursemaker.util.AuthorUtil;
import com.boha.coursemaker.util.CloudMsgUtil;
import com.boha.coursemaker.util.DataException;
import com.boha.coursemaker.util.GZipUtility;
import com.boha.coursemaker.util.LogfileUtil;
import com.boha.coursemaker.util.PlatformUtil;
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
@ServerEndpoint("/wsplatform")
@Stateful
public class PlatformWebSocket {

    @EJB
    PlatformUtil platformUtil;
    @EJB
    AuthorUtil authorUtil;
    @EJB
    CloudMsgUtil cloudMsgUtil;

    private static final Set<Session> peers
            = Collections.synchronizedSet(new HashSet<Session>());

    public void sendData(StatsResponseDTO resp, String sessionID)
            throws IOException, Exception {
        for (Session session : peers) {
            if (sessionID.equals(session.getId())) {
                session.getBasicRemote().sendBinary(getZippedResponse(resp));
            }
        }
    }

    private ByteBuffer getZippedResponse(StatsResponseDTO resp)
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
        StatsResponseDTO resp = new StatsResponseDTO();
        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
            switch (dto.getRequestType()) {
                case RequestDTO.GET_ERROR_LIST:
                    resp = platformUtil.getErrorStoreList(
                            dto.getDateFrom(), dto.getDateTo());
                    resp.setLogString(LogfileUtil.getFileString());
                    break;

                case RequestDTO.GET_COMPANY_STATS:
                    resp = platformUtil.getCompanyStats(dto.getCompanyID());
                    break;
                case RequestDTO.GET_OVERALL_STATS:
                    resp = platformUtil.getPlatformStats();
                    break;
                default:
                    resp.setStatusCode(StatsResponseDTO.ERROR_UNKNOWN_REQUEST);
                    resp.setMessage("Unknown request. Verboten!!");
                    platformUtil.addErrorStore(resp.getStatusCode(),
                            "Unknown request", "PlatformServlet");
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
            StatsResponseDTO r = new StatsResponseDTO();
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
    static final Logger log = Logger.getLogger(PlatformWebSocket.class.getName());
    public static final String SOURCE = "AuthorWebSocket";
}
