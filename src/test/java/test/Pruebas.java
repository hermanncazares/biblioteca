/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import dao.DevolucionDAO;
import dao.LibroDAO;
import dao.PrestamoDAO;
import dao.UsuarioDAO;
import objetosnegocio.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fabri
 */
public class Pruebas {

    UsuarioDAO usuarioDao;
    LibroDAO libroDao;
    PrestamoDAO prestamoDao;
    DevolucionDAO devolucionDao;
    Usuario usuario;
    Libro libro;

    public Pruebas() {
        usuarioDao = new UsuarioDAO();
        libroDao = new LibroDAO();
        prestamoDao = new PrestamoDAO();
        devolucionDao = new DevolucionDAO();
        libro = new Libro();
        usuario = new Usuario();
    }

    @Test
    public void autenticarUsuario() {
        assertTrue( usuarioDao.autenticarUsuario(usuario));
    }

    @Test
    public void registrarUsuario() {
        assertTrue(usuarioDao.registrarUsuario(usuario));
    }

    @Test
    public void editarUsuario() {
        assertTrue(usuarioDao.editarUsuario(usuario));
    }

    @Test
    public void agregarLibro() {
        assertTrue(libroDao.agregarLibro(libro));
    }

    @Test
    public void editarLibro() {
        assertTrue(libroDao.editarLibro(libro));
    }

    @Test
    public void eliminarLibro() {
        assertTrue(libroDao.eliminarLibro(libro));
    }

    @Test
    public void registrarPrestamo() {
        assertTrue(prestamoDao.registrarPrestamo("libro", "usuario"));

        libro.setDisponibilidad("prestado");
        String disponibilidad = libro.getDisponibilidad();
        assertEquals("prestado", disponibilidad);
    }

    @Test
    public void devolverLibro() {
        assertTrue(devolucionDao.devolverLibro("libro"));

        libro.setDisponibilidad("disponble");
        String disponibilidad = libro.getDisponibilidad();
        assertEquals("disponble", disponibilidad);
    }

    @Test
    public void buscarLibroPorTitulo() {
        assertEquals(libroDao.buscarLibroPorTitulo("titulo"), "libro");

    }

    @Test
    public void buscarLibroPorAutor() {
        assertEquals(libroDao.buscarLibroPorAutor("autor"), "libro");

    }

    @Test
    public void buscarLibroPorIdentificador() {
        assertEquals(libroDao.buscarLibroPorIdentificador(1), "libro");

    }

}
