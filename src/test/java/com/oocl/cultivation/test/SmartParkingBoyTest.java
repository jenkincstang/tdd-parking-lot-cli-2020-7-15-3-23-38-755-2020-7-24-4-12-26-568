package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class SmartParkingBoyTest {
    /**
     * //given
     * a parkingboy
     * multiple parking lot
     * //when
     * parkingCar
     * //then
     * return "parking lot of rank x contains more empty positions"
     */
    @Test
    public void should_return_a_ticket_when_parking_car_given_a_smart_parking_boy_with_a_car(){
        //given
        Car car = new Car(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        //when
        Ticket resultTicket = smartParkingBoy.parkCar(car);

        //then
        Assertions.assertEquals(new Ticket(1),resultTicket);
    }

    @Test
    public void should_return_a_car_when_fetching_car_given_a_smart_parking_boy_with_a_ticket(){
        //given
        Ticket ticket = new Ticket(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        //when
        Car resultCar = smartParkingBoy.fetchCar(ticket);

        //then
        Assertions.assertEquals(new Car(1),resultCar);
    }

    @Test
    public void should_return_parking_lot_of_rank_x_contains_more_empty_positions_when_parking_car_given_a_smart_parking_boy_with_multiple_parking_lot(){
        //given
        LinkedList<ParkingLot> parkingLots = initParkingLots();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        //when
        String result = smartParkingBoy.chooseParkingLotWithPosition(parkingLots);
        //then
        Assertions.assertEquals("Parking lot of rank 3 contains more empty positions",result);
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
