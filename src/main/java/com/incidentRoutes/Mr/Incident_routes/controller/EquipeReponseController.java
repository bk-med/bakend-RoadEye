package com.incidentRoutes.Mr.Incident_routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.incidentRoutes.Mr.Incident_routes.model.EquipeReponse;
import com.incidentRoutes.Mr.Incident_routes.service.EquipeReponseService;

import java.util.List;

@RestController
@RequestMapping("/api/equipeReponses")
public class EquipeReponseController {
    @Autowired
    private EquipeReponseService equipeReponseService;

    @GetMapping
    public List<EquipeReponse> getAllEquipeReponses() {
        return equipeReponseService.getAllEquipeReponses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeReponse> getEquipeReponseById(@PathVariable Long id) {
        return equipeReponseService.getEquipeReponseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EquipeReponse createEquipeReponse(@RequestBody EquipeReponse equipeReponse) {
        return equipeReponseService.createEquipeReponse(equipeReponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeReponse> updateEquipeReponse(@PathVariable Long id, @RequestBody EquipeReponse equipeReponseDetails) {
        return ResponseEntity.ok(equipeReponseService.updateEquipeReponse(id, equipeReponseDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipeReponse(@PathVariable Long id) {
        equipeReponseService.deleteEquipeReponse(id);
        return ResponseEntity.noContent().build();
    }
}
