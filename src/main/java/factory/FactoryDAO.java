
package factory;

import conexionBD.ConexionBD;
import conexionBD.IConexionBD;
import dao.implementaciones.CopiaDAO;
import dao.implementaciones.LibroDAO;
import dao.implementaciones.PrestamoDAO;
import dao.implementaciones.UsuarioDAO;
import dao.interfaces.ICopiaDAO;
import dao.interfaces.ILibroDAO;
import dao.interfaces.IPrestamoDAO;
import dao.interfaces.IUsuarioDAO;

/**
 *
 * @author Jairi
 */
public class FactoryDAO implements IFactoryDAO{
    
    private IConexionBD iConexionBD;

    public FactoryDAO() {
        this.iConexionBD = new ConexionBD();
    }

    
    
    @Override
    public ILibroDAO crearLibroDAO() {
        return new LibroDAO(iConexionBD);
    }

    @Override
    public ILibroDAO leerLibroDAO() {
        return new LibroDAO(iConexionBD);
    }

    @Override
    public ILibroDAO editarLibroDAO() {
        return new LibroDAO(iConexionBD);
    }

    @Override
    public ILibroDAO eliminarLIbroDAO() {
        return new LibroDAO(iConexionBD);
    }

    @Override
    public ILibroDAO leerTodoLibroDAO() {
        return new LibroDAO(iConexionBD);
    }

    //--------------------------------------------------------------------------
    @Override
    public IUsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO(iConexionBD);
    }

    @Override
    public IUsuarioDAO leerUsuarioDAO() {
        return new UsuarioDAO(iConexionBD);
    }

    @Override
    public IUsuarioDAO editarUsuarioDAO() {
        return new UsuarioDAO(iConexionBD);
    }

    @Override
    public IUsuarioDAO eliminarUsuarioDAO() {
        return new UsuarioDAO(iConexionBD);
    }

    @Override
    public IUsuarioDAO leerTodoUsuarioDAO() {
        return new UsuarioDAO(iConexionBD);
    }

    //--------------------------------------------------------------------------
    @Override
    public IPrestamoDAO crearPrestamoDAO() {
        return new PrestamoDAO(iConexionBD);
    }

    @Override
    public IPrestamoDAO leerPrestamoDAO() {
        return new PrestamoDAO(iConexionBD);
    }

    @Override
    public IPrestamoDAO editarPrestamoDAO() {
        return new PrestamoDAO(iConexionBD);
    }

    @Override
    public IPrestamoDAO eliminarPrestamoDAO() {
        return new PrestamoDAO(iConexionBD);
    }

    @Override
    public IPrestamoDAO leerTodoPrestamoDAO() {
        return new PrestamoDAO(iConexionBD);
    }

    //--------------------------------------------------------------------------
    @Override
    public ICopiaDAO crearCopiaDAO() {
        return new CopiaDAO(iConexionBD);
    }

    @Override
    public ICopiaDAO leerCopiaDAO() {
        return new CopiaDAO(iConexionBD);
    }

    @Override
    public ICopiaDAO editarCopiaDAO() {
        return new CopiaDAO(iConexionBD);
    }

    @Override
    public ICopiaDAO eliminarCopiaDAO() {
        return new CopiaDAO(iConexionBD);
    }

    @Override
    public ICopiaDAO leerTodoCopiaDAO() {
        return new CopiaDAO(iConexionBD);
    }
    
}
