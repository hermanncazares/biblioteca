package dao.interfaces;

import dominio.Prestamo;
import java.util.List;

public interface IPrestamoDAO {

    //public boolean registrarPrestamo(String libro, String usuario);
    
    public Prestamo crearPrestamo(Prestamo prestamo);
    
    public Prestamo leerPrestamo(Prestamo prestamo);
    
    public Prestamo editarPrestamo(Prestamo prestamo);
    
    public void eliminarPrestamo(Prestamo prestamo);
    
    public List<Prestamo> leerTodoPrestamo();
    

}
