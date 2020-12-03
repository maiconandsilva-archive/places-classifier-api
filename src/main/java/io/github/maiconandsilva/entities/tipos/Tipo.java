package io.github.maiconandsilva.entities.tipos;

import javax.persistence.MappedSuperclass;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@MappedSuperclass
public abstract class Tipo extends PanacheEntity {
    public String nome;

    public String descricao;
}
