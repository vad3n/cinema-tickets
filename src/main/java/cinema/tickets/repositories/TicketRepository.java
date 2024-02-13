package cinema.tickets.repositories;

import java.util.List;

import cinema.tickets.repositories.models.TicketDAO;

public interface TicketRepository {
    TicketDAO getTicket(int id);

    List<TicketDAO> getTickets();

    TicketDAO createTicket(int userId, int projectionId);

    void deleteTicket(int id);
}
