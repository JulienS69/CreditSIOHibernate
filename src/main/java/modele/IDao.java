package modele;

import metier.CompteCourant;
import metier.CompteEpargne;

/**
 * Signatures des méthodes CRUD.
 * Implémentée par ClientDao, CompteCourantDao, CompteEpargneDao.
 * @param <T> : type générique, déterminé à la compilation.
 */
public interface IDao<T> {
    /**
     * Create : C du crud.
     * Insère une ligne dans la table.
     */

    void create(T t);

    void create(CompteCourant courant);


    /**
     * Read : R du crud.
     * Selectionne toutes les lignes de la table.
     */
    void read(String req);

    /**
     * Update : modifie une ligne dans la table.
     * U du crud.
     */

    void update(T t);

    /**
     * Delete : supprime une ligne dans la table.
     * D du crud.
     */

    void delete(T t);
}
