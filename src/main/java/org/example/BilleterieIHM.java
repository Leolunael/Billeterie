package org.example;

import org.example.Adresse;
import org.example.Billet;
import org.example.Client;
import org.example.Evenement;
import org.example.Lieu;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class BilleterieIHM {
    private Client client;
    private Evenement evenement;
    private Lieu lieu;
    private Scanner scanner;

    public BilleterieIHM() {
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Billetterie ouverte");

        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choix) {
                    case 1: gererClients(); break;
                    case 2: gererEvenements(); break;
                    case 3: gererLieux(); break;
                    case 4: reserverBillet(); break;
                    case 0:
                        System.out.println("Merci, à bientôt!");
                        return;
                    default:
                        System.out.println("Choix invalide!");
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }

    private void afficherMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gérer les clients");
        System.out.println("2. Gérer les événements");
        System.out.println("3. Gérer les lieux");
        System.out.println("4. Réserver un billet");
        System.out.println("0. Quitter");
        System.out.print("Votre choix: ");
    }

    private void gererClients() {
        System.out.println("\n--- Gestion des Clients ---");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Afficher tous les clients");
        System.out.println("3. Modifier un client");
        System.out.println("4. Supprimer un client");
        System.out.print("Votre choix: ");

        int choix = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choix) {
                case 1: ajouterClient(); break;
                case 2: afficherClients(); break;
                case 3: modifierClient(); break;
                case 4: supprimerClient(); break;
                default: System.out.println("Choix invalide!");
            }
        } catch (NotFoundException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private void ajouterClient() {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Rue: ");
        String rue = scanner.nextLine();
        System.out.print("Ville: ");
        String ville = scanner.nextLine();
        System.out.print("Âge: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Numéro de téléphone: ");
        String telephone = scanner.nextLine();

        Adresse adresse = new Adresse(rue, ville);
        Client client = new Client(nom, prenom, adresse, age, telephone);
        gestion.ajouterClient(client);

        System.out.println("Client ajouté avec succès!");
    }

    private void afficherClients() {
        List<Client> clients = gestion.getClients();
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return;
        }

        System.out.println("\n--- Liste des Clients ---");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i + ". " + clients.get(i));
        }
    }

    private void modifierClient() throws NotFoundException {
        afficherClients();
        System.out.print("Index du client à modifier: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        Client client = gestion.getClient(index);
        System.out.println("Client actuel: " + client);

        // Ici, vous pouvez demander les nouvelles informations
        System.out.println("Modification effectuée!");
    }

    private void supprimerClient() throws NotFoundException {
        afficherClients();
        System.out.print("Index du client à supprimer: ");
        int index = scanner.nextInt();

        gestion.supprimerClient(index);
        System.out.println("Client supprimé!");
    }

    private void gererEvenements() {
        // Implémentation similaire pour les événements
        System.out.println("Gestion des événements - À implémenter");
    }

    private void gererLieux() {
        // Implémentation similaire pour les lieux
        System.out.println("Gestion des lieux - À implémenter");
    }

    private void reserverBillet() {
        try {
            afficherClients();
            System.out.print("Index du client: ");
            int indexClient = scanner.nextInt();

            // Afficher les événements disponibles
            System.out.print("Index de l'événement: ");
            int indexEvenement = scanner.nextInt();

            System.out.print("Numéro de place: ");
            int numeroPlace = scanner.nextInt();

            System.out.println("Types de place: 1=STANDARD, 2=GOLD, 3=VIP");
            System.out.print("Type de place: ");
            int typeChoix = scanner.nextInt();

            TypePlace typePlace = TypePlace.values()[typeChoix - 1];

            Billet billet = gestion.reserverBillet(indexClient, indexEvenement, numeroPlace, typePlace);
            System.out.println("Billet réservé: " + billet);

        } catch (NotFoundException e) {
            System.out.println("Erreur: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur lors de la réservation: " + e.getMessage());
        }
    }

    private void afficherStatistiques() {
        System.out.println("\n--- Statistiques ---");
        System.out.println("Nombre de clients: " + gestion.getClients().size());
        System.out.println("Nombre d'événements: " + gestion.getEvenements().size());
        System.out.println("Nombre de lieux: " + gestion.getLieux().size());
    }
}
}
