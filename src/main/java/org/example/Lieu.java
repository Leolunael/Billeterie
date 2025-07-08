package org.example;

public class Lieu extends Adresse{

    private int capacite;

    public Lieu(String rue, String ville, int capacite){
        super(rue, ville);
        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public void adresse() {
        super.adresse();
        System.out.println("Le lieu est à cette adresse");
    }

    @Override
    public String toString() {
        return super.toString()
               + ", capacite=" + capacite +
                '}';
    }
}
