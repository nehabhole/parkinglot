package org.scaler.parkinglot.repositories;

import com.sun.source.tree.Tree;
import org.scaler.parkinglot.models.Vehicle;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRespository {
    private HashMap<Integer, Vehicle> vehicles = new HashMap<>();
    private Integer vehicleIndex = 0;

    public Vehicle addVehicle(Vehicle vehicle){
        vehicleIndex++;
        vehicle.setId(vehicleIndex);
        vehicles.put(vehicleIndex,vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findVehicleById(Long vehicleId){
        if(vehicles.containsKey(vehicleId)){
            return Optional.of(vehicles.get(vehicleId));
        }
        return Optional.empty();
    }

    public Optional<Vehicle> findVehicleByNo(String vehicleId){

        for(Map.Entry<Integer, Vehicle> entry : vehicles.entrySet()){
            if(entry.getValue().getVehicleNo() == vehicleId){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }


}
