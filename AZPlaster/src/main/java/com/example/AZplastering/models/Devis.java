package com.example.AZplastering.models;

import javax.persistence.*;

@Entity
@Table(name = "devis")
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nomprenom")
    private String nomprenom;

    @Column(name = "email")
    private String email;

    @Column(name = "sujet")
    private String sujet;

    @Column(name = "description")
    private String description;
    public Devis() {

    }

    public Devis(String sujet, String description,String email,String nomprenom) {
        this.sujet = sujet;
        this.description = description;
        this.email = email;
        this.nomprenom = nomprenom;
    }

    public long getId() {
        return id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getemail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getNomprenom() {
        return nomprenom;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    @Override
    public String toString() {
        return "Devis [id=" + id + ", sujet=" + sujet + ", desc=" + description + ", email=" + email +", nomprenom=" + nomprenom+ "]";
    }



}