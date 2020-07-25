package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class ParkingBoyFacts {
    private final int CAPACITY_OF_PARKING_LOT = 10;

    @Test
    public void should_return_a_ticket_when_parking_car_given_a_parking_boy_with_a_car() {
        //given
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        Ticket resultTicket = parkingBoy.parkCar(car);

        //then
        Assertions.assertEquals(new Ticket(car.getId()), resultTicket);
    }

    @Test
    public void should_return_a_car_when_fetching_car_given_a_parking_boy_with_a_ticket() {
        //given
        Ticket ticket = new Ticket(1);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        Car resultCar = parkingBoy.fetchCar(ticket);

        //then
        Assertions.assertEquals(new Car(1), resultCar);
    }

    @Test
    public void should_return_a_responding_car_when_fetching_responding_car_given_a_parking_boy_with_a_ticket() {
        //given
        Ticket ticket = new Ticket(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        LinkedList<Car> cars = initCarsInParkingLot();

        //when
        Car resultCar = parkingBoy.fetchRespondingCar(ticket, cars);

        //then
        Assertions.assertEquals(new Car(1), resultCar);
    }

    public LinkedList<Car> initCarsInParkingLot() {
        LinkedList<Car> cars = new LinkedList<>();
        cars.add(new Car(1));
        cars.add(new Car(2));
        cars.add(new Car(3));

        return cars;
    }

    @Test
    public void should_return_tips_about_none_ticket_when_fetching_responding_car_given_a_parking_boy_with_no_ticket() {
        //given
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.fetchRespondingCarWithNoTicket(ticket);

        //then
        Assertions.assertEquals("Please provide your parking ticket.", result);
    }

    @Test
    public void should_return_tips_about_used_ticket_when_fetching_responding_car_given_a_parking_boy_with_a_used_ticket() {
        //given
        Ticket ticket = getUsedTicket();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.fetchRespondingCarWithUsedTicket(ticket);

        //then
        Assertions.assertEquals("Used Ticket", result);
    }

    public Ticket getUsedTicket() {
        Ticket ticket = new Ticket(1);
        ticket.setUsed(true);

        return ticket;
    }

    @Test
    public void should_return_tips_about_no_position_when_parking_car_given_a_parking_boy_and_a_parkinglot() {
        //given
        ParkingLot parkingLot = new ParkingLot(CAPACITY_OF_PARKING_LOT);
        parkingLot.setRemainingCapacity(0);

        ParkingBoy parkingBoy = new ParkingBoy();


        //when
        String result = parkingBoy.parkingCarToParkingLot(parkingLot);

        //then
        Assertions.assertEquals("Not enough position.", result);
    }

    @Test
    public void should_return_tips_about_parked_car_when_parking_car_given_a_parking_boy_with_a_parked_car() {
        //given
        Car car = getParkedCar();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.parkingParkedCar(car);
        //then
        Assertions.assertEquals("Parked Car", result);
    }

    public Car getParkedCar() {
        Car car = new Car(1);
        car.setParked(true);
        return car;
    }

    @Test
    public void should_return_tips_about_no_car_when_parking_car_given_a_parking_boy_with_no_car() {
        //given
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.parkingNullCar(car);
        //then
        Assertions.assertEquals("No Car", result);
    }

    @Test
    public void should_return_tips_about_wrong_ticket_when_fetching_responding_car_given_a_parking_boy_with_a_wrong_ticket() {
        //given
        Ticket illegalTicket = new Ticket(1);
        illegalTicket.setLegal(false);

        Ticket usedTicket = new Ticket(2);
        usedTicket.setUsed(true);

        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String illegalTicketResult = parkingBoy.fetchRespondingCarWithWrongTicket(illegalTicket);
        String usedTicketResult = parkingBoy.fetchRespondingCarWithWrongTicket(usedTicket);
        //then
        Assertions.assertEquals("Unrecognized parking ticket.", illegalTicketResult);
        Assertions.assertEquals("Unrecognized parking ticket.", usedTicketResult);
    }

    @Test
    public void should_return_parking_lot_of_rank_x_can_park_car_when_parking_car_given_a_parking_boy_with_multiple_parking_lot() {
        //given
        LinkedList<ParkingLot> parkingLots = initParkingLots();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.chooseParkingLotWithPosition(parkingLots);
        //then
        Assertions.assertEquals("Parking lot of rank 3 can park car", result);
    }

    public LinkedList<ParkingLot> initParkingLots() {
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        ParkingLot firstParkingLot = new ParkingLot(CAPACITY_OF_PARKING_LOT);
        firstParkingLot.setRemainingCapacity(0);
        ParkingLot secondParkingLot = new ParkingLot(CAPACITY_OF_PARKING_LOT);
        secondParkingLot.setRemainingCapacity(0);
        ParkingLot thirdParkingLot = new ParkingLot(CAPACITY_OF_PARKING_LOT);
        thirdParkingLot.setRemainingCapacity(1);
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        parkingLots.add(thirdParkingLot);

        return parkingLots;
    }
}
