package org.example.utilisateur.service;

import org.example.utilisateur.dto.UtilisateurDtoReceive;
import org.example.utilisateur.entity.Utilisateur;
import org.example.utilisateur.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UtilisateurService {

    // ========== Propriétés ==========

    @Autowired // Avec ça, pas besoin de constructeur
    private UtilisateurRepository utilisateurRepository;


    // ========== Constructeur ==========

    // ========== Méthodes ==========

    // ----- Read -----

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getById(int id) {
        return utilisateurRepository.findById(id).orElseThrow();
    }

    // ----- Create -----

    public Utilisateur create(UtilisateurDtoReceive u) {
        Utilisateur u1 = Utilisateur.builder()
                .name(u.getName())
                .email(u.getEmail())
                .build();

        return utilisateurRepository.save(u1);
    }

    // ----- Update -----


    // ----- Delete -----





}
