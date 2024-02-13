package cinema.tickets.web.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import cinema.tickets.core.MovieService;
import cinema.tickets.core.models.Movie;
import cinema.tickets.web.api.models.MovieInput;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    @GetMapping("/{id}")
    public Movie getMovie(int id) {
        return movieService.getMovie(id);
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping
    public Movie createMovie(@RequestBody MovieInput movieInput) {
        return movieService.createMovie(movieInput.title, movieInput.description, movieInput.imageUrl);
    }
    
    @PutMapping("/{id}")
    public Movie updateMovie(int id, @RequestBody MovieInput movieInput) {
        return movieService.updatMovie(id, movieInput.title, movieInput.description, movieInput.imageUrl);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(int id) {
        movieService.deleteMovie(id);
    }
}
