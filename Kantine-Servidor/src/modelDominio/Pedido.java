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
    private int codProduto;
    private int codCliente;
    private Date dataHora;
    private int status;
    
    // UPDATEs e SELECTs
    public Pedido(int codigo, int codProduto, int codCliente, Date dataHora, int status) {
        this.codigo = codigo;
        this.codProduto = codProduto;
        this.codCliente = codCliente;
        this.dataHora = dataHora;
        this.status = status;
    }
    
    // INSERTs
    public Pedido(int codProduto, int codCliente, Date dataHora, int status) {
        this.codProduto = codProduto;
        this.codCliente = codCliente;
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

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
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
        return "Pedido{" + "codigo=" + codigo + ", codProduto=" + codProduto + ", codCliente=" + codCliente + ", dataHora=" + dataHora + ", status=" + status + '}';
    }
}
