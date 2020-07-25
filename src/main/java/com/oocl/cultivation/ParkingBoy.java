package com.oocl.cultivation;

import java.util.LinkedList;

/**
 * @author Jenkin
 * @date 2020/7/25 - 0:19
 */
public class ParkingBoy {
    public Ticket parkCar(Car car) {
        return new Ticket(1);
    }

    public Car fetchCar(Ticket ticket) {
        return new Car(1);
    }

    public Car fetchRespondingCar(Ticket ticket, LinkedList<Car> cars) {
        for (Car car:cars) {
            if (car.getId() == ticket.getId()) return car;
        }
        return null;
    }

    public String fetchRespondingCarWithWrongTicket(Ticket ticket) {
        return "Wrong Ticket";
    }

    public String fetchRespondingCarWithNoTicket(Ticket ticket) {
        return "No Ticket";
    }

    public String fetchRespondingCarWithUsedTicket(Ticket ticket) {
        if(ticket.isUsed()) return "Used Ticket";
        return null;
    }

    public String parkingCarToParkingLot(ParkingLot parkingLot) {
        return "No Position";
    }

    public String parkingParkedCar(Car car) {
        return "Parked Car";
    }

    public String parkingNullCar(Car car) {
        return null;
    }
}
