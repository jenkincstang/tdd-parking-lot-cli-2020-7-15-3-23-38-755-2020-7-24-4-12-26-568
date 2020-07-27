package com.oocl.cultivation;

import java.util.Map;

public class ParkingLot {
    private int capacity;
    private int remainingCapacity;
    private Map<Ticket,Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    public double getAvailablePositionRate(){
        return (double)this.remainingCapacity/this.capacity;
    }

    public Map<Ticket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public void setTicketCarMap(Map<Ticket, Car> ticketCarMap) {
        this.ticketCarMap = ticketCarMap;
    }
}
