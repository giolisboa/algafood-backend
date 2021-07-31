package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listarTodas() {
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Override
    public Permissao listarPorId(Long id) {
        return manager.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public Permissao adicionar(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao = listarPorId(permissao.getId());
        manager.remove(permissao);
    }

}
