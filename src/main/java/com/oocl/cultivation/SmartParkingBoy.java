package com.oocl.cultivation;

import java.util.LinkedList;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public String chooseParkingLotWithPosition(LinkedList<ParkingLot> parkingLots) {
        int indexOfParkingLotWithMoreEmptyPosotion = 0;
        int maxEmptyPosotionCurrent = 0;
        for (int indexOfParkingLots = 0; indexOfParkingLots < parkingLots.size(); indexOfParkingLots++) {
            ParkingLot parkingLot = parkingLots.get(indexOfParkingLots);
            if (parkingLot.getRemainingCapacity() > maxEmptyPosotionCurrent) {
                indexOfParkingLotWithMoreEmptyPosotion = indexOfParkingLots;
                maxEmptyPosotionCurrent = parkingLot.getRemainingCapacity();
            }
        }
        return "Parking lot of rank " + (indexOfParkingLotWithMoreEmptyPosotion + 1) + " contains more empty positions";
    }
}
