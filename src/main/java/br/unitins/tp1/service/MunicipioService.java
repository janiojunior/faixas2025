package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.MunicipioDTO;
import br.unitins.tp1.dto.MunicipioResponseDTO;

public interface MunicipioService {

    MunicipioResponseDTO create(MunicipioDTO Municipio);
    void update(long id, MunicipioDTO Municipio);
    void delete(long id);
    MunicipioResponseDTO findById(long id);
    List<MunicipioResponseDTO> findByEstado(Long idEstado);
    List<MunicipioResponseDTO> findByNome(String nome);
    List<MunicipioResponseDTO> findAll();
    
}
