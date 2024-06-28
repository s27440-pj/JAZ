package pl.PJATK.MovieService.movie.controler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.PJATK.MovieService.movie.model.Movie;
import pl.PJATK.MovieService.movie.service.MovieService;

import java.util.List;

@RestController
@Tag(name = "Movie Controller", description = "Operations related to movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    @Operation(summary = "Get all movies", description = "Retrieve a list of all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "No movies found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    @Operation(summary = "Get a movie by ID", description = "Retrieve a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved movie"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Movie> getMovie(
            @Parameter(description = "ID of the movie to be retrieved") @PathVariable Long id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @PostMapping("/movies")
    @Operation(summary = "Add a new movie", description = "Create a new movie entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created movie"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Movie> addMovie(
            @Parameter(description = "Movie object to be created") @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    @Operation(summary = "Update an existing movie", description = "Update details of an existing movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated movie"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Movie> updateMovie(
            @Parameter(description = "ID of the movie to be updated") @PathVariable Long id,
            @Parameter(description = "Updated movie object") @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }

    @DeleteMapping("/movies/{id}")
    @Operation(summary = "Delete a movie", description = "Delete a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted movie"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> deleteMovie(
            @Parameter(description = "ID of the movie to be deleted") @PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/available/{id}")
    @Operation(summary = "Mark a movie as available", description = "Set the availability status of a movie to true")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully marked movie as available"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> makeAvailable(
            @Parameter(description = "ID of the movie to be marked as available") @PathVariable Long id) {
        movieService.changeAvailabilityTrue(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/unavailable/{id}")
    @Operation(summary = "Mark a movie as unavailable", description = "Set the availability status of a movie to false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully marked movie as unavailable"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> makeUnAvailable(
            @Parameter(description = "ID of the movie to be marked as unavailable") @PathVariable Long id) {
        movieService.changeAvailabilityFalse(id);
        return ResponseEntity.ok().build();
    }
}