package org.example.commande.dto;

import lombok.Data;


@Data
public class CommandeDtoReceive {

    private String produit;

    private int utilisateurId; // Lien vers l'utilisateur

}
