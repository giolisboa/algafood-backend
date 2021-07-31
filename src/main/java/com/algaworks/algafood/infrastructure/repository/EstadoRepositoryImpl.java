package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listarTodos() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    public Estado listarPorId(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        estado = listarPorId(estado.getId());
        manager.remove(estado);
    }

}
