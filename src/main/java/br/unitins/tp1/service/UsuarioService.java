package br.unitins.tp1.service;

import br.unitins.tp1.dto.UsuarioResponseDTO;

public interface UsuarioService {

    // UsuarioResponseDTO create(UsuarioDTO usuario);
    // void update(long id, UsuarioDTO usuario);
    // void delete(long id);
    // UsuarioResponseDTO findById(long id);
    // UsuarioResponseDTO findBySigla(String sigla);
    // List<UsuarioResponseDTO> findAll();
    UsuarioResponseDTO findByUsernameAndSenha(String username, String senha);
    UsuarioResponseDTO findByUsername(String username);

    
}
