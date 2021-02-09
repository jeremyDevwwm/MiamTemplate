package com.projet.titre.cecile.TitreDev.Repository;


import com.projet.titre.cecile.TitreDev.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT u FROM Recipe u WHERE u.idUser=?1")
    List<Recipe> findAllUserRecipe(long idUser);

    @Modifying
    @Query(value = "UPDATE Recipe r SET r.titre = :titre, r.ingredients = :ingredients, r.contenu = :contenu WHERE r.idRecipe = :id")
    void updateRecipe(@Param("id")long id,
                        @Param("titre")String titre,
                        @Param("ingredients") String ingredients,
                        @Param("contenu") String contenu);
}
