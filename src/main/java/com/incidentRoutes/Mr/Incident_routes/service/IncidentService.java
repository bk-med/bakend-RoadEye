package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.Incident;
import com.incidentRoutes.Mr.Incident_routes.repository.IncidentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Incident updateIncident(Long id, Incident incidentDetails) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident not found"));
        incident.setType(incidentDetails.getType());
        incident.setLocation(incidentDetails.getLocation());
        incident.setDescription(incidentDetails.getDescription());
        incident.setStatus(incidentDetails.getStatus());
        incident.setDateHeure(incidentDetails.getDateHeure());
        incident.setUtilisateurId(incidentDetails.getUtilisateurId());
        return incidentRepository.save(incident);
    }

    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}
