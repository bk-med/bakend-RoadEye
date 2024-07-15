package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.PhotoIncident;
import com.incidentRoutes.Mr.Incident_routes.repository.PhotoIncidentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoIncidentService {
    @Autowired
    private PhotoIncidentRepository photoIncidentRepository;

    public List<PhotoIncident> getAllPhotoIncidents() {
        return photoIncidentRepository.findAll();
    }

    public Optional<PhotoIncident> getPhotoIncidentById(Long id) {
        return photoIncidentRepository.findById(id);
    }

    public PhotoIncident createPhotoIncident(PhotoIncident photoIncident) {
        return photoIncidentRepository.save(photoIncident);
    }

    public PhotoIncident updatePhotoIncident(Long id, PhotoIncident photoIncidentDetails) {
        PhotoIncident photoIncident = photoIncidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PhotoIncident not found"));
        photoIncident.setIncidentId(photoIncidentDetails.getIncidentId());
        photoIncident.setPhoto(photoIncidentDetails.getPhoto());
        return photoIncidentRepository.save(photoIncident);
    }

    public void deletePhotoIncident(Long id) {
        photoIncidentRepository.deleteById(id);
    }
}
