package com.incidentRoutes.Mr.Incident_routes.service;

import com.incidentRoutes.Mr.Incident_routes.model.IncidentReport;
import com.incidentRoutes.Mr.Incident_routes.repository.IncidentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentReportService {

    @Autowired
    private IncidentReportRepository repository;

    public IncidentReport saveReport(IncidentReport report) {
        return repository.save(report);
    }

    public IncidentReport getReportById(Long id) {
        Optional<IncidentReport> report = repository.findById(id);
        return report.orElse(null);
    }

    public List<IncidentReport> getAllReports() {
        return repository.findAll();
    }
    public IncidentReport updateReport(Long id, IncidentReport report) {
        if (repository.existsById(id)) {
            report.setId(id);
            return repository.save(report);
        }
        return null;
    }

    public void deleteReport(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
