/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Usuario implements Serializable{

    private static final long serialVersionUID = 123l;
    
    private int codigo;
    private String nome;
    private String senha;
    private String email;
    private String telefone;

    // UPDATEs e SELECTs
    public Usuario(int codigo, String nome, String senha, String email, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }
    
    // INSERTS
    public Usuario(String nome, String senha, String email, String telefone) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }
    // DELETES
    public Usuario(int codigo) {
        this.codigo = codigo;
    }
    
    // Construtor para login
    public Usuario(String senha, String email) {
        this.senha = senha;
        this.email = email;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", telefone=" + telefone + '}';
    }
}
