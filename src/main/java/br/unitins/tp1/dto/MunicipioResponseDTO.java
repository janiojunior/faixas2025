package br.unitins.tp1.dto;

import br.unitins.tp1.model.Municipio;

public record MunicipioResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estado) {

    public static MunicipioResponseDTO valueOf(Municipio municipio) {
        if (municipio == null)
            return null;
        return new MunicipioResponseDTO(
            municipio.getId(), 
            municipio.getNome(), 
            EstadoResponseDTO.valueOf(municipio.getEstado())
        );
    }
   
}
