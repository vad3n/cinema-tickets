package cinema.tickets.core;

import cinema.tickets.core.models.Movie;
import cinema.tickets.repositories.models.MovieDAO;

public class Mappers {
    public static Movie fromMovieDAO(MovieDAO movie) {
        return new Movie(movie.id, movie.title, movie.description, movie.imageUrl);
    }
}
