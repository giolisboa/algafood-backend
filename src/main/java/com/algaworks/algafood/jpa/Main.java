package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE).run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cozinhaRepository.adicionar(cozinha1);
        cozinhaRepository.adicionar(cozinha2);

        List<Cozinha> cozinhas = cozinhaRepository.listarTodas();

        cozinhas.forEach(cozinha -> System.out.println(cozinha.getId() + " - " + cozinha.getNome()));

        System.out.println(cozinhaRepository.listarPorId(3L).getNome());

        Cozinha cozinhaRemover = new Cozinha();
        cozinhaRemover.setId(3L);

        cozinhaRepository.remover(cozinhaRemover);

        // RESTAURANTES
        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> restaurantes = restauranteRepository.listarTodos();

        restaurantes.forEach(r -> System.out.println(r.getNome() + " " + r.getTaxaFrete() + " " + r.getCozinha().getNome()));

    }

}
