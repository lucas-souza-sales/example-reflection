package com.sales.example_reflection.refl;

import com.sales.example_reflection.domain.Endereco;
import com.sales.example_reflection.domain.Pessoa;
import com.sales.example_reflection.domain.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {

    @Test
    public void deveConverterComSucessoParaPessoaDTO() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        var pessoa = new Pessoa(1, "Lucas", "12345678912");
        var transformator = new Transformator();
        var pessoaDTO = (PessoaDTO) transformator.transform(pessoa);
        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    public void deveLancarErroClassNotFoundException() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            var endereco = new Endereco(1, "Rua tal", "Bairro tal", "Juazeiro do Norte", "Ceará", "Brasil");
            var transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

}
