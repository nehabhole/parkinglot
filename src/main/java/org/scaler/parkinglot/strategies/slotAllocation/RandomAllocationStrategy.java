package org.scaler.parkinglot.strategies.slotAllocation;

import org.scaler.parkinglot.models.*;

import java.util.List;
import java.util.Optional;

public class RandomAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public Optional<ParkingSpot> allocate(VehicleType vehicleType, ParkingLot parkingLot) {
        //check available spots floor wise
        List<ParkingFloor> floors = parkingLot.getFloors();
        for(ParkingFloor floor : floors){
            List<ParkingSpot> spots = floor.getParkingSpot();

            for(ParkingSpot spot : spots){
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    return Optional.of(spot);
                }
            }
        }
        return Optional.empty();
    }
}
