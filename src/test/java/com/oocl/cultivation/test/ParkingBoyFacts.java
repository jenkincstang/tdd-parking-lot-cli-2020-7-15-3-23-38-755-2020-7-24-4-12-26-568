package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
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
     * no ticket
     * a parkingboy
     * //when
     * fetchingCar
     * //then
     * return "Please provide your parking ticket."
     */
    @Test
    public void should_return_tips_about_none_ticket_when_fetching_responding_car_given_a_parking_boy_with_no_ticket(){
        //given
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.fetchRespondingCarWithNoTicket(ticket);

        //then
        Assertions.assertEquals("Please provide your parking ticket.",result);
    }

    @Test
    public void should_return_tips_about_used_ticket_when_fetching_responding_car_given_a_parking_boy_with_a_used_ticket(){
        //given
        Ticket ticket = getUsedTicket();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.fetchRespondingCarWithUsedTicket(ticket);

        //then
        Assertions.assertEquals("Used Ticket",result);
    }

    public Ticket getUsedTicket(){
        Ticket ticket = new Ticket(1);
        ticket.setUsed(true);

        return ticket;
    }

    /**
     * //given
     * a parkingboy
     * a parkinglot
     * //when
     * parkingCar
     * //then
     * return "Not enough position."
     */
    @Test
    public void should_return_tips_about_no_position_when_parking_car_given_a_parking_boy_and_a_parkinglot(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setRemainingCapacity(0);

        ParkingBoy parkingBoy = new ParkingBoy();


        //when
        String result = parkingBoy.parkingCarToParkingLot(parkingLot);

        //then
        Assertions.assertEquals("Not enough position.",result);
    }

    /**
     * //given
     * a parked car
     * a parkingboy
     *
     * //when
     * parkingingCar
     *
     * //then
     * return "Parked Car"
     */
    @Test
    public void should_return_tips_about_parked_car_when_parking_car_given_a_parking_boy_with_a_parked_car(){
        //given
        Car car = getParkedCar();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.parkingParkedCar(car);
        //then
        Assertions.assertEquals("Parked Car",result);
    }

    public Car getParkedCar(){
        Car car = new Car(1);
        car.setParked(true);
        return car;
    }

    @Test
    public void should_return_tips_about_no_car_when_parking_car_given_a_parking_boy_with_no_car(){
        //given
        Car car = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.parkingNullCar(car);
        //then
        Assertions.assertEquals("No Car",result);
    }

    /**
     * //given
     * a wrong ticket
     * a parkingboy
     * //when
     * fetchingCar
     * //then
     * return "Unrecognized parking ticket."
     */

    @Test
    public void should_return_tips_about_wrong_ticket_when_fetching_responding_car_given_a_parking_boy_with_a_wrong_ticket(){
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
        Assertions.assertEquals("Unrecognized parking ticket.",illegalTicketResult);
        Assertions.assertEquals("Unrecognized parking ticket.",usedTicketResult);
    }

    /**
     * //given
     * a parkingboy
     * multiple parking lot
     * //when
     * parkingCar
     * //then
     * return "X parking lot can park car"
     */
    @Test
    public void should_return_parking_lot_of_rank_x_can_park_car_when_parking_car_given_a_parking_boy_with_multiple_parking_lot(){
        //given
        LinkedList<ParkingLot> parkingLots = initParkingLots();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        String result = parkingBoy.chooseParkingLotWithPosition(parkingLots);
        //then
        Assertions.assertEquals("Parking lot of rank 3 can park car",result);
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
