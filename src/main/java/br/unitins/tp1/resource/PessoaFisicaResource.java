package br.unitins.tp1.resource;

import br.unitins.tp1.dto.PessoaFisicaDTO;
import br.unitins.tp1.service.PessoaFisicaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("pessoasfisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaFisicaResource {

    @Inject
    PessoaFisicaService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response buscarPorNome(String nome) { 
        return Response.ok().entity(service.findByNome(nome)).build();
    }

    @GET
    @Path("/cpf/{cpf}")
    public Response buscarPorSigla(String cpf) { 
        return Response.ok().entity(service.findByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorSigla(Long id) { 
        return Response.ok().entity(service.findById(id)).build();
    }

    @POST
    public Response incluir(@Valid PessoaFisicaDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, PessoaFisicaDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response apagar(Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

}
