package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.util.EmailUtil;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class EmailService {

    private final EmailUtil emailUtil;
    private final JavaMailSender mailSender;

    @Async
    public void sendSimpleMessage(String to, String fullName) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Verification");
        message.setText(emailUtil.getEmailMessage(fullName));

        mailSender.send(message);
    }
}