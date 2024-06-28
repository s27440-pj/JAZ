package pl.PJATK.MovieService.rental.controler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.PJATK.MovieService.rental.service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a movie by ID", description = "Retrieve a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved movie"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<String> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/available/{id}")
    @Operation(summary = "Mark a movie as available", description = "Set the availability status of a movie to true")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully marked movie as available"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> changeMovieToAvailable(
            @Parameter(description = "ID of the movie to be marked as available") @PathVariable Long id) {
        rentalService.changeMovieToAvailable(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/unavailable/{id}")
    @Operation(summary = "Mark a movie as unavailable", description = "Set the availability status of a movie to false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully marked movie as unavailable"),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> changeMovieToUnAvailable(
            @Parameter(description = "ID of the movie to be marked as unavailable") @PathVariable Long id) {
        rentalService.changeMovieToUnAvailable(id);
        return ResponseEntity.ok().build();
    }



}
