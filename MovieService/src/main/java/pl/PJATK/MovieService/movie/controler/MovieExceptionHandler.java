package pl.PJATK.MovieService.movie.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.PJATK.MovieService.movie.exceptions.NoMovieException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchElementException(NoMovieException ex) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured, here is the message: " + ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadArgumentsException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured, invalid arguments: " + ex);
    }

}
