package com.sysonecars.salesmanager;

import com.sysonecars.salesmanager.model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoicingFacadeTest {

    @Mock
    VehicleService vehicleService;

    @InjectMocks
    Vehicle vehicle;


    @Test
    public void getTotalSumOk(){
        when(vehicleService.getValueFromSale(vehicle)).thenReturn(new Double(1500.00));

        assertEquals(new Double(1500.00), vehicleService.getValueFromSale(vehicle));
    }



}
