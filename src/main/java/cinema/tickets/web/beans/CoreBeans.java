package cinema.tickets.web.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cinema.tickets.core.MovieService;
import cinema.tickets.core.UserService;
import cinema.tickets.core.TicketService;
import cinema.tickets.repositories.MovieRepository;
import cinema.tickets.repositories.UserRepository;
import cinema.tickets.repositories.TicketRepository;

@Configuration
public class CoreBeans {
    @Bean
    public MovieService movieService(MovieRepository movieRepository) {
        return new MovieService(movieRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean TicketService ticketService(TicketRepository ticketRepository) {
        return new TicketService(ticketRepository);
    }
}
