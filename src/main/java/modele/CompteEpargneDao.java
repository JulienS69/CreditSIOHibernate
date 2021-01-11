package modele;

import metier.Client;
import metier.CompteCourant;
import metier.CompteEpargne;

import javax.persistence.*;
import java.util.List;

/**
 * Classe CompteCourantDAO.
 * Classe d'accès aux données de la table comptecourant.
 * Transforme ces données en objets métiers.
 * Implémentation des méthodes du CRUD pour la table comptecourant dans la db.
 * Implémente l'interface IDao.
 * @author J. SEUX.
 * created on 06/01/2020.
 * modified on 06/01/2020.
 * @see metier.CompteEpargne
 */

public class CompteEpargneDao implements IDao<CompteEpargne>{

    private EntityManager em;
    private List<CompteEpargne> epargnes = null;
    /**
     * Constructeur.
     * Connecte l'application à la db.
     * Selectionne tous les comptes courants de la table, les stocke dans la collection.
     */
    public CompteEpargneDao() {
        em = Dal.getEm();
        read("from CompteEpargne");
        Dal.close();
    }


    @Override
    public void create(CompteEpargne epargne) {
        StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery("insertCompte");
        procedureQuery.registerStoredProcedureParameter("numeroCompte", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("typeCompte", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("decouvertAutorise", Double.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("txInteret", Double.class, ParameterMode.IN);
        procedureQuery.setParameter("numeroCompte", Integer.parseInt(epargne.getNumero()));
        procedureQuery.setParameter("typeCompte", 2);
        procedureQuery.setParameter("decouvertAutorise", 0.0);
        procedureQuery.setParameter("txInteret", epargne.getTauxInteret());
        procedureQuery.execute();
    }

    @Override
    public void create(CompteCourant courant) {
    }


    /**
     * Selectionne tous les comptes courants, les ajoute dans la collection.
     * Coupe ensuite la connexion à la base.
     * @param req : la requete (select *).
     */
    @Override
    public void read(String req) {
        TypedQuery<CompteEpargne> typedQuery = (TypedQuery<CompteEpargne>) em.createQuery(req);
        epargnes = typedQuery.getResultList();
    }

    @Override
    public void update(CompteEpargne epargne) {

    }

    @Override
    public void delete(CompteEpargne epargne) {

    }

    /**
     * @return la collection de comptes courants.
     */
    public List<CompteEpargne> findAll() {
        return epargnes;
    }
}
