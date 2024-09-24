package org.example.commande.controller;

import org.example.commande.dto.CommandeDtoReceive;
import org.example.commande.dto.CommandeDtoSend;
import org.example.commande.entity.Commande;
import org.example.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/commande") // URL par défaut : http://localhost:8080/api/commande/
public class CommandeController {

    // ========== Propriétés ==========

    @Autowired
    private CommandeService commandeService;


    // ========== Constructeur ==========

    // ========== Méthodes ==========

    // ----- Read -----

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(commandeService.getById(id));
    }

    // --- ---

    @GetMapping("/utilisateur/{utilisateurId}") // URL : http://localhost:8080/api/commande/utilisateur/1
    public ResponseEntity<List<Commande>> getCommandesByUtilisateurId(@PathVariable int utilisateurId) {
        List<Commande> commandes = commandeService.getCommandesByUtilisateurId(utilisateurId);
        return ResponseEntity.ok(commandes);
    }

    // ----- Create -----

    @PostMapping
    public ResponseEntity<Commande> create(@RequestBody CommandeDtoReceive commandeDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeService.create(commandeDtoReceive));
    }

    // ----- Update -----

    @PutMapping("/{id}/update")
    public ResponseEntity<Commande> update(@PathVariable int id, @RequestBody CommandeDtoReceive commandeDto) {
        return ResponseEntity.ok(commandeService.update(commandeDto, id));
    }

    // ----- Delete -----

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        commandeService.delete(id);
        return ResponseEntity.ok("Commande supprimée");
    }

}
