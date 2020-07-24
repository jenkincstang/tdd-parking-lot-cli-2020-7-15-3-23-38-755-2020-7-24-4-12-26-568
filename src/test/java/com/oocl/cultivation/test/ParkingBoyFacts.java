package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingBoyFacts {
    @Test
    void write_your_first_test() {

    }
    /**
     * //given
     * a parkingboy
     * a car
     * //when
     * parking car
     * //then
     * return a ticket
     */
    @Test
    public void should_return_a_ticket_when_parking_car_given_a_parking_boy_with_a_car(){
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        Ticket resultTicket = parkingBoy.parkCar(car);

        //then
        Assertions.assertEquals(new Ticket(1),resultTicket);
    }
}
