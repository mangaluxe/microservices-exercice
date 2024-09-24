package org.example.commande.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CommandeDtoSend {

    private int id;

    private String produit;

    private int utilisateurId; // Lien vers l'utilisateur

}
