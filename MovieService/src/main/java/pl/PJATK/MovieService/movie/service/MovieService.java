package pl.PJATK.MovieService.movie.service;

import org.springframework.stereotype.Service;
import pl.PJATK.MovieService.movie.exceptions.NoMovieException;
import pl.PJATK.MovieService.movie.model.Movie;
import pl.PJATK.MovieService.movie.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NoMovieException("No movie with such id"));
    }

    public Movie findMovieByTitle(String title) {
        return movieRepository.findByTitle(title)
                .orElseThrow(() -> new NoMovieException("No movie with such title"));
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie) {
        Movie movieInBase = movieRepository.findById(movie.getID())
                .orElseThrow(() -> new NoMovieException("No movie with such id"));
        movieInBase.setTitle(movie.getTitle());
        movieInBase.setCategory(movie.getCategory());
        movieInBase.setDirector(movie.getDirector());
        movieInBase.setAvailable(movie.getIsAvailable());
        return movieRepository.save(movieInBase);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public void changeAvailabilityTrue(Long id) {
        Movie movieInBase = movieRepository.findById(id)
                .orElseThrow(() -> new NoMovieException("No movie with such id"));
        movieInBase.setAvailable(true);
        movieRepository.save(movieInBase);
    }

    public void changeAvailabilityFalse(Long id) {
        Movie movieInBase = movieRepository.findById(id)
                .orElseThrow(() -> new NoMovieException("No movie with such id"));
        movieInBase.setAvailable(false);
        movieRepository.save(movieInBase);
    }
}
