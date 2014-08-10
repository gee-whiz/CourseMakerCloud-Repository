/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
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
@ServerEndpoint("/endpoint")
@Stateful
public class CMWSEndpoint {

    public CMWSEndpoint() {
        log.log(Level.OFF, "CMWSEndpoint instance has been created. {0}", this);
    }
    private static final Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String onMessage(String message, Session session) {
        log.log(Level.INFO, "##### onMessage: {0}", message);
        log.log(Level.INFO, "----- onMessage, Session ID: {0}", session.getId());
        return "SERVER: " + message;
    }

    public void sendTextMessage(String sessionID, String message) throws IOException {
        log.log(Level.OFF, "Sending message to {0}", sessionID);
        Iterator<Session> ite = peers.iterator();
        Session session = null;
        while (ite.hasNext()) {
            session = ite.next();
            log.log(Level.OFF, "Found session in peers: {0}", session.getId());
            if (sessionID.equalsIgnoreCase(session.getId())) {
                break;
            } else {
                session = null;
            }
        }
        if (session != null) {
            log.log(Level.INFO, "---------> sending message to 1 phone via SessionID");
            session.getBasicRemote().sendText(sdf.format(new Date()) + " " + message);
        }

    }

    public void sendTextMessage(String message) throws IOException {
        Iterator<Session> ite = peers.iterator();
        while (ite.hasNext()) {
            Session s = ite.next();
            log.log(Level.INFO, "========> sending message to: {0}", s.getId());
            s.getBasicRemote().sendText(sdf.format(new Date()) + " " + message);

        }

    }

    @OnClose
    public void onClose(Session session) {
        log.log(Level.WARNING, "Handling webSocket close");
        peers.remove(session);

    }

    @OnError
    public void onError(Throwable t) {
        log.log(Level.SEVERE, "Websocket Error: {0}", t.getMessage());
    }

    static final Logger log = Logger.getLogger(CMWSEndpoint.class.getName());

    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
        try {
            session.getBasicRemote().sendText("WebSocket Session opened:\n " + session.getId());
        } catch (IOException ex) {
            Logger.getLogger(CMWSEndpoint.class.getName()).log(Level.SEVERE, "Failed to open web socket session", ex);
        }
        log.log(Level.INFO, "----- onOpen, Session ID: {0}", session.getId());
    }
    static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
}
