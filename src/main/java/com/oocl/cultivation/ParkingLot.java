package com.oocl.cultivation;

public class ParkingLot {
    private int capacity;
    private int remainingCapacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }
}
