/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aluno
 */
public class Principal{

    public static void main(String[] args) {
        ServerSocket servidor;
        int idUnico = 0;

        try {
            //iniciando o servidor Socket
            servidor = new ServerSocket(12345);
            System.out.println("Servidor da KANTINE foi inicializado. Aguardando clientes...");

            if (Conector.getConnection() != null) {
                System.out.println("Conectado com sucesso no banco!");
            }

            // esse looping possibilitará que vários clientes se conectem
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente conectou: " + cliente);
                idUnico++;
                System.out.println("Iniciando uma thread para o cliente: " + idUnico);

                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);
                trataCliente.start();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
