package com.algaworks.algafood.domain.event;

import com.algaworks.algafood.domain.model.Pedido;

public class PedidoCanceladoEvent {

    private Pedido pedido;

    public PedidoCanceladoEvent(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

}
