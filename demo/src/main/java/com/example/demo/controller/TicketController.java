package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //display the list of the tickets
    @GetMapping("/viewTicket")
    public String viewTickets(Model model){
        model.addAttribute("listTickets", ticketService.getAllTickets());
        return "index1";
    }

    @GetMapping("/showNewTicketForm")
    public String showNewTicketForm(Model model) {
        //create model attribute to bind form data
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "new_ticket";
    }

    @PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket){
        //save ticket to database
        ticketService.saveTicket(ticket);
        return "redirect:/viewTicket";
    }

    @GetMapping("/deleteTicket/{ticket_id}")
    public String deleteTicket(@PathVariable(value = "ticket_id") int ticket_id) {
        //call delete ticket method
        this.ticketService.deleteTicketByTicketId(ticket_id);
        return "redirect:/viewTicket";
    }
}
