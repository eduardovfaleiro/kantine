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
import modelDominio.Produto;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    private Connection con;

    public ProdutoDAO() {
        con = Conector.getConnection();
    }
    
    public ArrayList<Produto> getProdutoLista() {
        Statement stmt = null;
        ArrayList<Produto> lista = new ArrayList<>();

        try {
            String sql = "select * from produto";
            //criar o statament
            stmt = con.createStatement();
            //executando o script sql acima e guardando o resultado dentro da variavel res
            ResultSet res = stmt.executeQuery(sql);
            //percorrendo o res co o looping while
            /*
            // UPDATEs e SELECTs
            public Produto(int codigo, String nome, String descricao, float preco, byte[] imagens, boolean disponivel) {
                this.codigo = codigo;
                this.nome = nome;
                this.descricao = descricao;
                this.preco = preco;
                this.imagens = imagens;
                this.disponivel = disponivel;
            }
            */
            while (res.next()) {
                Produto produto = new Produto(res.getInt("codigo"), res.getString("nome"), res.getString("descricao"), res.getFloat("preco"), (byte[]) res.getBytes("imagem"), res.getBoolean("disponivel"));
                //adicionar objeto marca na lista
                lista.add(produto);
                //imprimindo o objeto marca
                System.out.println(produto);
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
    
    public boolean inserir(Produto produto) {
        PreparedStatement stmt = null;
        try {
            //para eu ter controle das tranções
            con.setAutoCommit(false);
            String sql = "insert into produto (codigo, descricao, preco, imagem, disponivel, nome) values (?, ?, ?, ?, ?, ?)";
            //preparando o script
            stmt = con.prepareStatement(sql);
            //trocando o ? pelo nome da marca
            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getDescricao());
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
