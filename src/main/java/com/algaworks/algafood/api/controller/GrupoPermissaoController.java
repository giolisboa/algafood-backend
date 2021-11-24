package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.PermissaoModelAssembler;
import com.algaworks.algafood.api.model.output.PermissaoModel;
import com.algaworks.algafood.api.openapi.controller.GrupoPermissaoControllerOpenApi;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.service.GrupoService;

@RestController
@RequestMapping(path = "/grupos/{idGrupo}/permissoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoPermissaoController implements GrupoPermissaoControllerOpenApi {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private PermissaoModelAssembler permissaoModelAssembler;

    @GetMapping
    public List<PermissaoModel> listar(@PathVariable Long idGrupo) {
        Grupo grupo = grupoService.buscar(idGrupo);

        return permissaoModelAssembler.toCollectionModel(grupo.getPermissoes());
    }

    @Override
    @DeleteMapping("/{idPermissao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long idGrupo, @PathVariable Long idPermissao) {
        grupoService.desassociarPermissao(idGrupo, idPermissao);
    }

    @Override
    @PutMapping("/{idPermissao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long idGrupo, @PathVariable Long idPermissao) {
        grupoService.associarPermissao(idGrupo, idPermissao);
    }

}
