package com.roundhousecode.gods.thing.provider;

import com.roundhousecode.gods.thing.Thing;
import com.roundhousecode.gods.thing.ThingProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component("thingProvider")
public class ThingDaoProvider implements ThingProvider {

    public List<Thing> provideThings() {
        List<Thing> list = new LinkedList<>();
        return list;
    }
}
