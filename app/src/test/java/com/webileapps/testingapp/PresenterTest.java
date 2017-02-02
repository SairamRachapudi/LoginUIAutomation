package com.webileapps.testingapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by sairam on 31/1/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Test
    public void doSumWithNoExceptioCase() throws Exception {

        Service service = Mockito.mock(Service.class);
        Mockito.when(service.doSum(1,2)).thenReturn(3);
        Presenter presenter = new Presenter(service);
        assertEquals(3,presenter.doSum(1,2));
        Mockito.verify(service,Mockito.times(1)).doSum(1,2);
    }

    @Test
    public void doSumWithExceptioCase() throws Exception {

        Service service = Mockito.mock(Service.class);
        Mockito.when(service.doSum(1,2)).thenThrow(new RuntimeException());
        Presenter presenter = new Presenter(service);
        assertEquals(-1,presenter.doSum(1,2));
    }

}