
package dao.implementaciones;

import conexionBD.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import objetosnegocio.Libro;
import dao.interfaces.ILibroDAO;
import dominio.Libro;

/**
 *
 * @author fabri
 */
public class LibroDAO implements ILibroDAO {
    
    IConexionBD iConexionBD;
    
    public LibroDAO(IConexionBD iConexionBD){
        this.iConexionBD = iConexionBD;
    }

    @Override
    public Libro agregarLibro(Libro libro) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(libro);
            bd.getTransaction().commit();
            return libro;
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
    public Libro leerLibro(Libro libro) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Libro libroEncontrado = bd.find(Libro.class, libro.getId());
            bd.getTransaction().commit();
            return libroEncontrado;
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
    public Libro editarLibro(Libro libro) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Libro libroActualizado = bd.find(Libro.class, libro.getId());
            libroActualizado.setIsbn(libro.getIsbn());
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setAutor(libro.getAutor());
            bd.merge(libroActualizado);
            bd.getTransaction().commit();
            return libroActualizado;
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
    public void eliminarLibro(Libro libro) {
        EntityManagerFactory em = iConexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                libro = bd.find(Libro.class, libro.getId());
            } catch (EntityNotFoundException enfe) {
            }
            if (libro != null) {
                bd.remove(libro);
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
    public List<Libro> leerTodoLibro() {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Libro> criteria = builder.createQuery(Libro.class);
            Root<Libro> root = criteria.from(Libro.class);
            TypedQuery<Libro> query = bd.createQuery(criteria);
            List<Libro> pagos = query.getResultList();
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
