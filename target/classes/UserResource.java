import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.uam.bl.GestorClientes;

import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private final  GestorClientes service = new GestorClientes();

    @GET
    public List<User> getUsers() {
        return service.getAllClients();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        return service.getUser(id);
    }

    @POST
    public Response createUser(User user) {
        service.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        service.deleteUser(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}