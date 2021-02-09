package com.projet.titre.cecile.TitreDev.Controller;

import com.projet.titre.cecile.TitreDev.Entities.Recipe;
import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Service.RecipeService;
import com.projet.titre.cecile.TitreDev.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControllerFront {

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipe;


    @GetMapping("/Accueil.html")
    public void Hello(Model model){
        model.addAttribute("UserMiam", userService.getLoggedUsername());


    }


    @GetMapping("/Recettes.html")
    public void Recettes(Model model){
        List<Recipe> recettes =  recipe.findAllRecipes();
        model.addAttribute("recettes" , recettes);
    }

    @GetMapping("/Profil.html")
    public void Profil(Model model){
        UserMiam LoggedUser = userService.getUserInfos();

            model.addAttribute("Nom", LoggedUser.getNom());
            model.addAttribute("Prenom", LoggedUser.getPrenom());
            model.addAttribute("Login", LoggedUser.getLogin());

    }

    @GetMapping("/UpdatePassword.html{id}")
    public void updatePass(@PathVariable String id, Model model){
        UserMiam usr = new UserMiam();
        model.addAttribute("userMiam", userService.getUserInfos());

    }

    @GetMapping("/AjouterRecette.html")
    public void displayPage(Model model){
        Recipe recipe =  new Recipe();
        model.addAttribute("recipe", recipe);
    }

    @GetMapping("/Consulter.html{id}")
    public void displaySingle(@PathVariable String id, Model model){
        model.addAttribute("recette", recipe.findRecipeById(Long.parseLong(id)));
    }

    @GetMapping("/UpdateRecette.html{id}")
    public void updateRecette(@PathVariable String id, Model model){
        model.addAttribute("recette", recipe.findRecipeById(Long.parseLong(id)));
    }

    @GetMapping("/deleteConfirm.html{id}")
    public void confirmDelete(@PathVariable String id, Model model){
        model.addAttribute("recette", recipe.findRecipeById(Long.parseLong(id)));
    }

}
