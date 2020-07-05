package com.decathlon.movie_api.Controller;

import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Model.MovieDto;
import com.decathlon.movie_api.Repository.MovieRepository;
import com.decathlon.movie_api.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepo ;

    @Autowired
    private MovieService movieService ;

    @GetMapping
    public List<Movie> findAll(){
        return movieRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newMovie(@RequestBody String title){
        final String uri = "http://www.omdbapi.com/?apikey=b79c83ed&t=" + title;
        RestTemplate restTemplate = new RestTemplate();
        Movie movieResult = restTemplate.getForObject(uri, Movie.class);
        return movieRepo.save(movieResult);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMovie(@PathVariable int id) throws Exception {
        try {
            movieRepo.deleteById(id);
            return true ;
        } catch(Exception e){
            throw new Exception("error");
        }
    }

    @PutMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovie(@PathVariable int id, @RequestBody MovieDto movieBody) throws IllegalAccessException {
        Movie updateMovie = movieRepo.findById(id);
        if(updateMovie == null){
            return null ;
        }
        movieBody.setId(id);
        return movieService.update(updateMovie, movieBody);
    }
}
