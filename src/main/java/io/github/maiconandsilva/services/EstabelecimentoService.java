package io.github.maiconandsilva.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.github.maiconandsilva.entities.Avaliacao;
import io.github.maiconandsilva.entities.Estabelecimento;

@GraphQLApi
@ApplicationScoped
public class EstabelecimentoService {
    @Mutation
    @Transactional
    public Long adicionarNovoEstabelecimento(Estabelecimento estabelecimento) {
        estabelecimento.persist();
        return estabelecimento.id;
    }
    
    @Query
    public List<Avaliacao> getAvaliacoesPorEstabelecimento(
        Integer estabelecimentoId) {
        return Avaliacao.find("estabelecimento_id = ?1", estabelecimentoId).list();
    }
}
