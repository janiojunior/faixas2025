package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.EstadoDTO;
import br.unitins.tp1.dto.EstadoResponseDTO;
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
    public EstadoResponseDTO create(EstadoDTO estado) {
        Estado novoEstado = new Estado();
        novoEstado.setNome(estado.nome());
        novoEstado.setSigla(estado.sigla());
       
        novoEstado.setRegiao(Regiao.valueOf(estado.idRegiao()));

        // realizando inclusao
        estadoRepository.persist(novoEstado);

        return EstadoResponseDTO.valueOf(novoEstado);
    }

    @Override
    @Transactional
    public void update(long id, EstadoDTO estado) {
        Estado edicaoEstado = estadoRepository.findById(id);

        edicaoEstado.setNome(estado.nome());
        edicaoEstado.setSigla(estado.sigla());
        edicaoEstado.setRegiao(Regiao.valueOf(estado.idRegiao()));
    }

    @Override
    @Transactional
    public void delete(long id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public EstadoResponseDTO findById(long id) {
        return EstadoResponseDTO.valueOf(estadoRepository.findById(id));
    }

    @Override
    public EstadoResponseDTO findBySigla(String sigla) {
        return EstadoResponseDTO.valueOf(estadoRepository.findBySigla(sigla));
    }

    @Override
    public List<EstadoResponseDTO> findAll() {
        return estadoRepository.findAll().stream().map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }
    
}
