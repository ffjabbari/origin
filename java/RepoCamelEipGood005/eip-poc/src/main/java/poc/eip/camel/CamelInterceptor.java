package poc.eip.camel;

import org.apache.camel.Exchange;

/**
 * @author stanislav bashkirtsev
 */
public class CamelInterceptor {
    public void intercept(Exchange exchange) throws Exception {
    	System.out.println("\nCamel saying: " + exchange.getIn().getHeaders().keySet());
    	System.out.println("\nCamel saying: " + exchange.getIn().getMandatoryBody().toString());
        
    }
}
