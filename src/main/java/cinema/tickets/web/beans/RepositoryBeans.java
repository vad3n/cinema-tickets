package cinema.tickets.web.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cinema.tickets.repositories.MovieRepository;
import cinema.tickets.repositories.mysql.MySqlMovieRepository;

@Configuration
public class RepositoryBeans {
    @Bean
    public MovieRepository movieRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        return new MySqlMovieRepository(txTemplate, jdbc);
    }
}
