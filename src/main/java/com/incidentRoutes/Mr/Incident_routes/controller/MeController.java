package com.incidentRoutes.Mr.Incident_routes.controller;

import com.incidentRoutes.Mr.Incident_routes.model.Me;
import com.incidentRoutes.Mr.Incident_routes.service.MeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/me")
public class MeController {
    @Autowired
    private MeService service;

    @GetMapping
    public List<Me> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Me getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Me create(@RequestBody Me me) {
        return service.save(me);
    }

    @PutMapping("/{id}")
    public Me update(@PathVariable Long id, @RequestBody Me me) {
        Me existingMe = service.findById(id);
        if (existingMe != null) {
            me.setId(id);
            return service.save(me);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
