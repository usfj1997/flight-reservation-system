package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void saveTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    /*public Ticket getTicketByTicketId(int ticket_id) {
        Optional<Ticket> optional = ticketRepository.findById(ticket_id);
        Ticket ticket = null;
        if (optional.isPresent()){
            ticket= optional.get();
        } else {
            throw new RuntimeException("Ticket not found for the ticket id :: " + ticket_id);
        }
        return ticket;
    }*/

    public void deleteTicketByTicketId(int ticket_id) {
        this.ticketRepository.deleteById(ticket_id);
    }
}
