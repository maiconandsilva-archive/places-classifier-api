package io.github.maiconandsilva.entities.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable
public class Endereco {
    public String cep;

    public String cidade;

    public String bairro;

    public String logradouro;
    
    public Integer numero;

    @Embedded
    public Coordenadas coordenadas;
}
