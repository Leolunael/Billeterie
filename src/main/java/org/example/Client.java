package org.example;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adressePostale;
    private int age;
    private String telephone;
    private List<Billet> billets;

    public Client (String nom, String prenom, String adressePostale, int age, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.adressePostale = adressePostale;
        this.age = age;
        this.telephone = telephone;
        this.billets = new ArrayList<>();
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
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

    public List<Billet> getBillet() {
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
                "Adresse postale='" + adressePostale + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", billets=" + billets +
                '}';
    }
}
