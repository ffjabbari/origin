package poc.eip.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.language.SimpleExpression;

/**
 * @author stanislav bashkirtsev
 */
public class DslRoute extends RouteBuilder {
    public void configure() {
        from("file:camelSource?autoCreate=true")
                .transform(new SimpleExpression("${in.body}, I am Apache Camel!"))
                .bean(CamelInterceptor.class)
                .to("jms:toSi");
        from("stream:in?promptMessage=Give me something:")
                .transform(new SimpleExpression("${in.body}, I am Apache Camel!"))
                .bean(CamelInterceptor.class)
                .to("jms:toSi");
    }

}
