package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.TypeIncident;
import com.incidentRoutes.Mr.Incident_routes.repository.TypeIncidentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeIncidentService {
    @Autowired
    private TypeIncidentRepository typeIncidentRepository;

    public List<TypeIncident> getAllTypeIncidents() {
        return typeIncidentRepository.findAll();
    }

    public Optional<TypeIncident> getTypeIncidentById(Long id) {
        return typeIncidentRepository.findById(id);
    }

    public TypeIncident createTypeIncident(TypeIncident typeIncident) {
        return typeIncidentRepository.save(typeIncident);
    }

    public TypeIncident updateTypeIncident(Long id, TypeIncident typeIncidentDetails) {
        TypeIncident typeIncident = typeIncidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeIncident not found"));
        typeIncident.setType(typeIncidentDetails.getType());
        return typeIncidentRepository.save(typeIncident);
    }

    public void deleteTypeIncident(Long id) {
        typeIncidentRepository.deleteById(id);
    }
}
