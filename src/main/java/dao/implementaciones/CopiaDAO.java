
package dao.implementaciones;

import conexionBD.IConexionBD;
import dao.interfaces.ICopiaDAO;
import dominio.Copia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jairi
 */
public class CopiaDAO implements ICopiaDAO{
    
    IConexionBD iConexionBD;

    public CopiaDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }

    @Override
    public Copia crearCopia(Copia copia) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(copia);
            bd.getTransaction().commit();
            return copia;
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
    public Copia leerCopia(Copia copia) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Copia copiaEncontrada = bd.find(Copia.class, copia.getId());
            bd.getTransaction().commit();
            return copiaEncontrada;
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
    public Copia editarCopia(Copia copia) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Copia copiaEditada = bd.find(Copia.class, copia.getId());
            copiaEditada.setCopiaEstado(copia.getCopiaEstado());
            bd.merge(copiaEditada);
            bd.getTransaction().commit();
            return copiaEditada;
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
    public void eliminarCopia(Copia copia) {
        EntityManagerFactory em = iConexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                copia = bd.find(Copia.class, copia.getId());
            } catch (EntityNotFoundException enfe) {
            }
            if (copia != null) {
                bd.remove(copia);
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
    public List<Copia> leerTodoCopia() {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Copia> criteria = builder.createQuery(Copia.class);
            Root<Copia> root = criteria.from(Copia.class);
            TypedQuery<Copia> query = bd.createQuery(criteria);
            List<Copia> pagos = query.getResultList();
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
