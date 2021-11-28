package com.algaworks.algafood.api.v2.model.output;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;

@Relation(collectionRelation = "cozinhas")
public class CozinhaModelV2 extends RepresentationModel<CozinhaModelV2> {

    @ApiModelProperty(example = "1")
    private Long idCozinha;

    @ApiModelProperty(example = "Brasileira")
    private String nomeCozinha;

    public Long getIdCozinha() {
        return idCozinha;
    }

    public void setIdCozinha(Long idCozinha) {
        this.idCozinha = idCozinha;
    }

    public String getNomeCozinha() {
        return nomeCozinha;
    }

    public void setNomeCozinha(String nomeCozinha) {
        this.nomeCozinha = nomeCozinha;
    }

}
