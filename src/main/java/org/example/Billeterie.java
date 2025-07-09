package org.example;

import org.example.BilleterieIHM;
import org.example.Adresse;
import org.example.Billet;
import org.example.Client;
import org.example.Evenement;
import org.example.Lieu;
import org.example.TypePlace;

import java.util.ArrayList;
import java.util.List;

public class Billeterie {
        private List<Client> clients;
        private List<Evenement> evenements;
        private List<Lieu> lieux;

        public Billeterie() {
            this.clients = new ArrayList<>();
            this.evenements = new ArrayList<>();
            this.lieux = new ArrayList<>();
        }

        public void ajouterClient(Client client) {
            clients.add(client);
        }

        public Client getClient(int nClient) throws NotFoundException {
            if (nClient < 0 || nClient >= clients.size()) {
                throw new NotFoundException("Client non trouvé: " + nClient);
            }
            return clients.get(nClient);
        }

        public List<Client> getClients() {
            return clients;
        }

        public void ajouterEvenement(Evenement evenement) {
            evenements.add(evenement);
        }

        public Evenement getEvenement(int nEvent) throws NotFoundException {
            if (nEvent < 0 || nEvent >= evenements.size()) {
                throw new NotFoundException("Evenement non trouvé: " + nEvent);
            }
            return evenements.get(nEvent);
        }

        public List<Evenement> getEvenements() {
            return evenements;
        }

        public void ajouterLieu(Lieu lieu) {
            lieux.add(lieu);
        }

        public Lieu getLieu(int nLieu) throws NotFoundException {
            if (nLieu < 0 || nLieu >= lieux.size()) {
                throw new NotFoundException("Lieu non trouvé: " + nLieu);
            }
            return lieux.get(nLieu);
        }

        public List<Lieu> getLieu() {
            return lieux;
        }

        public Billet reserverBillet(int nClient, int nEvent, int numeroPlace, TypePlace place)
            throws NotFoundException {
            Client client = getClient(nClient);
            Evenement evenement = getEvenement(nEvent);

            Billet billet = new Billet(numeroPlace, client, evenement, place);
            client.ajouterBillet(billet);
            evenement.ajouterBillet(billet);

            return billet;
        }
}




