package fontys.sot.rest.service.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentsResources {

    @GET //GET at http://localhost:XXXX/student/hello
    @Path("hello")
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello() {
        return "Hello, your service works !";
    }

}
