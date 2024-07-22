package com.incidentRoutes.Mr.Incident_routes.repository;

import com.incidentRoutes.Mr.Incident_routes.model.IncidentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentReportRepository extends JpaRepository<IncidentReport, Long> {
}

