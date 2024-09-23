package org.example.utilisateur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    // ========== Propriétés ==========

    // ========== Constructeur ==========

    public HomeController() {
    }


    // ========== Méthodes ==========

    // ----- Read -----

    /**
     * Page d'Accueil
     */
    @GetMapping("/") // URL : http://localhost:8081/
    public String home() {
        return "index"; // Renvoie le nom de la vue "index" pour la page d'accueil
    }

}
