package pl.deska.ksb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.deska.ksb2.aop.SendEmail;
import pl.deska.ksb2.model.Movie;
import pl.deska.ksb2.repository.MovieRepository;

@RestController
public class MovieController {

    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping("/movies")
    public ResponseEntity findAll(){
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @SendEmail
    public ResponseEntity addMovie(@RequestBody Movie movie){
        boolean isAdded = movieRepository.add(movie);
        ResponseEntity responseEntity;
        if(isAdded){
            responseEntity = new ResponseEntity<>(isAdded, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
