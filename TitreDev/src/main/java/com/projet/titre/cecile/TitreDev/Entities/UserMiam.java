package com.projet.titre.cecile.TitreDev.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*

 */
@Data
@Entity
@Table
@NoArgsConstructor
public class UserMiam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;

}
