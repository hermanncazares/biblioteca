/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;


/**
 *
 * @author fabri
 */
public interface IUsuario {
    public boolean autenticarUsuario(String usuario);
    public boolean registrarUsuario(String usuario);
    public boolean editarUsuario(String usuario);
}
