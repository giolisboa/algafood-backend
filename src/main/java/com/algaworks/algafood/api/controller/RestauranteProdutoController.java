package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.ProdutoInputDisassembler;
import com.algaworks.algafood.api.assembler.ProdutoModelAssembler;
import com.algaworks.algafood.api.model.input.ProdutoInput;
import com.algaworks.algafood.api.model.output.ProdutoModel;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import com.algaworks.algafood.domain.service.ProdutoService;
import com.algaworks.algafood.domain.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes/{idRestaurante}/produtos")
public class RestauranteProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoInputDisassembler produtoInputDisassembler;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<ProdutoModel> listar(@PathVariable Long idRestaurante,
            @RequestParam(required = false) boolean incluirInativos) {
        Restaurante restaurante = restauranteService.buscar(idRestaurante);

        List<Produto> produtos = null;

        if (incluirInativos) {
            produtos = produtoRepository.findTodosByRestaurante(restaurante);
        } else {
            produtos = produtoRepository.findAtivosByRestaurante(restaurante);
        }

        return produtoModelAssembler.toCollectionModel(produtos);
    }

    @GetMapping("/{idProduto}")
    public ProdutoModel buscar(@PathVariable Long idRestaurante, @PathVariable Long idProduto) {
        Produto produto = produtoService.buscar(idRestaurante, idProduto);

        return produtoModelAssembler.toModel(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel adicionar(@RequestBody @Valid ProdutoInput produtoInput, @PathVariable Long idRestaurante) {
        Restaurante restaurante = restauranteService.buscar(idRestaurante);

        Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);

        produto.setRestaurante(restaurante);

        return produtoModelAssembler.toModel(produtoService.salvar(produto));
    }

    @PutMapping("/{idProduto}")
    public ProdutoModel atualizar(@RequestBody @Valid ProdutoInput produtoInput, @PathVariable Long idRestaurante,
            @PathVariable Long idProduto) {
        Produto produtoAtual = produtoService.buscar(idRestaurante, idProduto);

        produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);

        return produtoModelAssembler.toModel(produtoService.salvar(produtoAtual));
    }

}
