package pl.deska.ksb2.repository;

import org.springframework.stereotype.Repository;
import pl.deska.ksb2.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository {

    List<Movie> findAll();

     boolean add(Movie movie);
}
