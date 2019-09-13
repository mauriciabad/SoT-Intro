package fontys.sot.rest.service.resources;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Publisher {
    private static URI baseUri = UriBuilder.fromUri("http://localhost/").port(9090).build();

    public static void main(String[] args) {
        ResourceConfig resourceConfig = new ResourceConfig(StudentsResources.class);
        JdkHttpServerFactory.createHttpServer(baseUri, resourceConfig, true);
        System.out.println("Hosting service at " + baseUri);
    }
}
