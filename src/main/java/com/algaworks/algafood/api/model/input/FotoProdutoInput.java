package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.core.validation.FileSize;

public class FotoProdutoInput {

    @NotNull
    @FileSize(max = "500KB")
    private MultipartFile arquivo;

    @NotBlank
    private String descricao;

    public MultipartFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
