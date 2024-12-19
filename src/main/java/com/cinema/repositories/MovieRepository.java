package com.cinema.repositories;

import com.cinema.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.model.Genre;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findByGenreAndImdbRatingGreaterThanEqual(Genre genre, Double rating, Pageable pageable);
    Page<Movie> findByGenre(Genre genre, Pageable pageable);
    Page<Movie> findByImdbRatingGreaterThanEqual(Double rating, Pageable pageable);
    Page<Movie> findAll(Pageable pageable);
}