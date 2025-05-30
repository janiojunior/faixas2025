package br.unitins.tp1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.tp1.dto.ItemPedidoDTO;
import br.unitins.tp1.dto.PedidoDTO;
import br.unitins.tp1.dto.PedidoResponseDTO;
import br.unitins.tp1.model.Faixa;
import br.unitins.tp1.model.ItemPedido;
import br.unitins.tp1.model.Pedido;
import br.unitins.tp1.model.Usuario;
import br.unitins.tp1.repository.FaixaRepository;
import br.unitins.tp1.repository.PedidoRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    FaixaRepository faixaRepository;

    @Override
    public List<PedidoResponseDTO> findByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public PedidoResponseDTO findById(long idPedido, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    @Transactional
    public PedidoResponseDTO create(PedidoDTO pedidoDTO, String username) {
        // obter o usuario pelo username
        Usuario usuario = usuarioRepository.findByUsername(username);

        Pedido pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());
        // calcular o total e verificar se eh igual ao dto
        // vcs (alunos) vao fazer :)
        pedido.setTotalPedido(pedidoDTO.total());
        pedido.setUsuario(usuario);

        List<ItemPedido> listaItem = new ArrayList<ItemPedido>();
        for (ItemPedidoDTO  itemDTO : pedidoDTO.itens()) {
            Faixa faixa = faixaRepository.findById(itemDTO.idProduto());

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setFaixa(faixa);
            // verificar se o preco do dto eh o mesmo do produto
            item.setPreco(item.getFaixa().getPreco());
            item.setQuantidade(itemDTO.qtd());

            listaItem.add(item);

            // alterando o estoque 
            faixa.setEstoque(faixa.getEstoque() - itemDTO.qtd());

        }

        pedido.setItens(listaItem);

        // salvando o pedido no banco de dados
        pedidoRepository.persist(pedido);




        return PedidoResponseDTO.valueOf(pedido);
    }


    
}
