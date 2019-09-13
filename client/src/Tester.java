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
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        URI baseURI = UriBuilder.fromUri("http://localhost:9090/students").build();
        WebTarget serviceTarget = client.target(baseURI);

        Builder requestBuilder = serviceTarget.path("hello").request().accept(MediaType.TEXT_PLAIN);
        Response response = requestBuilder.get();

        if(response.getStatus() == 200) {
            String entity = response.readEntity(String.class);
            System.out.println("The service response is: " + entity);
        } else{
            System.out.println("ERROR: cannot get Hello! " + response);
            String entity = response.readEntity(String.class);
            System.out.println(entity);
        }
    }
}
