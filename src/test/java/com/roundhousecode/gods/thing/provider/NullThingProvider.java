package com.roundhousecode.gods.thing.provider;

import com.roundhousecode.gods.thing.Thing;
import com.roundhousecode.gods.thing.ThingProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@Component("thingProvider")
public class NullThingProvider implements ThingProvider {

    @Value("${rhc.thing.test.howManyThings:1}")
    private int howManyThings;

    @Override
    public List<Thing> provideThings() {
        List<Thing> list = new LinkedList<>();
        IntStream.range(0, howManyThings).forEach(i -> list.add(null));
        return list;
    }
}
