package fontys.sot.rest.service.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("courses")
public class CoursesResources {
    @GET
    @Path("test")
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello() {
        return "true";
    }
}
