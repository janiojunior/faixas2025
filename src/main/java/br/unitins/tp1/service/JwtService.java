package br.unitins.tp1.service;

public interface JwtService {

    String generateJwt(String username, String perfil);
    
}
