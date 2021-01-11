package modele;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dal {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private  static void CreateEm () {
        emf = Persistence.createEntityManagerFactory("creditSIO");
        em = emf.createEntityManager();
    }

    public static EntityManager getEm() {
        CreateEm();
        return em;
    }

    public static void close() {
        em.close();
        emf.close();
    }
}
