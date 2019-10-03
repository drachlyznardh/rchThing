package com.roundhousecode.gods.thing;

import com.roundhousecode.gods.thing.provider.NullThingProvider;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = {Application.class, NullThingProvider.class})
public class MostBasicTest {

    @Autowired
    private CamelContext camelContext;

    @Test
    public void mostBasicTest() throws Exception {
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();
        Assert.assertTrue(notify.matches(10, TimeUnit.SECONDS));
    }
}