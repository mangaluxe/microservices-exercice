package org.example.commande.repository;

import org.example.commande.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findByUtilisateurId(int utilisateurId); // Récupérer les commandes par utilisateur

}