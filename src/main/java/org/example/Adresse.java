package org.example;

public class Adresse {

    private String rue;
    private String ville;

    public Adresse(String rue, String ville){
        this.rue = rue;
        this.ville = ville;
    }

    public void adresse(){
        System.out.println("La salle est ici");
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
