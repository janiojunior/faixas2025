package br.unitins.tp1.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.model.Pedido;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime data,
    // endereco
    // pagamento
    // status pedido
    Double totalPedido,
    List<ItemPedidoResponseDTO> lista) {

    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getDataHora(),
            pedido.getTotalPedido(),
            pedido.getItens().stream().map(i -> ItemPedidoResponseDTO.valueOf(i)).toList()  
        );
      
    }
    
}
