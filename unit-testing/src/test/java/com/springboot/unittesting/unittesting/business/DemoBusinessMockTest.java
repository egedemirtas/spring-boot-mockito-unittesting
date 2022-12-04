package com.springboot.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // this annotation is used with @InjectMocks and @Mock
class DemoBusinessMockTest {
    //DemoBusiness business = new DemoBusiness();
    // we are mocking a data service (interface)
    //IDemoDataService demoDataServiceMock = mock(IDemoDataService.class);

//    @BeforeEach
//    public void beforeEach(){
//        // set the data service as mocked class
//        business.setDemoDataService(demoDataServiceMock);
//    }


    // rather than using above flow, you can use annotations to inject DemoBusiness and mock IDemoDataService
    // you donteven have to use @BeforeEach
    @InjectMocks
    DemoBusiness business;
    @Mock
    IDemoDataService demoDataServiceMock;


    @Test
    void calculateMeanFromDataService_basic() {
        // write what the mock should do, when retrieveNumberList() is called
        when(demoDataServiceMock.retrieveNumberList()).thenReturn(Arrays.asList(1,2,3,4,5,6,7,8,9));

        // calculateMeanFromDataService() calls retrieveNumberList(), thus it calls the mocked class' method
        Double actual = business.calculateMeanFromDataService();
        Double expected = 5.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMeanFromDataService_empty() {
        when(demoDataServiceMock.retrieveNumberList()).thenReturn(null);

        Double actual = business.calculateMeanFromDataService();
        Double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMeanFromDataService_OneValue() {
        when(demoDataServiceMock.retrieveNumberList()).thenReturn(Arrays.asList(1));

        Double actual = business.calculateMeanFromDataService();
        Double expected = 1.0;
        assertEquals(expected, actual);
    }
    // verify
    @Test
    void calculateMeanFromDataService_StoreMean() {
        when(demoDataServiceMock.retrieveNumberList()).thenReturn(Arrays.asList(1,2,3,4,5,6,7,8,9));

        Double actual = business.calculateMeanFromDataService();
        Double expected = 5.0;
        assertEquals(expected, actual);

        // you can also use anyDouble()
        // there are other options like never(), atLeast(), atMost()
        verify(demoDataServiceMock, times(1)).storeMean(expected);
    }

    @Test
    void calculateMeanFromDataService_StoreMeanCaptor() {
        when(demoDataServiceMock.retrieveNumberList()).thenReturn(Arrays.asList(1,2,3,4,5,6,7,8,9));

        Double actual = business.calculateMeanFromDataService();
        Double expected = 5.0;
        assertEquals(expected, actual);

        ArgumentCaptor<Double> captor = ArgumentCaptor.forClass(Double.class);
        verify(demoDataServiceMock, times(1)).storeMean(captor.capture());

        // if you have called storeMean multiple times and want to capture all the calls, you can use allValues = captor.getAllValues()
        // and get each value by index: allValues.get(0)
        assertEquals(expected, captor.getValue());
    }
}