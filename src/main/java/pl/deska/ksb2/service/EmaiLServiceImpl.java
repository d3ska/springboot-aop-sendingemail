package pl.deska.ksb2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmaiLServiceImpl {

    private JavaMailSender emailSender;

    @Autowired
    public EmaiLServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(
            String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("email");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
}
