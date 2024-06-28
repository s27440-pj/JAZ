package pl.PJATK.currencies.Inquiry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class InquiryExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFound(HttpClientErrorException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception from NBP: " + exception.toString());
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleBadRequest(HttpClientErrorException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception from NBP: " + exception.toString());
    }
}
