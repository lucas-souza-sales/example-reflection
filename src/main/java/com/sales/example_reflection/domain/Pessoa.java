package com.sales.example_reflection.domain;

import java.util.List;

public class Pessoa {

    private Integer id;

    private String nome;

    private String cpf;

    private List<Endereco> enderecos;

    public Pessoa(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(Integer id, String nome, String cpf, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = enderecos;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
