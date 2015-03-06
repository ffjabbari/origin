package poc.eip;

import org.apache.camel.CamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import poc.eip.camel.DslRoute;

/**
 * @author stanislav bashkirtsev
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/poc/eip/appContext.xml",
                "/poc/eip/camel/camelContext.xml", "/poc/eip/si/siRoutes.xml");
        CamelContext camelContext = context.getBean(CamelContext.class);
        camelContext.addRoutes(new DslRoute());
    }
}
