package com.cinema.repositories;

import com.cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.model.Genre;



import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(Genre genre);

    List<Movie> findByImdbRatingGreaterThanEqual(double imdbRating);

    List<Movie> findByDirectorContainingIgnoreCase(String director);

    List<Movie> findByYearOrderByImdbRatingDesc(Integer year);
}
