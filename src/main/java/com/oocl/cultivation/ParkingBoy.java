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
        return null;
    }
}
