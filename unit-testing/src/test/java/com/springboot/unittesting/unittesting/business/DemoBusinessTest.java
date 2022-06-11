package com.springboot.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DemoBusinessTest {

    @Test
    void calculateMean_basic() {
        DemoBusiness business = new DemoBusiness();
        Double actual = business.calculateMean(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Double expected = 5.0;
        assertEquals(actual, expected);
    }

    @Test
    void calculateMean_empty() {
        DemoBusiness business = new DemoBusiness();
        Double actual = business.calculateMean(null);
        Double expected = 0.0;
        assertEquals(actual, expected);
    }
}