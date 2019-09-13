package fontys.sot.rest.service.resources;

import fontys.sot.rest.service.model.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("students")
public class StudentsResources {

    private List<Student> studentList = new ArrayList<>();

    public StudentsResources() {
        studentList.add(new Student(1, "Joe Smith"));
        studentList.add(new Student(2, "Ann Johnsson"));
        studentList.add(new Student(3, "Miranda Winslet"));
    }

    @GET //GET at http://localhost:XXXX/students/hello
    @Path("hello")
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello() {
        return "Hello, your service works !";
    }

    @GET //GET at http://localhost:XXXX/students/count
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public int getNumberOfStudents() {
        return studentList.size();
    }

}
