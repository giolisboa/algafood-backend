package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

    List<FormaPagamento> listar();

    FormaPagamento listarPorId(Long id);

    FormaPagamento adicionar(FormaPagamento formaDePagamento);

    void remover(FormaPagamento formaDePagamento);
}
