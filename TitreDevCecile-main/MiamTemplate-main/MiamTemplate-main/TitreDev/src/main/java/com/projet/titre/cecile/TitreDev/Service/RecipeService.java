package com.projet.titre.cecile.TitreDev.Service;

import com.projet.titre.cecile.TitreDev.Entities.Recipe;
import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository repository;

    @Autowired
    UserService currentUser;

    public Recipe saveRecipe(Recipe recipe){
        Recipe recette = new Recipe();
        UserMiam User = currentUser.getUserInfos();


        recette.setIdUser(User.getId());
        recette.setTitre(recipe.getTitre());
        recette.setIngredients(recipe.getIngredients());
        recette.setContenu(recipe.getContenu());
        return repository.save(recette);
    }

    public List<Recipe> findAllRecipes(){
        UserMiam User = currentUser.getUserInfos();
        return repository.findAllUserRecipe(User.getId());
    }


    @Transactional
    public void updateRecipe (long idRecipe, Recipe recette){
        Recipe temp = repository.findById(idRecipe).orElse(null);
        UserMiam User = currentUser.getUserInfos();
        temp.setIdUser(User.getId());
        temp.setTitre(recette.getTitre());
        temp.setIngredients(recette.getIngredients());
        temp.setContenu(recette.getContenu());

        repository.updateRecipe(idRecipe, temp.getTitre(), temp.getIngredients(), temp.getContenu());

    }

    public void deleteRecipeById(long idRecipe){
        repository.deleteById(idRecipe);
    }

    public Recipe findRecipeById(long id){
        return repository.findById(id).orElse(null);
    }
}
