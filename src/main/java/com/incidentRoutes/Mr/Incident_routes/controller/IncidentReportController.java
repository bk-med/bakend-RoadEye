package com.incidentRoutes.Mr.Incident_routes.controller;

import com.incidentRoutes.Mr.Incident_routes.model.IncidentReport;
import com.incidentRoutes.Mr.Incident_routes.service.IncidentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class IncidentReportController {

    @Autowired
    private IncidentReportService service;

    @PostMapping("/create")
    public ResponseEntity<IncidentReport> submitReport(@RequestBody IncidentReport report) {
        try {
            IncidentReport savedReport = service.saveReport(report);
            return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentReport> getReportById(@PathVariable Long id) {
        IncidentReport report = service.getReportById(id);
        if (report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/l")
    public ResponseEntity<List<IncidentReport>> getAllReports() {
        try {
            List<IncidentReport> reports = service.getAllReports();
            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidentReport> updateReport(@PathVariable Long id, @RequestBody IncidentReport report) {
        try {
            IncidentReport updatedReport = service.updateReport(id, report);
            if (updatedReport != null) {
                return new ResponseEntity<>(updatedReport, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReport(@PathVariable Long id) {
        try {
            service.deleteReport(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
