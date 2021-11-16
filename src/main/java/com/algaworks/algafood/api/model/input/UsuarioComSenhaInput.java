package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioComSenhaInput extends UsuarioInput {

    @ApiModelProperty(example = "123", required = true)
    @NotBlank
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
