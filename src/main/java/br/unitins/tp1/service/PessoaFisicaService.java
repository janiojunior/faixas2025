package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.PessoaFisicaDTO;
import br.unitins.tp1.dto.PessoaFisicaResponseDTO;

public interface PessoaFisicaService {

    PessoaFisicaResponseDTO create(PessoaFisicaDTO pessoafisica);
    void update(long id, PessoaFisicaDTO pessoafisica);
    void delete(long id);
    PessoaFisicaResponseDTO findById(long id);
    List<PessoaFisicaResponseDTO> findByNome(String nome);
    PessoaFisicaResponseDTO findByCpf(String cpf);
    List<PessoaFisicaResponseDTO> findAll();
    
}
