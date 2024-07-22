package com.incidentRoutes.Mr.Incident_routes.service;

import com.incidentRoutes.Mr.Incident_routes.model.Me;
import com.incidentRoutes.Mr.Incident_routes.repository.MeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeService {
    @Autowired
    private MeRepository repository;

    public List<Me> findAll() {
        return repository.findAll();
    }

    public Me save(Me me) {
        return repository.save(me);
    }

    public Me findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
