package br.unitins.tp1.dto;

import br.unitins.tp1.model.Estado;
import br.unitins.tp1.model.Regiao;

public record EstadoResponseDTO(
    Long id,
    String nome,
    String sigla,
    Regiao regiao) {

    public static EstadoResponseDTO valueOf(Estado estado) {
        if (estado == null)
            return null;
        return new EstadoResponseDTO(estado.getId(), estado.getNome(), estado.getSigla(), estado.getRegiao());
    }
    
}
