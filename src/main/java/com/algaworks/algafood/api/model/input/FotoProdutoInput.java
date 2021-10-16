package com.algaworks.algafood.api.model.input;

import org.springframework.web.multipart.MultipartFile;

public class FotoProdutoInput {

    private MultipartFile arquivo;
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
