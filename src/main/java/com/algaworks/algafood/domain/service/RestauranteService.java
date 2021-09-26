package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

    private static final String MSG_RESTAURANTE_EM_USO = "O restaurante de código %d não pode ser removido, pois está em uso";

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private CozinhaService cozinhaService;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        Long idCozinha = restaurante.getCozinha().getId();
        Long idCidade = restaurante.getEndereco().getCidade().getId();

        Cozinha cozinha = cozinhaService.buscar(idCozinha);
        Cidade cidade = cidadeService.buscar(idCidade);

        restaurante.setCozinha(cozinha);
        restaurante.getEndereco().setCidade(cidade);

        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public void excluir(Long idRestaurante) {
        try {
            restauranteRepository.deleteById(idRestaurante);
            restauranteRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new RestauranteNaoEncontradoException(idRestaurante);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_RESTAURANTE_EM_USO, idRestaurante));
        }
    }

    public Restaurante buscar(Long idRestaurante) {
        return restauranteRepository.findById(idRestaurante)
                .orElseThrow(() -> new RestauranteNaoEncontradoException(idRestaurante));
    }

    @Transactional
    public void ativar(Long idRestaurante) {
        Restaurante restaurante = buscar(idRestaurante);
        restaurante.ativar();
    }

    @Transactional
    public void inativar(Long idRestaurante) {
        Restaurante restaurante = buscar(idRestaurante);
        restaurante.inativar();
    }

    @Transactional
    public void desassociarFormaPagamento(Long idRestaurante, Long idFormaPagamento) {
        Restaurante restaurante = buscar(idRestaurante);
        FormaPagamento formaPagamento = formaPagamentoService.buscar(idFormaPagamento);

        restaurante.removerFormaPagamento(formaPagamento);
    }

    @Transactional
    public void associarFormaPagamento(Long idRestaurante, Long idFormaPagamento) {
        Restaurante restaurante = buscar(idRestaurante);
        FormaPagamento formaPagamento = formaPagamentoService.buscar(idFormaPagamento);

        restaurante.adicionarFormaPagamento(formaPagamento);
    }

}
