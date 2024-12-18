package com.cinema.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    @Column(name = "release_year")
    private Integer year;
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private Double imdbRating;
    private String description;

    @Transient
    public String getGenreDisplay() {
        if (genre == null) return "";
        return switch (genre) {
            case ACTION -> "Боевик";
            case COMEDY -> "Комедия";
            case DRAMA -> "Драма";
            case HORROR -> "Ужасы";
            case THRILLER -> "Триллер";
            case SCIFI -> "Научная фантастика";
        };
    }

    @Transient
    public String getRatingDisplay() {
        if (rating == null) return "";
        return switch (rating) {
            case G -> "Без ограничений";
            case PG -> "6+";
            case PG13 -> "13+";
            case R -> "17+";
            case NC17 -> "18+";
        };
    }
    }


