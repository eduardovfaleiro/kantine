/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UsuarioDAO;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class TrataClienteController extends Thread  {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int idUnico;
    
    public TrataClienteController(Socket socket, int idUnico){
        this.socket = socket;
        this.idUnico = idUnico;
        
        try {
            this.in =  new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void run(){
        String comando; // comando recebido do cliente
        System.out.println("Esperando comandos do cliente...");
        
        try {
            comando = (String) in.readObject();
            // enquanto o comando NÃO for fim, fica dentro do looping
            while (!comando.equalsIgnoreCase("fim")) {                
                System.out.println("Cliente "+idUnico+" enviou o comando: "+comando);
                if (comando.equalsIgnoreCase("EfetuarLogin")){
                    out.writeObject("MandaAíMano");
                    Usuario usr = (Usuario) in.readObject();
                    System.out.println(usr);
                    // chamar o UsuarioDao e o metodo efetuarLogin
                    UsuarioDAO usrDao = new UsuarioDAO();
                    out.writeObject(usrDao.efetuarLogin(usr));
                }else if (comando.equalsIgnoreCase("EfetuarCadastro")){
                    out.writeObject("MandaAíMano");
                    int tipoUsuario = (int) in.readObject();
                    Usuario usr = (Usuario) in.readObject();
                    System.out.println(usr);
                    // chamar o UsuarioDao e o metodo efetuarLogin
                    UsuarioDAO usrDao = new UsuarioDAO();
                    out.writeObject(usrDao.efetuarCadastro(usr, tipoUsuario));
                }
                comando = (String) in.readObject();
            }
        
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println("Cliente " +idUnico+ "finalizou a conexão.");
        try {
            this.in.close();
            this.out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    
}
