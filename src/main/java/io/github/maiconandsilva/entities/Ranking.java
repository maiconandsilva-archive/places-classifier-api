package io.github.maiconandsilva.entities;

import javax.persistence.Entity;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
@Subselect(
    "select a.tipo_id id, count(nota) numeroNotas, sum(nota)/count(nota) rank"
    + " from avaliacao a"
    + " join tipoavaliacao ta on ta.id = a.tipo_id"
    + " join estabelecimento e on e.id = a.estabelecimento_id"
    + " group by e.id, a.tipo_id"
    + " order by rank, numeroNotas desc"
)
@Synchronize( {"avaliacao", "tipoavaliacao", "estabelecimento"} )
public class Ranking extends PanacheEntity {
    public Integer numeroNotas;
    
    public Double rank;
}