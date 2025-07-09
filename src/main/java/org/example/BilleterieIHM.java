package org.example;

import org.example.Billeterie;
import org.example.Adresse;
import org.example.Billet;
import org.example.Client;
import org.example.Evenement;
import org.example.Lieu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BilleterieIHM {
    private Billeterie billeterie;
    private Scanner scanner;

    public BilleterieIHM() {
        this.billeterie = new Billeterie();
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Billetterie ouverte");

        while (true) {
            System.out.println(Menu());
            String entry = scanner.nextLine();

            switch (entry) {
                case "1"-> creationClients();
                case "2"-> afficherClients();
                case "3"-> creationEvent();
                case "4"-> afficherEvents();
                case "5"-> gererLieux();
                case "6"-> reserverBillet();
                default -> {
                    return;
                }
            }
        }
    }

    private String Menu() {
        return """
            1/ ajouter un client
            2/ afficher les clients
            3/ ajouter un évènement
            4/ afficher les évènements
            4/ Gérer les lieux
            5/ Réserver votre billet
                """;
    }

    private void creationClients() {
        System.out.println("Création du Client");
        System.out.println("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Adresse Postale : ");
        String adressePostale = scanner.nextLine();
        System.out.print("Age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Numéro de téléphone: ");
        String telephone = scanner.nextLine();

        Client client = new Client(nom, prenom, adressePostale, age, telephone);
        billeterie.ajouterClient(client);

        System.out.println("Client ajouté avec succès!");
    }

    private void afficherClients() {
        System.out.println("Affichage des clients : ");
        List<Client> clients = billeterie.getClients();
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i + ": " + clients.get(i));
        }
    }

    private void creationEvent() {
        System.out.println("Création de l'évènement");
        System.out.println("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Lieu : ");
        String lieu = scanner.nextLine();
        System.out.print("Date : ");
        System.out.print("Date (format: yyyy-MM-dd) : ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.print("Heure (format: HH:mm) : ");
        String heureStr = scanner.nextLine();
        LocalTime heure = LocalTime.parse(heureStr, DateTimeFormatter.ofPattern("HH:mm"));
        System.out.print("nombre de Place: ");
        int nbPlace = scanner.nextInt();
        scanner.nextLine();

        Evenement evenement = new Evenement(nom, Lieu, date, heure, nbPlace);
        billeterie.ajouterEvenement(evenement);

        System.out.println("Evènement ajouté avec succès!");
    }

    private void afficherEvents() {
        System.out.println("Affichage des évènements : ");
        List<Evenement> evenements = billeterie.getEvenements();
        for (int i = 0; i < evenements.size(); i++) {
            System.out.println(i + ": " + evenements.get(i));
        }
    }

    private void gererLieux() {
        System.out.println("Gestion des lieux");
    }

    private void reserverBillet() {


        try {
            afficherClients();
            System.out.print("Numéro de client: ");
            int nClient = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numéro de l'événement: ");
            int nEvent = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numéro de place: ");
            int numeroPlace = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Types de place: 1=STANDARD, 2=GOLD, 3=VIP");
            System.out.print("Type de place: ");
            int typeEntry = scanner.nextInt();
            scanner.nextLine();

            TypePlace typePlace = TypePlace.values()[typeEntry - 1];

            Billet billet = billeterie.reserverBillet(nClient, nEvent, numeroPlace, typePlace);
            System.out.println("Billet réservé: " + billet);

        } catch (NotFoundException e) {
            System.out.println("Erreur: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur lors de la réservation: " + e.getMessage());
        }
    }

}
