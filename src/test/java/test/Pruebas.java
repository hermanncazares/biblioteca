/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import dao.LibroDAO;
import dao.UsuarioDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fabri
 */
public class Pruebas {

    UsuarioDAO usuarioDao;
    LibroDAO libroDao;

    public Pruebas() {
        usuarioDao = new UsuarioDAO();
        libroDao = new LibroDAO();
    }

    @Test
    public void autenticarUsuario() {
        assertEquals("", usuarioDao.autenticarUsuario("hola"));
    }

    @Test
    public void registrarUsuario() {
        assertTrue(usuarioDao.registrarUsuario("hola"));
    }

    @Test
    public void editarUsuario() {
        assertTrue(usuarioDao.editarUsuario("hola"));
    }

    @Test
    public void agregarLibro() {
        assertTrue(libroDao.agregarLibro("libro"));
    }

    @Test
    public void editarLibro() {
        assertTrue(libroDao.editarLibro("libro"));
    }

    @Test
    public void eliminarLibro() {
        assertTrue(libroDao.eliminarLibro("libro"));
    }

    @Test
    public void registrarPrestamo() {

    }

    @Test
    public void devolverLibro() {
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
