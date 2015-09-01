import org.reflections.Reflections;

import javax.ws.rs.Path;

/**
 * Created by alex on 01/09/15.
 */
public class main {
    public static void main(String arg[]) {
        Reflections reflections = new Reflections("REST.SERVICE");
        System.out.printf(String.valueOf(reflections.getTypesAnnotatedWith(Path.class)));
    }
}
