package com.example.trainsystem.util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorTest {
    @Test
    void twoPlustTwoEqualsFour(){
        var distance = new DistanceCalculator();
        assertEquals(4,distance.calculateTwo(2,2));
    }
}