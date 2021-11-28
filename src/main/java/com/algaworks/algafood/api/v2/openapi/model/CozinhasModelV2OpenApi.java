package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.output.CozinhaModel;

import io.swagger.annotations.ApiModel;

@ApiModel("CozinhasModel")
public class CozinhasModelV2OpenApi {

    private CozinhasEmbeddedModelOpenApi _embedded;
    private Links _links;
    private PageModelV2OpenApi page;

    public CozinhasEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(CozinhasEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public PageModelV2OpenApi getPage() {
        return page;
    }

    public void setPage(PageModelV2OpenApi page) {
        this.page = page;
    }

    @ApiModel("CozinhasEmbeddedModel")
    public class CozinhasEmbeddedModelOpenApi {

        private List<CozinhaModel> cozinhas;

        public List<CozinhaModel> getCozinhas() {
            return cozinhas;
        }

        public void setCozinhas(List<CozinhaModel> cozinhas) {
            this.cozinhas = cozinhas;
        }

    }

}
