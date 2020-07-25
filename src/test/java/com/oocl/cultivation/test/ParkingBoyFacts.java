package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        Ticket resultTicket = parkingBoy.parkCar(car);

        //then
        Assertions.assertEquals(new Ticket(1),resultTicket);
    }

    /**
     * //given
     * a ticket
     * a parkingboy
     * //when
     * fetching car
     * //then
     * return a car
     */
    @Test
    public void should_return_a_car_when_fetching_car_given_a_parking_boy_with_a_ticket(){
        //given
        Ticket ticket = new Ticket(1);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        Car resultCar = parkingBoy.fetchCar(ticket);

        //then
        Assertions.assertEquals(new Car(1),resultCar);
    }

    /**
     * //given
     * multiple cars
     * a ticket
     * a parkingboy
     * //when
     * fetchingRespondingCar
     * //then
     * return a responding car
     */
    @Test
    public void should_return_a_responding_car_when_fetching_responding_car_given_a_parking_boy_with_a_ticket(){
        //given
        Ticket ticket = new Ticket(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        LinkedList<Car> cars = initCarsInParkingLot();

        //when
        Car resultCar = parkingBoy.fetchRespondingCar(ticket,cars);

        //then
        Assertions.assertEquals(new Car(1),resultCar);
    }

    public LinkedList<Car> initCarsInParkingLot(){
        LinkedList<Car> cars = new LinkedList<>();
        cars.add(new Car(1));
        cars.add(new Car(2));
        cars.add(new Car(3));

        return cars;
    }

    /**
     * //given
     * a parkingboy
     * a wrong ticket
     *
     * //when
     * fetchRespondingCar
     *
     * //then
     * return null
     */
    @Test
    public void should_return_tips_about_wrong_ticket_when_fetching_responding_car_given_a_parking_boy_with_a_wrong_ticket(){
        //given
        Ticket ticket = new Ticket(1);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.fetchRespondingCarWithWrongTicket(ticket);

        //then
        Assertions.assertEquals("Wrong Ticket",result);
    }

    @Test
    public void should_return_tips_about_none_ticket_when_fetching_responding_car_given_a_parking_boy_with_no_ticket(){
        //given
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.fetchRespondingCarWithNoTicket(ticket);

        //then
        Assertions.assertEquals("No Ticket",result);
    }

}
