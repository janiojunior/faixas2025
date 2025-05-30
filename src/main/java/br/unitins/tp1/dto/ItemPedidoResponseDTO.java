package br.unitins.tp1.dto;

import br.unitins.tp1.model.ItemPedido;

public record ItemPedidoResponseDTO(
    Long idProduto,
    Integer qtd,
    Double preco) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO (
            itemPedido.getFaixa().getId(), 
            itemPedido.getQuantidade(),
            itemPedido.getPreco());
    }
    
}
