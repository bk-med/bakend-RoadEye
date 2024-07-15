package com.incidentRoutes.Mr.Incident_routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.incidentRoutes.Mr.Incident_routes.model.PhotoIncident;
import com.incidentRoutes.Mr.Incident_routes.service.PhotoIncidentService;

import java.util.List;

@RestController
@RequestMapping("/api/photo_incidents")
public class PhotoIncidentController {
    @Autowired
    private PhotoIncidentService photoIncidentService;

    @GetMapping
    public List<PhotoIncident> getAllPhotoIncidents() {
        return photoIncidentService.getAllPhotoIncidents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoIncident> getPhotoIncidentById(@PathVariable Long id) {
        return photoIncidentService.getPhotoIncidentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhotoIncident createPhotoIncident(@RequestBody PhotoIncident photoIncident) {
        return photoIncidentService.createPhotoIncident(photoIncident);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoIncident> updatePhotoIncident(@PathVariable Long id, @RequestBody PhotoIncident photoIncidentDetails) {
        return ResponseEntity.ok(photoIncidentService.updatePhotoIncident(id, photoIncidentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotoIncident(@PathVariable Long id) {
        photoIncidentService.deletePhotoIncident(id);
        return ResponseEntity.noContent().build();
    }
}
