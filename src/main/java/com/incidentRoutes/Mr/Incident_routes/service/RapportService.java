package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.Rapport;
import com.incidentRoutes.Mr.Incident_routes.repository.RapportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {
    @Autowired
    private RapportRepository rapportRepository;

    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    public Optional<Rapport> getRapportById(Long id) {
        return rapportRepository.findById(id);
    }

    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    public Rapport updateRapport(Long id, Rapport rapportDetails) {
        Rapport rapport = rapportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rapport not found"));
        rapport.setType(rapportDetails.getType());
        rapport.setContenu(rapportDetails.getContenu());
        rapport.setDateHeure(rapportDetails.getDateHeure());
        rapport.setAdminId(rapportDetails.getAdminId());
        return rapportRepository.save(rapport);
    }

    public void deleteRapport(Long id) {
        rapportRepository.deleteById(id);
    }
}
