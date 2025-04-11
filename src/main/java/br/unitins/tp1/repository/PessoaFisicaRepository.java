package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica> {

    public List<PessoaFisica> findByNome(String nome) {
        return find("nome LIKE ?1 ", "%" + nome + "%").list();
    }

    public PessoaFisica findByCpf(String cpf) {
        return find("cpf = ?1 ", cpf).firstResult();
    }

}