package com.projet.titre.cecile.TitreDev.Entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRecipe;
    private long idUser;
    private String titre;
    private String ingredients;
    private String contenu;

    public long getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(long idRecipe) {
        this.idRecipe = idRecipe;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
