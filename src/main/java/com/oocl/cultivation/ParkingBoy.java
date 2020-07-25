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
        if (!ticket.isLegal() || ticket.isUsed()) return "Unrecognized parking ticket.";
        return null;

    }

    public String fetchRespondingCarWithNoTicket(Ticket ticket) {
        if (ticket == null) return "Please provide your parking ticket.";
        return null;
    }

    public String fetchRespondingCarWithUsedTicket(Ticket ticket) {
        if(ticket.isUsed()) return "Used Ticket";
        return null;
    }

    public String parkingCarToParkingLot(ParkingLot parkingLot) {
        if (parkingLot.getRemainingCapacity() == 0)return "Not enough position.";
        return null;
    }

    public String parkingParkedCar(Car car) {
        return "Parked Car";
    }

    public String parkingNullCar(Car car) {
        return "No Car";
    }

    public String chooseParkingLotWithPosition(LinkedList<ParkingLot> parkingLots) {
        return null;
    }
}
