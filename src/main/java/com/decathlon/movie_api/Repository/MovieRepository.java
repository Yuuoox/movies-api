package com.decathlon.movie_api.Repository;

import com.decathlon.movie_api.Model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findAll();
    Movie findById(int id);

    long deleteById(int id);
}
