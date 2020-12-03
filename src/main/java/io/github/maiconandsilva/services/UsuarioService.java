package io.github.maiconandsilva.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.github.maiconandsilva.entities.Usuario;


@GraphQLApi
@ApplicationScoped
public class UsuarioService {
    @Mutation
    @Transactional
    public Long criarUsuario(Usuario usuario) {
        usuario.persist();
        return usuario.id;
    }
    @Query
    public List<Usuario> getUsuario(Usuario usuario) {
        return Usuario.find("id", usuario.id).list();
    }

    @Query
    public List<Usuario> listaUsuarios() {
        return Usuario.listAll();
    }
}
