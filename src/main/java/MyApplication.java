import REST.HelloService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex on 30/08/15.
 */

/**
 * Since we're not using a jax-rs servlet mapping, we must define an Application class that is
 * annotated with the @ApplicationPath annotation. If you return any empty set for by classes and singletons,
 * your WAR will be scanned for JAX-RS annotation resource and provider classes.
 */
@ApplicationPath("/service")
public class MyApplication extends Application {
    //    private Set<Object> singletons = new HashSet<Object>();
//
//    public MyApplication() {
//        singletons.add(new HelloWorld());
//    }
//
//    @Override
//    public Set<Object> getSingletons() {
//        return singletons;
//    }

    /**
     * Setup the classes that the application server will use for deployment.
     * Just add a new class so the application server can use it.
     *
     * @return the classes that the application server will use
     */
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(HelloService.class));
    }
}
