package com.algaworks.algafood.core.email;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
@ConfigurationProperties("algafood.email")
public class EmailProperties {

    @NotNull
    private String remetente;

    private Implementacao impl = Implementacao.FAKE;

    private Sandbox sandbox = new Sandbox();

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public Implementacao getImpl() {
        return impl;
    }

    public void setImpl(Implementacao impl) {
        this.impl = impl;
    }

    public Sandbox getSandbox() {
        return sandbox;
    }

    public void setSandbox(Sandbox sandbox) {
        this.sandbox = sandbox;
    }

    public class Sandbox {

        private String destinatario;

        public String getDestinatario() {
            return destinatario;
        }

        public void setDestinatario(String destinatario) {
            this.destinatario = destinatario;
        }

    }

    public enum Implementacao {
        SMTP, FAKE, SANDBOX
    }

}
