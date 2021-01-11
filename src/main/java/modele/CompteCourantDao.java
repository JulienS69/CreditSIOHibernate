package modele;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;

import javax.persistence.*;
import java.util.List;

/**
 * Classe CompteCourantDAO.
 * Classe d'accès aux données de la table comptecourant.
 * Transforme ces données en objets métiers.
 * Implémentation des méthodes du CRUD pour la table comptecourant dans la db.
 * Implémente l'interface IDao.
 * @author B. Chataing.
 * created on 30/12/2020.
 * modified on 31/12/2020.
 * @see metier.CompteCourant
 */



public class CompteCourantDao implements IDao<CompteCourant>{
    private EntityManager em;
    private List<CompteCourant> courants = null;
    /**
     * Constructeur.
     * Connecte l'application à la db.
     * Selectionne tous les comptes courants de la table, les stocke dans la collection.
     */
    public CompteCourantDao() {
        em = Dal.getEm();
        read("from CompteCourant");
        Dal.close();
    }


    @Override
    public void create(CompteCourant courant) {
        em = Dal.getEm();
        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery("insertCompte");
        procedureQuery.registerStoredProcedureParameter("numeroCompte", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("typeCompte", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("decouvertAutorise", Double.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("txInteret", Double.class, ParameterMode.IN);
        procedureQuery.setParameter("numeroCompte", Integer.parseInt(courant.getNumero()));
        procedureQuery.setParameter("typeCompte", 2);
        procedureQuery.setParameter("decouvertAutorise", 0.0);
        procedureQuery.setParameter("txInteret", 0.0);
        procedureQuery.execute();
        Dal.close();
    }


    /**
     * Selectionne tous les comptes courants, les ajoute dans la collection.
     * Coupe ensuite la connexion à la base.
     * @param req : la requete (select *).
     */
    @Override
    public void read(String req) {
        TypedQuery<CompteCourant> typedQuery = (TypedQuery<CompteCourant>) em.createQuery(req);
        courants = typedQuery.getResultList();
    }

    @Override
    public void update(CompteCourant courant) {

    }

    @Override
    public void delete(CompteCourant courant) {

    }

    /**
     * @return la collection de comptes courants.
     */
    public List<CompteCourant> findAll() {
        return courants;
    }
}
