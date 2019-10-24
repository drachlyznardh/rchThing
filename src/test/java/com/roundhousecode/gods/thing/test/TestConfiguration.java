package com.roundhousecode.gods.thing.test;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext camelContext) {
                try {
                    camelContext.addRoutes(new RouteBuilder() {
                        @Override
                        public void configure() throws Exception {
                            from("timer:thing?period={{rhc.thing.period}}")
                                    .id("theThingsMainRoute")
                                    .to("stream:out");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
            }
        };
    }
}
