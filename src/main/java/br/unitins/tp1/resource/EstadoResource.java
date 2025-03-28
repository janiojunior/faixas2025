package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.EstadoDTO;
import br.unitins.tp1.dto.EstadoResponseDTO;
import br.unitins.tp1.service.EstadoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService service;

    @GET
    public List<EstadoResponseDTO> buscarTodos() { 
        return service.findAll();
    }

    @GET
    @Path("/sigla/{sigla}")
    public EstadoResponseDTO buscarPorSigla(String sigla) { 
        return service.findBySigla(sigla);
    }

    @POST
    public EstadoResponseDTO incluir(EstadoDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, EstadoDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}
