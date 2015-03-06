package se.supportix.camelreboot;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spring.SpringCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.supportix.camelreboot.xml.Order;

public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args) throws Exception {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    	
    	CamelContext camelContext = new SpringCamelContext(context);
        
        
        ProducerTemplate template = camelContext.createProducerTemplate();
        
        final DataFormat jaxb = new JaxbDataFormat(JAXBContext.newInstance(Order.class));
        
        
        RouteBuilder route1 = new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:inbox?delay=2000").unmarshal(jaxb).beanRef("fixerBean");	
				
				from("direct:bean").marshal(jaxb).to("file:outbox");
				
			}
		};
        
		camelContext.addRoutes(route1);
		
		camelContext.start();
		
		Order o1 = new Order();
		o1.setNumber("45543");
		o1.setProduct("Gräsklippare");
		template.sendBody("direct:bean", o1);
		
		System.in.read();
		
		camelContext.stop();
    }
    
    
}
