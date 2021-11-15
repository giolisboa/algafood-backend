package com.algaworks.algafood.api.openapi.model;

import java.math.BigDecimal;

import com.algaworks.algafood.api.model.output.CozinhaModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("RestauranteBasicoModel")
public class RestauranteBasicoModelOpenApi {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "Thai Gourmet")
    private String nome;

    @ApiModelProperty(example = "12.00")
    private BigDecimal taxaFrete;

    private CozinhaModel cozinha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public CozinhaModel getCozinha() {
        return cozinha;
    }

    public void setCozinha(CozinhaModel cozinha) {
        this.cozinha = cozinha;
    }

}
