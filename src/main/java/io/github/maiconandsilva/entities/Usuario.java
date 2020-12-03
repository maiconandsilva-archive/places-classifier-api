package io.github.maiconandsilva.entities;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Usuario extends PanacheEntity {
    public String nome;
}
