package org.example.commande.repository;

import org.example.commande.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {


}
