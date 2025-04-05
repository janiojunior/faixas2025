package br.unitins.tp1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EstadoDTO(
    @NotBlank(message = "O nome deve ser informado.")
    @Size(min = 4, max = 60, message = "O nome deve possuir entre 4 a 60 caracteres.")
    String nome,

    @Size(max = 2, min = 2, message = "A sigla deve possuir 2 caracteres.")
    @NotNull(message = "A sigla não pode ser nula.")
    String sigla,

    @Min(value = 1, message = "O valor mínimo para a região é 1.")
    Integer idRegiao) {
    
}
