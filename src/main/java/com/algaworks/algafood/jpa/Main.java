package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE).run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cadastroCozinha.salvar(cozinha1);
        cadastroCozinha.salvar(cozinha2);

        List<Cozinha> cozinhas = cadastroCozinha.listar();

        cozinhas.forEach(cozinha -> System.out.println(cozinha.getId() + " - " + cozinha.getNome()));

        System.out.println(cadastroCozinha.buscar(3L).getNome());

        Cozinha cozinhaRemover = new Cozinha();
        cozinhaRemover.setId(3L);

        cadastroCozinha.remover(cozinhaRemover);
    }

}
