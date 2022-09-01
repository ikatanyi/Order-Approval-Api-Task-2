package com.castille.mail;

import com.castille.config.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailService {

    @Autowired
    private EmailConfiguration emailConfiguration;
    private static final String NOREPLY_ADDRESS = "castille@gmail.com";

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(emailConfiguration.getAgentEmail());
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}


