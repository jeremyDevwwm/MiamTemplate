package com.projet.titre.cecile.TitreDev.Entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idUser;
    private String titre;
    private String ingredients;
    private String contenu;

}
