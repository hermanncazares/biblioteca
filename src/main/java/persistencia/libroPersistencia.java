package persistencia;

import dominio.Libro;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class libroPersistencia {

    private EntityManager entityManager;

    public libroPersistencia() {
        entityManager = Persistence.createEntityManagerFactory("").createEntityManager();
    }

    public void crearLibro(Libro libro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Libro leerLibro(long id) {
        return entityManager.find(Libro.class, id);
    }

    public List<Libro> leerTodos() {
        return entityManager.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }

    public void actualizarLibro(Libro libro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminarLibro(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Libro libro = entityManager.find(Libro.class, id);
            if (libro != null) {
                entityManager.remove(libro);
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
