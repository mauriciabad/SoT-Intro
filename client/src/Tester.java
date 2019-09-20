import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Tester {

    public static void main(String[] args) {
        test("http://localhost:9090/students");
        test("http://localhost:9090/students/2");
        test("http://localhost:9090/students?id=2");
        test("http://localhost:9090/students/first");
        test("http://localhost:9090/students/hello");
        test("http://localhost:9090/students/count");
        test("http://localhost:9090/students/first");
    }

    public static int test(String url) {
        return test(url, "GET", null);
    }

    public static int test(String url, String method, String body){
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        URI baseURI = UriBuilder.fromUri(url).build();
        WebTarget serviceTarget = client.target(baseURI);

        Builder requestBuilder = serviceTarget.path("").request();
        Response response = requestBuilder.get();

        System.out.println();
        System.out.println(method + " " + url);

        if(response.getStatus() == Response.Status.OK.getStatusCode()) {
            String entity = response.readEntity(String.class);
            System.out.println(entity);
        } else{
            System.out.println(response);
        }

        return response.getStatus();
    }
}
