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

        Builder requestBuilder = serviceTarget.path("").request();
        Response response = requestBuilder.get();

        if(response.getStatus() == Response.Status.OK.getStatusCode()) {
            String entity = response.readEntity(String.class);
            System.out.println("OK:");
            System.out.println(entity);
        } else{
            System.out.println("Error");
            System.out.println(response);
        }
    }
}
