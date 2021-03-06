package com.buildria.camel.example.eip.routingslip;

import com.buildria.camel.example.JunitBase;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RoutingSlipBasicTest extends JunitBase {
    
    @Autowired
    protected CamelContext camelContext;
    
    private ProducerTemplate template;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        template = camelContext.createProducerTemplate();
    }
    
    @Test
    @DirtiesContext
    public void testRoute() throws Exception {  
        template.sendBodyAndHeader("direct:roundslip", "Data", "routingSlipHeader", "direct:route_a");
    }

    @Test
    @DirtiesContext
    public void testRoutes() throws Exception {  
        template.sendBodyAndHeader("direct:roundslip", "Data", "routingSlipHeader", "direct:route_a#direct:route_b#direct:route_c");
    }

}
