package com.imos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonBuilderUnitTest {

    @Test
    public void whenBuildPersonWithBuilder_thenObjectHasPropertyValues() {
        Person person = new PersonBuilder()
                .setAge(27)
                .setName("Mike")
                .build();
        assertEquals(27, person.getAge());
        assertEquals("Mike", person.getName());
    }

}