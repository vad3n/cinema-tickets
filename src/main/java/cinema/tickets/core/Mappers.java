package cinema.tickets.core;

import cinema.tickets.core.models.Movie;
import cinema.tickets.core.models.Ticket;
import cinema.tickets.core.models.User;
import cinema.tickets.repositories.models.MovieDAO;
import cinema.tickets.repositories.models.TicketDAO;
import cinema.tickets.repositories.models.UserDAO;

public class Mappers {
    public static Movie fromMovieDAO(MovieDAO movie) {
        return new Movie(movie.id, movie.title, movie.description, movie.imageUrl);
    }

    public static User fromUserDAO(UserDAO user) {
        return new User(user.id, user.username, user.password, user.email);
    }

    public static Ticket fromTicketDAO(TicketDAO ticket) {
        return new Ticket(ticket.id, ticket.userId, ticket.projectionId);
    }
}
