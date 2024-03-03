package org.scaler.parkinglot.repositories;

import org.scaler.parkinglot.models.*;

import java.util.List;
import java.util.TreeMap;

public class ParkingFloorRepository {
    private TreeMap<Integer, ParkingFloor> floors = new TreeMap<>();
    private int floorIndex = 0;

    public ParkingFloor addFloor(Integer floorNo, List<ParkingSpot> parkingSpots ){
        floorIndex++;
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNo(floorNo);
        parkingFloor.setParkingSpot(parkingSpots);
        parkingFloor.setId(floorIndex);
        floors.put(floorIndex,parkingFloor);
        return parkingFloor;
    }
}
