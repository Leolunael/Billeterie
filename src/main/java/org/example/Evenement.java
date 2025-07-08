package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Evenement {
    private String nom;
    private Lieu lieu;
    private LocalDate date;
    private LocalTime heure;
    private int nbPlace;
    private List<Billet> billets;


    public Evenement(String nom, Lieu lieu, LocalDate date, LocalTime heure, int nbPlace){
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.heure = heure;
        this.nbPlace = nbPlace;
        this.billets = new ArrayList<>();
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void ajouterBillet(Billet billet) {
        billets.add(billet);
    }
    public void supprimerBillet(Billet billet) {
        billets.remove(billet);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "billets=" + billets +
                ", nom='" + nom + '\'' +
                ", lieu=" + lieu +
                ", date=" + date +
                ", heure=" + heure +
                ", nbPlace=" + nbPlace +
                '}';
    }
}
