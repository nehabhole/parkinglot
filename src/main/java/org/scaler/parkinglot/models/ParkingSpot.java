package org.scaler.parkinglot.models;

import java.util.List;

public class ParkingSpot {
    private int id;
    private int spotNo;
    private Vehicle vehicle;
    private List<VehicleType> supportedTypes;
    private ParkingSpotStatus parkingSpotStatus;



    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<VehicleType> getSupportedTypes() {
        return supportedTypes;
    }

    public void setSupportedTypes(List<VehicleType> supportedTypes) {
        this.supportedTypes = supportedTypes;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

}
