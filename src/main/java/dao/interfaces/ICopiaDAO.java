
package dao.interfaces;

import dominio.Copia;
import java.util.List;

/**
 *
 * @author Jairi
 */
public interface ICopiaDAO {
    
    public Copia crearCopia(Copia copia);
    
    public Copia leerCopia(Copia copia);
    
    public Copia editarCopia(Copia copia);
    
    public void eliminarCopia(Copia copia);
    
    public List<Copia> leerTodoCopia();
    
}
