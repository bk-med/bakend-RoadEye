package com.incidentRoutes.Mr.Incident_routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.incidentRoutes.Mr.Incident_routes.model.TypeIncident;
import com.incidentRoutes.Mr.Incident_routes.service.TypeIncidentService;

import java.util.List;

@RestController
@RequestMapping("/api/typeIncidents")
public class TypeIncidentController {
    @Autowired
    private TypeIncidentService typeIncidentService;

    @GetMapping
    public List<TypeIncident> getAllTypeIncidents() {
        return typeIncidentService.getAllTypeIncidents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeIncident> getTypeIncidentById(@PathVariable Long id) {
        return typeIncidentService.getTypeIncidentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeIncident createTypeIncident(@RequestBody TypeIncident typeIncident) {
        return typeIncidentService.createTypeIncident(typeIncident);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeIncident> updateTypeIncident(@PathVariable Long id, @RequestBody TypeIncident typeIncidentDetails) {
        return ResponseEntity.ok(typeIncidentService.updateTypeIncident(id, typeIncidentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeIncident(@PathVariable Long id) {
        typeIncidentService.deleteTypeIncident(id);
        return ResponseEntity.noContent().build();
    }
}
