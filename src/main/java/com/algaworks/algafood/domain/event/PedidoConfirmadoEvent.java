package com.algaworks.algafood.domain.event;

import com.algaworks.algafood.domain.model.Pedido;

public class PedidoConfirmadoEvent {

    private Pedido pedido;

    public PedidoConfirmadoEvent(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

}
