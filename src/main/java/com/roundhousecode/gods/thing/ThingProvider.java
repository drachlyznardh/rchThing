package com.roundhousecode.gods.thing;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component("thingProvider")
public class ThingProvider {

    List<Thing> provideThings() {
        List<Thing> list = new LinkedList<>();
        return list;
    }
}
