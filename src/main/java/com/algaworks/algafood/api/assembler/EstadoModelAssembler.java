package com.algaworks.algafood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class EstadoModelAssembler {

    @Autowired
    private ModelMapper modeMapper;

    public EstadoModel toModel(Estado estado) {
        return modeMapper.map(estado, EstadoModel.class);
    }

    public List<EstadoModel> toCollectionModel(List<Estado> estados) {
        return estados.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }

}
