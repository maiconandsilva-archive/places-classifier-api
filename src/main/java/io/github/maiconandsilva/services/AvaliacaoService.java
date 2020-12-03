package io.github.maiconandsilva.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import io.github.maiconandsilva.entities.Avaliacao;


@GraphQLApi
@ApplicationScoped
public class AvaliacaoService {
    @Mutation
    @Transactional
    public Long avaliarEstabelecimento(Avaliacao avaliacao) {
        avaliacao.persist();
        return avaliacao.id;
    }
}
