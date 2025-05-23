package br.unitins.tp1.dto;

import br.unitins.tp1.model.ItemPedido;
import br.unitins.tp1.model.Regiao;

public record ItemPedidoResponseDTO(
    Long id,
    Long idProduto,
    Integer qtd,
    Double preco) {

    // public static ItemPedidoResponseDTO valueOf(ItemPedido itempedido) {
    //     if (itempedido == null)
    //         return null;
    //     return new ItemPedidoResponseDTO(itempedido.getId(), itempedido.getNome(), itempedido.getSigla(), itempedido.getRegiao());
    // }
    
}
