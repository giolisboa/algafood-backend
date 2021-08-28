package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

    private static final String MSG_COZINHA_EM_USO = "A cozinha de código %d não pode ser removida, pois está em uso.";

    private static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe um cadastro de cozinha com o código %d";

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void remover(Long idCozinha) {
        try {
            cozinhaRepository.deleteById(idCozinha);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, idCozinha));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_COZINHA_EM_USO, idCozinha));
        }
    }

    public Cozinha buscar(Long idCozinha) {
        return cozinhaRepository.findById(idCozinha).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, idCozinha)));
    }

}
