package persistencia;

import dominio.Copia;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class copiaPersistencia {

    private EntityManager entityManager;

    public copiaPersistencia() {
        entityManager = Persistence.createEntityManagerFactory("").createEntityManager();
    }

    public void crearCopia(Copia copia) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(copia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Copia leerCopia(long id) {
        return entityManager.find(Copia.class, id);
    }

    public List<Copia> leerTodas() {
        return entityManager.createQuery("SELECT c FROM Copia c", Copia.class).getResultList();
    }

    public void actualizarCopia(Copia copia) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(copia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminarCopia(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Copia copia = entityManager.find(Copia.class, id);
            if (copia != null) {
                entityManager.remove(copia);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
