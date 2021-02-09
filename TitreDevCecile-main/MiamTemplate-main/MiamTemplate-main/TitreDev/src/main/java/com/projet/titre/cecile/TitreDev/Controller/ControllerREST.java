package com.projet.titre.cecile.TitreDev.Controller;

import com.projet.titre.cecile.TitreDev.Entities.Recipe;
import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Service.RecipeService;
import com.projet.titre.cecile.TitreDev.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ControllerREST {
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipe;

    @PostMapping("/saveUser")
    public UserMiam saveUser(UserMiam user){
        return userService.saveUser(user);
    }

    @RequestMapping(value= "/UpdatePass{id}")
    public void updateUser(@PathVariable String id, UserMiam user){
        userService.updateUser(Long.parseLong(id),user.getMdp());
    }

    @PostMapping("/saveRecipe")
    public Recipe saveRecipe(@ModelAttribute("recipe")  Recipe recette, HttpServletResponse res) throws IOException {
        res.sendRedirect("/Recettes.html");
        return recipe.saveRecipe(recette);
    }

    @RequestMapping(value= "/updateRecipe{idRecipe}")
    public void  updateRecipe(@PathVariable String idRecipe, Recipe recette, HttpServletResponse res) throws IOException{
        res.sendRedirect("/Recettes.html");
        recipe.updateRecipe(Long.parseLong(idRecipe), recette);
    }

    @RequestMapping(value = "/deleteRecipe{id}")
    public void deleteRecipe(@PathVariable String id, HttpServletResponse res) throws IOException{
        res.sendRedirect("/Recettes.html");
        recipe.deleteRecipeById(Long.parseLong(id));
    }

}
