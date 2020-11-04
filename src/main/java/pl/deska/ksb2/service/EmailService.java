package pl.deska.ksb2.service;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


public class EmailService {

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        setMailAccountInfo(mailSender);
        setMailProperties(mailSender);
        return mailSender;
    }

    private void setMailAccountInfo(JavaMailSenderImpl mailSender) {
        mailSender.setDefaultEncoding("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("email");
        mailSender.setPassword("password");
    }

    private void setMailProperties(JavaMailSenderImpl mailSender) {
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }
}
