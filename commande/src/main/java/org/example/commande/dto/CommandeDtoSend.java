package org.example.commande.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CommandeDtoSend {

    private int orderId;

    private String product;

    private UtilisateurDto utilisateur;

}
