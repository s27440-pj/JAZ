package pl.PJATK.MovieService.rental.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMovie(Long id) {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/movies/{id}",
                String.class, id);
        return response.getBody();
    }

    public void changeMovieToAvailable(Long id) {
        restTemplate.exchange("http://localhost:8081/movies/available/{id}",
                HttpMethod.PUT, null, Void.class, id);
    }

    public void changeMovieToUnAvailable(Long id) {
        restTemplate.exchange("http://localhost:8081/movies/unavailable/{id}",
                HttpMethod.PUT, null, Void.class, id);
    }

}
