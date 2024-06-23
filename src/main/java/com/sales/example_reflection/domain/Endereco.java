package com.sales.example_reflection.domain;

public class Endereco {

    public Endereco(Integer id, String endereco, String bairro, String cidade, String estado, String pais) {
        this.id = id;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    private Integer id;

    private String endereco;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    public Integer getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }
}
