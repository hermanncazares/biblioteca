package persistencia;

import dominio.Prestamo;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class prestamoPersistencia {

    private EntityManager entityManager;

    public prestamoPersistencia() {
        entityManager = Persistence.createEntityManagerFactory("").createEntityManager();
    }

    public void crearPrestamo(Prestamo prestamo) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(prestamo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Prestamo leerPrestamo(Long id) {
        return entityManager.find(Prestamo.class, id);
    }

    public List<Prestamo> leerTodos() {
        return entityManager.createQuery("SELECT p FROM Prestamo p", Prestamo.class).getResultList();
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(prestamo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminarPrestamo(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Prestamo prestamo = entityManager.find(Prestamo.class, id);
            if (prestamo != null) {
                entityManager.remove(prestamo);
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