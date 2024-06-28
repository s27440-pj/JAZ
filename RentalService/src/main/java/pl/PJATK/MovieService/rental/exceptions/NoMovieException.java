package pl.PJATK.MovieService.rental.exceptions;

import java.util.NoSuchElementException;

public class NoMovieException extends NoSuchElementException {

    public NoMovieException(String text) {
        super(text);
    }

}
