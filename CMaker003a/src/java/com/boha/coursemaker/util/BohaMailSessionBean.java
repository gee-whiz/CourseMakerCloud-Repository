/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

/**
 *
 * @author aubreyM
 */

public class BohaMailSessionBean {

    private Session session;

    public void sendMailx(String email, String subject, String body) throws NamingException, MessagingException {

        MimeMessage message = new MimeMessage(session); 
        message.setSubject(subject);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
        message.setText(body);
        message.setSentDate(new Date());
        Transport.send(message);
        log.log(Level.OFF, "attempted eMail sent to: {0} subject: {1}", new Object[]{email, subject});
    }
    public static void sendInternalMail(String subject, String body) {
        try {
            sendMail(ADMIN_EMAIL, subject, body);
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(BohaMailSessionBean.class.getName()).log(Level.SEVERE, "Failed to send admin mail", ex);
        }
        
    }
    public static void sendMail(String email, String subject, String body) throws NamingException, MessagingException {
        log.log(Level.OFF, "Ignoring the email request: {0}\n{1}", new Object[]{subject, body});
        if (ADMIN_EMAIL != null) return;
        long s = System.currentTimeMillis();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ADMIN_EMAIL, ADMIN_PASSWD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ADMIN_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            long e = System.currentTimeMillis();
            log.log(Level.OFF, "Email sent to  " + " malengadev@gmail.com,  elapsed time: {0} milliseconds", (e-s));
        } catch (MessagingException e) {
            log.log(Level.SEVERE, "Failed to send email", e);
            throw new RuntimeException(e);
        }
    }
    public static final String ADMIN_EMAIL = "malengadev@gmail.com";
    public static final String ADMIN_PASSWD = "kktiger3";
    private static final Logger log = Logger.getLogger("BohaMailSessionBean");
}
