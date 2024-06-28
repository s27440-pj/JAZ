package pl.PJATK.MovieService.movie.exceptions;

import java.util.NoSuchElementException;

public class NoMovieException extends NoSuchElementException {

    public NoMovieException(String text) {
        super(text);
    }

}
