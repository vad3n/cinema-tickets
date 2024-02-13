package cinema.tickets.core;

import java.util.List;
import java.util.stream.Collectors;

import cinema.tickets.core.models.Ticket;
import cinema.tickets.repositories.TicketRepository;

public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicket(int id) {
        return Mappers.fromTicketDAO(ticketRepository.getTicket(id));
    }

    public List<Ticket> getTickets() {
        return ticketRepository.getTickets()
                .stream()
                .map(Mappers::fromTicketDAO)
                .collect(Collectors.toList());
    }
    
    public Ticket createTicket(int userId, int projectionId) {
        return Mappers.fromTicketDAO(ticketRepository.createTicket(userId, projectionId));
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteTicket(id);
    }
}
