package com.algaworks.algafood.domain.listener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.event.PedidoConfirmadoEvent;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.service.EnvioEmailService;
import com.algaworks.algafood.domain.service.EnvioEmailService.Mensagem;

@Component
public class NotificacaoClientePedidoConfirmadoListener {

    @Autowired
    EnvioEmailService envioEmailService;

    @EventListener
    public void aoConfirmarPedido(PedidoConfirmadoEvent event) {
        Pedido pedido = event.getPedido();

        Mensagem mensagem = new Mensagem();
        mensagem.setAssunto(pedido.getRestaurante().getNome().concat(" - Pedido confirmado"));
        mensagem.setCorpo("pedido-confirmado.html");

        Set<String> destinatarios = new HashSet<>();
        destinatarios.add(pedido.getCliente().getEmail());

        Map<String, Object> variaveis = new HashMap<>();
        variaveis.put("pedido", pedido);

        mensagem.setDestinatarios(destinatarios);
        mensagem.setVariaveis(variaveis);

        envioEmailService.enviar(mensagem);
    }

}
