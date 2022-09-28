package io.github.kassymbekoff.clients.notification;

import io.github.kassymbekoff.clients.notification.models.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping(value = "api/v1/notifications")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
