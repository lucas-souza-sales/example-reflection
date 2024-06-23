package com.sales.example_reflection.repository;

import com.sales.example_reflection.domain.Pessoa;

import java.util.List;

public class PessoaRepository {

    public List<Pessoa> list() {
        return List.of(new Pessoa(1, "Lucas Sales", "12345678909"));
    }

}
