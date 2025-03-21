package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.MunicipioDTO;
import br.unitins.tp1.dto.MunicipioResponseDTO;
import br.unitins.tp1.service.MunicipioService;
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

@Path("municipios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioResource {

    @Inject
    MunicipioService service;

    @GET
    public List<MunicipioResponseDTO> buscarTodos() { 
        return service.findAll();
    }

    @GET
    @Path("/estado/{id}")
    public List<MunicipioResponseDTO>  buscarPorEstado(Long id) { 
        return service.findByEstado(id);
    }

    @GET
    @Path("/nome/{nome}")
    public List<MunicipioResponseDTO>  buscarPorNome(String nome) { 
        return service.findByNome(nome);
    }

    @POST
    public MunicipioResponseDTO incluir(MunicipioDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, MunicipioDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}
