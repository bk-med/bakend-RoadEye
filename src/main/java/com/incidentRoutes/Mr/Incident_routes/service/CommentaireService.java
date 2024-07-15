package com.incidentRoutes.Mr.Incident_routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incidentRoutes.Mr.Incident_routes.model.Commentaire;
import com.incidentRoutes.Mr.Incident_routes.repository.CommentaireRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {
    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    public Optional<Commentaire> getCommentaireById(Long id) {
        return commentaireRepository.findById(id);
    }

    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Commentaire updateCommentaire(Long id, Commentaire commentaireDetails) {
        Commentaire commentaire = commentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commentaire not found"));
        commentaire.setMessage(commentaireDetails.getMessage());
        commentaire.setDateHeure(commentaireDetails.getDateHeure());
        commentaire.setUtilisateurId(commentaireDetails.getUtilisateurId());
        commentaire.setIncidentId(commentaireDetails.getIncidentId());
        return commentaireRepository.save(commentaire);
    }

    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}
