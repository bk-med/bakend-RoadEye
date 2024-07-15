package com.incidentRoutes.Mr.Incident_routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.incidentRoutes.Mr.Incident_routes.model.Intervention;
import com.incidentRoutes.Mr.Incident_routes.service.InterventionService;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
    @Autowired
    private InterventionService interventionService;

    @GetMapping
    public List<Intervention> getAllInterventions() {
        return interventionService.getAllInterventions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
        return interventionService.getInterventionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Intervention createIntervention(@RequestBody Intervention intervention) {
        return interventionService.createIntervention(intervention);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention interventionDetails) {
        return ResponseEntity.ok(interventionService.updateIntervention(id, interventionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
        interventionService.deleteIntervention(id);
        return ResponseEntity.noContent().build();
    }
}
