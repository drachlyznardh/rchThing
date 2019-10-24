package com.roundhousecode.gods.thing.test;

import com.roundhousecode.gods.thing.Application;
import com.roundhousecode.gods.thing.test.provider.NullThingProvider;
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
    private CamelContext context;

    @Test
    public void test() throws Exception {
        NotifyBuilder notify = new NotifyBuilder(this.context).fromRoute("theThingsMainRoute").whenDone(0).create();
        Assert.assertTrue(notify.matches(3, TimeUnit.SECONDS));
    }
}
