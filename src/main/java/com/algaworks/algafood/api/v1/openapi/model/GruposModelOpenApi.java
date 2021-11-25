package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.output.GrupoModel;

import io.swagger.annotations.ApiModel;

@ApiModel("GruposModel")
public class GruposModelOpenApi {

    private GruposEmbeddedModelOpenApi _embedded;
    private Links _links;

    public GruposEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(GruposEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("GruposEmbeddedModel")
    public class GruposEmbeddedModelOpenApi {

        private List<GrupoModel> grupos;

        public List<GrupoModel> getGrupos() {
            return grupos;
        }

        public void setGrupos(List<GrupoModel> grupos) {
            this.grupos = grupos;
        }

    }

}
