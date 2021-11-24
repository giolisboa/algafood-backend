package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.output.EstadoModel;

import io.swagger.annotations.ApiModel;

@ApiModel("EstadosModel")
public class EstadosModelOpenApi {

    private EstadosEmbeddedModelOpenApi _embedded;
    private Links _links;

    public EstadosEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(EstadosEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("EstadosEmbeddedModel")
    public class EstadosEmbeddedModelOpenApi {

        private List<EstadoModel> estados;

        public List<EstadoModel> getEstados() {
            return estados;
        }

        public void setEstados(List<EstadoModel> estados) {
            this.estados = estados;
        }

    }
}
