package org.scaler.parkinglot.strategies.slotAllocation;

import org.scaler.parkinglot.models.ParkingLot;
import org.scaler.parkinglot.models.ParkingSpot;
import org.scaler.parkinglot.models.VehicleType;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SlotAllocationStrategy {
    public Optional<ParkingSpot> allocate(VehicleType vehicleType, ParkingLot parkingLot);
}
