package org.scaler.parkinglot.repositories;

import org.scaler.parkinglot.ParkingLotApplication;
import org.scaler.parkinglot.models.Gate;
import org.scaler.parkinglot.models.ParkingFloor;
import org.scaler.parkinglot.models.ParkingLot;
import org.scaler.parkinglot.strategies.slotAllocation.RandomAllocationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {

    private HashMap<Integer, ParkingLot> lots = new HashMap<>();
    private Integer lotIndex = 0;

    public ParkingLot addLot(List<ParkingFloor> parkingFloors,List<Gate> gates){
        lotIndex++;
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(lotIndex);
        parkingLot.setFloors(parkingFloors);
        parkingLot.setGates(gates);
        parkingLot.setSlotAllocationStrategy(new RandomAllocationStrategy());
        lots.put(lotIndex, parkingLot);
        return parkingLot;
    }

    public Optional<ParkingLot> getParkingLotOfGate(Gate gate){
        for(Map.Entry<Integer, ParkingLot> entry : lots.entrySet()){
            if(entry.getValue().getGates().contains(gate)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
}
