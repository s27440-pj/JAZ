package pl.PJATK.currencies.Inquiry;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Schema(description = "Information about user's inquiries")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique id of inquiry", example = "2")
    private Long id;
    @Schema(description = "Currency name", example = "USD")
    private String currency;
    @Schema(description = "Number of calendar days that user is interested into", example = "7")
    private Integer days;
    @Schema(description = "Date of inquiry", example = "2024-03-25 14:55:00")
    private LocalDateTime date;
    @Schema(description = "Calculated mean of currency from X calendar days")
    private Double meanCourse;

    public Inquiry() {
    }

    public Inquiry(String currency, Integer days, LocalDateTime date, Double meanCourse) {
        this.currency = currency;
        this.days = days;
        this.date = date;
        this.meanCourse = meanCourse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

