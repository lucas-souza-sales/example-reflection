package com.sales.example_reflection.refl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sales.example_reflection.domain.Endereco;
import com.sales.example_reflection.domain.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ObjectToJsonTest {

    @Test
    public void deveConverterParaJsonComSucesso() throws JsonProcessingException {
        ObjectToJson objectToJson = new ObjectToJson();
        Pessoa pessoa = new Pessoa(1, "Lucas Sales", "12345678912",
                List.of(new Endereco(1, "Rua tal", "Bairro tal", "Juazeiro do Norte", "Ceará", "Brasil")));
        Assertions.assertDoesNotThrow(()-> {
            System.out.println(objectToJson.transform(pessoa));
        });

    }
}
