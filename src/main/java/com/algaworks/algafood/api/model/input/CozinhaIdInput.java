package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CozinhaIdInput {

    @ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
