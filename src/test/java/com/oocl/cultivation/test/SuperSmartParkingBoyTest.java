package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_return_a_ticket_when_parking_car_given_a_super_smart_parking_boy_with_a_car(){
        //given
        Car car = new Car(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        //when
        Ticket resultTicket = superSmartParkingBoy.parkCar(car);

        //then
        Assertions.assertEquals(new Ticket(1),resultTicket);
    }

    @Test
    public void should_return_a_car_when_fetching_car_given_a_super_smart_parking_boy_with_a_ticket(){
        //given
        Ticket ticket = new Ticket(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        //when
        Car resultCar = superSmartParkingBoy.fetchCar(ticket);

        //then
        Assertions.assertEquals(new Car(1),resultCar);
    }
    /**
     * //given
     * a superSmartParkingBoy
     * multiple parking lot
     * //when
     * parkingCar
     * //then
     * return "parking lot of rank x has a larger available position rate"
     */
    @Test
    public void should_return_parking_lot_of_rank_x_has_a_larger_available_position_rate_when_parking_car_given_a_super_smart_parking_boy_with_multiple_parking_lot(){
        //given
        LinkedList<ParkingLot> parkingLots = initParkingLots();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        //when
        String result = superSmartParkingBoy.chooseParkingLotWithPosition(parkingLots);
        //then
        Assertions.assertEquals("Parking lot of rank 3 has a larger available position rate",result);
    }
    public LinkedList<ParkingLot> initParkingLots(){
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.setRemainingCapacity(0);
        ParkingLot secondParkingLot = new ParkingLot();
        secondParkingLot.setRemainingCapacity(0);
        ParkingLot thirdParkingLot = new ParkingLot();
        thirdParkingLot.setRemainingCapacity(1);
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        parkingLots.add(thirdParkingLot);

        return parkingLots;
    }
}
