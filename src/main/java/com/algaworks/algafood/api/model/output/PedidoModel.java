package com.algaworks.algafood.api.model.output;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;

@Relation(collectionRelation = "pedidos")
public class PedidoModel extends RepresentationModel<PedidoModel> {

    @ApiModelProperty(example = "f9981ca4-5a5e-4da3-af04-933861df3e55")
    private String codigo;

    @ApiModelProperty(example = "298.90")
    private BigDecimal subtotal;

    @ApiModelProperty(example = "10.00")
    private BigDecimal taxaFrete;

    @ApiModelProperty(example = "308.90")
    private BigDecimal valorTotal;

    @ApiModelProperty(example = "CRIADO")
    private String status;

    @ApiModelProperty(example = "2019-12-01T20:34:04Z")
    private OffsetDateTime dataCriacao;

    @ApiModelProperty(example = "2019-12-01T20:35:10Z")
    private OffsetDateTime dataConfirmacao;

    @ApiModelProperty(example = "2019-12-01T20:55:30Z")
    private OffsetDateTime dataEntrega;

    @ApiModelProperty(example = "2019-12-01T20:35:00Z")
    private OffsetDateTime dataCancelamento;

    private RestauranteResumoModel restaurante;

    private UsuarioModel cliente;

    private FormaPagamentoModel formaPagamento;

    private EnderecoModel enderecoEntrega;

    private List<ItemPedidoModel> itens;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public OffsetDateTime getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(OffsetDateTime dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }

    public OffsetDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(OffsetDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public OffsetDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(OffsetDateTime dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public RestauranteResumoModel getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteResumoModel restaurante) {
        this.restaurante = restaurante;
    }

    public UsuarioModel getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioModel cliente) {
        this.cliente = cliente;
    }

    public FormaPagamentoModel getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoModel formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public EnderecoModel getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoModel enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<ItemPedidoModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoModel> itens) {
        this.itens = itens;
    }

}
