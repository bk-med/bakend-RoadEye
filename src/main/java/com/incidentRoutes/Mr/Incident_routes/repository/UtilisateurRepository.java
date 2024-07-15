package com.incidentRoutes.Mr.Incident_routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidentRoutes.Mr.Incident_routes.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
}
