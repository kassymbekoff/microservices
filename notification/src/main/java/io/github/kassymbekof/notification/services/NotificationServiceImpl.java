package io.github.kassymbekof.notification.services;

import io.github.kassymbekof.notification.models.Notification;
import io.github.kassymbekof.notification.repositories.NotificationRepository;
import io.github.kassymbekoff.clients.notification.models.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public void save(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                                .message(notificationRequest.getMessage())
                                .sender(notificationRequest.getToCustomerEmail())
                                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                                .toCustomerId(notificationRequest.getToCustomerId())
                                .sentAt(LocalDateTime.now())
                                .build();
        notificationRepository.save(notification);
    }
}
