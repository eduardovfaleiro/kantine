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
public class Cliente extends Usuario implements Serializable{
    private static final long serialVersionUID = 123l;

    public Cliente(int codigo, String nome, String senha, String email, String telefone) {
        super(codigo, nome, senha, email, telefone);
    }

    public Cliente(String nome, String senha, String email, String telefone) {
        super(nome, senha, email, telefone);
    }

    public Cliente(int codigo) {
        super(codigo);
    }

    public Cliente(String senha, String email) {
        super(senha, email);
    }

    @Override
    public String toString() {
        return super.toString()+"Cliente{" + '}';
    }
}
