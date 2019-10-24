package com.roundhousecode.gods.thing.test;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest()
public class ValidatorMockTest {

    @Autowired
    private CamelContext context;

    @Produce(uri = "simple:start")
    private ProducerTemplate producer;

    @EndpointInject(uri = "mock:result")
    private MockEndpoint endpoint;

    @Test
    public void test() throws InterruptedException {

        endpoint.expectedHeaderReceived("lol", false);

        producer.sendBodyAndHeader("this is a body", "lol", false);

        endpoint.assertIsSatisfied();
    }
}
