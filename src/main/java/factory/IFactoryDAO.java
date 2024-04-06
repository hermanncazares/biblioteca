
package factory;

import dao.interfaces.ICopiaDAO;
import dao.interfaces.ILibroDAO;
import dao.interfaces.IPrestamoDAO;
import dao.interfaces.IUsuarioDAO;

/**
 *
 * @author Jairi
 */
public interface IFactoryDAO {
    
    public ILibroDAO crearLibroDAO();
    public ILibroDAO leerLibroDAO();
    public ILibroDAO editarLibroDAO();
    public ILibroDAO eliminarLIbroDAO();
    public ILibroDAO leerTodoLibroDAO();
    
    public IUsuarioDAO crearUsuarioDAO();
    public IUsuarioDAO leerUsuarioDAO();
    public IUsuarioDAO editarUsuarioDAO();
    public IUsuarioDAO eliminarUsuarioDAO();
    public IUsuarioDAO leerTodoUsuarioDAO();
    
    public IPrestamoDAO crearPrestamoDAO();
    public IPrestamoDAO leerPrestamoDAO();
    public IPrestamoDAO editarPrestamoDAO();
    public IPrestamoDAO eliminarPrestamoDAO();
    public IPrestamoDAO leerTodoPrestamoDAO();
    
    public ICopiaDAO crearCopiaDAO();
    public ICopiaDAO leerCopiaDAO();
    public ICopiaDAO editarCopiaDAO();
    public ICopiaDAO eliminarCopiaDAO();
    public ICopiaDAO leerTodoCopiaDAO();
    
}
