package cinema.tickets.web.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import cinema.tickets.core.TicketService;
import cinema.tickets.core.models.Ticket;
import cinema.tickets.web.api.models.TicketInput;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public Ticket getTicket(int id) {
        return ticketService.getTicket(id);
    }

    @GetMapping
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @PostMapping
    public Ticket createTicket(TicketInput ticketInput) {
        return ticketService.createTicket(ticketInput.userId, ticketInput.projectionId);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(int id) {
        ticketService.deleteTicket(id);
    }
}
