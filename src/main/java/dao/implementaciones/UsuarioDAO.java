
package dao.implementaciones;

import conexionBD.IConexionBD;
import dominio.Usuario;
import dao.interfaces.IUsuarioDAO;
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
 * @author fabri
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    IConexionBD iConexionBD;
    
    public UsuarioDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(usuario);
            bd.getTransaction().commit();
            return usuario;
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
    public Usuario leerUsuario(Usuario usuario) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Usuario usuarioEncontrado = bd.find(Usuario.class, usuario.getId());
            bd.getTransaction().commit();
            return usuarioEncontrado;
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
    public Usuario editarUusario(Usuario usuario) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Usuario usuarioEditado = bd.find(Usuario.class, usuario.getId());
            
            usuarioEditado.setId_personal(usuario.getId_personal());
            usuarioEditado.setNombre(usuario.getNombre());
            usuarioEditado.setPassword(usuario.getPassword());
            usuarioEditado.setUsuarioTipo(usuario.getUsuarioTipo());
            bd.merge(usuarioEditado);
            bd.getTransaction().commit();
            return usuarioEditado;
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
    public void eliminarUsuario(Usuario usuario) {
        EntityManagerFactory em = iConexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                usuario = bd.find(Usuario.class, usuario.getId());
            } catch (EntityNotFoundException enfe) {
            }
            if (usuario != null) {
                bd.remove(usuario);
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
    public List<Usuario> leerTodoUsuario() {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            Root<Usuario> root = criteria.from(Usuario.class);
            TypedQuery<Usuario> query = bd.createQuery(criteria);
            List<Usuario> pagos = query.getResultList();
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
