package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.output.ProdutoModel;

import io.swagger.annotations.ApiModel;

@ApiModel("ProdutosModel")
public class ProdutosModelOpenApi {

    private ProdutosEmbeddedModelOpenApi _embedded;
    private Links _links;

    public ProdutosEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(ProdutosEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("ProdutosEmbeddedModel")
    public class ProdutosEmbeddedModelOpenApi {

        private List<ProdutoModel> produtos;

        public List<ProdutoModel> getProdutos() {
            return produtos;
        }

        public void setProdutos(List<ProdutoModel> produtos) {
            this.produtos = produtos;
        }

    }

}
