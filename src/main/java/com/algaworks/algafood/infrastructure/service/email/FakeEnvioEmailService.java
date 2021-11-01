package com.algaworks.algafood.infrastructure.service.email;

public class FakeEnvioEmailService extends SmtpEnvioEmailService {

    @Override
    public void enviar(Mensagem mensagem) {
        String corpo = processarTemplate(mensagem);

        System.out.println(mensagem.getDestinatarios());
        System.out.println(corpo);
    }

}
