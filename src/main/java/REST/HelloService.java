package REST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by alex on 30/08/15.
 */

@Path("/hello")
public class HelloService {
    @GET
    public Response printHello() {

        String result = "Hello";

        return Response.status(200).entity(result).build();

    }

    @GET
    @Path("/{param}")
    public Response printHelloWithParam(@PathParam("param") String msg) {

        String result = "Hello: " + msg;

        return Response.status(200).entity(result).build();

    }
}
