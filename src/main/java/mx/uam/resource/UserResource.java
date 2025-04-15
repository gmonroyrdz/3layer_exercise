package mx.uam.resource;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.uam.bl.GestorClientes;
import mx.uam.bl.dto.ClienteDto;
import mx.uam.dal.entities.Cliente;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users", description = "Operaciones relacionadas a usuarios")
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private final  GestorClientes service = new GestorClientes();

    @GET
    @Operation(summary = "Obtener todos los usuarios")
    public List<ClienteDto> getUsers() {
        return service.getAllClients();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Obtener un usuario por ID")
    public Cliente getUser(@PathParam("id") int id) {
        return service.getUser(id);
    }

    @POST
    @Operation(summary = "Crear un nuevo usuario")
    public Response createUser(Cliente user) {
        service.agregarCliente(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar un usuario por ID")
    public Response deleteUser(@PathParam("id") int id) {
        service.eliminarCliente(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}