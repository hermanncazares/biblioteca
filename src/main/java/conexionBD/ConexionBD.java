
package conexionBD;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jairi
 */
public class ConexionBD implements IConexionBD {

    private static EntityManagerFactory factory;

    @Override
    public EntityManagerFactory useConnectionMySQL() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("persistenciaBiblioteca");
        }
        return factory;
    }

    public static void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }

}
