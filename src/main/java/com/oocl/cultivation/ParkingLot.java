package com.oocl.cultivation;

public class ParkingLot {
    private final int MAX_CAPACITY = 10;
    private int remainingCapacity;

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }
}
