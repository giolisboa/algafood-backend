package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

public class UsuarioComSenhaInput extends UsuarioInput {

    @NotBlank
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
