package pl.deska.ksb2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.deska.ksb2.service.EmaiLServiceImpl;

@Aspect
@Service
public class EmailAspect {

    private EmaiLServiceImpl emaiLService;

    @Autowired
    public EmailAspect(EmaiLServiceImpl emaiLService) {
        this.emaiLService = emaiLService;
    }

    @After("@annotation(SendEmail)")
    private void sendEmailWhenFilmIsAdded(){
        emaiLService.sendSimpleMessage("recipent", "subject", "text");
    }
}
