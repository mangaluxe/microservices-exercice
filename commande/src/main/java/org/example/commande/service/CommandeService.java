package org.example.commande.service;

import org.example.commande.dto.CommandeDtoReceive;
import org.example.commande.dto.CommandeDtoSend;
import org.example.commande.dto.UtilisateurDto;
import org.example.commande.repository.CommandeRepository;
import org.example.commande.util.RestClient;
import org.example.commande.entity.Commande;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommandeService {

    // ========== Propriétés ==========

    private final CommandeRepository commandeRepository;


    // ========== Constructeur ==========

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    // ========== Méthodes ==========

    // ----- Read -----

    public List<CommandeDtoSend> findAll() {
        return commandesToCommandeDtoSends((List<Commande>) commandeRepository.findAll());
    }

//    public List<Commande> findAll() {
//        return (List<Commande>) commandeRepository.findAll();
//    }

    public Commande findById(int id) {
        return commandeRepository.findById(id).orElseThrow();
    }

    public CommandeDtoSend getById(int id) {
        return commandeToCommandeDtoSend(findById(id));
    }

    // ----- Create -----

    public CommandeDtoSend create(CommandeDtoReceive re) {
        RestClient<UtilisateurDto> utilisateurRestClient = new RestClient<>("http://localhost:8080/api/utilisateur/" + re.getUserId());

        UtilisateurDto utilisateurDto = utilisateurRestClient.getRequest(UtilisateurDto.class);

        if (utilisateurDto != null) {
            Commande commande = Commande.builder()
                    .product(re.getProduct())
                    .userId((re.getUserId()))
                    .build();

            return commandeToCommandeDtoSend(commandeRepository.save(commande));

        }

        throw new RuntimeException("Utilisateur inexistant");
    }


    // ----- Update -----

    public CommandeDtoSend update(CommandeDtoReceive re, int id) {
        RestClient<UtilisateurDto> utilisateurRestClient = new RestClient<>("http://localhost:8080/api/utilisateur/" + re.getUserId());

        UtilisateurDto utilisateurDto = utilisateurRestClient.getRequest(UtilisateurDto.class);

        if (utilisateurDto != null) {
            Commande commande = findById(id);
            commande.setProduct(re.getProduct());
            commande.setUserId(utilisateurDto.getId());

            return commandeToCommandeDtoSend(commandeRepository.save(commande));
        }

        throw new RuntimeException("Utilisateur inexistant");
    }


    // ----- Delete -----

    public void delete(int id) {
        commandeRepository.delete(findById(id));
    }


    // ----- -----

    private CommandeDtoSend commandeToCommandeDtoSend(Commande commande) {
        RestClient<UtilisateurDto> utilisateurRestClient = new RestClient<>("http://localhost:8080/api/utilisateur/" + commande.getUserId());

        UtilisateurDto utilisateurDto = utilisateurRestClient.getRequest(UtilisateurDto.class);

        return  CommandeDtoSend.builder()
                .orderId(commande.getOrderId())
                .product(commande.getProduct())
                .build();
    }

    private  List<CommandeDtoSend> commandesToCommandeDtoSends(List<Commande> commandes) {
        return commandes.stream().map(this::commandeToCommandeDtoSend).toList();
    }


}
