package modele;

import metier.Client;
import metier.CompteCourant;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Classe ClientDAO.
 * Classe d'accès aux données de la table client.
 * Implémentation des méthodes du CRUD pour la table client dans la db.
 * Implémente l'interface IDao.
 * @author B. Chataing.
 * created on 30/12/2020.
 * modified on 30/12/2020.
 * @see metier.Client
 */

public class ClientDao implements IDao<Client> {
    private EntityManager em;
    private List<Client> clients = null;

    /**
     * Constructeur.
     * Etablit la connexion à la base de données.
     * Initialise la liste clients avec tous les clients de la table.
     */
    public ClientDao() {
        em = Dal.getEm();
        read("from Client");
        Dal.close();
    }

    /**
     * Insère un client dans la table.
     * @param client : le client à ajouter.
     */
    @Override
    public void create(Client client) {
        em = Dal.getEm();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(client);
        transaction.commit();
        Dal.close();
    }

    @Override
    public void create(CompteCourant courant) {
        em = Dal.getEm();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(courant);
        transaction.commit();
        Dal.close();
    }

    /**
     * Selectionne tous les clients, les ajoute dans la collection.
     * @param req : la requete (select * from client).
     */
    @Override
    public void read(String req) {
        TypedQuery<Client> typedQuery = (TypedQuery<Client>) em.createQuery(req);
        clients = typedQuery.getResultList();
    }

    /**
     * Mise à jour d'un client
     * @param client : le client à mettre à jour
     */
    @Override
    public void update(Client client) {
        em = Dal.getEm();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(client);
        transaction.commit();
        Dal.close();

    }

    /**
     * Suppression d'un client
     * @param client : le client à supprimer
     */
    @Override
    public void delete(Client client) {
        em = Dal.getEm();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.contains(client) ? client : em.merge(client));
        transaction.commit();
        Dal.close();
    }

    /**
     * @return la collection de clients.
     */
    public List<Client> findAll() {
        return clients;
    }

    /**
     * Trouve un client dans la liste.
     * @param index indice du client dans la collection.
     * @return le client ayant l'indice index dans la collection.
     */
    public Client findByIndex(int index) {
        return clients.get(index);
    }

    /**
     * Trouve un client par son id.
     * @param id indice du client dans la table.
     * @return le client ayant l'id id.
     */
    public Client findById(String id) {
        em = Dal.getEm();
        Client client = em.find(Client.class,id);
        em.close();
        return client;
    }
}
