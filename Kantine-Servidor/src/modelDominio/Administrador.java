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
public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID = 123l;

    public Administrador(int codigo, String nome, String senha, String email, String telefone) {
        super(codigo, nome, senha, email, telefone);
    }

    public Administrador(String nome, String senha, String email, String telefone) {
        super(nome, senha, email, telefone);
    }

    public Administrador(int codigo) {
        super(codigo);
    }

    public Administrador(String senha, String email) {
        super(senha, email);
    }
    
        @Override
    public String toString() {
        return super.toString()+"Administrador{" + '}';
    }
    
    
    
}
