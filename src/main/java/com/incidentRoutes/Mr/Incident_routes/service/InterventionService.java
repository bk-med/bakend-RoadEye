package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.Intervention;
import com.incidentRoutes.Mr.Incident_routes.repository.InterventionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InterventionService {
    @Autowired
    private InterventionRepository interventionRepository;

    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    public Optional<Intervention> getInterventionById(Long id) {
        return interventionRepository.findById(id);
    }

    public Intervention createIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    public Intervention updateIntervention(Long id, Intervention interventionDetails) {
        Intervention intervention = interventionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intervention not found"));
        intervention.setIncidentId(interventionDetails.getIncidentId());
        intervention.setEquipeId(interventionDetails.getEquipeId());
        intervention.setDateHeure(interventionDetails.getDateHeure());
        intervention.setStatus(interventionDetails.getStatus());
        return interventionRepository.save(intervention);
    }

    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }
}
