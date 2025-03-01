package com.colak.springtutorial.service.userregistration.listener;

import com.colak.springtutorial.service.userregistration.User;
import com.colak.springtutorial.service.userregistration.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventListener {

    @EventListener(condition = "#event.type.equals('Register')")
    @Order(1)
    public void sendEmail(UserEvent event) {
        User user = event.user();
        log.info("Thread: {} . Send Email to: {}", Thread.currentThread().getName(), user.email());
    }

    @EventListener(condition = "#event.user.userName == 'admin'")
    @Order(2)
    public void pointsGiving(UserEvent event) {
        User user = event.user();
        log.info("Thread: {} . Giving 1000 points to: {}", Thread.currentThread().getName(), user.userName());
    }
}
