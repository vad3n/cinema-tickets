package cinema.tickets.web.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cinema.tickets.core.MovieService;
import cinema.tickets.repositories.MovieRepository;

@Configuration
public class CoreBeans {
    @Bean
    public MovieService movieService(MovieRepository movieRepository) {
        return new MovieService(movieRepository);
    }
}
