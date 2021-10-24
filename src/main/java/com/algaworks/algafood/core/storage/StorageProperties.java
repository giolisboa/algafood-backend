package com.algaworks.algafood.core.storage;

import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;

@Component
@ConfigurationProperties("algafood.storage")
public class StorageProperties {

    private Local local = new Local();
    private S3 s3 = new S3();

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public S3 getS3() {
        return s3;
    }

    public void setS3(S3 s3) {
        this.s3 = s3;
    }

    public class Local {

        private Path diretorioFotos;

        public Path getDiretorioFotos() {
            return diretorioFotos;
        }

        public void setDiretorioFotos(Path diretorioFotos) {
            this.diretorioFotos = diretorioFotos;
        }
    }

    public class S3 {

        private String idChaveAcesso;
        private String chaveAcessoSecreta;
        private String bucket;
        private Regions regiao;
        private String diretorioFotos;

        public String getIdChaveAcesso() {
            return idChaveAcesso;
        }

        public void setIdChaveAcesso(String idChaveAcesso) {
            this.idChaveAcesso = idChaveAcesso;
        }

        public String getChaveAcessoSecreta() {
            return chaveAcessoSecreta;
        }

        public void setChaveAcessoSecreta(String chaveAcessoSecreta) {
            this.chaveAcessoSecreta = chaveAcessoSecreta;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public Regions getRegiao() {
            return regiao;
        }

        public void setRegiao(Regions regiao) {
            this.regiao = regiao;
        }

        public String getDiretorioFotos() {
            return diretorioFotos;
        }

        public void setDiretorioFotos(String diretorioFotos) {
            this.diretorioFotos = diretorioFotos;
        }
    }

}
