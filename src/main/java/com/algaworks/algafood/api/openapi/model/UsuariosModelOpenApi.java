package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.output.UsuarioModel;

import io.swagger.annotations.ApiModel;

@ApiModel("UsuariosModel")
public class UsuariosModelOpenApi {

    private UsuariosEmbeddedModelOpenApi _embedded;
    private Links _links;

    public UsuariosEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(UsuariosEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("UsuariosEmbeddedModel")
    public class UsuariosEmbeddedModelOpenApi {

        private List<UsuarioModel> usuarios;

        public List<UsuarioModel> getUsuarios() {
            return usuarios;
        }

        public void setUsuarios(List<UsuarioModel> usuarios) {
            this.usuarios = usuarios;
        }

    }

}
