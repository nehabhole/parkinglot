package org.scaler.parkinglot;

import org.scaler.parkinglot.controllers.TicketController;
import org.scaler.parkinglot.dtos.IssueTicketRequestDTO;
import org.scaler.parkinglot.dtos.IssueTicketResponseDTO;
import org.scaler.parkinglot.models.*;
import org.scaler.parkinglot.repositories.*;
import org.scaler.parkinglot.services.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotApplication {
    public static void main(String[] args) {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

        List<ParkingFloor> floors = new ArrayList<>();

        for(int f = 1; f< 3; f++) {
            List<ParkingSpot> spots = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                ParkingSpot spot = parkingSpotRepository.addSpot((f-1)*10 + i);
                spots.add(spot);
            }
            ParkingFloor floor = parkingFloorRepository.addFloor(f, spots);
            floors.add(floor);
        }

        List<Gate> gates = new ArrayList<>();
        OperatorRepository operatorRepository = new OperatorRepository();
        GateRepository gateRepository = new GateRepository();
        for(int g =1; g<3; g++){
          Operator operator = operatorRepository.addOperator(100+g);
          Gate gate = gateRepository.addGate(g, GateType.ENTRY,operator);
          gates.add(gate);
        }

        for(int g =3; g<6; g++){
            Operator operator = operatorRepository.addOperator(200+g);
            Gate gate = gateRepository.addGate(g, GateType.EXIT,operator);
            gates.add(gate);
        }

        ParkingLot parkingLot  = parkingLotRepository.addLot(floors, gates);
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRespository vehicleRespository = new VehicleRespository();

        TicketService ticketService = new TicketService(ticketRepository,gateRepository,vehicleRespository,
                parkingLotRepository);
        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application started");

        while(true) {
            System.out.println("options :");
            System.out.println("option 1 : issue ticket");
            System.out.println("option 2 : generate bill");
            System.out.println("option 3 : pay bill");
            System.out.println("option 4 : exit");
            System.out.println("Choose one option :");

            Scanner src = new Scanner(System.in);
            int option = src.nextInt();
            if(option > 0 && option < 5){
                if(option == 4){
                    System.out.println("Closing parkingLot");
                    break;
                }
                if(option == 1){
                    IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();

                    System.out.println("please enter gateId");
                    int gateId = src.nextInt();
                    issueTicketRequestDTO.setGateId(gateId);

                    System.out.println("please enter vehicleNo");
                    String vehicleNo = src.next();
                    issueTicketRequestDTO.setVehicleNo(vehicleNo);

                    System.out.println("please enter Vehicle Owner name");
                    String name = src.next();
                    issueTicketRequestDTO.setVehicleOwnerName(name);

                    issueTicketRequestDTO.setVehicleType(VehicleType.CAR);

                    IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);
                    if(issueTicketResponseDTO.getResponseStatus() == "success"){
                        System.out.println("Ticket Issued : "+ issueTicketResponseDTO.getTicket().getId());
                        System.out.println("Spot Assigned : "+ issueTicketResponseDTO.getTicket().getParkingSpot().getSpotNo());
                    }else{
                        System.out.println("Something went wrong = "+ issueTicketResponseDTO.getMessage());
                    }
                }
                continue;
            }else{
                System.out.println("Wrong option.Please try again");
                continue;
            }
        }
    }
}
