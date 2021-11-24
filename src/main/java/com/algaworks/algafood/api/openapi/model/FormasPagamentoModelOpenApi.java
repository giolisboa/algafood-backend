package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.output.FormaPagamentoModel;

import io.swagger.annotations.ApiModel;

@ApiModel("FormasPagamentoModel")
public class FormasPagamentoModelOpenApi {

    private FormasPagamentoEmbeddedModelOpenApi _embedded;
    private Links _links;

    public FormasPagamentoEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(FormasPagamentoEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @ApiModel("FormasPagamentoEmbeddedModel")
    public class FormasPagamentoEmbeddedModelOpenApi {

        private List<FormaPagamentoModel> formasPagamento;

        public List<FormaPagamentoModel> getFormasPagamento() {
            return formasPagamento;
        }

        public void setFormasPagamento(List<FormaPagamentoModel> formasPagamento) {
            this.formasPagamento = formasPagamento;
        }

    }

}
