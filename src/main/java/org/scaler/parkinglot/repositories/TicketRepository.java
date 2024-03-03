package org.scaler.parkinglot.repositories;


import org.scaler.parkinglot.models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TicketRepository {
    private TreeMap<Integer, Ticket> tickets = new TreeMap<>();

    private int ticketIndex = 0;

    public Optional<Ticket> findTicketById(Long ticketId){
        if(tickets.containsKey(ticketId)){
            return Optional.of(tickets.get(ticketId));
        }
        return Optional.empty();
    }

    public Ticket saveTicket(Ticket ticket){
        ticketIndex++;
        ticket.setId(ticketIndex);
        tickets.put(ticketIndex, ticket);
        return ticket;

    }
}
