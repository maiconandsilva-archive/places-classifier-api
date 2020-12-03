package io.github.maiconandsilva.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Range;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import io.github.maiconandsilva.entities.tipos.TipoAvaliacao;


@Entity
public class Avaliacao extends PanacheEntity {
    @OneToOne
    public TipoAvaliacao tipo;

    @Range(min = 1, max = 5)
    public Short nota;

    public String comentario;

    @ManyToOne
    public Usuario usuario;

    @ManyToOne
    public Estabelecimento estabelecimento;
}
