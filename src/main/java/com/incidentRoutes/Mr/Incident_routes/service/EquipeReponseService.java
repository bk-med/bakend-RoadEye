package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.EquipeReponse;
import com.incidentRoutes.Mr.Incident_routes.repository.EquipeReponseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeReponseService {
    @Autowired
    private EquipeReponseRepository equipeReponseRepository;

    public List<EquipeReponse> getAllEquipeReponses() {
        return equipeReponseRepository.findAll();
    }

    public Optional<EquipeReponse> getEquipeReponseById(Long id) {
        return equipeReponseRepository.findById(id);
    }

    public EquipeReponse createEquipeReponse(EquipeReponse equipeReponse) {
        return equipeReponseRepository.save(equipeReponse);
    }

    public EquipeReponse updateEquipeReponse(Long id, EquipeReponse equipeReponseDetails) {
        EquipeReponse equipeReponse = equipeReponseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EquipeReponse not found"));
        equipeReponse.setNom(equipeReponseDetails.getNom());
        equipeReponse.setSpecialite(equipeReponseDetails.getSpecialite());
        return equipeReponseRepository.save(equipeReponse);
    }

    public void deleteEquipeReponse(Long id) {
        equipeReponseRepository.deleteById(id);
    }
}
