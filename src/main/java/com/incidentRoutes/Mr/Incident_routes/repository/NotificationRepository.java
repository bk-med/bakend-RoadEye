package com.incidentRoutes.Mr.Incident_routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.incidentRoutes.Mr.Incident_routes.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
