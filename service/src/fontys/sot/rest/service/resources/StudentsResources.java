package fontys.sot.rest.service.resources;

import fontys.sot.rest.service.model.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("students")
public class StudentsResources {

    private List<Student> studentList = new ArrayList<>();

    public StudentsResources() {
        // To simplify getters, we create a list of students
        // where the index and id are the same.
        studentList.add(new Student(0, "Joe Smith"));
        studentList.add(new Student(1, "Ann Johnsson"));
        studentList.add(new Student(2, "Miranda Winslet"));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getStudentByQuery(@QueryParam("id") Integer id) {
        if (id != null) {
            if (id < studentList.size()) {
                List<Student> filteredStudentList = new ArrayList<Student>();
                filteredStudentList.add(studentList.get(id));
                return filteredStudentList;
            } else {
                throw new RuntimeException("Student wit id " + id + " doesn't exist");
            }
        }else{
            return studentList;
        }
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
        return studentList.size();
    }

    @GET
    @Path("first")
    @Produces({MediaType.APPLICATION_JSON})
    public Student GetFirstStudent() {
        if (studentList.size() > 0){
            return studentList.get(0);
        }else {
            throw new RuntimeException("There are 0 students");
        }
    }

}
