package com.springboot.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoDataServiceStub implements IDemoDataService{

    @Override
    public List<Integer> retrieveNumberList() {
        return Arrays.asList(1,2,3,4,5,6,7,8,9);
    }

    @Override
    public void storeMean(double mean) {
        return;
    }
}

class DemoBusinessStubTest {

    @Test
    void calculateMeanFromService_basic() {
        DemoBusiness business = new DemoBusiness();
        business.setDemoDataService(new DemoDataServiceStub()); // MAJOR DISADVANTAGE: you need to create different stubs for every unit test. Ex: to test empty list you need to create new stub
                                                                // MAJOR DISADVANTAGE: if you add another method to IDemoDataService, you need to create another stub
                                                                // DISADVANTAGE: you need to do business analysis to fill the stubs
        Double actual = business.calculateMeanFromDataService();
        Double expected = 5.0;
        assertEquals(actual, expected);
    }
}