package br.unitins.tp1.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.model.Pedido;
import br.unitins.tp1.model.Regiao;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime data,
    // endereco
    // pagamento
    // status pedido
    Double totalPedido,
    List<ItemPedidoResponseDTO> lista,
    Regiao regiao) {

    // public static PedidoResponseDTO valueOf(Pedido pedido) {
    //     if (pedido == null)
    //         return null;
    //     return new PedidoResponseDTO(pedido.getId(), pedido.getNome(), pedido.getSigla(), pedido.getRegiao());
    // }
    
}
