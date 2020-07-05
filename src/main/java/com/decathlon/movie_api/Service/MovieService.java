package com.decathlon.movie_api.Service;

import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Model.MovieDto;

import javax.transaction.Transactional;

@Transactional
public interface MovieService {

    Movie update(Movie movieToUpdate, MovieDto movieDto) throws IllegalAccessException;
}
