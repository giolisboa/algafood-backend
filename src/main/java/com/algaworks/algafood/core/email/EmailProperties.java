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

    public enum Implementacao {
        SMTP, FAKE
    }

}
