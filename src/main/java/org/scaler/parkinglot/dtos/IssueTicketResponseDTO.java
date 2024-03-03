package org.scaler.parkinglot.dtos;

import org.scaler.parkinglot.models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private String responseStatus;
    private String message;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
