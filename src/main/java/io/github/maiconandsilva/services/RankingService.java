package io.github.maiconandsilva.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import io.github.maiconandsilva.entities.Ranking;
import io.github.maiconandsilva.entities.tipos.TipoAvaliacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@GraphQLApi
@ApplicationScoped
public class RankingService implements PanacheRepository<Ranking> {
    @Inject
    EntityManager em;

    @Query
    public List<Ranking> rankingOf(TipoAvaliacao tipoAvaliacao) {
        return em.createQuery(
            "select r from Ranking r"
            + " where r.id = :tipo_id", Ranking.class)
            .setParameter("tipo_id", tipoAvaliacao.id)
            .getResultList();
    }
}
