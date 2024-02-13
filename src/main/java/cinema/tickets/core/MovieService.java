package cinema.tickets.core;

import cinema.tickets.core.models.Movie;
import cinema.tickets.repositories.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(int id) {
        return Mappers.fromMovieDAO(movieRepository.getMovie(id));
    }

    public List<Movie> getMovies() {
        return movieRepository.getMovies()
                .stream()
                .map(Mappers::fromMovieDAO)
                .collect(Collectors.toList());
    }


    public Movie createMovie(String title, String description, String imageUrl) {
        return Mappers.fromMovieDAO(movieRepository.createMovie(title, description, imageUrl));
    }

    public Movie updatMovie(int id, String title, String description, String imageUrl) {
        return Mappers.fromMovieDAO(movieRepository.updateMovie(id, title, description, imageUrl));
    }

    public void deleteMovie(int id) {
        movieRepository.deleteMovie(id);
    }
}
