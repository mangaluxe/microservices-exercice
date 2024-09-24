package org.example.utilisateur.controller;

import org.example.utilisateur.dto.UtilisateurDtoReceive;
import org.example.utilisateur.entity.Utilisateur;
import org.example.utilisateur.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/utilisateur") // URL par défaut : http://localhost:8081/api/utilisateur/
public class UtilisateurController {

    // ========== Propriétés ==========

    @Autowired
    private UtilisateurService utilisateurService;


    // ========== Constructeur ==========

    // ========== Méthodes ==========

    // ----- Read -----

    @GetMapping // URL : http://localhost:8081/api/utilisateur
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @GetMapping("/{id}") // URL : http://localhost:8081/api/utilisateur/1
    public ResponseEntity<Utilisateur> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(utilisateurService.getById(id));
    }

    // ----- Create -----

    @PostMapping
    public ResponseEntity<Utilisateur> create(@RequestBody UtilisateurDtoReceive utilisateurDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurService.create(utilisateurDtoReceive));
    }

    // ----- Update -----

    @PutMapping("/{id}/update")
    public ResponseEntity<Utilisateur> update(@PathVariable int id, @RequestBody UtilisateurDtoReceive utilisateur) {
        return ResponseEntity.ok(utilisateurService.update(utilisateur, id));
    }

    // ----- Delete -----

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        utilisateurService.delete(id);
        return ResponseEntity.ok("Utilisateur supprimé");
    }

}
