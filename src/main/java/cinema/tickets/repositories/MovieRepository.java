package cinema.tickets.repositories;

import cinema.tickets.repositories.models.MovieDAO;

import java.util.List;

public interface MovieRepository {
    MovieDAO getMovie(int id);

    List<MovieDAO> getMovies();

    MovieDAO createMovie(String title, String description, String imageUrl);

    MovieDAO updateMovie(int id, String title, String description, String imageUrl);
    
    void deleteMovie(int id);
}
