package com.algaworks.algafood.api.openapi.model;

import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.output.CidadeModel;

import io.swagger.annotations.ApiModel;

@ApiModel("CidadesModel")
public class CidadesModelOpenApi {

    private CidadeEmbeddedModelOpenApi _embedded;
    private Links _links;

    public CidadeEmbeddedModelOpenApi get_embedded() {
        return _embedded;
    }

    public void set_embedded(CidadeEmbeddedModelOpenApi _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_embedded, _links);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CidadesModelOpenApi other = (CidadesModelOpenApi) obj;
        return Objects.equals(_embedded, other._embedded) && Objects.equals(_links, other._links);
    }

    @ApiModel("CidadesEmbeddedModel")
    public class CidadeEmbeddedModelOpenApi {

        private List<CidadeModel> cidades;

        public List<CidadeModel> getCidades() {
            return cidades;
        }

        public void setCidades(List<CidadeModel> cidades) {
            this.cidades = cidades;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + Objects.hash(cidades);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CidadeEmbeddedModelOpenApi other = (CidadeEmbeddedModelOpenApi) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            return Objects.equals(cidades, other.cidades);
        }

        private CidadesModelOpenApi getEnclosingInstance() {
            return CidadesModelOpenApi.this;
        }

    }

}
