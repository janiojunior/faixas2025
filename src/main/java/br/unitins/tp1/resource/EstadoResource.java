package br.unitins.tp1.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.EstadoDTO;
import br.unitins.tp1.dto.EstadoResponseDTO;
import br.unitins.tp1.service.EstadoService;
import br.unitins.tp1.service.JwtServiceImpl;
import jakarta.annotation.security.RolesAllowed;
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

@Path("estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    private static final Logger LOG = Logger.getLogger(EstadoResource.class);

    @Inject
    EstadoService service;

    @GET
    @RolesAllowed("Adm")
    public Response buscarTodos() { 
        LOG.info("Entrou no método buscarTodos");
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @RolesAllowed("User")
    @Path("/sigla/{sigla}")
    public Response buscarPorSigla(String sigla) { 
        LOG.info("Entrou no método buscarPorSigla");
        LOG.debug("O parametro informado foi: " + sigla);

        EstadoResponseDTO dto = service.findBySigla(sigla);

        LOG.debug("Os dados de retorno são: nome=" +dto.nome() + " sigla="+ dto.sigla());

        return Response.ok().entity(dto).build();
    }

    @POST
    public Response incluir(@Valid EstadoDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, EstadoDTO dto) {
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
