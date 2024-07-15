package com.incidentRoutes.Mr.Incident_routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.incidentRoutes.Mr.Incident_routes.model.Commentaire;
import com.incidentRoutes.Mr.Incident_routes.service.CommentaireService;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        return commentaireService.getCommentaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireService.createCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaireDetails) {
        return ResponseEntity.ok(commentaireService.updateCommentaire(id, commentaireDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.noContent().build();
    }
}
