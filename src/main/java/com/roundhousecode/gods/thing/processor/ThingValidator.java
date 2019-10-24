package com.roundhousecode.gods.thing.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("thingValidator")
public class ThingValidator implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setHeader("isValid", true);
    }
}
