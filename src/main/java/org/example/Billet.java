package org.example;

public class Billet {
    private int numeroPlace;
    private Client client;
    private Evenement evenement;
    private TypePlace place;

    public Billet(int numeroPlace, Client client, Evenement evenement, TypePlace place){
        this.numeroPlace = numeroPlace;
        this.client = client;
        this.evenement = evenement;
        this.place = place;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public TypePlace getPlace() {
        return place;
    }

    public void setPlace(TypePlace place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Billet{" +
                "client=" + client +
                ", numeroPlace=" + numeroPlace +
                ", evenement=" + evenement +
                ", place=" + place +
                '}';
    }
}
