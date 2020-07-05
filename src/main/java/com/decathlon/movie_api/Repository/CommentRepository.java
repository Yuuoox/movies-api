package com.decathlon.movie_api.Repository;

import com.decathlon.movie_api.Model.Comment;
import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Model.Top;
import com.decathlon.movie_api.Model.TopInterface;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAll();

    List<Comment> findAllByMovie(Movie movie);

    List<Comment> findAllByCreatedAtBetween(Date start, Date end);

    //@Query(value = "select count(*) as commentsAmount, movie_id as movieId, DENSE_RANK() OVER( order by count(*) DESC ) as 'rank' from comments where created_at BETWEEN ?1 and ?2 group by movie_id order by commentsAmount DESC" , nativeQuery = true)
    @Query(value = "select count(*) as commentsAmount, movie_id as movieId, DENSE_RANK() OVER( order by count(*) DESC ) movieRank from comments where created_at BETWEEN ?1 and ?2 group by movie_id order by commentsAmount DESC" , nativeQuery = true)
  //  @Query(value = "select new com.decathlon.movie_api.Model.Top( movie_id as movieId, count(*) as commentsAmount, DENSE_RANK() OVER( order by count(*) DESC ) movieRank) from comments where created_at BETWEEN ?1 and ?2 group by movie_id order by commentsAmount DESC" , nativeQuery = true)
    List<TopInterface> filter(Date start, Date end);
}
