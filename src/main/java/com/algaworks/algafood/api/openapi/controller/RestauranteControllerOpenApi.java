package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.input.RestauranteInput;
import com.algaworks.algafood.api.model.output.RestauranteModel;
import com.algaworks.algafood.api.openapi.model.RestauranteBasicoModelOpenApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {

    @ApiOperation(value = "Lista restaurantes", response = RestauranteBasicoModelOpenApi.class)
    public List<RestauranteModel> listar();

    @ApiOperation("Busca um restaurante por ID")
    @ApiResponses({
            @ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    public RestauranteModel buscar(
            @ApiParam(value = "ID de um restaurante", example = "1", required = true) Long idRestaurante);

    @ApiOperation("Cadastra um restaurante")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Restaurante cadastrado"),
    })
    public RestauranteModel adicionar(
            @ApiParam(name = "corpo", value = "Representação de um novo restaurante", required = true) RestauranteInput restauranteInput);

    @ApiOperation("Atualiza um restaurante por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Restaurante atualizado"),
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    public RestauranteModel atualizar(
            @ApiParam(value = "ID de um restaurante", example = "1", required = true) Long idRestaurante,
            @ApiParam(name = "corpo", value = "Representação de um restaurante com os novos dados", required = true) RestauranteInput restauranteInput);

    @ApiOperation("Ativa um restaurante por ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Restaurante ativado com sucesso"),
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    public void ativar(@ApiParam(value = "ID de um restaurante", example = "1", required = true) Long idRestaurante);

    @ApiOperation("Inativa um restaurante por ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Restaurante inativado com sucesso"),
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    public void inativar(@ApiParam(value = "ID de um restaurante", example = "1", required = true) Long idRestaurante);

    @ApiOperation("Ativa múltiplos restaurantes")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Restaurantes ativados com sucesso")
    })
    public void ativarMultiplos(
            @ApiParam(name = "corpo", value = "IDs de restaurantes", required = true) List<Long> idsRestaurante);

    @ApiOperation("Inativa múltiplos restaurantes")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Restaurantes ativados com sucesso")
    })
    public void inativarMultiplos(
            @ApiParam(name = "corpo", value = "IDs de restaurantes", required = true) List<Long> idsRestaurante);

    @ApiOperation("Abre um restaurante por ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Restaurante aberto com sucesso"),
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    public void abrir(@ApiParam(value = "ID de um restaurante", example = "1", required = true) Long idRestaurante);

    @ApiOperation("Fecha um restaurante por ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Restaurante fechado com sucesso"),
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    public void fechar(@ApiParam(value = "ID de um restaurante", example = "1", required = true) Long idRestaurante);

}
