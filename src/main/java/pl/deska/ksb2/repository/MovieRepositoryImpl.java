package pl.deska.ksb2.repository;

import org.springframework.stereotype.Repository;
import pl.deska.ksb2.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

    private List<Movie> movieList;

    public MovieRepositoryImpl() {
        this.movieList = new ArrayList<>();
        initializeDataBase(movieList);
    }

    @Override
    public List<Movie> findAll(){
        return movieList;

    }

    @Override
    public boolean add(Movie movie) {
        return  movieList.add(movie);
    }

    private void initializeDataBase(List<Movie> movieList) {
        movieList.add(new Movie("Interstellar", "2014", "Christopher Nolan"));
        movieList.add(new Movie("Władca Pierścieni: Powrót Króla", "2003", "Peter Jackson"));
        movieList.add(new Movie("John Wick 3", "2019", "Chad Stahelski"));
        movieList.add(new Movie("Tylko sprawiedliwość", "2019", "Destin Daniel Cretton"));
    }
}
