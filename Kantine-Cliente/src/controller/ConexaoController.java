/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class ConexaoController {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    // usuario que fez login
    private Usuario usuario;
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }
    
        // aqui iremos implementar vários métodos para se comunicar com o servidor
    public Usuario efetuarLogin(Usuario usr){
        try {
            // enviando comando
            out.writeObject("EfetuarLogin");
            // recebendo "MandaAíMano"
            String msg = (String) in.readObject();
            // enviado usuario que veio da tela de login
            out.writeObject(usr);
            // retornando o usuário que o servidor buscou no Banco
            return (Usuario) in.readObject();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
