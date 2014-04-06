/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
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
@ServerEndpoint("/bohaws")
public class BohaWebsocketEndpoint {

   private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String onMessage(String message, Session client) throws IOException, EncodeException {
        log.log(Level.INFO, "Websocket onMessage: {0}", message);
        for (Session peer : peers) {
            peer.getBasicRemote().sendObject(message);
        }

        return null;
    }

    @OnClose
    public void onClose(Session peer) {
        log.log(Level.OFF, "Websocket onClose - '{'peer id: {0} date: {1}", new Object[]{peer.getId(), new Date().toString()});

        peers.remove(peer);
    }

    @OnOpen
    public void onOpen(Session peer) {
        log.log(Level.INFO, "Websocket onOpen - '{'peer id: {0} date: {1}", new Object[]{peer.getId(), new Date().toString()});

        peers.add(peer);
    }

    @OnError
    public void onError(Throwable t) {
        log.log(Level.SEVERE, "Websocket onError {0}", t.getMessage());
    }
    static final Logger log = Logger.getLogger("BohaWSEndpoint");
    
}
