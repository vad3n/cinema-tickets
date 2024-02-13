package cinema.tickets.web.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import cinema.tickets.repositories.MovieRepository;
import cinema.tickets.repositories.UserRepository;
import cinema.tickets.repositories.TicketRepository;
import cinema.tickets.repositories.mysql.MySqlMovieRepository;
import cinema.tickets.repositories.mysql.MySqlUserRepository;
import cinema.tickets.repositories.mysql.MySqlTicketRepository;

@Configuration
public class RepositoryBeans {
    @Bean
    public MovieRepository movieRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        return new MySqlMovieRepository(txTemplate, jdbc);
    }

    @Bean
    public UserRepository userRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        return new MySqlUserRepository(txTemplate, jdbc);
    }

    @Bean
    public TicketRepository ticketRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        return new MySqlTicketRepository(txTemplate, jdbc);
    }
}
