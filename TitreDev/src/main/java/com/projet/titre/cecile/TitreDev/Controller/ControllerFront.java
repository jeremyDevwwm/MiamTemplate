package com.projet.titre.cecile.TitreDev.Controller;

import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Service.RecipeService;
import com.projet.titre.cecile.TitreDev.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerFront {

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipe;


    @GetMapping("/Accueil.html")
    public void Hello(Model model){
        model.addAttribute("UserMiam", userService.getLoggedUsername());
        System.out.println("salut");

    }


    @GetMapping("/Recettes.html")
    public void Recettes(Model model){

        model.addAttribute("Titre", "Ma Recette");

    }

    @GetMapping("/Profil.html")
    public void Profil(Model model){
        UserMiam LoggedUser = userService.getUserInfos();

            model.addAttribute("Nom", LoggedUser.getNom());
            model.addAttribute("Prenom", LoggedUser.getPrenom());
            model.addAttribute("Login", LoggedUser.getLogin());

    }

    @GetMapping("/UpdatePassword.html")
    public void updatePass(){
        UserMiam LoggedUser = userService.getUserInfos();

    }
}
