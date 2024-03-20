/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import objetosnegocio.Usuario;


/**
 *
 * @author fabri
 */
public interface IUsuario {
    public boolean autenticarUsuario(Usuario usuario);
    public boolean registrarUsuario(Usuario usuario);
    public boolean editarUsuario(Usuario usuario);
}
