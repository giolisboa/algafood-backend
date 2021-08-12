package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {

    List<Cidade> listar();

    Cidade listarPorId(Long idCidade);

    Cidade salvar(Cidade cidade);

    void remover(Long idCidade);
}
