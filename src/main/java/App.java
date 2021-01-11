import metier.Client;
import metier.CompteCourant;
import metier.CompteEpargne;
import modele.ClientDao;
import modele.CompteCourantDao;
import modele.CompteEpargneDao;
import org.hibernate.query.Query;

import java.util.List;


public class App {
    public static void main(String argv[]) {

        //Création de l'objet ClientDAO

        ClientDao clientDao = new ClientDao();

        // Voir tous les clients
        System.out.println("Recherche de tous les clients");
        List<Client> clients = clientDao.findAll();
        for (Client client : clients) {
            System.out.println(client);
        }

        //Recherche d'un client par son index dans la collection

        System.out.println("Recherche d'un client par son index dans la collection");
        Client client = clientDao.findByIndex(2);
        System.out.println(client);


        //Recherche d'un client par son id

        System.out.println("Recherche d'un client par son id");
        client = clientDao.findById("CLI04");
        System.out.println(client);


        //Création d'un client

        System.out.println("Insertion d'un client");
        Client clientJade = new Client("CLI06", "Biyamou", "Jade", "13 chemin des Chassagnes", "69600", "Oullins", "0604429810", "jadebiyamou@leschassagnes.net");

        System.out.println("Le client à insérer :");
         /*
        System.out.println(clientJade);
        clientDao.create(clientJade);


        //Modifié un client

        System.out.println("Modification d'un client");
        clientJade.setNom("Biyamou Clemenceau");
        clientDao.update(clientJade);
        System.out.println("Le client modifié :");
        System.out.println(clientJade);


        //Supprimer un client

        System.out.println("Suppression d'un client");
        clientDao.delete(clientJade);
        System.out.println("Liste des clients après suppression :");
        clientDao = new ClientDao();
          */
/*

        // Voir tous les clients

        System.out.println("Recherche de tous les clients");
        clients = clientDao.findAll();
        for (Client cli : clients) {
            System.out.println(cli);
        }

        //Voir tous les Comptes Courants

        CompteCourantDao compteCourantDao = new CompteCourantDao();
        System.out.println("Recherche de tous les comptes courants");
        List<CompteCourant> courants = compteCourantDao.findAll();
        for (CompteCourant courant : courants) {
            System.out.println(courant);
        }

        //Création d'un compte Courant

        CompteCourant jadecourant = new CompteCourant("55580", clientJade, 200, 600.00);
        System.out.println("Insertion d'un compte courant");
        System.out.println("Le compte à insérer :");
        System.out.println(clientJade);
        compteCourantDao.create(jadecourant);

        //Modification d'un compte Courant


        //Voir tous les comptes Epargnes

        CompteEpargneDao compteEpargneDao = new CompteEpargneDao();
        System.out.println("Recherche de tous les comptes epargnes");
        List<CompteEpargne> epargnes = compteEpargneDao.findAll();
        for(CompteEpargne epargne : epargnes) {
            System.out.println(epargne);
        }


        // Création d'un compte Epargne

        CompteEpargne jade = new CompteEpargne("55259", clientJade, 250, 0.30);
        System.out.println("Insertion d'un compte epargne");
        System.out.println("Le compte à insérer :");
        System.out.println(clientJade);
        compteEpargneDao.update(jade);



        CompteCourant courant = new CompteCourant("55280", clientJade, 280, 0.30);
        System.out.println("Insertion d'un compte epargne");
        System.out.println("Le compte à insérer :");
        System.out.println(clientJade);

        CompteCourantDao compteCourantDao = new CompteCourantDao();
        compteCourantDao.create(courant);

 */
    }

}