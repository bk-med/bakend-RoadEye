package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.Notification;
import com.incidentRoutes.Mr.Incident_routes.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setType(notificationDetails.getType());
        notification.setMessage(notificationDetails.getMessage());
        notification.setDateHeure(notificationDetails.getDateHeure());
        notification.setUtilisateurId(notificationDetails.getUtilisateurId());
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
