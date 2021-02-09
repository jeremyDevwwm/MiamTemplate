package com.projet.titre.cecile.TitreDev.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*

 */
@Data
@Entity
@Table(name="UserMiam")
@NoArgsConstructor
public class UserMiam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
