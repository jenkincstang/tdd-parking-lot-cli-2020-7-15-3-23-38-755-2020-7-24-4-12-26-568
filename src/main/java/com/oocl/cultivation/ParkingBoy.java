package com.oocl.cultivation;

import java.util.LinkedList;

/**
 * @author Jenkin
 * @date 2020/7/25 - 0:19
 */
public class ParkingBoy {
    public Ticket parkCar(Car car) {
        return new Ticket(car.getId());
    }

    public Car fetchCar(Ticket ticket) {
        return new Car(ticket.getId());
    }

    public Car fetchRespondingCar(Ticket ticket, LinkedList<Car> cars) {
        for (Car car : cars) {
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
        if (ticket.isUsed()) return "Used Ticket";
        return null;
    }

    public String parkingCarToParkingLot(ParkingLot parkingLot) {
        if (parkingLot.getRemainingCapacity() == 0) return "Not enough position.";
        return null;
    }

    public String parkingParkedCar(Car car) {
        if (car.isParked()) return "Parked Car";
        return null;

    }

    public String parkingNullCar(Car car) {
        return "No Car";
    }

    public String chooseParkingLotWithPosition(LinkedList<ParkingLot> parkingLots) {
        for (int indexOfParkingLots = 0; indexOfParkingLots < parkingLots.size(); indexOfParkingLots++) {
            if (parkingLots.get(indexOfParkingLots).getRemainingCapacity() > 0)
                return "Parking lot of rank " + (indexOfParkingLots + 1) + " can park car";
        }
        return null;
    }
}
