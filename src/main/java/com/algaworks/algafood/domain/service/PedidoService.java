package com.algaworks.algafood.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.PedidoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.StatusPedido;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProdutoService produtoService;

    public Pedido buscar(Long idPedido) {
        return pedidoRepository.findById(idPedido).orElseThrow(() -> new PedidoNaoEncontradoException(idPedido));
    }

    @Transactional
    public Pedido salvar(Pedido pedido) {
        validarPedido(pedido);
        validarItens(pedido);

        pedido.setTaxaFrete(pedido.getRestaurante().getTaxaFrete());
        pedido.calcularValorTotal();

        return pedidoRepository.save(pedido);
    }

    private void validarPedido(Pedido pedido) {
        Long idRestaurante = pedido.getRestaurante().getId();
        Long idFormaPagamento = pedido.getFormaPagamento().getId();
        Long idCidade = pedido.getEnderecoEntrega().getCidade().getId();
        Long idUsuario = pedido.getCliente().getId();

        Restaurante restaurante = restauranteService.buscar(idRestaurante);
        FormaPagamento formaPagamento = formaPagamentoService.buscar(idFormaPagamento);
        Cidade cidade = cidadeService.buscar(idCidade);
        Usuario usuario = usuarioService.buscar(idUsuario);

        pedido.setRestaurante(restaurante);
        pedido.setFormaPagamento(formaPagamento);
        pedido.getEnderecoEntrega().setCidade(cidade);
        pedido.setCliente(usuario);

        if (restaurante.naoAceitaFormaPagamento(formaPagamento)) {
            throw new NegocioException(String.format("A forma de pagamento '%s' não é aceita por esse restaurante.",
                    formaPagamento.getDescricao()));
        }
    }

    private void validarItens(Pedido pedido) {
        Long idRestaurante = pedido.getRestaurante().getId();

        pedido.getItens().stream().forEach(item -> {
            Long idProduto = item.getProduto().getId();
            Produto produto = produtoService.buscar(idRestaurante, idProduto);

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());
        });
    }

    @Transactional
    public void confirmarPedido(Long idPedido) {
        Pedido pedido = buscar(idPedido);

        if (!pedido.getStatus().equals(StatusPedido.CRIADO)) {
            throw new NegocioException(String.format("O status do pedido %s não pode ser alterado de %s para %s",
                    pedido.getId(), pedido.getStatus().getDescricao(), StatusPedido.CONFIRMADO.getDescricao()));
        }

        pedido.setStatus(StatusPedido.CONFIRMADO);
        pedido.setDataConfirmacao(OffsetDateTime.now());
    }

}
