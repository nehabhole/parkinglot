package org.scaler.parkinglot.controllers;

import org.scaler.parkinglot.ParkingLotApplication;
import org.scaler.parkinglot.dtos.IssueTicketRequestDTO;
import org.scaler.parkinglot.dtos.IssueTicketResponseDTO;
import org.scaler.parkinglot.models.Ticket;
import org.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try {
            Ticket ticket = this.ticketService.issueTicket(issueTicketRequestDTO.getVehicleNo(),
                    issueTicketRequestDTO.getVehicleOwnerName(),
                    issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getGateId());
            response.setResponseStatus("success");
            response.setTicket(ticket);
            response.setMessage("ticket issued");
        }catch(Exception e){
            response.setResponseStatus("error");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}

