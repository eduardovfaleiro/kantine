package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
    public static String hashPassword(String password) {
        try {
            // Crie uma instância do MessageDigest com o algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Converta a senha em bytes
            byte[] passwordBytes = password.getBytes();
            
            // Calcule o hash da senha
            byte[] hashedBytes = md.digest(passwordBytes);
            
            // Converta o hash em uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            
            // Retorne o hash como uma string em hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Trate a exceção caso o algoritmo não esteja disponível
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "senha123";
        String hashedPassword = hashPassword(password);
        System.out.println("Senha criptografada: " + hashedPassword);
    }
}
