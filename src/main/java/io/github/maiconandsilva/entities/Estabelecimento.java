package io.github.maiconandsilva.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import io.github.maiconandsilva.entities.embeddables.Endereco;
import io.github.maiconandsilva.entities.tipos.TipoEstabelecimento;
import io.github.maiconandsilva.utils.IndiceCriminalidade;
import io.github.maiconandsilva.utils.MapURL;


@Entity
public class Estabelecimento extends PanacheEntity {
    @OneToOne
    public TipoEstabelecimento tipo;

    public String nome;

    @Embedded
    public Endereco endereco;

    @OneToMany(mappedBy = "estabelecimento")
    public List<Avaliacao> avaliacoes;

    public String getMapUrl() {
        return MapURL.buildURLWith(endereco.coordenadas);
    }

    public Double getIndiceCriminalidade() {
        return IndiceCriminalidade.get(endereco);
    }
}
