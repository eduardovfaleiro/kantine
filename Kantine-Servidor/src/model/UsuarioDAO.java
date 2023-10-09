/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.xdevapi.Client;
import factory.Conector;
import java.sql.*;
import modelDominio.Administrador;
import modelDominio.Cliente;
import modelDominio.Usuario;

/**
 *
 * @author Igor Mateus
 */
// classe responsável por pegar os dados do banco e transformar
// em objetos e vice-versa
// DAO -> Data Access Object
// SELECTs, UPDATEs, INSERTs, DELETEs,
public class UsuarioDAO {
    
    private Connection con;

    public UsuarioDAO() {
        con = Conector.getConnection();
    }
    
    // implementar um método que irá consultar no banco 
    // para verificar se o usuário existe
    public Usuario efetuarLogin(Usuario usr){
        PreparedStatement stmt = null;
        Usuario usrSel = null;
        
        try {
            String sql = "select * from usuario where login = ? and senha = ?";
            stmt = con.prepareStatement(sql);
            // substituir as ?s
            stmt.setString(1, usr.getEmail());
            stmt.setString(2, usr.getSenha());
            
            // excuta o script e armazena o resultado na variavel
            // res
            ResultSet res = stmt.executeQuery();
            if (res.next()){
                // se existe um registro. Então, tenho que pegar
                // os dados do res e criar um objeto de Usuario
                if (res.getInt("tipo") == 1) {
                    // é um usuário administrador
                    usrSel = new Administrador(res.getInt("codusuario"),
                                               res.getString("nomeusuario"),
                                               res.getString("login"),
                                               res.getString("email"),
                                               res.getString("senha"));
                }else{
                    // é um usuário COmum
                    usrSel = new Cliente(res.getInt("codusuario"),
                                               res.getString("nomeusuario"),
                                               res.getString("login"),
                                               res.getString("email"),
                                               res.getString("senha"));
                }
            }
            System.out.println(usrSel);
            // fechando conexoes com o banco
            res.close(); // fechando o resultadop
            stmt.close();// fechando o statment
            con.close();
            // devolvendo o usuário
            return usrSel;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Usuario efetuarCadastro (Usuario usr, int tipoUsuario){
        PreparedStatement stmt = null;
        try {
            String sql = "insert into clientes (nome, email, telefone, senha, tipo) values (?, ?, ?, ?, ?) ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usr.getNome());
            stmt.setString(2, usr.getEmail());
            stmt.setString(3, usr.getTelefone());
            stmt.setString(4, usr.getSenha());
            stmt.setInt(5, tipoUsuario);
            
            stmt.execute();
            con.commit();
            
            return usr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}

