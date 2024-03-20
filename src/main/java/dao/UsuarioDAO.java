/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IUsuario;

/**
 *
 * @author fabri
 */
public class UsuarioDAO implements IUsuario {

    @Override
    public boolean autenticarUsuario(String usuario) {
        return true;
    }

    @Override
    public boolean registrarUsuario(String usuario) {

        return true;
    }

    @Override
    public boolean editarUsuario(String usuario) {
        return true;
    }

}
