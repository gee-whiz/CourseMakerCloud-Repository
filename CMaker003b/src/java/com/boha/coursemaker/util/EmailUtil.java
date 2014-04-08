/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.dto.platform.ResponseDTO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.mail.MessagingException;

/**
 *
 * @author aubreyM
 */
public class EmailUtil {

    private static javax.mail.Session mySession;

    public static void sendInternalMail(String subject, String body) {
        log.log(Level.OFF, "ignoring sending InternalMail subject: {0}", subject);
        
    }

    public void sendHelpRequestObject(String helpRequest) throws JMSException {
        log.log(Level.INFO, "Starting JMS send ...");
        try {
            Context ctx = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("myQueueConnectionFactory");
            Queue queue = (Queue) ctx.lookup("jms/instructorQueue");

            javax.jms.Connection connection = connectionFactory.createConnection();
            javax.jms.Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            ObjectMessage message = session.createObjectMessage();
            message.setObject(helpRequest);
            messageProducer.send(message);
            log.log(Level.INFO, "Object Message sent: ");
        } catch (NamingException ex) {
            log.log(Level.SEVERE, "Failed to send JMS Queue message", ex);
        }
    }

    public void sendHelpRequestMessage(String email, String msg) throws JMSException {
        log.log(Level.INFO, "Starting JMS send ...");
        try {
            Context ctx = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("myTopicConnectionFactory");
            Queue queue = (Queue) ctx.lookup("jms/instructorQueue");

            javax.jms.Connection connection = connectionFactory.createConnection();
            javax.jms.Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setText(msg);
            message.setStringProperty("email", email);
            message.setStringProperty("body", msg);
            messageProducer.send(message);
            log.log(Level.INFO, "JMS TextMessage sent: {0}", msg);
        } catch (NamingException ex) {
            log.log(Level.SEVERE, "Failed to send JMS Topic message", ex);
        }
    }
    private static final Logger log = Logger.getLogger("EmailUtil");

    private static javax.mail.Session getCourseMakerMail() throws NamingException {
        Context c = new InitialContext();
        mySession = (javax.mail.Session) c.lookup("mail/coursemaker");
        return mySession;
    }

    public static void sendMail(String email, String subject, String body, BohaMailSessionBean mailBean) throws NamingException, MessagingException {

        mailBean.sendMail(email, subject, body);

    }

    public static void sendServerError(Exception e, BohaMailSessionBean mailBean) {
        StringBuilder sb = new StringBuilder();
        sb.append("Server Error on CourseMaker Server\n\n");
        sb.append(e.getMessage()).append("\n\n");
        try {
            sb.append(e.toString()).append("\n");
        } catch (Exception ex) {
        }
        sb.append(new Date().toString());
        try {
            mailBean.sendMail(ADMIN_EMAIL,
                    "CourseMaker Server Exception",
                    sb.toString());
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, ADMIN_FAIL, ex);
        }
    }

    public static void sendDatabaseError(DataException e, BohaMailSessionBean mailBean) {
        StringBuilder sb = new StringBuilder();
        sb.append("Database Error on CourseMaker Server\n\n");
        sb.append(e.getDescription()).append("\n");
        sb.append(e.getMessage()).append("\n\n");
        try {
            sb.append(e.toString()).append("\n\n");
        } catch (Exception ex) {
        }
        sb.append(new Date().toString());
        try {
            mailBean.sendMail(ADMIN_EMAIL,
                    "CourseMaker Database Exception",
                    sb.toString());
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, ADMIN_FAIL, ex);
        }
    }

    public static void sendNewCompany(ResponseDTO resp, BohaMailSessionBean mailBean) {
        StringBuilder sb = new StringBuilder();
        sb.append("Yebo!\n\n").append("New training orhanization on board!!\n\n\n");
        sb.append(resp.getCompany().getCompanyName()).append("\n");
        sb.append(resp.getAdministrator().getFirstName()).append(" ");
        sb.append(resp.getAdministrator().getLastName()).append("\n");
        sb.append(resp.getAdministrator().getEmail());
        try {
            mailBean.sendMail(ADMIN_EMAIL,
                    "CourseMaker Gets a New Trainining Organization",
                    sb.toString()
                    + new Date().toString());
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, ADMIN_FAIL, ex);
        }
    }
    private static final String ADMIN_FAIL = "Failed to send mail to admin";
    private static final String ADMIN_EMAIL = "malengadev@gmail.com";

    public static void sendAdminMessage(String message, BohaMailSessionBean mailBean) {

        try {
            BohaMailSessionBean.sendMail(ADMIN_EMAIL,
                    "CourseMaker Administrator Message",
                    message
                    + new Date().toString());
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, ADMIN_FAIL, ex);
        }
    }

    public static void sendUnkownRequest(HttpServletRequest req, BohaMailSessionBean mailBean) {
        StringBuilder sb = new StringBuilder();
        sb.append("An attempt was made to the server that is unknown. Please check logs\n\n");
        sb.append("Request IP Address: ").append(req.getRemoteAddr());
        try {
            mailBean.sendMail(ADMIN_EMAIL,
                    "CourseMaker Unknown Request",
                    sb.toString()
                    + new Date().toString());
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, ADMIN_FAIL, ex);
        }
    }

   
    public static final int TRAINEE = 1, AUTHOR = 2, INSTRUCTOR = 3, ADMINISTRATOR = 4,
            EXECUTIVE = 5;
    
}
