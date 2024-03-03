package org.scaler.parkinglot.repositories;

import org.scaler.parkinglot.models.ParkingFloor;
import org.scaler.parkinglot.models.ParkingLot;
import org.scaler.parkinglot.models.ParkingSpot;
import org.scaler.parkinglot.models.ParkingSpotStatus;

import java.util.TreeMap;

public class ParkingSpotRepository {
    private TreeMap<Integer, ParkingSpot> spots = new TreeMap<>();
    private int spotIndex = 0;

    public ParkingSpot addSpot(Integer spotNo ){
        spotIndex++;
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot.setSpotNo(spotNo);
        parkingSpot.setId(spotIndex);
        spots.put(spotIndex,parkingSpot);
        return parkingSpot;
    }
}
