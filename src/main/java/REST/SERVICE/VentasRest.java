package REST.SERVICE;


import EJB.SERVICE.VentasService;
import org.jboss.logging.annotations.LoggingClass;

import javax.ejb.EJB;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Created by alex on 31/08/15.
 */

@Path("/ventas")
public class VentasRest {

    // Tipo de Ordenacion
    private static final String ASC = "asc";
    private static final String DESC = "desc";

    // Nombre de las columnas
    private static final String nombreCliente = "nombre_cliente";
    private static final String fecha = "fecha";
    private static final String montoTotal = "monto_total";
    private static final String rucCliente = "ruc_cliente";
    private static final String numero = "numero";

    // Nombre de columnas para filtro
    private static final String byNombreCliente = "by_nombre_cliente";
    private static final String byFecha = "by_fecha";
    private static final String byMontoTotal = "by_monto_total";
    private static final String byRucCliente = "by_ruc_cliente";
    private static final String byNumero = "by_numero";
    private static final String byAllAttributes = "by_all_attributes";

    @EJB
    VentasService ventasService;

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVentas() {
        return Response.status(200).entity(ventasService.createQuery("Arsenio")).build();
    }*/

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVenta(@PathParam("id") int id) {
        return Response.status(200).entity(ventasService.getVenta(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVentas(
            @QueryParam(byNombreCliente) String nombreClienteVenta,
            @QueryParam(byFecha) String fechaVenta,
            @QueryParam(byNumero) String numeroVenta,
            @QueryParam(byMontoTotal) String montoVenta,
            @QueryParam(byRucCliente) String rucVenta,
            @QueryParam(byAllAttributes) String allAttributes) {


        try {
            return Response.status(200).entity(ventasService.createQuery(nombreClienteVenta, fechaVenta, numeroVenta,
                    montoVenta, rucVenta, allAttributes )).build();
        } catch (Exception e) {
            return Response.status(404).entity("404: No encontrado").build();
        }
    }
}
