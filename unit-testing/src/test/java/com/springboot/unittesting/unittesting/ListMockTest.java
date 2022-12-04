package com.springboot.unittesting.unittesting;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

// how to return multiple values
public class ListMockTest {

    @Test
    public void returnDifferentValues(){
        List mock = mock(List.class);
        when(mock.size()).thenReturn(1).thenReturn(100);
        assertEquals(1, mock.size());
        assertEquals(1, mock.size());
    }

    @Test
    public void returnWithParams(){
        List mock = mock(List.class);
        when(mock.get(0)).thenReturn(1);
        assertEquals(1, mock.get(0));
        assertNull(mock.get(1));
        // fails the test because when you work with params, it only excepts the return value for the specific parameter,
        // if such param is not provided, default value will be returned
        // assertEquals(1, mock.get(1));
    }

    @Test
    public void returnWithAnyParams(){
        List mock = mock(List.class);
        when(mock.get(anyInt())).thenReturn(1);
        assertEquals(1, mock.get(0));
        assertEquals(1, mock.get(567567));
    }

    // spy
    @Test
    public void spying(){
        // when you use mock, entire behaviour of that class is lost
        List mock = mock(List.class);
        mock.get(0); // null
        mock.size(); // 0
        mock.add(1);
        mock.size(); // 0: a mock does not retain the behaviour of the original class.

        List spy = spy(List.class);
        spy.add(234);
        spy.size(); // 1
        when(spy.size()).thenReturn(99); // however spy keeps the behaviour of the original class and you can override class methods with `mockito.when`
        spy.size(); // 99
    }
}
