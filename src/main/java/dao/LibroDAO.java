/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.ILibro;
import objetosnegocio.Libro;

/**
 *
 * @author fabri
 */
public class LibroDAO implements ILibro {

    @Override
    public boolean agregarLibro(Libro libro) {
        return true;
    }

    @Override
    public boolean editarLibro(Libro libro) {
        return true;
    }

    @Override
    public boolean eliminarLibro(Libro libro) {
        return true;
    }

    public String buscarLibroPorTitulo(String titulo) {
        return "libro";
    }

    public String buscarLibroPorAutor(String autor) {
        return "libro";
    }

    public String buscarLibroPorIdentificador(int id) {
        return "libro";
    }

}
