package org.scaler.parkinglot.services;

import org.scaler.parkinglot.ParkingLotApplication;
import org.scaler.parkinglot.exceptions.InvalidGateException;
import org.scaler.parkinglot.exceptions.ParkingLotFullException;
import org.scaler.parkinglot.models.*;
import org.scaler.parkinglot.repositories.GateRepository;
import org.scaler.parkinglot.repositories.ParkingLotRepository;
import org.scaler.parkinglot.repositories.TicketRepository;
import org.scaler.parkinglot.repositories.VehicleRespository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class TicketService {
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;
    private VehicleRespository vehicleRespository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository,
                         GateRepository gateRepository,
                         VehicleRespository vehicleRespository,
                         ParkingLotRepository parkingLotRepository){
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.vehicleRespository = vehicleRespository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(String vehicleNo, String ownerName, VehicleType vehicleType, int gateId)
    throws InvalidGateException, ParkingLotFullException{
        //validate input
        //check if gates exists and correct
        Optional<Gate> OptionalGate = this.gateRepository.findGateById(gateId);
        if(OptionalGate.isEmpty()){
            throw new InvalidGateException("Invalid Gate provided");
        }

        Gate gate = OptionalGate.get();
        if(gate.getGateType().equals(GateType.EXIT)){
            //throw exception
        }

        //check if vehicle exists in db else add it
        Optional<Vehicle> OptionalVehicle = this.vehicleRespository.findVehicleByNo(vehicleNo);
        Vehicle vehicle = new Vehicle();

        if(OptionalVehicle.isEmpty()){
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNo(vehicleNo);
            vehicle = this.vehicleRespository.addVehicle(vehicle);
        }else{
            vehicle = OptionalVehicle.get();
        }

        //allot slot based on vehicle type and strategy
        Optional<ParkingLot> optionalparkingLot = this.parkingLotRepository.getParkingLotOfGate(gate);
        ParkingLot parkingLot = optionalparkingLot.get();
        Optional<ParkingSpot> optionalparkingSpot = parkingLot.getSlotAllocationStrategy()
                .allocate(vehicle.getVehicleType(), parkingLot);

        if(optionalparkingSpot.isEmpty()){
            throw new ParkingLotFullException("No Spot available right now");
        }else {
            ParkingSpot parkingSpot = optionalparkingSpot.get();
            //update ticket and return
            Ticket ticket = new Ticket();
            ticket.setVehicle(vehicle);
            ticket.setOperator(gate.getOperator());
            ticket.setEntryTime(new Date());
            ticket.setParkingSpot(parkingSpot);

            ticket = this.ticketRepository.saveTicket(ticket);
            return ticket;
        }
    }
}
