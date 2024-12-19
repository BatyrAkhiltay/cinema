package com.cinema.service;

import com.cinema.model.Genre;
import com.cinema.model.Movie;
import com.cinema.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Page<Movie> getMovies(Genre genre, Double minRating, Pageable pageable) {
        if (genre != null && minRating != null) {
            return movieRepository.findByGenreAndImdbRatingGreaterThanEqual(genre, minRating, pageable);
        } else if (genre != null) {
            return movieRepository.findByGenre(genre, pageable);
        } else if (minRating != null) {
            return movieRepository.findByImdbRatingGreaterThanEqual(minRating, pageable);
        }
        return movieRepository.findAll(pageable);
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("нет такого"));
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
