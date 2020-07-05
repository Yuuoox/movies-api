package com.decathlon.movie_api.Service;

import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Model.MovieDto;
import com.decathlon.movie_api.Repository.MovieMapper;
import com.decathlon.movie_api.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper ;

    @Autowired
    private MovieRepository movieRepo ;

    @Override
    public Movie update(Movie movieToUpdate, MovieDto movieDto) {
        movieMapper.updateMovieFromDto(movieDto, movieToUpdate);
        return movieRepo.save(movieToUpdate);
    }
}
