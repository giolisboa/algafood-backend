package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v2.model.output.CidadeModelV2;

import io.swagger.annotations.ApiModel;

@ApiModel("CidadesModel")
public class CidadesModelV2OpenApi {

    private CidadesEmbeddedModelOpenApi _embedded;
    private Links _links;

    public CidadesEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(CidadesEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("CidadesEmbeddedModel")
    public class CidadesEmbeddedModelOpenApi {

        private List<CidadeModelV2> cidades;

        public List<CidadeModelV2> getCidades() {
            return cidades;
        }

        public void setCidades(List<CidadeModelV2> cidades) {
            this.cidades = cidades;
        }

    }

}
