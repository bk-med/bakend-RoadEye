package com.incidentRoutes.Mr.Incident_routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.incidentRoutes.Mr.Incident_routes.model.EquipeReponse;

@Repository
public interface EquipeReponseRepository extends JpaRepository<EquipeReponse, Long> {
}
