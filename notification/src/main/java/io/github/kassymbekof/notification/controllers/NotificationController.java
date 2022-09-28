package io.github.kassymbekof.notification.controllers;

import io.github.kassymbekof.notification.services.NotificationService;
import io.github.kassymbekoff.clients.notification.models.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("NotificationController. Get message to: " + notificationRequest.getToCustomerEmail());
        notificationService.save(notificationRequest);
    }
}
