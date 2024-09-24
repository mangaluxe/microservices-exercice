package org.example.commande.service;

import org.example.commande.dto.CommandeDtoReceive;
import org.example.commande.dto.CommandeDtoSend;
import org.example.commande.dto.UtilisateurDto;
import org.example.commande.repository.CommandeRepository;
// import org.example.commande.util.RestClient;
import org.example.commande.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommandeService {

    // ========== Propriétés ==========

    @Autowired
    private CommandeRepository commandeRepository;


    // ========== Constructeur ==========

    // ========== Méthodes ==========

    // ----- Read -----

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getById(int id) {
        return commandeRepository.findById(id).orElseThrow();
    }

    // --- ---

    public List<Commande> getCommandesByUtilisateurId(int utilisateurId) {
        return commandeRepository.findByUtilisateurId(utilisateurId);
    }


    // ----- Create -----

    public Commande create(CommandeDtoReceive c) {
        Commande commande = Commande.builder()
                .utilisateurId(c.getUtilisateurId())
                .produit(c.getProduit())
                .build();
        return commandeRepository.save(commande);
    }


    // ----- Update -----

    public Commande update(CommandeDtoReceive c, int id) {
        Commande commande = getById(id);
        commande.setUtilisateurId(c.getUtilisateurId());
        commande.setProduit(c.getProduit());
        return commandeRepository.save(commande);
    }


    // ----- Delete -----

    public void delete(int id) {
        commandeRepository.delete(getById(id));
    }


    // ----- -----

//    private CommandeDtoSend commandeToCommandeDtoSend(Commande commande) {
//        RestClient<UtilisateurDto> utilisateurRestClient = new RestClient<>("http://localhost:8081/api/utilisateur/" + commande.getUtilisateurId());
//
//        UtilisateurDto utilisateurDto = utilisateurRestClient.getRequest(UtilisateurDto.class);
//
//        return  CommandeDtoSend.builder()
//                .orderId(commande.getOrderId())
//                .product(commande.getProduct())
//                .utilisateur(utilisateurDto) // Pour la liaison
//                .build();
//    }
//
//
//    private  List<CommandeDtoSend> commandesToCommandeDtoSends(List<Commande> commandes) {
//        return commandes.stream().map(this::commandeToCommandeDtoSend).toList();
//    }


}
