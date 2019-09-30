package com.roundhousecode.gods.thing;

public interface Thing {

    /**
     * A Thing must have a numeric id
     */
    Long getId();

    /**
     * A Thing may have a name
     */
    String getName();
}
