package com.oocl.cultivation;

import java.util.LinkedList;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public String chooseParkingLotWithPosition(LinkedList<ParkingLot> parkingLots) {
        int indexOfParkingLotWithMoreEmptyPosotion = 0;
        int largerAvailablePositionRate = 0;
        for (int indexOfParkingLots = 0; indexOfParkingLots < parkingLots.size(); indexOfParkingLots++) {
            ParkingLot parkingLot = parkingLots.get(indexOfParkingLots);
            if (parkingLot.getRemainingCapacity() / parkingLot.getCapacity() > largerAvailablePositionRate) {
                indexOfParkingLotWithMoreEmptyPosotion = indexOfParkingLots;
                largerAvailablePositionRate = parkingLot.getRemainingCapacity() / parkingLot.getCapacity();
            }
        }
        return "Parking lot of rank " + (indexOfParkingLotWithMoreEmptyPosotion + 1) +
                " has a larger available position rate";
    }
}
