package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.EstadoDTO;
import br.unitins.tp1.model.Estado;
import br.unitins.tp1.model.Regiao;
import br.unitins.tp1.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository estadoRepository;

    @Override
    @Transactional
    public Estado create(EstadoDTO estado) {
        Estado novoEstado = new Estado();
        novoEstado.setNome(estado.getNome());
        novoEstado.setSigla(estado.getSigla());
       
        // selecionar uma regiao
        Regiao regiao = null;
        for (Regiao r : Regiao.values()) {
            if (r.getId() == estado.getIdRegiao())
                regiao = r;
        }

        novoEstado.setRegiao(regiao);

        // realizando inclusao
        estadoRepository.persist(novoEstado);

        return novoEstado;
    }

    @Override
    @Transactional
    public void update(long id, Estado estado) {
        Estado edicaoEstado = estadoRepository.findById(id);

        edicaoEstado.setNome(estado.getNome());
        edicaoEstado.setSigla(estado.getSigla());
    }

    @Override
    @Transactional
    public void delete(long id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public Estado findById(long id) {
        return estadoRepository.findById(id);
    }

    @Override
    public Estado findBySigla(String sigla) {
        return estadoRepository.findBySigla(sigla);
    }

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll().list();
    }
    
}
