/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexionBD;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jairi
 */
public interface IConexionBD {
    
    EntityManagerFactory useConnectionMySQL();
    
}
