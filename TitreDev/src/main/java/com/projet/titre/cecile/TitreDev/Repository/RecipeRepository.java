package com.projet.titre.cecile.TitreDev.Repository;


import com.projet.titre.cecile.TitreDev.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
