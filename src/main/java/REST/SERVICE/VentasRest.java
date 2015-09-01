package REST.SERVICE;


import EJB.SERVICE.VentasService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alex on 31/08/15.
 */

@Path("/ventas")
public class VentasRest {

    @EJB
    VentasService ventasService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVentas() {
        return Response.status(200).entity(ventasService.getVentas()).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVenta(@PathParam("id") int id) {
        return Response.status(200).entity(ventasService.getVenta(id)).build();
    }
}
