package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries {

    @Query("select distinct r from Restaurante r join fetch r.cozinha")
    List<Restaurante> findAll();

    List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
    List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha); // poderia deixar como :cozinha e sem o @Param

//  List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

    Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    int countByCozinhaId(Long cozinha);

    @Query("from Restaurante where nome like %:texto% and cozinha.nome = :nome")
    List<Restaurante> consultarPorNomeCozinha(String texto, String nome);

    @Query("select case when count(1) > 0 then true else false end from Restaurante rest join rest.responsaveis resp where rest.id = :restauranteId and resp.id = :usuarioId")
    boolean existsResponsavel(Long restauranteId, Long usuarioId);

}
