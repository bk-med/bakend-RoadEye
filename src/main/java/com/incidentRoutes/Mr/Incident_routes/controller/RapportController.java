package com.incidentRoutes.Mr.Incident_routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.incidentRoutes.Mr.Incident_routes.model.Rapport;
import com.incidentRoutes.Mr.Incident_routes.service.RapportService;

import java.util.List;

@RestController
@RequestMapping("/api/rapports")
public class RapportController {
    @Autowired
    private RapportService rapportService;

    @GetMapping
    public List<Rapport> getAllRapports() {
        return rapportService.getAllRapports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable Long id) {
        return rapportService.getRapportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rapport createRapport(@RequestBody Rapport rapport) {
        return rapportService.createRapport(rapport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable Long id, @RequestBody Rapport rapportDetails) {
        return ResponseEntity.ok(rapportService.updateRapport(id, rapportDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Long id) {
        rapportService.deleteRapport(id);
        return ResponseEntity.noContent().build();
    }
}
