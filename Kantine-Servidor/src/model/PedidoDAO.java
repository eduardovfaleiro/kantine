/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Pedido;
import java.util.*;

/**
 *
 * @author aluno
 */
public class PedidoDAO {
    private Connection con;

    public PedidoDAO() {
        con = Conector.getConnection();
    }
    
    public ArrayList<Pedido> getPedidoLista() {
        Statement stmt = null;
        ArrayList<Pedido> lista = new ArrayList<>();

        try {
            String sql = "select * from pedidos";
            //criar o statament
            stmt = con.createStatement();
            //executando o script sql acima e guardando o resultado dentro da variavel res
            ResultSet res = stmt.executeQuery(sql);
            //percorrendo o res co o looping while
            /*
                // UPDATEs e SELECTs
                public Pedido(int codigo, int codProduto, int codCliente, Date dataHora, int status) {
                    this.codigo = codigo;
                    this.codProduto = codProduto;
                    this.codCliente = codCliente;
                    this.dataHora = dataHora;
                    this.status = status;
                }
            */
            while (res.next()) {
                Pedido p = new Pedido(res.getInt("codigo"), res.getInt("codProduto"), res.getInt("codCliente"), res.getDate("dataHora"), res.getInt("status"));
                //adicionar objeto marca na lista
                lista.add(p);
                //imprimindo o objeto marca
                System.out.println(p);
            }
            //fechar as conexões
            res.close();//fecha o resultado
            stmt.close();//fecha o statement
            con.close();//fecha a conexão com o banco
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public boolean inserir(Pedido p) {
        PreparedStatement stmt = null;
        try {
            //para eu ter controle das tranções
            con.setAutoCommit(false);
            String sql = "insert into pedidos (codigo, codProduto, codCliente, dataHora, status) values (?, ?, ?, ?, ?)";
            //preparando o script
            stmt = con.prepareStatement(sql);
            //trocando o ? pelo nome da marca
            stmt.setInt(1, p.getCodigo());
            stmt.setInt(2, p.getCodProduto());
            stmt.setInt(3, p.getCodCliente());
            stmt.setDate(4, (java.sql.Date) p.getDataHora());
            stmt.setInt(5, 0);
            
            //exeutando o scrpit no banco de dados
            stmt.execute();
            //executar/confirmar a transação no bano de dados
            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            //executa sempre esse trecho de codigo
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean excluir(Pedido p) {
        PreparedStatement stmt = null;
        try {
            //para eu ter controle das tranções
            con.setAutoCommit(false);
            String sql = "delete from pedidos where codigo = ?";
            //preparando o script
            stmt = con.prepareStatement(sql);
            //trocando o ? pelo nome da marca
            stmt.setInt(1, p.getCodigo());
            //exeutando o scrpit no banco de dados
            stmt.execute();
            //executar/confirmar a transação no bano de dados
            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            //executa sempre esse trecho de codigo
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean alterar(Pedido p) {
        PreparedStatement stmt = null;
        try {
            //para eu ter controle das tranções
            con.setAutoCommit(false);
            String sql = "update pedidos set codProduto = ?, codCliente = ?, dataHora = ?, status = ? where codigo = ?";
            //preparando o script
            stmt = con.prepareStatement(sql);
            //trocando o ? pelo nome da marca
            stmt.setInt(1, p.getCodProduto());
            stmt.setInt(2, p.getCodCliente());
            stmt.setDate(3, (java.sql.Date) p.getDataHora());
            stmt.setInt(4, p.getStatus());
            
            //exeutando o scrpit no banco de dados
            stmt.execute();
            //executar/confirmar a transação no bano de dados
            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            //executa sempre esse trecho de codigo
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
