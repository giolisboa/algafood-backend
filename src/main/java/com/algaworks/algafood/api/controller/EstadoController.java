package com.algaworks.algafood.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
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

import com.algaworks.algafood.api.assembler.EstadoInputDisassembler;
import com.algaworks.algafood.api.assembler.EstadoModelAssembler;
import com.algaworks.algafood.api.model.input.EstadoInput;
import com.algaworks.algafood.api.model.output.EstadoModel;
import com.algaworks.algafood.api.openapi.controller.EstadoControllerOpenApi;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.EstadoService;

@RestController
@RequestMapping(path = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController implements EstadoControllerOpenApi {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EstadoModelAssembler estadoModelAssembler;

    @Autowired
    private EstadoInputDisassembler estadoInputDisassembler;

    @GetMapping
    public CollectionModel<EstadoModel> listar() {
        return estadoModelAssembler.toCollectionModel(estadoRepository.findAll());
    }

    @Override
    @GetMapping("/{idEstado}")
    public EstadoModel buscar(@PathVariable Long idEstado) {
        return estadoModelAssembler.toModel(estadoService.buscar(idEstado));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
        Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
        return estadoModelAssembler.toModel(estadoService.salvar(estado));
    }

    @Override
    @PutMapping("/{idEstado}")
    public EstadoModel atualizar(@PathVariable Long idEstado, @RequestBody @Valid EstadoInput estadoInput) {
        Estado estadoAtual = estadoService.buscar(idEstado);

        estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);

        return estadoModelAssembler.toModel(estadoService.salvar(estadoAtual));
    }

    @Override
    @DeleteMapping("/{idEstado}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long idEstado) {
        estadoService.excluir(idEstado);
    }

}
