package pl.PJATK.MovieService.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.PJATK.MovieService.movie.model.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);

}
