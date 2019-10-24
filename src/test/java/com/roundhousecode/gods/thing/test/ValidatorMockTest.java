package com.roundhousecode.gods.thing.test;

import com.roundhousecode.gods.thing.Application;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest()
public class ValidatorMockTest {

    @Autowired
    private CamelContext context;

    @Produce(uri = "direct:start")
    private ProducerTemplate producer;

    @EndpointInject(uri = "mock:result")
    private MockEndpoint endpoint;

    @Test
    public void test() throws InterruptedException {

        endpoint.expectedHeaderReceived("lol", false);
        producer.sendBodyAndHeader("this is a body", "lol", false);
        endpoint.assertIsSatisfied();
    }

    @Before
    public void setup() throws Exception {
        this.context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from(ValidatorMockTest.this.producer.getDefaultEndpoint().getEndpointUri())
                        .id("validatorMockTestRoute")
                        .process("thingValidator")
                        .to(ValidatorMockTest.this.endpoint.getEndpointUri());
            }
        });
    }
}
