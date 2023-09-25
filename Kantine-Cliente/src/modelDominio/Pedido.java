/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author aluno
 */
public class Pedido implements Serializable{
    private static final long serialVersionUID = 123l;
    
    private int codigo;
    private Produto produto;
    private Cliente cliente;
    private Date dataHora;
    private int status;
    
    // UPDATEs e SELECTs
    public Pedido(int codigo, Produto produto, Cliente cliente, Date dataHora, int status) {
        this.codigo = codigo;
        this.produto = produto;
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.status = status;
    }
    
    // INSERTs
    public Pedido(Produto produto, Cliente cliente, Date dataHora, int status) {
        this.produto = produto;
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.status = status;
    }
    
    // DELETEs
    public Pedido(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", produto=" + produto + ", cliente=" + cliente + ", dataHora=" + dataHora + ", status=" + status + '}';
    }    
}
