package org.example;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private int age;
    private String telephone;
    private List<Billet> billets;

    public Client (String nom, String prenom, String adresse, int age, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.telephone = telephone;
        this.billets = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void ajouterBillet(Billet billet){
        billets.add(billet);
    }

    public void supprimerBillet(Billet billet){
        billets.remove(billet);
    }

    @Override
    public String toString() {
        return "Client{" +
                "adresse='" + adresse + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", billets=" + billets +
                '}';
    }
}
