package poc.eip.si;

import org.springframework.integration.Message;

/**
 * @author stanislav bashkirtsev
 */
public class SiServiceActivator {
    public Message process(Message message) {
        System.out.println("SI saying: " + message.getHeaders().keySet());
        System.out.println("SI saying: " + message.getPayload().toString() + "too...");
        
        return message;
    }
}
