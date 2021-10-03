package com.algaworks.algafood.api.model.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PedidoInput {

    @Valid
    @NotNull
    private RestauranteIdInput restaurante;

    @Valid
    @NotNull
    private FormaPagamentoIdInput formaPagamento;

    @Valid
    @NotNull
    private EnderecoInput enderecoEntrega;

    @Valid
    @Size(min = 1)
    @NotNull
    private List<ItemPedidoInput> itens;

    public RestauranteIdInput getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteIdInput restaurante) {
        this.restaurante = restaurante;
    }

    public FormaPagamentoIdInput getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoIdInput formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public EnderecoInput getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoInput endereco) {
        this.enderecoEntrega = endereco;
    }

    public List<ItemPedidoInput> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoInput> itens) {
        this.itens = itens;
    }

}
