package fontys.sot.rest.service.resources;

import fontys.sot.rest.service.model.AllStudents;
import fontys.sot.rest.service.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("students")
public class StudentsResources {

    private AllStudents students = new AllStudents();

    public StudentsResources() {
        students.add(new Student(0, "Joe Smith"));
        students.add(new Student(1, "Ann Johnsson"));
        students.add(new Student(2, "Miranda Winslet"));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getStudentByQuery(@QueryParam("id") Integer id) {
        if (id != null) {
            if (students.exists(id)) {
                List<Student> filteredStudentList = new ArrayList<Student>();
                filteredStudentList.add(students.get(id));
                return filteredStudentList;
            } else {
                throw new RuntimeException("Student wit id " + id + " doesn't exist");
            }
        }else{
            return students.getAll();
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Student getStudentByQuery(@PathParam("id") int id) {
        if (students.exists(id)) {
            return students.get(id);
        } else {
            throw new RuntimeException("Student wit id " + id + " doesn't exist");
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteStudent(@PathParam("id") int id) {
         students.remove(id);
    }

    @GET
    @Path("hello")
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello() {
        return "Hello, your service works!";
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public int getNumberOfStudents() {
        return students.total();
    }

    @GET
    @Path("first")
    @Produces({MediaType.APPLICATION_JSON})
    public Student GetFirstStudent() {
        if (students.exists(0)){
            return students.get(0);
        }else {
            throw new RuntimeException("Student wit id 0 doesn't exist");
        }
    }

}
