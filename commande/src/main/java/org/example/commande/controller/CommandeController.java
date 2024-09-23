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
    public ResponseEntity<List<CommandeDtoSend>> getAll() {
        return ResponseEntity.ok(commandeService.findAll());

//        List<Commande> commandes = commandeService.findAll(); // Récupération de la liste des livres via le service
//        List<CommandeDtoSend> commandeDtoSends = new ArrayList<>(); // Transformation des entités Book en DTO BookDtoSend
//
//        for (Commande commande : commandes) {
//            commandeDtoSends.add(new CommandeDtoSend(commande.getOrderId(), commande.getProduct(), commande.getUserId()));
//        }
//
//        return ResponseEntity.ok(commandeDtoSends);
    }

    @GetMapping("/{id}") // URL : http://localhost:8081/api/commande/1
    public ResponseEntity<CommandeDtoSend> getById(@PathVariable int id) {
        return ResponseEntity.ok(commandeService.getById(id));
    }

    // ----- Create -----

    @PostMapping
    public ResponseEntity<CommandeDtoSend> create(@RequestBody CommandeDtoReceive commandeDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeService.create(commandeDtoReceive));
    }

    // ----- Update -----

    @PutMapping("/{id}/delete")
    public ResponseEntity<CommandeDtoSend> update(@PathVariable int id, @RequestBody CommandeDtoReceive commandeDtoReceive) {
        return ResponseEntity.ok(commandeService.update(commandeDtoReceive, id));
    }

    // ----- Delete -----

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        commandeService.delete(id);
        return ResponseEntity.ok("Commande supprimé");
    }

}
