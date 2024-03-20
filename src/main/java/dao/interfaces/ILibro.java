/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import objetosnegocio.Libro;


/**
 *
 * @author fabri
 */
public interface ILibro {

    public boolean agregarLibro(Libro libro);

    public boolean editarLibro(Libro libro);

    public boolean eliminarLibro(Libro libro);

}
