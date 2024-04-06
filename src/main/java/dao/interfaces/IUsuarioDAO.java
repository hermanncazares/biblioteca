
package dao.interfaces;

import java.util.List;
import dominio.Usuario;


/**
 *
 * @author fabri
 */
public interface IUsuarioDAO {
//    public boolean autenticarUsuario(Usuario usuario);
//    public boolean registrarUsuario(Usuario usuario);
//    public boolean editarUsuario(Usuario usuario);
    
    public Usuario crearUsuario(Usuario usuario);
    
    public Usuario leerUsuario(Usuario usuario);
    
    public Usuario editarUusario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public List<Usuario> leerTodoUsuario();
}
