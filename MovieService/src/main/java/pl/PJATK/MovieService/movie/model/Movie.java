package pl.PJATK.MovieService.movie.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Entity
@Schema(description = "Information about movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique ID of the movie", example = "1")
    private Long ID;

    @Schema(description = "The title of the movie", example = "Mamma Mia")
    private String title;

    @Enumerated(EnumType.STRING)
    @Schema(description = "The category of the movie", example = "COMEDY")
    private Category category;

    @Schema(description = "The director of the movie", example = "Phyllida Lloyd")
    private String director;

    @Schema(description = "Availability status of the movie", example = "true")
    private Boolean isAvailable;
    public Movie() {
    }

    public Movie(Long ID, String title, Category category, String director) {
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.director = director;
        this.isAvailable = false;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
