package io.github.kassymbekof.notification.services;


import io.github.kassymbekoff.clients.notification.models.NotificationRequest;

public interface NotificationService {
    void save(NotificationRequest notificationRequest);
}
