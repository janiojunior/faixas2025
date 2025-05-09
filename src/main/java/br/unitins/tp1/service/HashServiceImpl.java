package br.unitins.tp1.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashServiceImpl implements HashService {

    private String salt = "@#1237Zt";
    private Integer iterationCount = 403;
    private Integer keyLength = 512;

    @Override
    public String getHashSenha(String senha) throws Exception {

        byte[] result;
        try {
            result = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA512")
                .generateSecret(new PBEKeySpec(senha.toCharArray(),
                                salt.getBytes(),
                                iterationCount,
                                keyLength))
                .getEncoded();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw new Exception("Problema ao gerar o hash");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new Exception("Problema ao gerar o hash");
        }
        
        return Base64.getEncoder().encodeToString(result);

    }

    public static void main(String[] args) {
        HashServiceImpl hash = new HashServiceImpl();
        try {
            System.out.println(hash.getHashSenha("1234"));
            System.out.println(hash.getHashSenha("1234"));
            System.out.println(hash.getHashSenha("Leandra"));
            System.out.println(hash.getHashSenha("leandra"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
