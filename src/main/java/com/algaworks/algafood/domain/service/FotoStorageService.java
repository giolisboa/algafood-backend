package com.algaworks.algafood.domain.service;

import java.io.InputStream;
import java.util.UUID;

public interface FotoStorageService {

    void armazenar(NovaFoto novaFoto);

    default String gerarNomeArquivo(String nomeOriginal) {
        return UUID.randomUUID().toString().concat("_").concat(nomeOriginal);
    }

    class NovaFoto {

        private String nomeArquivo;
        private InputStream inputStream;

        public NovaFoto(String nomeArquivo, InputStream inputStream) {
            this.nomeArquivo = nomeArquivo;
            this.inputStream = inputStream;
        }

        public String getNomeArquivo() {
            return nomeArquivo;
        }

        public void setNomeArquivo(String nomeArquivo) {
            this.nomeArquivo = nomeArquivo;
        }

        public InputStream getInputStream() {
            return inputStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }

}
