package br.unitins.tp1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.tp1.dto.UsuarioResponseDTO;
import br.unitins.tp1.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;
    
    @GET
    @RolesAllowed({"User", "Adm"})
    @Path("/perfil")
    public Response buscarUsuarioLogado() { 

        // obtendo o username do token
        String username = jwt.getSubject();

        // buscando no bd o usuario pelo seu username
        UsuarioResponseDTO usuario = usuarioService.findByUsername(username);

        return Response.ok().entity(usuario).build();
    }

}
