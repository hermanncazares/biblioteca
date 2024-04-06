package dao.implementaciones;

import conexionBD.IConexionBD;
import dao.interfaces.IPrestamoDAO;
import dominio.Prestamo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PrestamoDAO implements IPrestamoDAO {
    
    IConexionBD iConexionBD;

    public PrestamoDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }

    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(prestamo);
            bd.getTransaction().commit();
            return prestamo;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public Prestamo leerPrestamo(Prestamo prestamo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Prestamo prestamoEncontrado = bd.find(Prestamo.class, prestamo.getId());
            bd.getTransaction().commit();
            return prestamoEncontrado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public Prestamo editarPrestamo(Prestamo prestamo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Prestamo prestamoEditado = bd.find(Prestamo.class, prestamo.getId());
            prestamoEditado.setFechaInicio(prestamo.getFechaInicio());
            prestamoEditado.setFechaFin(prestamo.getFechaFin());
            bd.merge(prestamoEditado);
            bd.getTransaction().commit();
            return prestamoEditado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        EntityManagerFactory em = iConexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                prestamo = bd.find(Prestamo.class, prestamo.getId());
            } catch (EntityNotFoundException enfe) {
            }
            if (prestamo != null) {
                bd.remove(prestamo);
            }
            //comentario = em.merge(comentario);
            bd.getTransaction().commit();
        } finally {
            if (bd != null) {
                bd.close();
            }
        }
    }

    @Override
    public List<Prestamo> leerTodoPrestamo() {
         EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Prestamo> criteria = builder.createQuery(Prestamo.class);
            Root<Prestamo> root = criteria.from(Prestamo.class);
            TypedQuery<Prestamo> query = bd.createQuery(criteria);
            List<Prestamo> pagos = query.getResultList();
            bd.getTransaction().commit();
            return pagos;

        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

}
