package org.scaler.parkinglot.strategies.slotAllocation;

import org.scaler.parkinglot.models.ParkingLot;
import org.scaler.parkinglot.models.ParkingSpot;
import org.scaler.parkinglot.models.VehicleType;

import java.util.Optional;

public class NearestAllocationStrategy implements SlotAllocationStrategy{
    @Override
    public Optional<ParkingSpot> allocate(VehicleType vehicleType, ParkingLot parkingLot) {
        return Optional.empty();
    }
}
