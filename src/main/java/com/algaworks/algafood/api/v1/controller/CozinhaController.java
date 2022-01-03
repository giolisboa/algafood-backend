package com.algaworks.algafood.api.v1.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.assembler.CozinhaInputDisassembler;
import com.algaworks.algafood.api.v1.assembler.CozinhaModelAssembler;
import com.algaworks.algafood.api.v1.model.input.CozinhaInput;
import com.algaworks.algafood.api.v1.model.output.CozinhaModel;
import com.algaworks.algafood.api.v1.openapi.controller.CozinhaControllerOpenApi;
import com.algaworks.algafood.core.security.CheckSecurity;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CozinhaService;

@RestController
@RequestMapping(value = "/v1/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController implements CozinhaControllerOpenApi {

    private static final Logger logger = LoggerFactory.getLogger(CozinhaController.class);

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CozinhaService cozinhaService;

    @Autowired
    private CozinhaModelAssembler cozinhaModelAssembler;

    @Autowired
    private CozinhaInputDisassembler cozinhaInputDisassembler;

    @Autowired
    private PagedResourcesAssembler<Cozinha> pagedResourcesAssembler;

    @CheckSecurity.Cozinhas.PodeConsultar
    @Override
    @GetMapping
    public PagedModel<CozinhaModel> listar(@PageableDefault(size = 10) Pageable pageable) {
        logger.info("Consultando cozinhas com páginas de {} registros...", pageable.getPageSize());

        Page<Cozinha> cozinhasPage = cozinhaRepository.findAll(pageable);

        PagedModel<CozinhaModel> cozinhasPagedModel = pagedResourcesAssembler
                .toModel(cozinhasPage, cozinhaModelAssembler);

        return cozinhasPagedModel;
    }

    @CheckSecurity.Cozinhas.PodeConsultar
    @Override
    @GetMapping("/{idCozinha}")
    public CozinhaModel buscar(@PathVariable Long idCozinha) {
        return cozinhaModelAssembler.toModel(cozinhaService.buscar(idCozinha));
    }

    @CheckSecurity.Cozinhas.PodeEditar
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaModel adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
        Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);

        return cozinhaModelAssembler.toModel(cozinhaService.salvar(cozinha));
    }

    @CheckSecurity.Cozinhas.PodeEditar
    @Override
    @PutMapping("/{idCozinha}")
    public CozinhaModel atualizar(@PathVariable Long idCozinha, @RequestBody @Valid CozinhaInput cozinhaInput) {
        Cozinha cozinhaAtual = cozinhaService.buscar(idCozinha);

        cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);

        return cozinhaModelAssembler.toModel(cozinhaService.salvar(cozinhaAtual));
    }

    @CheckSecurity.Cozinhas.PodeEditar
    @Override
    @DeleteMapping("/{idCozinha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long idCozinha) {
        cozinhaService.excluir(idCozinha);
    }

}
