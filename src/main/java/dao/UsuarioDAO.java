/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IUsuario;
import objetosnegocio.Usuario;

/**
 *
 * @author fabri
 */
public class UsuarioDAO implements IUsuario {

    @Override
    public boolean autenticarUsuario(Usuario usuario) {
        return true;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {

        return true;
    }

    @Override
    public boolean editarUsuario(Usuario usuario) {
        return true;
    }

}
