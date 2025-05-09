package br.unitins.tp1.repository;

import br.unitins.tp1.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Usuario findByUsernameAndSenha(String username, String senha) {
        return find("SELECT u FROM Usuario u WHERE u.username = ?1 AND u.senha = ?2", username, senha).firstResult();
    }


}