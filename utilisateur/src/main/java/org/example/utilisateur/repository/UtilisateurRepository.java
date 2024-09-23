package org.example.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.utilisateur.entity.Utilisateur;


@Repository
// public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> { // Marche aussi


}
