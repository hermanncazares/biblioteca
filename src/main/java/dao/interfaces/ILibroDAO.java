
package dao.interfaces;

import java.util.List;
import dominio.Libro;


/**
 *
 * @author fabri
 */
public interface ILibroDAO {

    public Libro agregarLibro(Libro libro);
    
    public Libro leerLibro(Libro libro);

    public Libro editarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
    
    public List<Libro> leerTodoLibro();

}
