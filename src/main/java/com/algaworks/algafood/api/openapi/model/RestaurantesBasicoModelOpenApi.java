package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.output.RestauranteBasicoModel;

import io.swagger.annotations.ApiModel;

@ApiModel("RestaurantesBasicoModel")
public class RestaurantesBasicoModelOpenApi {

    private RestaurantesEmbeddedModelOpenApi _embedded;
    private Links _links;

    public RestaurantesEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(RestaurantesEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("RestaurantesEmbeddedModel")
    public class RestaurantesEmbeddedModelOpenApi {

        private List<RestauranteBasicoModel> restaurantes;

        public List<RestauranteBasicoModel> getRestaurantes() {
            return restaurantes;
        }

        public void setRestaurantes(List<RestauranteBasicoModel> restaurantes) {
            this.restaurantes = restaurantes;
        }

    }

}
