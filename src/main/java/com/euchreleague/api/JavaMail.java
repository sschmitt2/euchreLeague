package com.euchreleague.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

public class JavaMail {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    public JavaMail(Properties properties) {
        this.properties = properties;
    }

    public void sendEmail(String recipients, String subject, String body) {

        String userName = properties.getProperty("mail.smtp.user");
        String password = properties.getProperty("password");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipients)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            logger.info("Email successfully sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
